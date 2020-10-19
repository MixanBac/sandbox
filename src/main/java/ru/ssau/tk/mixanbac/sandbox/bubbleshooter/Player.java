package ru.ssau.tk.mixanbac.sandbox.bubbleshooter;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.AffineTransform;

public class Player {

    Image img = new ImageIcon("res/Player.png").getImage();//Загрузка картинки

    //Fields
    private double x;
    private double y;
    //private int r;
    private double w;//Ширина объекта
    private double l;//Длина объекта

    private double dx;//Коэффициэнты смещения
    private double dy;

    private int speed;

    public double health;

    private double ang1;//Поворот угла
    private double distX;//Разница по x от мыши
    private double distY;//Разница по y от мыши
    private double dist;//Расстояние от мышки

    private Color color1;
    private Color color2;

    public static boolean up;//Управление
    public static boolean down;
    public static boolean left;
    public static boolean right;

    //public int magazine;//Патроны

    public static boolean isFiring;//Стрельба

    public Rectangle getRect(){//Получение прямоугольника
        return new Rectangle((int) x,(int) y, 54, 77);
    }

    //Constructor
    public Player() {//Инициализация игрока
        x = GamePanel.WIDTH / 2;//Начальная позиция игрока
        y = GamePanel.HEIGHT / 2;

        //r = 5;

        w = 54;
        l = 77;

        speed = 5;

        dx = 0;//Приращение
        dy = 0;

        health = 3;

        color1 = Color.WHITE;

        up = false;//Кнопки по дефолту не нажаты
        down = false;
        left = false;
        right = false;

        isFiring = false;

        //magazine = 1000;

    }

    //Functions

    public double getX() {//Считывание x
        return x;
    }

    public double getY() {//Считывание y
        return y;
    }

    /*public int getR() {//Считывание r
        return r;
    }*/

    public double getW() {//Считывание y
        return w;
    }

    public double getL() {//Считывание y
        return l;
    }

    public void hit() {//Падение здоровья при столкновении
        health--;
    }

    public void update() {//Обновление данных об игроке

        distX = GamePanel.mouseX - x;//Разница x от мышки
        distY = y - GamePanel.mouseY;
        dist = (Math.sqrt(distX * distX + distY * distY));

        if (distX > 0) ang1 = Math.acos(distY / (Math.sqrt(distX * distX + distY * distY)));//Вычисление угла в 1 и 4 координатной плоскости
        if (distX < 0) ang1 = -Math.acos(distY / (Math.sqrt(distX * distX + distY * distY)));//

        /*if (up && y > r) {
            dy = -speed;
        }
        if (down && y < GamePanel.HEIGHT - r) {
            dy = speed;
        }
        if (left && x > r) {
            dx = -speed;
        }
        if (right && x < GamePanel.WIDTH - r) {
            dx = speed;
        }*/

        if(up && y>20){
            y -=speed;
        }

        if(down && y<GamePanel.HEIGHT - l){
            y +=speed;
        }

        if(left && x>0){
            x -=speed;
        }

        if(right && y<GamePanel.WIDTH - w){
            x +=speed;
        }

        if (up && left || up && right || down && left || down && right) {//Чтобы не перемещался быстрее по диагонали
            double angle = Math.toRadians(45);//Перевод градусов в радианы
            dy = dy * Math.sin(angle);
            dx = dx * Math.cos(angle);
        }

        y += dy;
        x += dx;

        dy = 0;//Для остановки, если клавиши не нажаты
        dx = 0;

        if (GamePanel.wave.magazine <= 0) {
            GamePanel.wave.magazine = 0;
            isFiring = false;//Запрет стрельбы
        }

        if (isFiring) {//Добавление пули при стрельбе
            GamePanel.bullets.add(new Bullet());
            isFiring = false;//Запрет стрельбы
            GamePanel.wave.magazine--;
        }

    }

    public void draw(Graphics2D g) {//Для рисования

        //g.drawImage(img, (int) x - 26, (int) y, null);//Отрисовка игрока в координатах

        AffineTransform origXform;//Создание объекта класса AffineTransform
        origXform = g.getTransform();//Получение текущего значения
        AffineTransform copyXform = (AffineTransform) (origXform.clone());//Создание копии объекта
        copyXform.rotate(ang1, x + 27, y + 38);//Кручение изображения
        g.setTransform(copyXform);//Подставляем трансформированное изображение
        g.drawImage(img, (int) x, (int) y, null);//Рисуем картинку
        g.setTransform(origXform);//Возвращение старого значения

        Color bacColor = new Color(255, 45, 255);//Создание объекта класса цвет
        g.setColor(bacColor);// Передача цвета графическому объекту
        g.fillRect(45, 0, 110, 20);//Рисование прямоугольной области
        g.fillRect(245, 0, 170, 20);//Рисование прямоугольной области
        g.fillRect(495, 0, 95, 20);//Рисование прямоугольной области

        g.setColor(Color.WHITE);//Задание цвета объекту Соlor
        Font font = new Font("Arial", Font.ITALIC, 20);//Создание объекта класса Font (передаем в конструктор параметры)
        g.setFont(font);//Установка шрифта
        ((Graphics2D) g).drawString("Жизни - " + (int) health, 50, 15);//Рисование строки
        ((Graphics2D) g).drawString("Патроны " + GamePanel.wave.magazine, 250, 15);//Рисование строки
        ((Graphics2D) g).drawString("Враги " + GamePanel.enemies.size(), 500, 15);//Рисование строки

        /*g.setColor(color1);//Рисование 1 цветом
        g.fillOval((int) (x - r), (int) (y - r), 2 * r, 2 * r);//Смещение потому, что java рисует от верхнего левого угла
        g.setStroke(new BasicStroke(3));//Увеличение толщины линии
        g.setColor(color1.darker());//Цвет потемнее
        g.drawOval((int) (x - r), (int) (y - r), 2 * r, 2 * r);
        g.setStroke(new BasicStroke(1));*/
    }
}
