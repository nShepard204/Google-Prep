package com.example;

import java.util.*;

/**
 * Holds all of my solution for Chapter 1 of Cracking The Coding Interview (Strings & Arrays).
 */
public class ChapterOne {

    // This method takes in a string and determines if it has completely unique characters (First Iteration) - Appears Correct.
    public static boolean isUnique(String input){
        /**
         * General idea: Iterate through each character in the string, and check if its in a list that contains all the
         * characters we've visited so far. If we find a character in the string thats also in the list, that character has occurred more than once,
         * hence it's not unique so we return false. Otherwise we add that character to the list and continue.
         */
        List<Character> memo = new ArrayList<Character>();
        boolean retVal = true;

        for(int i = 0; i < input.length(); i++){
            char currentChar = input.charAt(i);
            if(memo.contains(currentChar)){
                retVal = false;
            } else {
                memo.add(currentChar);
            }
        }

        return retVal;
    }

    // TODO: Implement isUnique w/ no additional data structures.


    /**
     * This helper method takes in a string (str) and returns a HashMap where the keys are the chars in str
     * and the vals are the number of occurrences of that char in str.
     */
    public static HashMap<Character, Integer> buildCharMap(String str){
        HashMap<Character, Integer> charMap = new HashMap<Character, Integer>();
        
        for(int i = 0; i < str.length(); i++)
        {
            char currentChar = str.charAt(i);
            if(charMap.get(currentChar) == null)
            {
                charMap.put(currentChar, 1);
            }
            else 
            {
                charMap.put(currentChar, charMap.get(currentChar) + 1);
            }
        }

        return charMap;
    }

    // This method takes two strings and determines if one is a permutation of the other 
    // (In other words, if they contain the same characters, the same number of times.)
    public static boolean checkPermutation(String strOne, String strTwo)
    {
        /**
         * Brute Force: Make a HashMap for each string s.t. the keys are the chars in the str and the int is the number of times it occurs.
         *              Compare the two and if they're equal, we got a permutation.
        **/
        boolean retVal = true;
        HashMap<Character, Integer> mapOne = buildCharMap(strOne);
        HashMap<Character, Integer> mapTwo = buildCharMap(strTwo);

        if(mapOne.equals(mapTwo)){
            retVal = true;
        } else {
            retVal = false;
        }

        return retVal;
    }

    /**
     * This method takes in a string (str) and returns a version of that string where all spaces have been replaced w/ '%20'.
     */
    public static String urlify(String str){
        /**
         * General Idea: First we need to convert the string into a char array. Then we need to iterate through the array and for each space element
         * we encounter, we overwrite it's value with %20. Finally we turn that char array back into a string and return it. (Did not work).
         * 
         * New Idea: First, we count every occurrance of a space in str, then we make a new char array whose size is str.length + (3 * count).
         *           After this we iterate through this 
        **/

        char[] strArray = str.toCharArray();
        List<Integer> spaceIndicies = new ArrayList<Integer>();
        int count = 0;

        for(int i = 0; i < strArray.length; i++){
            if(strArray[i] == ' '){
                spaceIndicies.add(i);
                count++;
            }
        }

        char[] newStr = new char[strArray.length + (count * 2)];
        int j = 0;
        for(int i = 0; i < newStr.length; i++){
            if(spaceIndicies.contains(j))
            {
                newStr[i] = '%';
                newStr[i+1] = '2';
                newStr[i+2] = '0';
                i += 2;
            } else {
                newStr[i] = strArray[j];
            }
            j++;
        }

        String retVal = String.copyValueOf(newStr);
        return retVal;
    }

    /**
     * 
     * This function checks if a given string is a permutation of a palindrome.
     */
    public static boolean isPalinPermutation(String str){
        boolean retVal = true;
        HashMap<Character, Integer> charCounts = buildCharMap(str);
        
        for(int value : charCounts.values()){
            if(str.length() % 2 == 0){
                if(value % 2 != 0){ 
                    retVal = false; 
                }
            } else {
                // If the value we're at is odd and not one.
                if( (value % 2 == 1 && value != 1) || (charCounts.keySet().size() == str.length() && str.length() > 1) ){
                    retVal = false;
                
                }
            }
        }

        return retVal;
    }

    public static boolean oneAway(String str1, String str2){
        boolean retVal = true;

        char[] test = str1.toCharArray();
        System.out.println(test);

        return retVal;
    }
    
    public static void main(String[] args){
        System.out.println();
    }
}
