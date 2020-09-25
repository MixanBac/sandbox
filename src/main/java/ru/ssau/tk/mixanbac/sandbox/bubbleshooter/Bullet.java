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

    public double getX(){//Считывание x пули
        return x;
    }

    public double getY(){//Считывание y пули
        return y;
    }

    public int getR(){//Считывание r пули
        return r;
    }

    public boolean remove() {//Очистка пули из списка, если она улетела за экран
        if(y<0||x>GamePanel.WIDTH||x<0) {
            return true;
        }
        return false;
    }

    public  void  update(){
        y -= speed;
    }

    public void draw(Graphics2D g){//Рисование пули в месте где находится игрок
        g.setColor(color);
        g.fillOval((int)x, (int)y, r, 2 * r);
    }

}
