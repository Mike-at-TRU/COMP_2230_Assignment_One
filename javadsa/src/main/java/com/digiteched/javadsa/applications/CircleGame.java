package com.digiteched.javadsa.applications;

import java.util.LinkedList;
import java.util.Queue;

public class CircleGame {
      public int findTheWinner(int n, int k) {
        Queue<Integer> q = new LinkedList<Integer>();

        // first we fill the queue
        for(int i=1; i<=n; i++){
            q.add(i);
        }

        int counter = 1;

        while(q.size()>1){
            Integer next = q.remove();

            if(counter == k){
                next = null;
                // restart count for next player
                counter = 1;
            } else{
                // You're safe, get back in line
                q.add(next);
                counter++;
            }
        }

        // The size of the queue is now 1
        return q.remove();
    }
}
