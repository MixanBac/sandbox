package ru.ssau.tk.mixanbac.sandbox.bubbleshooter;

import java.awt.*;

public class Bullet {

    //Fields
    private double x;
    private double y;

    private double distX;
    private double distY;

    private int r;

    private int speed;

    private Color color;

    //Constructor
    public Bullet() {
        x = GamePanel.player.getX();//Задание X в конструкторе для мгновенного считывания и рисования пуль
        y = GamePanel.player.getY();
        r = 2;//Радиус пули

        speed = 10;

        distX = GamePanel.mouseX - x;
        distY = GamePanel.mouseY - y;

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
        y = y - speed*distY/(Math.sqrt(distX * distX + distY * distY));
        x = x - speed*distX/(Math.sqrt(distX * distX + distY * distY));
    }

    public void draw(Graphics2D g) {//Рисование пули в месте где находится игрок
        g.setColor(color);
        g.fillOval((int) x, (int) y, r, 2 * r);
    }

}
