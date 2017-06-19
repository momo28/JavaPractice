package com.catlab;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

/**
 * Created by black on 6/18/17.
 */
public class ArraysProb4 {

    //4. Write a method to replace all spaces in a string with '%20'. Use a Java character array.

    protected static void problem4(){
        System.out.println("\n4. Write a method to replace all spaces in a string with %20. Use a Java character array.\n");
        testSimpleHtmlEncode();
        testSimpleHtmlEncodeVisually();
    }

    private static char[] simpleHtmlEncode (char[] text, int textLength){
        int stringIterator=0;
        Queue<Character> charQueue = new ArrayDeque<>();

        while(stringIterator < textLength){
            if(text[stringIterator] == ' ' && charQueue.isEmpty()){
                text[stringIterator] = '%';
                charQueue.add(text[++stringIterator]);
                text[stringIterator] = '2';
                charQueue.add(text[++stringIterator]);
                text[stringIterator] = '0';
            }
            else if (!charQueue.isEmpty()){
                if(text[stringIterator] == ' '){
                    charQueue.add('%');
                    charQueue.add('2');
                    charQueue.add('0');
                }
                else{
                    charQueue.add(text[stringIterator]);
                }
                text[stringIterator] = charQueue.remove();
            }
            stringIterator++;
        }
        return text;
    }

    private static void testSimpleHtmlEncode(){}

    private static void testSimpleHtmlEncodeVisually(){
        String testString = "Mr John Smith    ";

        char [] testCharArr= simpleHtmlEncode(testString.toCharArray(), testString.length());
        System.out.printf(testString + "%n");
        System.out.println(Arrays.toString(testCharArr));
    }
}
