package com.github.spbennett;

/**
 * Created by sbennett on 7/11/15.
 */
public class greatestDifference {

    /**
     * Find the greatest difference between a starting value
     * in an array, and a subsequent ending value.
     * @param input source array
     */
    void greatestDifference(int[] input){
        int start_time = 0, start_value = 0;
        int end_time = 0, end_value = 0;
        int difference = 0;

        // Take each value as a starting point and go through
        // the list finding the greatest difference between it
        // and each possible ending value.
        for (int i = 0; i < input.length; i++){
            for (int j = i + 1; j < input.length; j++){
                if (Math.abs(input[j] - input[i]) > difference){
                    // A new greatest difference found, update.
                    difference = input[j] - input[i];
                    start_time = i;
                    start_value = input[i];
                    end_time = j;
                    end_value = input[j];
                }
            }
        }

        System.out.println("Greatest Difference found:");
        System.out.println(start_time+": "+start_value);
        System.out.println(end_time+": "+end_value);
    }

    public static void main (String args[]){
        greatestDifference gd = new greatestDifference();

        int[] sample = {1, 2, 1, 5, 6, 5, 2, 1};
        gd.greatestDifference(sample);
    }
}
