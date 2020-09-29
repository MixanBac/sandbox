package ru.ssau.tk.mixanbac.sandbox.bubbleshooter;

import java.awt.*;

public class GameBack {
    //Fields
    private Color color;

    //Constructor
    public GameBack() {
        color = Color.BLUE;//Задание цвета
    }

    //Functions
    public void update() {

    }

    public void draw(Graphics2D g) {//Передача кисточки
        g.setColor(color);//Придача кисточке цвета
        g.fillRect(0, 0, GamePanel.WIDTH, GamePanel.HEIGHT);//Создали прямоугольник игры
    }
}
