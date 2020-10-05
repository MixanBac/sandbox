package ru.ssau.tk.mixanbac.sandbox.bubbleshooter;

import java.awt.*;

public class Bullet {

    //Fields
    private double x;
    private double y;
    private double bulletDx;
    private double bulletDy;

    private double distX;
    private double distY;
    private double dist;
    private int r;

    private int speed;

    private Color color;

    //Constructor
    public Bullet() {
        x = GamePanel.player.getX();//Задание X в конструкторе для мгновенного считывания и рисования пуль
        y = GamePanel.player.getY();
        r = 2;//Радиус пули

        speed = 1;

        distX = GamePanel.mouseX - x;
        distY = GamePanel.mouseY - y;
        dist = Math.sqrt(distX * distX + distY * distY);

        bulletDx = distX / dist * speed;
        bulletDy = distY / dist * speed;
        color = Color.WHITE;
    }

    //Functions

    public double getX() {//Считывание x пули
        return x;
    }

    public double getY() {//Считывание y пули
        return y;
    }

    public int getR() {//Считывание r пули
        return r;
    }

    public boolean remove() {//Очистка пули из списка, если она улетела за экран
        if (y < 0 && y > GamePanel.HEIGHT && x < 0 && x > GamePanel.WIDTH) {
            return true;
        }
        return false;
    }

    public void update() {
        y += distY;
        x += distX;
    }

    public void draw(Graphics2D g) {//Рисование пули в месте где находится игрок
        g.setColor(color);
        g.fillOval((int) x, (int) y, r, 2 * r);
    }

}
