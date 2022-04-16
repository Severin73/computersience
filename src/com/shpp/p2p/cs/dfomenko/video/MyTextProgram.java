package com.shpp.p2p.cs.dfomenko.video;

import com.shpp.cs.a.console.TextProgram;

public class MyTextProgram extends TextProgram {

    public void run() {
        println("hello world");

        int n1 = readInt("n1: ");
        int n2 = readInt("n2: ");

        //int sum = n1 + n2;



        println("result = " + (n1 + n2));
    }

}
