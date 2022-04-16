package com.shpp.p2p.cs.dfomenko.assignment2;

/**
 * @author Dmitriy Fomenko
 * @version 1.0
 * @date 2022-04-15
 * @review 1
 */

import acm.graphics.*;
import com.shpp.cs.a.graphics.WindowProgram;
import java.awt.*;

/**
 * Problem 5 - Another optical illusion
 */
public class Assignment2Part5 extends WindowProgram {

//    public static final int APPLICATION_WIDTH = 400;
//    public static final int APPLICATION_HEIGHT = 300;

    /* The number of rows and columns in the grid, respectively. */
    private static final int NUM_ROWS = 5;
    private static final int NUM_COLS = 6;

    /* The width and height of each box. */
    private static final double BOX_SIZE = 40;

    /* The horizontal and vertical spacing between the boxes. */
    private static final double BOX_SPACING = 10;

    public void run() {
        printBlackDotIllusion(Color.BLACK);
    }

    /**
     * Method calculates the coordinates of the first square (upper left) and using constants creates an illusion
     * @param color - color of the square
     */
    private void printBlackDotIllusion(Color color) {

        //Calculating the total width of the illusion
        double widthIllusionBox = NUM_COLS * BOX_SIZE + (NUM_COLS - 1) * BOX_SPACING;

        //Calculating the total height of the illusion
        double highIllusionBox = NUM_ROWS * BOX_SIZE + (NUM_ROWS - 1) * BOX_SPACING;

        //Calculate the coordinates of the first (upper left) square
        double x = (getWidth() - widthIllusionBox) / 2.0;
        double y = (getHeight() - highIllusionBox) / 2.0;

        for (int i = 0; i < NUM_ROWS; i++) {
            for (int j = 0; j < NUM_COLS; j++) {
                // Each time calculating the new coordinates of the square with a horizontal and vertical offset
                GRect gRect = new GRect(x + j * (BOX_SIZE + BOX_SPACING), y + i * (BOX_SIZE + BOX_SPACING), BOX_SIZE, BOX_SIZE);
                gRect.setColor(color);
                gRect.setFilled(true);
                gRect.setFillColor(color);
                add(gRect);
            }
        }
    }
}
