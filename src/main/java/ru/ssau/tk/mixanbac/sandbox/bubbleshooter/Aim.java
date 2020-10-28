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
    private double dist;//дистанция

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
        if(Listeners.is_nip){
            for (int k = 0; k < GamePanel.enemies.size(); k++) {// каждого из списка
                Enemy e = GamePanel.enemies.get(k); // выделяем элемент списка
                double ex = e.getX();// получаем коорд элемента
                double ey = e.getY();
                double ew = e.getW();
                double eh = e.getL();
                // отслеживаем центральный прицел
                double ax = GamePanel.aim.getX();// получаем коорд элемента центрального прицела
                double ay = GamePanel.aim.getY();
                double aw = GamePanel.aim.getW();
                double ah = GamePanel.aim.getL();
                if ((ax > ex - aw) && (ax < ex + ew) && (ay > ey - ah) && (ay < ey + eh)) {
                    this.x = ex;// всем прицелам присваиваем координаты врага
                    this.y = ey;
                    GamePanel.aim.x = ex+ew/2; //переопределяем положения центрального маркера
                    GamePanel.aim.y = ey+eh/2;
                }

            }

        }
        else {
            this.x = GamePanel.mouseX + dx;
            this.y = GamePanel.mouseY + dy;
        }
    }

    public void draw(Graphics2D g) {
        if(Listeners.is_nip) GamePanel.aim1.img = "res/aim2.png";
        else GamePanel.aim1.img = "res/aim1.png";

        Image im = new ImageIcon(img).getImage();
        g.drawImage(im,(int)this.x,(int)this.y,null);//отрисовываем элемент в координатах

        g.setColor(Color.WHITE);//задаем цвет объекту Соlor
        Font font = new Font("Arial",Font.ITALIC,10);//Создём объект класса фонт (передаем в конструктор параметры)
        g.setFont(font);//устанвливаем наш шрифт
        if(Listeners.is_nip)
            ((Graphics2D) g).drawString("дистанция"+(int)dist,(int)GamePanel.aim.x -25,(int)GamePanel.aim.y - 40 );//отрисовываем строку
    }

}
