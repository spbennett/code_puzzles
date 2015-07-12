package com.github.spbennett;

import org.junit.Test;

import java.time.temporal.ChronoField;
import java.util.*;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by sbennett on 7/11/15.
 */
public class bracketValidator {
    Stack<String> charStack = new Stack<>();
    List<String> openers = Arrays.asList("(", "{", "[");
    List<String> closers = Arrays.asList(")", "}", "]");

    boolean nestingTester(String input){
        char[] inputArray = input.toCharArray();

        for (char current : inputArray){
            String item = String.valueOf(current);

            //Push each opener into our stack
            if (openers.contains(item))
                charStack.push(item);

            if (closers.contains(item)){
                if(charStack.empty())
                    // Closing character encountered without an
                    // opening character.
                    return false;

                // Closing character encountered, pop corresponding
                // opener off stack.
                String opener = openers.get(closers.indexOf(item));
                if (charStack.peek().equals(opener)){
                    charStack.pop();
                } else {
                    return false;
                }
            }
        }

        // Properly balanced brackets will leave an empty
        // stack.
        return charStack.empty();
    }

    @Test
    public void testVoid(){
        bracketValidator bv = new bracketValidator();
        assertTrue("BRACKET BALANCE CHECK FAILURE", bv.nestingTester("{void()}"));
    }

    @Test
    public void testVoid2(){
        bracketValidator bv = new bracketValidator();
        assertFalse("BRACKET BALANCE CHECK FAILURE", bv.nestingTester("void()}"));
    }

    @Test
    public void testSet(){
        bracketValidator bv = new bracketValidator();
        assertTrue("BRACKET BALANCE CHECK FAILURE", bv.nestingTester("{ [ ] ( ) }"));
        assertFalse("BRACKET BALANCE CHECK FAILURE", bv.nestingTester("{ [ ( ] ) }"));
        assertFalse("BRACKET BALANCE CHECK FAILURE", bv.nestingTester("{ [ }"));
    }
}
