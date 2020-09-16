package ru.ssau.tk.mixanbac.sandbox.bubbleshooter;

import javax.swing.JPanel;
import java.awt.*;
import java.awt.image.BufferedImage;

public class GamePanel extends JPanel implements Runnable {//Используем интерфэйс для создания потока

    //Field
    public static int WIDTH = 400;
    public static int HEIGHT = 400;

    private Thread thread;//Создание потока

    private BufferedImage image;//Создает переменную холста
    private Graphics2D g;//Создает кисточку

    public static GameBack background;//Для взаимодействия с другими классами
    public static Player player;

    // Constructor
    public GamePanel(){
        super();//Вызываем конструктор JPanel

        setPreferredSize(new Dimension(WIDTH, HEIGHT));//Размер окна с заданными параметрами
        setFocusable(true);//Сделать окно активным
        requestFocus();//Позволяет установить фокус на нужном компоненте
    }

    //Functions

    public void start(){//Метод для запуска потока
        thread = new Thread(this);
        thread.start();//Запускаем поток
    }

    public void run() {

        image= new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);//Инициализация значений
        g =(Graphics2D) image.getGraphics();//Привязка кисточки к холсту

        background = new GameBack();
        player = new Player();//Инициализация

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
    }

    public void gameRender(){//Обновление графических компонентов игры
        //Background draw
        background.draw(g);//Передача кисточки в GamePanel

        //Player draw
        player.draw(g);//Рисование игрока
    }

    private void gameDraw() {//Передача изображения в панель
        Graphics g2 = this.getGraphics();
        g2.drawImage(image, 0, 0, null);
        g2.dispose();//Очищение мусора,удаление g2, так как картинку уже нарисовали
    }

}
