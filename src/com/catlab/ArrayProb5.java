package com.catlab;

import com.sun.istack.internal.NotNull;

/**
 * Created by Momo28 on 7/4/17.
 */
class ArrayProb5 {

    /*
    5. Implement a method to perform basic string compression using the counts of repeated characters.  For example, the
    string 'aabcccccaaa' would become 'a2b1c5a3.  If the compressed string would bot become smaller than the original string,
    your method should return the original string.  You can assume the string has only upper and lower case letters (a-z).
    */

    static void problem5(){
        System.out.println("\n4. Implement a method to perform basic string compression using the counts of repeated characters.  For example, the\n" +
                "   string 'aabcccccaaa' would become 'a2b1c5a3.  If the compressed string would bot become smaller than the original string,\n" +
                "   your method should return the original string.  You can assume the string has only upper and lower case letters (a-z).\n");

        testStringCompression();

        // Visual Tests
        testStringCompressionVisually("aabcccccaaa");
        testStringCompressionVisually("Goddessship");
        testStringCompressionVisually("Mauricio");
        testStringCompressionVisually("Brrr");
        testStringCompressionVisually("Cooool");
        testStringCompressionVisually("Coooool");
        testStringCompressionVisually("Headmistressship");
    }

    private static String simpleStringCompressAlphaNonNumeric(@NotNull String uncompressedString){
        int uncompressedStringLength = uncompressedString.length();

        // Make sure we have something larger than 2 chars to compress
        if(uncompressedStringLength < 3){
            return uncompressedString;
        }
        else{
            int currentCompressedStringLength = 0;
            int charOccurrence = 1;

            // Set our first character to compare
            char lastChar = uncompressedString.charAt(0);
            StringBuilder compressedString = new StringBuilder();

            // Compare each character and increase the occurrence, or else add it to the string buffer
            for(int i = 1; i <= uncompressedStringLength; i++){

                // If we are at the last index of the string, or the last char does not equal the new one,
                // add the char+number of occurrences to the string buffer
                if(i == uncompressedStringLength || uncompressedString.charAt(i) != lastChar){
                    currentCompressedStringLength += 2;

                    if(currentCompressedStringLength >= uncompressedStringLength){
                        return uncompressedString;
                    }

                    compressedString.append(lastChar);
                    compressedString.append(charOccurrence);

                    // If this is not the last string index, set our new char to compare with and reset charOccurrence
                    if(i != uncompressedStringLength){
                        lastChar = uncompressedString.charAt(i);
                        charOccurrence = 1;
                    }
                }
                else if(uncompressedString.charAt(i) == lastChar){
                    charOccurrence++;
                }
            }

            // Concat all strings in buffer and return the compressed string.
            return compressedString.toString();
        }
    }

    private static void testStringCompression(){
    }

    private static void testStringCompressionVisually(String stringToCompress){
        String compressedString = simpleStringCompressAlphaNonNumeric(stringToCompress);
        System.out.printf("UncompressedString: \"%s\", CompressedString: \"%s\"%n", stringToCompress, compressedString);
    }
}
