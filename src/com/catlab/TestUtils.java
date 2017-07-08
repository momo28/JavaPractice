package com.catlab;

/**
 * Created by Momo28 on 7/6/17.
 */
class TestUtils {

    static void perfTime(String s, StringToBool methodToTime){
        long startTime;
        long endTime;

        startTime = System.nanoTime();
        methodToTime.operation(s);
        endTime = System.nanoTime();

        double duration = (double) (endTime - startTime);
        System.out.printf("Function Run Time: %sµs%n%n", String.format( "%.2f", duration/1000));
    }
}
