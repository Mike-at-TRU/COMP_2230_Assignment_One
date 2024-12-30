package com.digiteched.javadsa.applications;

import java.util.HashMap;

import com.digiteched.javadsa.ArrayStack;

// LC #20
class Solution {
    public boolean isValid(String s) {
        ArrayStack<String> stk = new ArrayStack<String>(String.class);

        HashMap<String,String> closeToOpen = new HashMap<String,String>();
        closeToOpen.put(")","(");
        closeToOpen.put("}","{");
        closeToOpen.put("]","[");

        String[] allSymbols = s.split("");

        for(String symbol: allSymbols){
            if(closeToOpen.containsKey(symbol)){
                // this is a closing symbol
                String top = stk.pop();

                if(!top.equals(closeToOpen.get(symbol))){
                    return false;
                }
            } else{
                // this is an opening symbol
                stk.push(symbol);
            }
        }

        return stk.size() == 0;
    }
}