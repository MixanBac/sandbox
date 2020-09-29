package ru.ssau.tk.mixanbac.sandbox.bubbleshooter;

import java.awt.*;

public class Wave {

    //Fields
    private int waveNumber;
    private int waveMultiplier;
    private long waveTimer;//Таймер
    private long waveDelay;
    private long waveTimerDiff;

    private String waveText;

    //Constructor
    public Wave() {//Инициализация переменных
        waveNumber = 1;
        waveMultiplier = 5;//Количество врагов в первую волну
        waveTimer = 0;
        waveDelay = 5000;//Количество миллисекунд
        waveTimerDiff = 0;

        waveText = " В О Л Н А -";

    }
    //Functions

    public void createEnemies() {//Создание врагов
        int enemyCount = waveNumber * waveMultiplier;
        if (waveNumber < 4) {
            while (enemyCount > 0) {
                int type = 1;
                int rank = 1;
                GamePanel.enemies.add(new Enemy(type, rank));//Создание врагов
                enemyCount -= type * rank;//Вычитание стоимости врага из инвестиций
            }

        }
    }

    public void update() {//После каждой волны ждет 5 минут и запустит новую волну
        if (GamePanel.enemies.size() == 0 && waveTimer == 0) ;
        {//Если живых врагов не осталось
            waveTimer = System.nanoTime();

        }
        if (waveTimer > 0) {
            waveTimerDiff += (System.nanoTime() - waveTimer) / 1000000;
            waveTimer = System.nanoTime();
        }
        if (waveTimerDiff > waveDelay) {
            createEnemies();//Создание врагов
            waveTimer = 0;
            waveTimerDiff = 0;
        }

    }

    public boolean showWave() {//Будет ли показываться надпись или нет
        if (waveTimer != 0) {//Показываем пока не обнулился таймер
            return true;
        } else return false;
    }

    public void draw(Graphics2D g) {//Создание прозрачности надписи
        double divider = waveDelay / 180;
        double alpha = waveTimerDiff / divider;
        alpha = 255 * Math.sin(Math.toRadians(alpha));//Нахождение синуса от числа переведенного в радианы
        g.setColor(new Color(255, 255, 255, (int) alpha));
        g.drawString(waveText, GamePanel.WIDTH / 2, GamePanel.HEIGHT / 2);//Рисование строки посередине

    }

}
