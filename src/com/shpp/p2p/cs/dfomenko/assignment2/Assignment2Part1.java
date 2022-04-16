package com.shpp.p2p.cs.dfomenko.assignment2;

/**
 * @author Dmitriy Fomenko
 * @version 1.0
 * @date 2022-04-12
 * @review 1
 */

import com.shpp.cs.a.console.TextProgram;

/**
 * Problem 1 - solving the quadratic equation.
 */
public class Assignment2Part1 extends TextProgram {

    public void run() {
        double coefficientA = readInt("Please enter a: ");
        double coefficientB = readInt("Please enter b: ");
        double coefficientC = readInt("Please enter c: ");

        solveEquation(coefficientA, coefficientB, coefficientC);
    }

    /**
     * We choose different options based on their coefficients.
     */
    private void solveEquation(double coefficientA, double coefficientB, double coefficientC) {
        // A = 0
        if (coefficientA == 0) {
            solveIfItNotQuadraticEquation(coefficientB, coefficientC);
        } else {
            // A != 0
            solveIfItQuadraticEquation(coefficientA, coefficientB, coefficientC);
        }
    }

    /**
     * if the first coefficient is exactly zero we solve the equation.
     * @param coefficientB second coefficient of quadratic equation.
     * @param coefficientC third coefficient of quadratic equation.
     */
    private void solveIfItNotQuadraticEquation(double coefficientB, double coefficientC) {
        // 0*(x^2) + 0*x + 0 = 0
        if (coefficientB == 0 && coefficientC == 0) {
            println("There are infinite number of roots");
            return;
        }

        // 0*(x^2) + 0*x + c = 0
        if (coefficientB == 0 && coefficientC != 0) {
            println("There are no roots");
            return;
        }

        // 0*(x^2) + b*x + 0 = 0 or 0*(x^2) + b*x + c = 0
        if (coefficientB != 0) {
            println("There one root: " + (-coefficientC / coefficientB));
        }
    }

    /**
     * If the first coefficient is not exactly zero, and we get the quadratic equation.
     * @param a, b, c double coefficients of quadratic equation (a != 0).
     */
    private void solveIfItQuadraticEquation(double a, double b, double c) {

        double discriminant = getDiscriminant(a, b, c);

        if (discriminant > 0) {
            double root1 = (-b + Math.sqrt(discriminant)) / (2 * a);
            double root2 = (-b - Math.sqrt(discriminant)) / (2 * a);
            println("There are two roots: " + root1 + " and " + root2);
        } else if (discriminant == 0) {
            double root = -b / (2 * a);
            println("There is one root: " + root);
        } else {
            println("There are no real roots");
        }
    }

    /**
     * Calculates discriminant of quadratic equation.
     * @param a first coefficient of quadratic equation.
     * @param b second coefficient of quadratic equation.
     * @param c third coefficient of quadratic equation.
     */
    private double getDiscriminant(double a, double b, double c) {
        return (b * b - 4 * a * c);
    }
}
