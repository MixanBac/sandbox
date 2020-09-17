package ru.ssau.tk.mixanbac.sandbox.bubbleshooter;

import java.awt.*;

public class Player {

    //Fields
    private double x;
    private double y;
    private int r;

    private int speed;

    private  Color color1;
    private  Color color2;

    public static boolean up;//Управление
    public static boolean down;
    public static boolean left;
    public static boolean right;

    //Constructor
    public Player(){//Инициализация игрока
        x = GamePanel.WIDTH/2;//Начальная позиция игрока
        y = GamePanel.HEIGHT/2;

        r = 5;

        speed = 5;

        color1 = Color.WHITE;

        up = false;//Кнопки по дефолту не нажаты
        down = false;
        left = false;
        right = false;

    }

    //Functions
    public void update(){//Обновление данных об игроке
        if(up && y > r){
            y -= speed;
        }
        if(down && y < GamePanel.HEIGHT - r){
            y += speed;
        }
        if(left && x > r){
            x -= speed;
        }
        if(right && x < GamePanel.WIDTH - r){
            x += speed;
        }

    }

    public void draw(Graphics2D g){//Для рисования
        g.setColor(color1);//Рисование 1 цветом
        g.fillOval((int) (x - r),(int) (y - r), 2 * r, 2 * r);//Смещение потому, что java рисует от верхнего левого угла
        g.setStroke(new BasicStroke(3));//Увеличение толщины линии
        g.setColor(color1.darker());//Цвет потемнее
        g.drawOval((int) (x - r),(int) (y - r), 2 * r, 2 * r);
        g.setStroke(new BasicStroke(1));
    }
}
