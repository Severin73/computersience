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
 * Problem 2 - Illusory contours
 */
public class Assignment2Part2 extends WindowProgram {

    public static final int APPLICATION_WIDTH = 300;
    public static final int APPLICATION_HEIGHT = 300;

    public void run() {
        double width = getWidth();
        double height = getHeight();
        double diameter = findProperDiameter(width, height);

        // find the coordinate of the lower right circle
        double x = width - diameter;
        double y = height - diameter;

        drawFourCircles(x, y, diameter, diameter, Color.BLACK, Color.BLACK);
        drawRectangle(x, y, diameter, diameter, Color.WHITE, Color.WHITE);
    }

    /**
     * Draws a rectangle with the given parameters.
     * @param x - x coordinate of the rectangle (left corner).
     * @param y - y coordinate of the rectangle (left corner).
     * @param diameterX - width of the rectangle.
     * @param diameterY - height of the rectangle.
     * @param colorEdge - color of the rectangle's edge.
     * @param colorFill - color of the rectangle's fill.
     */
    private void drawRectangle(double x, double y, double diameterX, double diameterY, Color colorEdge, Color colorFill) {
        GRect gRect = new GRect(diameterX / 2,  diameterY / 2, x, y);
        gRect.setColor(colorEdge);
        add((GRect) setFillColorToObject(gRect, colorFill));
    }

    /**
     * Draws four circles with the given parameters.
     * @param x - x coordinate of the circle (left corner of the rectangle).
     * @param y - y coordinate of the circle (left corner of the rectangle).
     * @param diameterX - width of the circle.
     * @param diameterY - height of the circle.
     * @param colorEdge - color of the circle's edge.
     * @param colorFill - color of the circle's fill.
     */
    private void drawFourCircles(double x, double y, double diameterX, double diameterY, Color colorEdge, Color colorFill) {
        add(createCircle(0, 0, diameterX, diameterY, colorEdge, colorFill));
        add(createCircle(x, y, diameterX, diameterY, colorEdge, colorFill));
        add(createCircle(0, y, diameterX, diameterY, colorEdge, colorFill));
        add(createCircle(x, 0, diameterX, diameterY, colorEdge, colorFill));
    }

    /**
     * Creates a circle with the given parameters.
     * @param x - x coordinate of the circle (left corner of the rectangle).
     * @param y - y coordinate of the circle (left corner of the rectangle).
     * @param diameterX - width of the circle.
     * @param diameterY - height of the circle.
     * @param colorEdge - color of the circle's edge.
     * @param colorFill - color of the circle's fill.
     * @return - the circle with the specified parameters.
     */
    private GOval createCircle(double x, double y, double diameterX, double diameterY, Color colorEdge, Color colorFill) {
        GOval circle = new GOval(x, y, diameterX, diameterY);
        circle.setColor(colorEdge);
        return (GOval) setFillColorToObject(circle, colorFill);
    }

    /**
     * Finds the proper diameter of the circle.
     * @param width - width of the window.
     * @param height - height of the window.
     * @return - the diameter of the circle that fits in the window 3 times.
     */
    private double findProperDiameter(double width, double height) {
        return Math.min(width, height) / 3.0;
    }

    /**
     * Sets the color of the given object to the given color.
     * @param gFillable - The object to set the color of.
     * @param color - The color to set the object to.
     * @return - The object with the given color.
     */
    private GFillable setFillColorToObject(GFillable gFillable, Color color) {
        gFillable.setFilled(true);
        gFillable.setFillColor(color);
        return gFillable;
    }
}
