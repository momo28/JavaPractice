package com.catlab;

import com.sun.istack.internal.NotNull;
import java.util.HashMap;
import java.util.Random;

/**
 * Created by black on 6/7/17.
 */
public class ArraysProb3 {

    //3. Given 2 strings, write a method to decide if one is a permutation of the other.
    protected static void problem3(){
        System.out.printf("3. Given 2 strings, write a method to decide if one is a permutation of the other.%n%n");
        testStringPermutation();

        String[] testStrings = {"a","adam", "", "Maurcio", "tale", "la", "tin", "maury", "in", "bin", "nit", "d"};
        testStringPermutaionVisually(testStrings);
    }

    private static boolean areStringPermutation(
            @NotNull String str1,
            @NotNull String str2){

        if(str1.isEmpty() || str2.isEmpty()){
            return false;
        }
        else if(str1.equals(str2)){
            return true;
        }
        else if(str1.length() >= str2.length()){
            return stringPermutation(str1.toLowerCase(), str2.toLowerCase());
        }
        else{
            return stringPermutation(str2.toLowerCase(), str1.toLowerCase());
        }
    }

    // Optimal solution: Time O(n) Space O(n)
    private static boolean stringPermutation(
            @NotNull String str1,
            @NotNull String str2){
        HashMap<Integer, Character> stringPermutationMap = new HashMap<>();

        for (int i=0; i<str1.length(); i++){
            stringPermutationMap.put(new Random().hashCode(), str1.charAt(i));
        }

        for (int j=0; j<str2.length(); j++){
         if(!stringPermutationMap.containsValue(str2.charAt(j))){
             return false;
         }
        }

        return true;
    }

    // Test
    private static void testStringPermutation(){
        String[] testStrings = {
            "tiffiny",
            "tiffyin",
            "tiinffy",
            "tiinyff",
            "tiyffin",
            "tiyinff",
            "fftiyin",
            "fftiiny",
            "ffinyti",
            "ffintiy",
            "ffyinti",
            "ffytiin",
            "intiffy",
            "intiyff",
            "infftiy",
            "inffyti",
            "inytiff",
            "inyffti",
            "ytiinff",
            "Ytiffin",
            "yffinti",
            "yfftiin",
            "yinffti",
            "yintiff",
        };

        String[] testStrings2 = {
            "",
            "wer",
            "tyu",
            "iop",
            "asd",
            "fgh",
            "jkl",
            "ZXC",
            "vbn",
            "mq"
        };

        for(int i=0; i<testStrings.length-1; i++) {
            assert areStringPermutation(testStrings[i],testStrings[i+1]);
        }

        for(int i=0; i<testStrings2.length-1; i++) {
            assert !areStringPermutation(testStrings2[i],testStrings2[i+1]);
        }
    }

    // Visual Test
    private static void testStringPermutaionVisually(@NotNull String[] strArray1){
        String trueResult= "strings: \"%s\" and \"%s\" are permutations%n";
        String falseResult= "strings: \"%s\" and \"%s\" are not permutations%n";

        for(String i:strArray1){
            for (String j:strArray1){
                System.out.printf(areStringPermutation(i, j) ? trueResult : falseResult, i, j);
            }
        }
    }
}
