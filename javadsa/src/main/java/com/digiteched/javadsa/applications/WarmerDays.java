package com.digiteched.javadsa.applications;

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
        throw new UnsupportedOperationException();
    }
}
