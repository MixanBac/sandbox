package ru.ssau.tk.mixanbac.sandbox.bubbleshooter;

import javax.swing.*;
import java.awt.*;

public class Enemy {

    Image img = new ImageIcon("res/Enemyp.png").getImage();//Загрузка картинки

    //Fields
    private double x;
    private double y;
    private int r;

    private double speed;
    private double dx;
    private double dy;

    private double health;

    private int type;
    private int rank;

    private Color color;

    //Constructor
    public Enemy(int type, int rank) {
        this.type = type;
        this.rank = rank;

        switch (type) {//Тип врага
            case (1):
                color = Color.GREEN;
                switch (rank) {//Ранг врага
                    case (1):
                        x = Math.random() * GamePanel.WIDTH;
                        y = 0;

                        r = 25;

                        speed = 3;
                        health = 1;

                        double angle = Math.toRadians(Math.random() * 360);//Враги могут двигаться в любую сторону
                        dx = Math.sin(angle) * speed;
                        dy = Math.cos(angle) * speed;
                }
        }
    }

    //Functions

    public double getX() {//Считывание x врага
        return x;
    }

    public double getY() {//Считывание y врага
        return y;
    }

    public int getR() {//Считывание r врага
        return r;
    }

    public boolean remove() {//Уничтожение врага
        if (health <= 0) {
            return true;
        }
        return false;
    }

    public void hit() {//При попадении во врага-потеря жизни
        health--;
    }

    public void destroy() {//При попадении во врага-потеря жизни
        health = 0;
    }

    public void update() {
        x += dx;
        y += dy;

        if (x < -100 && dx < 0) dx = -dx;//Враг не уходит за экран
        if (x > GamePanel.WIDTH + 100 && dx > 0) dx = -dx;
        if (y < -150 && dy < 0) dy = -dy;
        if (y > GamePanel.HEIGHT +150 && dy > 0) dy = -dy;
    }

    public void draw(Graphics2D g) {
        g.drawImage(img, (int) x, (int) y, null);//Отрисовка игрока в координатах

        /*g.setColor(color);//Цвет врага
        g.fillOval((int) (x - r), (int) (y - r), 2 * r, 2 * r);//Форма врага
        g.setStroke(new BasicStroke(3));//Обводка
        g.setColor(color.darker());//Цвет потемнее
        g.drawOval((int) (x - r), (int) (y - r), 2 * r, 2 * r);
        g.setStroke(new BasicStroke(1));*/
    }
}
