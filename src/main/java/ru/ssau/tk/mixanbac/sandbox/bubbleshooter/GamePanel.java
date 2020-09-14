package ru.ssau.tk.mixanbac.sandbox.bubbleshooter;

import javax.swing.JPanel;
import java.awt.*;

public class GamePanel extends JPanel implements Runnable {//Используем интерфэйс для создания потока

    //Field
    public static int WIDTH = 400;
    public static int HEIGHT = 400;

    private Thread thread = new Thread(this);//Создание потока

    // Constructor
    public GamePanel(){
        super();//Вызываем конструктор JPanel

        setPreferredSize(new Dimension(WIDTH, HEIGHT));//Размер окна с заданными параметрами
        setFocusable(true);//Сделать окно активным
        requestFocus();//Позволяет установить фокус на нужном компоненте
        thread.start();//Запускаем поток
    }

    //Functions
    public void run() {
        while(true){ //TODO States

            gameUpdate();//С каждым проходом обновление
            gameRender();

            try {
                thread.sleep(33);//TODO FPS
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    public void gameUpdate(){//Обновление данных и списков данных

    }

    public void gameRender(){//Обновление графических компонентов игры

    }
}
