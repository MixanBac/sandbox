package ru.ssau.tk.mixanbac.sandbox.bubbleshooter;

import javax.swing.*;
import java.awt.*;

public class GameBack {
    //Fields
    private Color color;

    Image img = new ImageIcon("res/50650-zvezdy_tochki_iskazhenie_volny_gradient (1).jpg").getImage();//Загрузка картинки

    //Constructor
    public GameBack() {
        color = Color.BLUE;//Задание цвета
    }

    //Functions
    public void update() {

    }

    public void draw(Graphics2D g) {//Передача кисточки
        /*g.setColor(color);//Придача кисточке цвета
        g.fillRect(0, 0, GamePanel.WIDTH, GamePanel.HEIGHT);//Создание прямоугольную область

        Color colorString = new Color(200, 200, 0);//Создание объекта класса цвет
        g.setColor(colorString);//Придаем цвет объекту
        g.fillRect(0, 0, GamePanel.WIDTH, 20);//Рисуем прямоугольную область
        g.setColor(Color.WHITE);//Новый цвет
        Font font = new Font("Arial", Font.ITALIC, 20);//Создание объекта типа Font
        g.setFont(font);//Установка шрифта

        ((Graphics2D) g).drawString("", 50, 15);*/
        g.drawImage(img, (int) 0, (int) 0, null);//Отрисовка картинки

    }
}
