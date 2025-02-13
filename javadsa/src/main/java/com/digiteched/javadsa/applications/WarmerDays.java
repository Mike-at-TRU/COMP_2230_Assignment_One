package com.digiteched.javadsa.applications;

import com.digiteched.javadsa.ArrayList;
import com.digiteched.javadsa.interfaces.IStack;

public class WarmerDays {

    public static int[] solutionA(int[] temperatures) {
        int[] out = new int[temperatures.length];

        for(int i = 0; i<temperatures.length; i++){
            int tempToBeat = temperatures[i];
            for(int k = i+1; k<temperatures.length; k++){
                if(tempToBeat < temperatures[k]){
                    out[i] = k-i;
                    break;
                }
            }
        }

        return out;
    }

    public static int[] solutionB(int[] temperatures) {
        int[] out = new int[temperatures.length];
        IStack<Integer> stack = new ArrayList<Integer>(Integer.class, temperatures.length);
        for(int i = 0; i<temperatures.length; i++){
            if(stack.size() == 0){
                stack.push(i);
                continue;
            }
            if(temperatures[stack.peek()] >= temperatures[i]){
                stack.push(i);
                continue;
            }
            while (stack.size() != 0 && temperatures[stack.peek()] < temperatures[i]) {
                out[stack.peek()] = i - stack.pop();
            }
            stack.push(i);
        }
        return out;
    }
}
