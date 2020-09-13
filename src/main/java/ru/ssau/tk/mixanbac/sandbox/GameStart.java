package ru.ssau.tk.mixanbac.sandbox;

import javax.swing.JFrame;

public class GameStart {

    public static void main(String[] args) {

        JFrame startFrame = new JFrame("BubbleShooter");
        startFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//Установим константы по определению при нажатии крестика, для закрытия приложения

        startFrame.setContentPane(new GamePanel());
        startFrame.pack();//Фрейм по размерам будет занимать столько, сколько и его компоненты
        startFrame.setLocationRelativeTo(null);//Позиция по центру
        startFrame.setVisible(true);//Окно видимое

    }

}
