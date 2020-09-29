package ru.ssau.tk.mixanbac.sandbox.bubbleshooter;

import java.awt.*;

public class Wave {

    private int waveNumber;//Номер волны
    private int waveMultiplier;//Кол врагов в волне
    private long waveTimer;//Таймер
    private long waveDelay;//Время между волнами
    private long waveTimerDiff;//Разница врем
    private String waveText;//Сообщение волны


    // Constructor

    public Wave() {
        waveNumber = 1;
        waveMultiplier = 5;
        waveTimer = 0;
        waveDelay = 5000;
        waveTimerDiff = 0;
        waveText = "ВОЛНА";
    }

    //Создание врагов
    public void createEnemies() {
        int enemyCount = waveNumber * waveMultiplier;//Количество врагов
        if (waveNumber < 10) {
            while (enemyCount > 0) {//Пока
                int type = 1;//
                int rank = 1;//
                GamePanel.enemies.add(new Enemy(type, rank));//
                enemyCount -= type * rank;//Конец цикла создания врагов
            }
        }
        waveNumber++;//Изменение номера волны
    }

    public void update() {
        //Обновление таймера
        if (GamePanel.enemies.size() == 0 && waveTimer == 0) {//Если нет врагов и таймер=0
            waveTimer = System.nanoTime();//= текущее время
        }
        //Проверка на создание врагов
        if (waveTimer > 0) {//Если таймер больше времени задержки
            waveTimerDiff += (System.nanoTime() - waveTimer) / 1000000;//Разница времени
            waveTimer = System.nanoTime();//Время

        }
        if (waveTimerDiff > waveDelay) {//Если пауза закончилась
            createEnemies(); //Создаём врагов
            waveTimer = 0;//Таймер
            waveTimerDiff = 0;

        }
    }

    //Показ надписи
    public boolean showWave() {
        if (waveTimer != 0) {//Если таймер не равен нулю
            return true;
        } else return false;
    }

    //Отрисовка
    public void draw(Graphics2D g) {
        //Закон изменения прозрачности
        double divider = waveDelay / 180; //Сколько вемени прийдется на 1 градус изменения цвеа
        double alpha = waveTimerDiff / divider;//Показатель прозрачности в опреденный момент паузы
        alpha = 255 * Math.sin(Math.toRadians(alpha)); //Переводим прозрачн в радианы и определ синус и умнож на уровень прозррачности
        if (alpha < 0) alpha = 0;
        if (alpha > 255) alpha = 255;
        g.setFont(new Font("consolas", Font.PLAIN, 20));//Передаём шрифт
        g.setColor(new Color(255, 255, 255, (int) alpha));//Полная строка
        String s = waveNumber + "ая " + waveText; //Полная строка
        long length = (int) g.getFontMetrics().getStringBounds(s, g).getWidth();//Длина надписи в пиксилях
        g.drawString(s, GamePanel.WIDTH / 2 - (int) (length / 2), GamePanel.HEIGHT / 2);//Рисуем строчку в центре панели

    }
}