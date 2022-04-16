package com.shpp.p2p.cs.dfomenko.assignment1;

/**
 * @author Dmitriy Fomenko
 * @version 1.0
 * @date 2022-04-12
 * @review 1
 */

import com.shpp.karel.KarelTheRobot;

/**
 * Problem#1 - pick up a newspaper.
 */
public class Assignment1Part1 extends KarelTheRobot {

    public void run() throws Exception {

        goToWhereNewspaperIs();

        pickBeeper();

        returnToTheOriginalPosition();
    }

    /**
     * Go to the place with the newspaper.
     */
    private void goToWhereNewspaperIs() throws Exception {
        // walk along the North wall to the corner until you hit the wall
        turnRight();
        move();
        turnLeft();
        moveAheadToTheBeeaper();
    }

    private void moveAheadToTheBeeaper() throws Exception {
        while (noBeepersPresent()){
            move();
        }
    }

    /**
     * Return to the original position.
     */
    private void returnToTheOriginalPosition() throws Exception {

        turnAround();
        moveAheadToTheWall();

        turnRight();
        moveAheadToTheWall();
    }

    /**
     * move forward until we hit an obstacle
     */
    private void moveAheadToTheWall() throws Exception {
        while (frontIsClear()) {
            move();
        }
    }

   private void turnRight() throws Exception {
        for (int i = 0; i < 3; i++) {
            turnLeft();
        }
    }

    private void turnAround() throws Exception {
        turnLeft();
        turnLeft();
    }
}

