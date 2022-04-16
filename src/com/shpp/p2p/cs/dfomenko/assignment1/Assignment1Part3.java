package com.shpp.p2p.cs.dfomenko.assignment1;

/**
 * @author Dmitriy Fomenko
 * @version 1.1
 * @date 2022-04-14
 * @review 2
 */

import com.shpp.karel.KarelTheRobot;

/**
 * Problem 3 - finding the middle ground
 */
public class Assignment1Part3 extends KarelTheRobot {

    public void run() throws Exception {
        findTheMiddleCell();
        putBeeper();
    }

    /**
     * Method that finds the middle cell. Two steps forward and one step back.
     */
    private void findTheMiddleCell() throws Exception {
        //2 step forward
        if (frontIsClear()) {
            move();
            if (frontIsClear()) {
                move();
            }
            findTheMiddleCell();
            move(); // step back = Karel goes back exactly half the times he went forward.
        } else {
            turnAround();
        }
    }

    private void turnAround() throws Exception {
        turnLeft();
        turnLeft();
    }
}
