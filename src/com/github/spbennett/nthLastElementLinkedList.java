package com.github.spbennett;

import java.util.*;

/**
 * Created by sbennett on 7/5/15.
 */
public class nthLastElementLinkedList {

    public static void main (String args[]){
        //List<Object> list = Arrays.asList(1,2,3,4,5,6);
        List<Object> list = Arrays.asList("1","2","3","4","5","6");
        int nth = 2;

        nthLastElementLinkedList inst = new nthLastElementLinkedList();
        Object result = inst.getNthElement(list, 2);
        System.out.println("\n"+nth+"th Item from end: "+result);
    }

    private <T> T getNthElement(List<T> list, int n){
        // Bounds and validity checking.
        if (list == null || n < 0 || n > list.size()){
            return null;
        }

        /**
         * Push every item onto a stack, then pop N times to
         * get the Nth item from the end.
         */
        Stack<T> stack = new Stack<>();

        for (T current : list){
            System.out.println("Pushing " + current + " onto stack...");
            stack.push(current);
        }

        for (int i=0; i<n; i++){
            System.out.print("\nPopping ");
            System.out.print(stack.pop());
            System.out.print(" off of stack...");
        }

        return stack.pop();
    }
}
