package com.digiteched.javadsa;

import com.digiteched.javadsa.utils.Factory;

import com.digiteched.javadsa.interfaces.IStack;

public class ArrayStack<T> implements IStack<T> {
    Factory<T> f;

    private T[] items;

    /**
     * Note that the backing array is not always filled to
     * capacity. For this reason, we need to track the number of
     * elements we are curently storing.
     */
    private int n;

    public ArrayStack(Class<T> t){
        f = new Factory<T>(t);

        items = f.newArray(10);

        n = 0;
    }
    
    @Override
    public void push(T item) {
        /**
         * Note that `n` is the previous size, which
         * is also the next index. So if n = 1, we are adding
         * a second item at index 1 and the new size will be n = 2;
         */

         // resize if necessary
         if(n+1>items.length){
            resize();
         }

        items[n] = item;

        n++;
    }

    @Override
    public T pop() {
        n--;

        T old = items[n];

        items[n] = null;

        if(items.length>3*n){
            resize();
        }

        return old;
    }

    @Override
    public int size(){
        return n;
    }

    private void resize(){
        T[] newItems = f.newArray(Math.max(n*2,1));

        // Copy existing items to new array
        for(int i = 0; i<n; i++){
            newItems[i] = items[i];
        }

        items = newItems;
    }
}
