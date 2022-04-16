package com.shpp.p2p.cs.dfomenko.assignment2;

/**
 * @author Dmitriy Fomenko
 * @version 1.0
 * @date 2022-04-16
 * @review 1
 */

import acm.graphics.*;
import com.shpp.cs.a.graphics.WindowProgram;
import java.awt.*;

/**
 * Problem 6 - Caterpillar extension
 */
public class Assignment2Part6ext extends WindowProgram {

    public static final int APPLICATION_WIDTH = 700;
    public static final int APPLICATION_HEIGHT = 400;

    public static final double DIAMETER_OF_CIRCLE = 20;

    // the larger the value, the more the circles will overlap each other, the smaller, the circles will be further apart
    public static final int FREQUENCY_OF_CIRCLES = 5;
    //the value 1 corresponds to one period
    public static final int NUMBER_OF_PERIODS = 3;
    // the magnitude of the oscillation amplitude of the caterpillar, the value of 1 corresponds from top to bottom
    public static final double OSCILLATION_AMPLITUDE = 0.5;

    public void run() {
        drawSinCaterpillar(Color.RED, Color.GREEN);
    }

    /**
     * Method draws a caterpillar.
     * For this we calculate the appropriate diameter of the circle,
     * and while it is possible, we draw the caterpillar, oscillate the Y coordinates
     * @param edgeColor - the color of the edge of the circle
     * @param fillColor - the color of the filling of the circle
     */
    private void drawSinCaterpillar(Color edgeColor, Color fillColor) {
        // calculating the coordinates of the first circle, in the middle of the left side of the window
        double x = 0;
        double y = getHeight() / 2.0;

        // normalization of caterpillar amplitude
        double normalization = getHeight() / 2.0 - DIAMETER_OF_CIRCLE;

        while (x < getWidth()) {
            GOval gOval = new GOval(x - DIAMETER_OF_CIRCLE/2, y - DIAMETER_OF_CIRCLE/2, DIAMETER_OF_CIRCLE, DIAMETER_OF_CIRCLE);

            gOval.setColor(edgeColor);
            gOval.setFilled(true);
            gOval.setFillColor(fillColor);
            add(gOval);

            // calculating new coordinates for the next circle
            // how much is it necessary for the circles to overlap
            x += DIAMETER_OF_CIRCLE/FREQUENCY_OF_CIRCLES;
            // a school course in trigonometry and a little logic to shove one caterpillar into a screen of the right size
            // f(x) = A * sin(k * x) + B;
            y = Math.abs(OSCILLATION_AMPLITUDE * normalization * (Math.sin(2 * NUMBER_OF_PERIODS * Math.PI * x / getWidth())) - getHeight() / 2.0);
        }
    }
}
