package com.github.spbennett;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sbennett on 7/3/15.
 * Design an algorithm that will return the largest Palindrome in a given string
 */
public class largestPalindrome {

    /**
     * Scan through each index in the input String array and check
     * if index-n is equal to index+n and store the count.
     * @param input
     * @return
     */
    String largestPalindrome(String input){
        List<String> palindromes = new ArrayList<String>();

        int beginIndex = 0;
        int endIndex = 0;

        for (int i=0; i < input.length(); i++){
            String testPalindrome;
            String palindrome = "";
            /*
            Create a string for palindrome testing by taking the current
            character and adding it's left and right siblings to it.
             */
            for (int j=1; j<input.length(); j++){
                beginIndex = i-j;
                endIndex = i+1+j;
                if (beginIndex >= 0 && endIndex <= input.length()){
                    testPalindrome = input.substring(beginIndex, endIndex);
                    if (isPalindrome(testPalindrome)){
                        palindromes.add(testPalindrome);
                    } else {
                        // Anytime the String in question stops being a palindrome
                        // reset our indexes and break the loop.
                        beginIndex = 0;
                        endIndex = 0;
                        break;
                    }
                }
            }

        }

        String largest = "";
        for (String current : palindromes){
            if (current.length() > largest.length())
                largest = current;
        }

        return largest;
    }

    boolean isPalindrome(String input){
        // type safety
        if (input == null)
            return false;

        // only accept palindromes greater than 2 characters.
        if(input.length() < 2) {
            return false;
        }

        // The starting character must equal the ending character
        // in order to be a palindrome.
        char[] temp = input.toCharArray();
        for(int i=0; i<temp.length; i++) {
            char first = temp[i];
            char last = temp[temp.length-1-i];
            if (first != last)
                return false;
        }
        return true;
    }

    public static void main(String args[]){
        largestPalindrome x = new largestPalindrome();
        String result = x.largestPalindrome("heylolheyhahheywowow");
        System.out.print(result);
    }
}
