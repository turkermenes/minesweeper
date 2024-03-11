package com.devenes.MayinTarlasi;

import javax.swing.*;
import java.awt.*;
import java.util.Timer;
import java.util.TimerTask;

public class GameFrame extends JFrame {

    public static final int FRAME_SIZE = 700;
    public static final int SIZE = 100;
    public static final int SQUARES = FRAME_SIZE / SIZE * FRAME_SIZE / SIZE;

    public GameFrame() {
        super("Mayin Tarlasi");
        setSize(FRAME_SIZE, FRAME_SIZE);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        addMouseListener(new KeyHandler());
        GameEngine.generateBombs();
        repaint();
        Timer t = new Timer();
        t.schedule(new TimerTask() {
            @Override
            public void run() {
                if (KeyHandler.leftClicked || KeyHandler.rightClicked) {
                    repaint();
                }
            }
        }, 0, 34);
    }

    public void paint(Graphics g) {
        if (KeyHandler.rightClicked) {
            if (!GameEngine.rightClickedSquares.contains(new Point(KeyHandler.mouseX, KeyHandler.mouseY))) {
                GameEngine.rightClickedSquares.add(new Point(KeyHandler.mouseX, KeyHandler.mouseY));
                g.setColor(Color.gray);
                g.fillRect(KeyHandler.mouseX, KeyHandler.mouseY, SIZE, SIZE);
                KeyHandler.rightClicked = false;
            } else {
                GameEngine.rightClickedSquares.remove(new Point(KeyHandler.mouseX, KeyHandler.mouseY));
                g.setColor(Color.white);
                g.fillRect(KeyHandler.mouseX, KeyHandler.mouseY, SIZE, SIZE);
                KeyHandler.rightClicked = false;
            }
        }
        g.setColor(Color.black);
        int lineX = SIZE;
        int lineY = SIZE;
        for (int i = 0; i < FRAME_SIZE / SIZE - 1; i++) {
            g.drawLine(0, lineY, FRAME_SIZE, lineY);
            lineY += SIZE;
        }
        for (int i = 0; i < FRAME_SIZE / SIZE - 1; i++) {
            g.drawLine(lineX, 0, lineX, FRAME_SIZE);
            lineX += SIZE;
        }

        if (GameEngine.gameEnded) {
            g.setColor(Color.red);
            for (int i = 0; i < GameEngine.coordsOfBombs.size(); i++) {
                g.fillOval((int) GameEngine.coordsOfBombs.get(i).getX(), (int) GameEngine.coordsOfBombs.get(i).getY(), SIZE, SIZE);
            }
        }

        if (KeyHandler.leftClicked) {
            switch (KeyHandler.bombAround) {
                case 0:
                case 1:
                    g.setColor(Color.blue);
                    break;
                case 2:
                    g.setColor(Color.green);
                    break;
                case 3:
                    g.setColor(Color.red);
                    break;
                default:
                    g.setColor(Color.black);
            }
            g.setFont(new Font("Times New Roman", Font.PLAIN, 35));
            g.drawString(String.valueOf(KeyHandler.bombAround), KeyHandler.mouseX + SIZE / 2, KeyHandler.mouseY + SIZE / 2);
            KeyHandler.bombAround = 0;
            KeyHandler.leftClicked = false;
        }

    }
}
