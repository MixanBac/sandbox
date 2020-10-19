package ru.ssau.tk.mixanbac.sandbox.bubbleshooter;

import java.awt.*;

public class Aim {//Прицел
    private double x;
    private double y;
    private double w;//Ширина объекта
    private double l;//Длина объекта

    private double dx;
    private double dy;

    public Rectangle getRect(){//Получение прямоугольника
        return new Rectangle((int) x,(int) y, (int) w, (int) l);
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

    public void update(){

    }

    public void draw(Graphics2D g){

    }

}
