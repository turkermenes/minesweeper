package com.devenes.MayinTarlasi;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class KeyHandler implements MouseListener {
    public static int mouseX;
    public static int mouseY;
    public static int bombAround = 0;
    public static boolean leftClicked = false;
    public static boolean rightClicked = false;
    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        mouseX = e.getX() / 100 * 100;
        mouseY = e.getY() / 100 * 100;
        if (e.getButton() == MouseEvent.BUTTON1) {
            leftClicked = true;
            if (GameEngine.coordsOfBombs.contains(new Point(mouseX, mouseY))) {
                System.out.println("Game over!");
                GameEngine.gameEnded = true;
            } else {
                GameEngine.opened++;
                if (GameEngine.coordsOfBombs.contains(new Point(mouseX, mouseY - 100))) {
                    bombAround++;
                }
                if (GameEngine.coordsOfBombs.contains(new Point(mouseX, mouseY + 100))) {
                    bombAround++;
                }
                if (GameEngine.coordsOfBombs.contains(new Point(mouseX - 100, mouseY))) {
                    bombAround++;
                }
                if (GameEngine.coordsOfBombs.contains(new Point(mouseX + 100, mouseY))) {
                    bombAround++;
                }
                if (GameEngine.coordsOfBombs.contains(new Point(mouseX + 100, mouseY + 100))) {
                    bombAround++;
                }
                if (GameEngine.coordsOfBombs.contains(new Point(mouseX - 100, mouseY - 100))) {
                    bombAround++;
                }
                if (GameEngine.coordsOfBombs.contains(new Point(mouseX + 100, mouseY - 100))) {
                    bombAround++;
                }
                if (GameEngine.coordsOfBombs.contains(new Point(mouseX - 100, mouseY + 100))) {
                    bombAround++;
                }
                if (GameEngine.opened == GameFrame.SQUARES - GameEngine.numberOfBombs) {
                    System.out.println("Congratulations!");
                    GameEngine.gameEnded = true;
                }
            }
        }
        if (e.getButton() == MouseEvent.BUTTON3) {
            rightClicked = true;
        }

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
