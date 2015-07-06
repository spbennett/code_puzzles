package com.github.spbennett;

import java.util.Iterator;
import java.util.LinkedList;


/**
 * Created by sbennett on 7/3/15.
 * Given a one direction circularly linked list, write an algorithm to remove a given value.
 */
public class circularLLremover {

    void remove (Object itemToRemove, LinkedList<Object> circularLinkedList){
        /* Iterate through the linked list saving references to the previous and to the next item
         in the list.*/
        //int size = circularLinkedList.size();

        Object prevNode = circularLinkedList.getLast();

        for (Object current : circularLinkedList){

            if (current.equals(itemToRemove)){
                // We've found our man, chop him out.
                //prevNode.next = current.next;

                // Remove the reference for garbage collection.
                current = null;
                return;
            }

            // Advance our previous node pointer.
            prevNode = current;
        }
    }
}
