package ru.ssau.tk.mixanbac.sandbox.bubbleshooter;

import java.awt.*;

public class Bullet {

    //Fields
    private double x;
    private  double y;
    private int r;

    private int speed;

    private  Color color;

    //Constructor
    public Bullet(){
        x = GamePanel.player.getX();//Задание X в конструкторе для мгновенного считывания и рисования пуль
        y = GamePanel.player.getY();
        r = 2;//Радиус пули

        speed = 10;

        color = Color.WHITE;
    }

    //Functions
    public  void  update(){
        y -= speed;
    }

    public void draw(Graphics2D g){//Рисование пули в месте где находится игрок
        g.setColor(color);
        g.fillOval((int)x, (int)y, r, 2 * r);
    }

}
