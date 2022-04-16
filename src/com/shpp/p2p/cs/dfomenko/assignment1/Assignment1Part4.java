package com.shpp.p2p.cs.dfomenko.assignment1;

/**
 * @author Dmitriy Fomenko
 * @version 1.1
 * @date 2022-04-14
 * @review 2
 */

import com.shpp.karel.KarelTheRobot;

/**
 * Problem # 4-chessboard
 */
public class Assignment1Part4 extends KarelTheRobot {

    public void run() throws Exception {
        // put beeper where Karel appears
        putBeeper();
        createChessBoard();
    }

    /**
     * recursive method
     */
    private void createChessBoard() throws Exception {
        fillOneRowByBeeperThroughOneCell();
        returnToTheWestEdge();
        if (rightIsClear()) {
            moveToTheNextRowIfPossible();
            createChessBoard();
        }
    }

    /**
     * Karel move to the East edge and pub beepers through one the cell
     */
    private void fillOneRowByBeeperThroughOneCell() throws Exception {
        while (frontIsClear()) {
            if (frontIsClear()){
                move();
                if (frontIsClear()) {
                    move();
                    putBeeper();
                }
            }
        }
    }

    /**
     * Karel is by the East edge. Karel turnAround and move to the West edge
     */
    private void returnToTheWestEdge() throws Exception {
        turnAround();
        while (frontIsClear()) {
            move();
        }
    }

    /**
     * Depending on whether the beeper is in the cell on the western edge,
     * we choose how to move Karl to the next row and where to put the beeper.
     * If the beeper is on the edge, we move to the next row, move one cell to East and put the beeper.
     * If the beeper is not on the edge, we move to the next row, put the beeper, after turn right.
     */
    private void moveToTheNextRowIfPossible() throws Exception {
        if (beepersPresent() && rightIsClear()) {
            turnRight();
            move();
            turnRight();
            if (frontIsClear()) {
                move();
                putBeeper();
            }
        } else if (noBeepersPresent() && rightIsClear()) {
            turnRight();
            move();
            turnRight();
            putBeeper();
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
