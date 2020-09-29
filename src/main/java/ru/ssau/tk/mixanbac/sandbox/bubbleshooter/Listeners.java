package ru.ssau.tk.mixanbac.sandbox.bubbleshooter;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Listeners implements KeyListener {//Для управления кнопками

    public void keyPressed(KeyEvent e) {//Определяет, была ли нажата клавиша на клавиатуре
        int key = e.getKeyCode();//Числовой код нажатой на клавиатуре клавишей

        if (key == KeyEvent.VK_W) {//Сравниваем с нажатием на кнопку W
            Player.up = true;
        }

        if (key == KeyEvent.VK_S) {//Сравниваем с нажатием на кнопку S
            Player.down = true;
        }

        if (key == KeyEvent.VK_A) {//Сравниваем с нажатием на кнопку A
            Player.left = true;
        }

        if (key == KeyEvent.VK_D) {//Сравниваем с нажатием на кнопку D
            Player.right = true;
        }

        if (key == KeyEvent.VK_SPACE) {//Стрельба игрока на кнопку SPACE
            Player.isFiring = true;
        }
    }

    public void keyReleased(KeyEvent e) {//Вызывается при отпускании любой клавиши на клавиатуре
        int key = e.getKeyCode();//Числовой код нажатой на клавиатуре клавишей

        if (key == KeyEvent.VK_W) {//Сравниваем с нажатием на кнопку W
            Player.up = false;
        }

        if (key == KeyEvent.VK_S) {//Сравниваем с нажатием на кнопку S
            Player.down = false;
        }

        if (key == KeyEvent.VK_A) {//Сравниваем с нажатием на кнопку A
            Player.left = false;
        }

        if (key == KeyEvent.VK_D) {//Сравниваем с нажатием на кнопку D
            Player.right = false;
        }
        if (key == KeyEvent.VK_SPACE) {//Прекращение огня если кнопка SPACE не нажата
            Player.isFiring = false;
        }
    }

    public void keyTyped(KeyEvent e) {//Вызывается системой каждый раз, когда пользователь нажимает на клавиатуре клавиши символы Unicode

    }

}
