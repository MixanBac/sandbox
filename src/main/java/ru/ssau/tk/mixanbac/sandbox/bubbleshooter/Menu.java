package ru.ssau.tk.mixanbac.sandbox.bubbleshooter;

import java.awt.*;

public class Menu {

    //Fields
    private int buttonWidth;
    private int buttonHeight;
    private Color buttonColor;

    //Constructor
    public Menu(){
        buttonWidth = 120;
        buttonHeight = 60;
        buttonColor = Color.white;
    }
    //Functions

    public void draw(Graphics2D g){
        g.setColor(buttonColor);//Передача кнопке цвета
        g.setStroke(new BasicStroke(3));//Толщина контура кнопки
        g.drawRect(GamePanel.WIDTH/2 - buttonWidth/2,
                GamePanel.HEIGHT/2 - buttonHeight/2, buttonWidth, buttonHeight);//Рисуем прямоугольник
        g.setStroke(new BasicStroke(1));//Вернем толщину линии в исходное значение после рисования кнопки

    }
}
