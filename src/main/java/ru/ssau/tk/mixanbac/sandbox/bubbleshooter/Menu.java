package ru.ssau.tk.mixanbac.sandbox.bubbleshooter;

import java.awt.*;

public class Menu {

    //Fields

    private int buttonWidth;
    private int buttonHeight;
    private Color buttonColor;
    private String s;

    //Constructor

    public Menu(){
        buttonWidth = 260;
        buttonHeight = 60;
        buttonColor = Color.white;
        s = "Начать игру";
    }

    //Functions

    public void draw(Graphics2D g){
        g.setColor(buttonColor);//Передача кнопке цвета
        g.setStroke(new BasicStroke(3));//Толщина контура кнопки
        g.drawRect(GamePanel.WIDTH/2 - buttonWidth/2,
                GamePanel.HEIGHT/2 - buttonHeight/2, buttonWidth, buttonHeight);//Рисуем прямоугольник
        g.setStroke(new BasicStroke(1));//Вернем толщину линии в исходное значение после рисования кнопки
        g.setColor(buttonColor);//Цвет текста на кнопке
        g.setFont(new Font("Consoles", Font.BOLD, 40));//Шрифт кнопки
        long length = (int) g.getFontMetrics().getStringBounds(s, g).getWidth();//Длина строки в кнопке
        g.drawString(s, (int) (GamePanel.WIDTH/2 - length/2),(int) (GamePanel.HEIGHT/2 + buttonHeight/4));

    }
}
