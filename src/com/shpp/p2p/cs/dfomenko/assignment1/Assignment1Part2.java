package com.shpp.p2p.cs.dfomenko.assignment1;

/**
 * @author Dmitriy Fomenko
 * @version 1.1
 * @date 2022-04-14
 * @review 2
 */

import com.shpp.karel.KarelTheRobot;

/**
 * Problem#2 - rows of stones
 */
public class Assignment1Part2 extends KarelTheRobot {

    public void run() throws Exception {
        fillAllColumnsByBeepersWhereEmpty();
    }

    private void fillAllColumnsByBeepersWhereEmpty() throws Exception {
        turnLeft();
        fillTheColumnByBeepersWhereEmpty();
        returnToTheSouthEdgeOfTheWorld();
        if (frontIsClear()) {
            moveToNextColumn();
            fillAllColumnsByBeepersWhereEmpty();
        }
    }

    /**
     * Complement the stones in the column where they are not.
     */
    private void fillTheColumnByBeepersWhereEmpty() throws Exception {

        if (noBeepersPresent()) {
            putBeeper();
        }

        if (frontIsClear()) {
            move();
            fillTheColumnByBeepersWhereEmpty();
        }
    }

    /**
     * returns to the edge of the world.
     */
    private void returnToTheSouthEdgeOfTheWorld() throws Exception {
        turnAround();
        moveAheadToWall();
        turnLeft();
    }

    /**
     * movement from anywhere in the world towards the eastern edge of the world
     */
    private void moveAheadToWall() throws Exception {
        while (frontIsClear()) {
            move();
        }
    }

    /**
     * movement to the next column from the current column
     */
    private void moveToNextColumn() throws Exception {
        for (int i = 0; i < 4; i++) {
            move();
        }
    }

    private void turnAround() throws Exception {
        turnLeft();
        turnLeft();
    }
}
