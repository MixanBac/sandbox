package ru.ssau.tk.mixanbac.sandbox.bubbleshooter;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.AffineTransform;

public class Bullet {

    Image img = new ImageIcon("res/Rocket_photo-resizer.ru.png").getImage();//Загрузка картинки
    //Fields
    private double x;
    private double y;

    private double w;//Ширина объекта
    private double l;//Длина объекта

    private double distX;
    private double distY;
    private double dist;

    private int r;

    private int speed;

    private Color color;

    //Constructor
    public Bullet() {
        x = 27+GamePanel.player.getX();//Задание X в конструкторе для мгновенного считывания и рисования пуль
        y = 38+GamePanel.player.getY();
        r = 2;//Радиус пули

        w = 8;
        l = 23;

        speed = 10;

        distX = GamePanel.mouseX - x;
        distY = y - GamePanel.mouseY;
        dist = (Math.sqrt(distX*distX+distY*distY));

        color = Color.WHITE;
    }

    //Functions

    public double getX() {//Считывание x пули
        return x;
    }

    public double getY() {//Считывание y пули
        return y;
    }

    /*public int getR() {//Считывание r пули
        return r;
    }*/

    public double getW() {//Считывание y
        return w;
    }

    public double getL() {//Считывание y
        return l;
    }

    public boolean remove() {//Очистка пули из списка, если она улетела за экран
        if (y < 0 && y > GamePanel.HEIGHT && x < 0 && x > GamePanel.WIDTH) {
            return true;
        }
        return false;
    }

    public void update() {
        y = y - speed * distY / dist;
        x = x + speed * distX / dist;
    }

    public void draw(Graphics2D g) {//Рисование пули в месте где находится игрок
        //g.drawImage(img, (int) x, (int) y, null);//Отрисовка игрока в координатах
        AffineTransform origXform;
        origXform = g.getTransform();// получаем текущее значение
        AffineTransform newXform = (AffineTransform)(origXform.clone()); // клонируем текущее значение
        if (distX>0) newXform.rotate(Math.acos(distY/(Math.sqrt(distX*distX + distY*distY))),x,y) ; // вертим полученное
        if (distX<0) newXform.rotate(-Math.acos(distY/(Math.sqrt(distX*distX + distY*distY))),x,y) ; // вертим полученное
        g.setTransform(newXform); // ставим
        g.drawImage(img,(int)x,(int)y,null); // здесь рисуем картинку
        g.setTransform(origXform); // возвращаем старое значение

        /*g.setColor(color);
        g.fillOval((int) x, (int) y, r, 2 * r);*/
    }

}
