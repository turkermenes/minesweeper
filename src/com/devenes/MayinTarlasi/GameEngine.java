package com.devenes.MayinTarlasi;

import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

public class GameEngine {
    static Random random = new Random();
    static int numberOfBombs;
    static int opened = 0;
    static boolean gameEnded = false;
    static ArrayList<Point> coordsOfBombs = new ArrayList<>();
    static ArrayList<Point> rightClickedSquares = new ArrayList<>();
    public static void generateBombs() {
        numberOfBombs = random.nextInt(1, (GameFrame.FRAME_SIZE / GameFrame.SIZE) * (GameFrame.FRAME_SIZE / GameFrame.SIZE) / 2);

        int tempX;
        int tempY;

        for (int i = 0; i < numberOfBombs; i++) {
            tempX = random.nextInt(0, GameFrame.FRAME_SIZE / GameFrame.SIZE);
            tempY = random.nextInt(0, GameFrame.FRAME_SIZE / GameFrame.SIZE);
            if (!coordsOfBombs.contains(new Point(tempX * 100, tempY * 100))) {
                coordsOfBombs.add(new Point(tempX * 100, tempY * 100));
            } else {
                i--;
            }
        }
    }
}
