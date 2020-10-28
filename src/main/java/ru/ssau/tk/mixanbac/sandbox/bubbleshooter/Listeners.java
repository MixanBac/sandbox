package ru.ssau.tk.mixanbac.sandbox.bubbleshooter;

import java.awt.event.*;

public class Listeners implements KeyListener, MouseListener, MouseMotionListener {//Для управления кнопками

    private boolean isFiring_on;//Достать патрон

    public static boolean is_nip;//Захват

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

        if (key == KeyEvent.VK_SPACE) {
            if (isFiring_on)// если патрон в патроннике
                Player.isFiring = true; //стрельба разрешена
            isFiring_on = false;  // нет патрона
        }
        if (key == KeyEvent.VK_ESCAPE) {
            GamePanel.state = GamePanel.STATES.MENU;
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
        if (key == KeyEvent.VK_SPACE) {
            Player.isFiring = false;
            isFiring_on = true; // Патрон в обойме
        }

    }

    public void keyTyped(KeyEvent e) {//Вызывается системой каждый раз, когда пользователь нажимает на клавиатуре клавиши символы Unicode

    }


    public void mouseClicked(MouseEvent e) {

    }

    public void mousePressed(MouseEvent e) {
        if (e.getButton() == MouseEvent.BUTTON1) {
            if (GamePanel.state == GamePanel.STATES.MENU) {
                GamePanel.leftMouse = true;
            }
            if (GamePanel.state == GamePanel.STATES.PLAY) {
                Player.isFiring = true;
            }
        }
        if (e.getButton() == MouseEvent.BUTTON3) {
            is_nip= true;
        }
    }


    public void mouseReleased(MouseEvent e) {
        if (e.getButton() == MouseEvent.BUTTON1) {
            GamePanel.player.isFiring = false;
            //isFiring_on = true;
            GamePanel.leftMouse = false;
        }
        if (e.getButton() == MouseEvent.BUTTON3) {
            is_nip= false;
        }
    }


    public void mouseEntered(MouseEvent e) {

    }


    public void mouseExited(MouseEvent e) {

    }


    public void mouseDragged(MouseEvent e) {//Если тащим мышь
        GamePanel.mouseX = e.getX();//Содержит координаты мыши
        GamePanel.mouseY = e.getY();
    }


    public void mouseMoved(MouseEvent e) {//Если мышь двигалась
        GamePanel.mouseX = e.getX();
        GamePanel.mouseY = e.getY();
    }
}
