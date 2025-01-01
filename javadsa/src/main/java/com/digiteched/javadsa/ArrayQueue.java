package com.digiteched.javadsa;

import com.digiteched.javadsa.interfaces.IQueue;
import com.digiteched.javadsa.utils.Factory;
import com.digiteched.javadsa.exceptions.FailedToDequeueFromEmptyQueueException;

public class ArrayQueue<T> implements IQueue<T> {
    private Factory<T> f;

    private T[] items;

    private int front;

    private int nextAvailableIndex;

    private int count;

    public ArrayQueue(Class<T> t, int initialCapacity) {
        f = new Factory<T>(t);

        items = f.newArray(initialCapacity);

        count = 0;

        front = 0;

        nextAvailableIndex = 0;
    }

    public ArrayQueue(Class<T> t) {
        this(t, 10);
    }

    @Override
    public void enqueue(T item) {
        if (size() == items.length) {
            resize();
        }

        items[nextAvailableIndex] = item;

        nextAvailableIndex = (nextAvailableIndex + 1) % items.length;

        count++;

    }

    @Override
    public T dequeue() {
        if (isEmpty()) {
            throw new FailedToDequeueFromEmptyQueueException();
        }

        T out = items[front];

        items[front] = null;

        front = (front + 1) % items.length;

        count--;

        return out;
    }

    @Override
    public int size() {
        return count;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    private void resize() {
        T[] expanded = f.newArray(items.length * 2);

        /**
         * We copy the current items to the beginning
         * of a new backing array.
         */
        for (int i = 0; i < count; i++) {
            expanded[i] = items[front];
            front = (front + 1) % items.length;
        }

        front = 0;
        nextAvailableIndex = count;
        items = expanded;
    }
}
