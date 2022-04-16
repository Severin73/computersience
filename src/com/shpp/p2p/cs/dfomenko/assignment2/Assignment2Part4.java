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
 * Problem 4 - Tricolor-flags
 */
public class Assignment2Part4 extends WindowProgram {

//    public static final int APPLICATION_WIDTH = 600;
//    public static final int APPLICATION_HEIGHT = 400;

    public static final double PERCENT_OF_EMPTY_SPACE_FROM_TOP_AND_BOTTOM = 0.1;
    public static final double PERCENT_OF_EMPTY_SPACE_FROM_LEFT_AND_RIGHT = 0.15;

    /**
     * standard height = 469px, and good font size is 24 => 24 / 469 = 0.0511 (but good work 0.053)
     * standard width = 754px, and good font size is 24 => 24 / 754 = 0.032
     * This constants are needed to correctly change the font size relative to the size of the window
     */
    public static final double RATIO_OF_STANDARD_HEIGHT_AND_FONT_SIZE = 0.053;
    public static final double RATIO_OF_STANDARD_WEIGHT_AND_FONT_SIZE = 0.032;


    public void run() {
        Color[] colors = {Color.BLACK, Color.YELLOW, Color.RED};

        printThreeColorFlag(colors, "Flag of Belgium");
    }

    /**
     * print three color flag
     * @param colors - array of colors
     * @param string - name of the country
     */
    private void printThreeColorFlag(Color[] colors, String string) {
        // calculating the width of the one strip if a certain percentage has been removed from left and right of the canvas
        double oneStripeWidth = getWidth() * (1 - 2 * PERCENT_OF_EMPTY_SPACE_FROM_LEFT_AND_RIGHT) / 3.0;
        double xCoordinateOfFlag = getWidth() * PERCENT_OF_EMPTY_SPACE_FROM_LEFT_AND_RIGHT;

        // calculating the height of the one strip if a certain percentage has been removed from top and bottom of the canvas
        double flagHeight = getHeight() * (1 - 2 * PERCENT_OF_EMPTY_SPACE_FROM_TOP_AND_BOTTOM);
        double yCoordinateOfFlag = getHeight() * PERCENT_OF_EMPTY_SPACE_FROM_TOP_AND_BOTTOM;

        for (int i = 0; i < 3; i++) {
            GRect stripe = new GRect(xCoordinateOfFlag + i * oneStripeWidth, yCoordinateOfFlag, oneStripeWidth, flagHeight);
            stripe.setColor(colors[i]);
            stripe.setFilled(true);
            stripe.setFillColor(colors[i]);
            add(stripe);
        }
        printLable(string);
    }

    /**
     * Method prints the label of the passed String in the lower right corner. The font size is selected automatically based on the size of the screen
     * @param string - name of the country
     */
    private void printLable(String string) {
        GLabel gLabel = new GLabel(string);

        // choosing the font size based on the size of the canvas
        String font = "Verdana-bold-" + (int) Math.min((getHeight() * RATIO_OF_STANDARD_HEIGHT_AND_FONT_SIZE), getWidth() * RATIO_OF_STANDARD_WEIGHT_AND_FONT_SIZE);
        gLabel.setFont(font);
        gLabel.setLocation(getWidth() - gLabel.getWidth(), getHeight() - gLabel.getHeight() / 2);

        add(gLabel);
    }
}
