package ru.ssau.tk.mixanbac.sandbox.bubbleshooter;

import javax.swing.*;
import java.awt.*;

public class Aim {//Прицел
    private double x;
    private double y;
    private double w;//Ширина объекта
    private double l;//Длина объекта

    private double dx;
    private double dy;

    private String img;

    public Aim(int x, int y, int w, int l, String img, int dx, int dy) {//Конструктор
        this.x = x;
        this.y = y;
        this.w = w;
        this.l = l;
        this.img = img;
        this.dx = dx;
        this.dy = dy;
    }

    public Rectangle getRect() {//Получение прямоугольника
        return new Rectangle((int) x, (int) y, (int) w, (int) l);
    }

    public double getX() {//Считывание x
        return x;
    }

    public double getY() {//Считывание y
        return y;
    }

    public double getW() {//Считывание y
        return w;
    }

    public double getL() {//Считывание y
        return l;
    }

    public void update() {
        this.x = GamePanel.mouseX + dx;
        this.y = GamePanel.mouseY + dy;
    }

    public void draw(Graphics2D g) {
        Image im = new ImageIcon(img).getImage();
        g.drawImage(im, (int) this.x, (int) this.y, null);//отрисовка в координатах

    }

}
