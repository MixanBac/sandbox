package ru.ssau.tk.mixanbac.sandbox.bubbleshooter;

import java.awt.*;

public class Player {

    //Fields
    private double x;
    private double y;
    private int r;

    private  Color color1;
    private  Color color2;

    //Constructor
    public Player(){//Инициализация игрока
        x = GamePanel.WIDTH/2;//Начальная позиция игрока
        y = GamePanel.HEIGHT/2;

        r = 5;

        color1 = Color.WHITE;

    }

    //Functions
    public void update(){//Обновление данных об игроке

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
