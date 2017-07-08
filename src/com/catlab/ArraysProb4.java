package com.catlab;

import java.util.ArrayDeque;
import java.util.Stack;
import java.util.Arrays;

/**
 * Created by Momo on 6/18/17.
 */
class ArraysProb4 {

    //4. Write a method to replace all spaces in a string with '%20'. Use a Java character array.

    static void problem4(){
        System.out.println("\n4. Write a method to replace all spaces in a string with %20. Use a Java character array.\n");
        testSimpleHtmlEncode();
        testSimpleHtmlEncodeVisually();
    }

    private static char[] simpleHtmlEncode (char[] text, int textLength){
        int stringIterator=0;
        ArrayDeque<Character> charQueue = new ArrayDeque<>();

        /*
            Go through the string, and use a queue to store all Chars once the first space is encountered.  If other spaces
        are encountered, inject '%20' instead of a space into the queue, and finally transfer all values in the queue back
        into the original string.
        */
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

    private static void testSimpleHtmlEncode(){
        String testString = "Mr John Smith    ";
        Stack<Integer> arrayIndexStack = new Stack<>();
        boolean actualString = false;

        // Get the indexes which have a space in the original string, avoiding the end spaces.
        for(int i=testString.length()-1; i>=0; i--){
            if(!actualString &&  testString.charAt(i) != ' '){
                actualString = true;
            }

            if(actualString && testString.charAt(i) == ' '){
                arrayIndexStack.push(i);
            }
        }

        // Call function to do a simpleHTMLEncode
        char [] testCharArr= simpleHtmlEncode(testString.toCharArray(), testString.length());
        int arrayIndexOffset = 0;

        // Look that '%20' is present at the array index of the original string + the offset of other spaces
        while(!arrayIndexStack.isEmpty()){
            int arrayIndex = arrayIndexStack.pop() + arrayIndexOffset;

            assert(testCharArr[arrayIndex] == '%');
            assert(testCharArr[arrayIndex + 1] == '2');
            assert(testCharArr[arrayIndex + 2] == '0');

            arrayIndexOffset += 2;
        }

    }

    private static void testSimpleHtmlEncodeVisually(){
        String testString = "Mr John Smith    ";
        char [] testCharArr= simpleHtmlEncode(testString.toCharArray(), testString.length());
        System.out.printf(testString + "%n");
        System.out.println(Arrays.toString(testCharArr));

        String testString2 = "I can eat a burger        ";
        char [] testCharArr2= simpleHtmlEncode(testString2.toCharArray(), testString2.length());
        System.out.printf(testString2 + "%n");
        System.out.println(Arrays.toString(testCharArr2));
    }
}
