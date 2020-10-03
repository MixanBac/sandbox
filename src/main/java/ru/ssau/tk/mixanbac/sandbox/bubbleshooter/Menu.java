package ru.ssau.tk.mixanbac.sandbox.bubbleshooter;

import java.awt.*;

public class Menu {

    //Fields

    private int buttonWidth;
    private int buttonHeight;
    private Color buttonColor;
    private String s;
    private int transp = 0;//Прозрачность

    //Constructor

    public Menu() {
        buttonWidth = 260;
        buttonHeight = 60;
        buttonColor = Color.white;
        s = "Начать игру";
    }

    //Functions
    public void update() {
        if (GamePanel.mouseX > GamePanel.WIDTH / 2 - buttonWidth / 2 &&
                GamePanel.mouseX < GamePanel.WIDTH + buttonWidth / 2 &&
                GamePanel.mouseY > GamePanel.HEIGHT / 2 - buttonHeight / 2 &&
                GamePanel.mouseY < GamePanel.HEIGHT / 2 + buttonHeight / 2) {//Если мышь попала в область кнопки
        transp = 60;
        } else {
            transp = 0;
        }
    }

    public void draw(Graphics2D g) {
        g.setColor(buttonColor);//Передача кнопке цвета
        g.setStroke(new BasicStroke(3));//Толщина контура кнопки
        g.drawRect(GamePanel.WIDTH / 2 - buttonWidth / 2,
                GamePanel.HEIGHT / 2 - buttonHeight / 2, buttonWidth, buttonHeight);//Рисуем прямоугольник
        g.setColor(new Color(255, 255, 255, transp));
        g.fillRect(GamePanel.WIDTH / 2 - buttonWidth / 2,
                GamePanel.HEIGHT / 2 - buttonHeight / 2, buttonWidth, buttonHeight);//Кнопка начинает мигать при нажатии

        g.setStroke(new BasicStroke(1));//Вернем толщину линии в исходное значение после рисования кнопки
        g.setColor(buttonColor);//Цвет текста на кнопке
        g.setFont(new Font("Consoles", Font.BOLD, 40));//Шрифт кнопки
        long length = (int) g.getFontMetrics().getStringBounds(s, g).getWidth();//Длина строки в кнопке
        g.drawString(s, (int) (GamePanel.WIDTH / 2 - length / 2), (int) (GamePanel.HEIGHT / 2 + buttonHeight / 4));

    }
}
