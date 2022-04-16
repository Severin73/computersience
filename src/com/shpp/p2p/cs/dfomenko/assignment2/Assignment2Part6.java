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
 * Problem 6 - Caterpillar
 */

public class Assignment2Part6 extends WindowProgram {

    public static final int APPLICATION_WIDTH = 700;
    public static final int APPLICATION_HEIGHT = 150;

    // the percentage that take the circle of the window height
    public static final double PERCENT_TAKEN_BY_ONE_CIRCLE = 0.7;

    // how much should the next circle be shifted relative to the diameter of the circle
    public static final double HORIZONTAL_DISPLACEMENT_NEXT_CIRCLE = 0.60;

    public void run() {
        drawCaterpillar(Color.RED, Color.GREEN);
    }

    /**
     * Method draws a caterpillar.
     * For this we calculate the appropriate diameter of the circle,
     * and while it is possible, we draw the caterpillar, oscillate the Y coordinates
     *
     * @param edgeColor - the color of the edge of the circle
     * @param fillColor - the color of the filling of the circle
     */
    private void drawCaterpillar(Color edgeColor, Color fillColor) {
        double diameter = getHeight() * PERCENT_TAKEN_BY_ONE_CIRCLE;

        // calculate the coordinates of the first circle. It should be touching the left border and to the lower border of the window
        double x = 0;
        double y = getHeight() - diameter;

        // need a counter to oscillate the coordinates Y of the circle
        int counter = 1;
        while (x + diameter < getWidth()) {
            GOval gOval = new GOval(x, (counter++ % 2) * y, diameter, diameter);
            gOval.setColor(edgeColor);
            gOval.setFilled(true);
            gOval.setFillColor(fillColor);
            add(gOval);
            x += diameter * HORIZONTAL_DISPLACEMENT_NEXT_CIRCLE;
        }
    }
}
