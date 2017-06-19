package com.catlab;

import com.sun.istack.internal.NotNull;
import java.util.HashMap;
import java.util.Random;

/**
 * Created by black on 6/7/17.
 */
public class ArraysProb1 {

    // 1. Implement an algorithm to determine if a string has all unique chars.
    // What if you can not use additional data structures?
    protected static void problem1(){
        System.out.printf("1. Implement an algorithm to determine if a string has all unique chars. " +
                "What if you can not use additional data structures?%n%n");

        testUniqueChars();

        String[] testStrings = {"a","adm", "maurcio", "tale", "", "tin"};
        testUniqueCharsVisually(testStrings);

        testStrings = new String[] {"adam", "mauricio", "tall", "teen"};
        testUniqueCharsVisually(testStrings);
    }

    // Time: O(n^2)  Space: O(1)
    private static boolean uniqueChars(@NotNull String s){
        if(s.length() <= 1) return true;

        for(int i=0; i< s.length(); i++){
            for (int j=0; j< s.length(); j++){

                if(s.charAt(i) == s.charAt(j) && i != j){
                    return false;
                }
            }
        }
        return true;
    }

    // Time O(n)  Space:O(1 or n ?)
    private static boolean uniqueCharsAlphaNonNumeric(@NotNull String s){
        if(s.length() <= 1) return true;
        final char[] uniqueChars = new char[26];

        for(int i=0; i< s.length(); i++){
            final int key = (int) s.charAt(i) % 26;
            if(uniqueChars[key] != s.charAt(i)){
                uniqueChars[key] = s.charAt(i);
            }
            else{
                return false;
            }
        }
        return true;
    }

    // Time: O(n)  Space: O(n)
    private static boolean uniqueCharsWithHashMap(@NotNull String s){
        if(s.length() <= 1) return true;
        final HashMap<Integer, Character> charHashMap = new HashMap<>();

        for(int i=0; i < s.length(); i++){
            if(!charHashMap.containsValue(s.charAt(i))){
                charHashMap.put(new Random().hashCode(), s.charAt(i));
            }
            else{
                return false;
            }
        }
        return true;
    }

    // Visual Test
    private static void testUniqueCharsVisually(@NotNull String[] testStrings){
        String trueResult="uniqueChars: \"%s\" has unique letters%n";
        String falseResult="uniqueChars: \"%s\" does not have unique letters%n";

        for(String s: testStrings) {
            System.out.printf( uniqueChars(s) ? trueResult : falseResult, s);
            System.out.printf(uniqueCharsAlphaNonNumeric(s) ? trueResult : falseResult, s);
            System.out.printf(uniqueCharsWithHashMap(s) ? trueResult : falseResult, s);
            System.out.printf("%n");
        }
    }

    // Test
    private static void testUniqueChars(){
        String[] testStrings = {"adm", "maurcio", "tale", "", "tin"};

        for(String s: testStrings) {
            assert uniqueChars(s);
            assert uniqueCharsAlphaNonNumeric(s);
            assert uniqueCharsWithHashMap(s);
        }

        testStrings = new String[] {"adam", "mauricio", "tall", "teen"};

        for(String s: testStrings) {
            assert !uniqueChars(s);
            assert !uniqueCharsAlphaNonNumeric(s);
            assert !uniqueCharsWithHashMap(s);
        }
    }
}
