package com.digiteched.javadsa.applications;

import com.digiteched.javadsa.ArrayList;
import com.digiteched.javadsa.interfaces.IStack;

public class TextProcessor {

    public static String reverse(String stringToReverse) {

        IStack<Character> stack = new ArrayList<Character>(Character.class); // I got really confused when the default
                                                                             // import was the one from java.util

        char[] stringAsChar = stringToReverse.toCharArray();

        for (char token : stringAsChar) {
            stack.push(token);
        }
        String out = "";

        while (stack.size() != 0) {
            out = out + stack.pop();
        }

        return out;

        // this solution would be O(2n) so just O(n)
    }
}
