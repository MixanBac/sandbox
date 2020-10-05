package ru.ssau.tk.mixanbac.sandbox.bubbleshooter;

import javax.swing.JPanel;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class GamePanel extends JPanel implements Runnable {//Используем интерфэйс для создания потока

    //Field
    public static int WIDTH = 600;
    public static int HEIGHT = 600;

    public static int mouseX;
    public static int mouseY;
    public static boolean leftMouse;

    private Thread thread;//Создание потока

    private BufferedImage image;//Создает переменную холста
    private Graphics2D g;//Создает кисточку

    private int FPS;
    private double millisToFps;
    private long timerFPS;
    private int sleepTime;

    public static enum STATES {//Задание категории
        MENU,
        PLAY
    }

    public static STATES state = STATES.MENU;

    public static GameBack background;//Для взаимодействия с другими классами
    public static Player player;
    public static ArrayList<Bullet> bullets;//Создание списка пуль
    public static ArrayList<Enemy> enemies;//Создание списка врагов
    public static Wave wave;//Создание экземпляра класса Wave
    public static Menu menu;//Создание экземпляра класса Menu

    // Constructor
    public GamePanel() {
        super();//Вызываем конструктор JPanel

        setPreferredSize(new Dimension(WIDTH, HEIGHT));//Размер окна с заданными параметрами
        setFocusable(true);//Сделать окно активным
        requestFocus();//Позволяет установить фокус на нужном компоненте

        addKeyListener(new Listeners());//Привязка к панели слушателя
        addMouseMotionListener(new Listeners());//Добавление слушателя мышь
        addMouseListener(new Listeners());
    }

    //Functions
    public void start() {//Метод для запуска потока
        thread = new Thread(this);
        thread.start();//Запускаем поток
    }

    public void run() {

        FPS = 30;
        millisToFps = 1000 / FPS;
        sleepTime = 0;//Сколько будет спать

        image = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);//Инициализация значений
        g = (Graphics2D) image.getGraphics();//Привязка кисточки к холсту
        g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);//Сглаживание

        leftMouse = false;
        background = new GameBack();
        player = new Player();//Инициализация
        bullets = new ArrayList<Bullet>();
        enemies = new ArrayList<Enemy>();
        wave = new Wave();//Инициализация
        menu = new Menu();

        Toolkit kit = Toolkit.getDefaultToolkit();
        BufferedImage buffered = new BufferedImage(16, 16, BufferedImage.TYPE_INT_ARGB);//Создание маленького "мольбертика" для рисования
        Graphics2D g3 = (Graphics2D) buffered.getGraphics();
        g3.setColor(new Color(255,255,255));//Цвет мишени
        g3.drawOval(0,0,4,4);//Окружение миншени
        g3.drawLine(2,0,2,4);
        g3.drawLine(0,2,4,2);
        Cursor myCursor = kit.createCustomCursor(buffered, new Point(3,3),"myCursor");
        g3.dispose();

        while (true) { //TODO States

            this.setCursor(myCursor);

            timerFPS = System.nanoTime();

            if (state.equals(STATES.MENU)) {//Если состояние меню
                background.update();
                background.draw(g);
                menu.update();
                menu.draw(g);
                gameDraw();
            }
            if (state.equals(STATES.PLAY)) {//Если состояние игра
                gameUpdate();//С каждым проходом обновление
                gameRender();
                gameDraw();
            }

            timerFPS = (System.nanoTime() - timerFPS) / 1000000;//В наносекундах
            if (millisToFps > timerFPS) {
                sleepTime = (int) (millisToFps - timerFPS);
            } else sleepTime = 1;

            try {
                thread.sleep(sleepTime);//Чтобы не зависело от цикла FPS
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            timerFPS = 0;
            sleepTime = 1;
        }
    }

    public void gameUpdate() {//Обновление данных и списков данных
        //Background update
        background.update();

        //Player update
        player.update();//Обновление данных об игроке

        //Bullets update
        for (int i = 0; i < bullets.size(); i++) {//Перебор и обновление всего списка пуль
            bullets.get(i).update();
            boolean remove = bullets.get(i).remove();//Реализация очиски пули
            if (remove) {
                bullets.remove(i);
                i--;//Сокращение индекса если объект удален
            }
        }

        //Enemies update
        for (int i = 0; i < enemies.size(); i++) {
            enemies.get(i).update();
        }

        //Bullets-enemies collide
        for (int i = 0; i < enemies.size(); i++) {//Сравнение положения пули и врага
            Enemy e = enemies.get(i);//Индекс врага
            double ex = e.getX();//Координата x врага
            double ey = e.getY();//Координата y врага
            for (int j = 0; j < bullets.size(); j++) {
                Bullet b = bullets.get(j);
                double bx = b.getX();//Считывание координаты пули
                double by = b.getY();//Считывание координаты пули
                double dx = ex - bx;//Разница
                double dy = ey - by;//Разница
                double dist = Math.sqrt(dx * dx + dy * dy);//Расстояние между врагом и пулей
                if ((int) dist <= e.getR() + b.getR()) {
                    e.hit();
                    bullets.remove(j);//Удаление пули при попадении
                    j--;//Удаление индекса пули из массива
                    boolean remove = e.remove();
                    if (remove) {
                        enemies.remove(i);//Удаление врага
                        i--;//Стереть врага из массива
                        break;
                    }

                }

            }

        }

        //Player-enemy collides
        for (int i = 0; i < enemies.size(); i++) {
            Enemy e = enemies.get(i);//Индекс врага
            double ex = e.getX();//Координата x врага
            double ey = e.getY();//Координата y врага

            double px = player.getX();//Координата x игрока
            double py = player.getY();//Координата y игрока
            double dx = ex - px;//Разница
            double dy = ey - py;//Разница
            double dist = Math.sqrt(dx * dx + dy * dy);//Расстояние между врагом и игроком
            if ((int) dist <= e.getR() + player.getR()) {
                e.hit();
                player.hit();
                boolean remove = e.remove();
                if (remove) {
                    enemies.remove(i);//Удаление врага
                    i--;//Стереть врага из массива
                }

            }

        }

        //Wave update
        wave.update();

    }

    public void gameRender() {//Обновление графических компонентов игры
        //Background draw
        background.draw(g);//Передача кисточки в GamePanel

        //Player draw
        player.draw(g);//Рисование игрока

        //Bullets draw
        for (int i = 0; i < bullets.size(); i++) {//Рисование всего списка пуль
            bullets.get(i).draw(g);
        }
        //Enemies draw
        for (int i = 0; i < enemies.size(); i++) {
            enemies.get(i).draw(g);
        }

        //Wave draw
        if (wave.showWave()) {
            wave.draw(g);//Вызов метода перерисовки для волны
        }
    }

    private void gameDraw() {//Передача изображения в панель
        Graphics g2 = this.getGraphics();
        g2.drawImage(image, 0, 0, null);
        g2.dispose();//Очищение мусора,удаление g2, так как картинку уже нарисовали
    }

}
