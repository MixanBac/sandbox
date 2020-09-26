package ru.ssau.tk.mixanbac.sandbox.bubbleshooter;

import javax.swing.JPanel;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class GamePanel extends JPanel implements Runnable {//Используем интерфэйс для создания потока

    //Field
    public static int WIDTH = 400;
    public static int HEIGHT = 400;

    private Thread thread;//Создание потока

    private BufferedImage image;//Создает переменную холста
    private Graphics2D g;//Создает кисточку

    public static GameBack background;//Для взаимодействия с другими классами
    public static Player player;
    public static ArrayList<Bullet> bullets;//Создание списка пуль

    public  static ArrayList<Enemy> enemies;//Создание списка врагов

    // Constructor
    public GamePanel(){
        super();//Вызываем конструктор JPanel

        setPreferredSize(new Dimension(WIDTH, HEIGHT));//Размер окна с заданными параметрами
        setFocusable(true);//Сделать окно активным
        requestFocus();//Позволяет установить фокус на нужном компоненте

        addKeyListener(new Listeners());//Привязка к панели слушателя

    }

    //Functions
    public void start(){//Метод для запуска потока
        thread = new Thread(this);
        thread.start();//Запускаем поток
    }

    public void run() {

        image= new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);//Инициализация значений
        g =(Graphics2D) image.getGraphics();//Привязка кисточки к холсту
        g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);//Сглаживание

        background = new GameBack();
        player = new Player();//Инициализация
        bullets = new ArrayList<Bullet>();
        enemies = new ArrayList<Enemy>();

        enemies.add(new Enemy(1, 1));
        enemies.add(new Enemy(1, 1));

        while(true){ //TODO States

            gameUpdate();//С каждым проходом обновление
            gameRender();
            gameDraw();

            try {
                thread.sleep(33);//TODO FPS
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    public void gameUpdate(){//Обновление данных и списков данных
        //Background update
        background.update();

        //Player update
        player.update();//Обновление данных об игроке

        //Bullets update
        for(int i = 0 ; i <bullets.size(); i++){//Перебор и обновление всего списка пуль
            bullets.get(i).update();
            boolean remove = bullets.get(i).remove();//Реализация очиски пули
            if(remove){
                bullets.remove(i);
                i--;//Сокращение индекса если объект удален
            }
        }

        //Enemies update
        for(int i = 0; i < enemies.size(); i++){
            enemies.get(i).update();
        }

        //Bullets-enemies collide
        for(int i = 0; i < enemies.size(); i++){//Сравнение положения пули и врага
            Enemy e = enemies.get(i);//Индекс врага
            double ex = e.getX();//Координата x врага
            double ey = e.getY();//Координата y врага
            for (int j = 0; j < bullets.size(); j++){
                Bullet b = bullets.get(j);
                double bx = b.getX();//Считывание координаты пули
                double by = b.getY();//Считывание координаты пули
                double dx = ex - bx;//Разница
                double dy = ey - by;//Разница
                double dist = Math.sqrt(dx * dx + dy * dy);//Расстояние между врагом и пулей
                if((int) dist <= e.getR() + b.getR()){
                    e.hit();
                    bullets.remove(j);//Удаление пули при попадении
                    j--;//Удаление индекса пули из массива
                    boolean remove = e.remove();
                    if(remove){
                        enemies.remove(i);//Удаление врага
                        i--;//Стереть врага из массива
                        break;
                    }

                }

            }

        }

        //Player-enemy collides
        for(int i = 0; i < enemies.size(); i++){
            Enemy e = enemies.get(i);//Индекс врага
            double ex = e.getX();//Координата x врага
            double ey = e.getY();//Координата y врага

            double px = player.getX();//Координата x игрока
            double py = player.getY();//Координата y игрока
            double dx = ex - px;//Разница
            double dy = ey - py;//Разница
            double dist = Math.sqrt(dx * dx + dy * dy);//Расстояние между врагом и игроком
            if((int) dist <= e.getR() + player.getR()){
                e.hit();
                player.hit();
                boolean remove = e.remove();
                if(remove){
                    enemies.remove(i);//Удаление врага
                    i--;//Стереть врага из массива
                }

            }

        }

    }

    public void gameRender(){//Обновление графических компонентов игры
        //Background draw
        background.draw(g);//Передача кисточки в GamePanel

        //Player draw
        player.draw(g);//Рисование игрока

        //Bullets draw
        for(int i = 0; i < bullets.size(); i++){//Рисование всего списка пуль
            bullets.get(i).draw(g);
        }
        //Enemies draw
        for (int i = 0; i < enemies.size(); i++){
            enemies.get(i).draw(g);
        }
    }

    private void gameDraw() {//Передача изображения в панель
        Graphics g2 = this.getGraphics();
        g2.drawImage(image, 0, 0, null);
        g2.dispose();//Очищение мусора,удаление g2, так как картинку уже нарисовали
    }

}
