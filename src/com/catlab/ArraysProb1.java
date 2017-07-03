package com.catlab;

import com.sun.istack.internal.NotNull;
import java.util.HashMap;
import java.util.Random;

/**
 * Created by Momo on 6/7/17.
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

        // Brute force, compare every char to every other char
        for(int i=0; i< s.length(); i++){
            for (int j=0; j< s.length(); j++){

                if(s.charAt(i) == s.charAt(j) && i != j){
                    return false;
                }
            }
        }
        return true;
    }

    // Time O(n)  Space:O(1)
    private static boolean uniqueCharsAlphaNonNumericLowercase(@NotNull String s){
        if(s.length() <= 1) return true;
        final char[] uniqueChars = new char[26];

        // If only Alpha-Lowercase-NonNumeric chars can be depended on, than we can use a simple array alphabet dictionary.
        // to keep duplicate occurrences of chars.  For Uppercase, and Numeric, use a bigger array dictionary.
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

        // Use a hashmap dictionary to keep track of duplicates in an efficient way.  Add the char to the dictionary
        // if it doesn't exist.  If it is already there, then the chars in the string are not unique.
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
            System.out.printf(uniqueCharsAlphaNonNumericLowercase(s) ? trueResult : falseResult, s);
            System.out.printf(uniqueCharsWithHashMap(s) ? trueResult : falseResult, s);
            System.out.printf("%n");
        }
    }

    // Test
    private static void testUniqueChars(){
        String[] testStrings = {"adm", "maurcio", "tale", "", "tin"};

        for(String s: testStrings) {
            assert uniqueChars(s);
            assert uniqueCharsAlphaNonNumericLowercase(s);
            assert uniqueCharsWithHashMap(s);
        }

        testStrings = new String[] {"adam", "mauricio", "tall", "teen"};

        for(String s: testStrings) {
            assert !uniqueChars(s);
            assert !uniqueCharsAlphaNonNumericLowercase(s);
            assert !uniqueCharsWithHashMap(s);
        }
    }
}
