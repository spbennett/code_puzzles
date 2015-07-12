package com.github.spbennett;

/**
 * Created by sbennett on 7/8/15.
 * EASIES
 *
 * 1. Write a function that determines if a string starts with an upper-case
 * letter A-Z
 * 2. Write a function that determines the area of a circle given the radius
 * 3. Add up all the values in an array
 */
public class uppercase {

    public static void main (String args[]){
        uppercase u = new uppercase();
        System.out.println(u.startsWithUppercase("hire me"));
    }

    boolean startsWithUppercase(String input){
        if (input == null){
            return false;
        }

        char c = input.toCharArray()[0];
        // Just check ASCII value since cap letters are contiguous.
        if((int)c >= 65 && (int)c <=90){
            return true;
        }
        return false;
    }

    double getAreaOfCircle(double radius){
        return Math.PI * radius*radius;
    }

    int addValuesInArray(int[] input){
        if (input == null){
            return 0;
        }

        int sum = 0;
        for (int i=0; i<input.length; i++){
            sum += input[i];
        }
        return sum;
    }
}
