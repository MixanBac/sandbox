package ru.ssau.tk.mixanbac.sandbox.bubbleshooter;

import java.awt.*;

public class Player {

    //Fields
    private double x;
    private double y;
    private int r;

    private double dx;//Коэффициэнты смещения
    private double dy;

    private int speed;

    private double health;

    private Color color1;
    private Color color2;

    public static boolean up;//Управление
    public static boolean down;
    public static boolean left;
    public static boolean right;

    public static boolean isFiring;//Стрельба

    //Constructor
    public Player() {//Инициализация игрока
        x = GamePanel.WIDTH / 2;//Начальная позиция игрока
        y = GamePanel.HEIGHT / 2;

        r = 5;

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

    }

    //Functions

    public double getX() {//Считывание x
        return x;
    }

    public double getY() {//Считывание y
        return y;
    }

    public int getR() {//Считывание r
        return r;
    }

    public void hit() {//Падение здоровья при столкновении
        health--;
        System.out.println(health);
    }

    public void update() {//Обновление данных об игроке
        if (up && y > r) {
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

        if (isFiring) {//Добавление пули при стрельбе
            GamePanel.bullets.add(new Bullet());
        }

    }

    public void draw(Graphics2D g) {//Для рисования
        g.setColor(color1);//Рисование 1 цветом
        g.fillOval((int) (x - r), (int) (y - r), 2 * r, 2 * r);//Смещение потому, что java рисует от верхнего левого угла
        g.setStroke(new BasicStroke(3));//Увеличение толщины линии
        g.setColor(color1.darker());//Цвет потемнее
        g.drawOval((int) (x - r), (int) (y - r), 2 * r, 2 * r);
        g.setStroke(new BasicStroke(1));
    }
}
