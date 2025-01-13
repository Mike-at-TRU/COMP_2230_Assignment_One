package com.digiteched.javadsa;

import com.digiteched.javadsa.exceptions.FailedToDequeueFromEmptyQueueException;
import com.digiteched.javadsa.interfaces.IList;
import com.digiteched.javadsa.interfaces.IQueue;
import com.digiteched.javadsa.interfaces.IStack;
import com.digiteched.javadsa.utils.Factory;

public class ArrayList<T> implements IList<T>, IStack<T>, IQueue<T> {
    private Factory<T> f;

    private T[] items;

    private int head;

    private int count;

    public ArrayList(Class<T> t, int initialCapacity) {
        f = new Factory<T>(t);

        items = f.newArray(initialCapacity);

        head = 0;

        count = 0;
    }

    public ArrayList(Class<T> t) {
        this(t, 10);
    }

    @Override
    public void set(int index, T newElement) {
        items[(index + head) % items.length] = newElement;
    }

    @Override
    public void add(T element) {
        if (size() == items.length) {
            resize();
        }

        items[tail()] = element;

        count++;
    }

    @Override
    public void add(int index, T element) {
        if (count + 1 > items.length) {
            resize();
        }

        // if the insertion point is in the left half, shift elements at lower indices
        // left
        if (index < count / 2) {
            // we need to shift the `head` left as well
            head = head == 0 ? items.length - 1 : head - 1;

            for (int k = 0; k < index - 1; k++) {
                // note that there is always at least 1 vacant location to shift into, as we
                // call resize if need be
                items[(k + head) % items.length] = items[(k + head + 1) % items.length];
            }
        } else {
            // if the insertion point is in the middle or right half, shift elements at
            // higher indices right
            // no need to shift head when shifting to the right
            for (int k = count; k >= index; k--) {
                items[(k + head) % items.length] = items[(k + head - 1) % items.length];
            }
        }

        items[(index + head) % items.length] = element;
        count++;
    }

    @Override
    public T remove(int index) {
        T elementToRemove = items[(index + head) % items.length];

        // we are removing from the interior
        // point to the right
        if (index < count / 2) {
            // if we are less than half way through, we shift elements left of the removal
            // to the right
            for (int k = index; k > 0; k--) {
                items[(head + k) % items.length] = items[(head + k - 1) % items.length];
            }

            head = (head = head + 1) % items.length;
        } else {
            // shift items right of the removal point to the left
            for (int k = index; k < count - 1; k++) {
                items[(head + k) % items.length] = items[(head + k + 1) % items.length];

                // no need to shift the head.
            }
        }

        count--;

        return elementToRemove;
    }

    @Override
    public T get(int index) {
        // TODO throw OutOfBoundsException if index is invalid

        return items[(head + index) % items.length];
    }

    @Override
    public int size() {
        return count;
    }

    @Override
    public void enqueue(T item) {
        this.add(item);
    }

    @Override
    public T dequeue() {
        if (isEmpty()) {
            throw new FailedToDequeueFromEmptyQueueException();
        }

        T out = items[head];

        items[head] = null;

        head = (head + 1) % items.length;

        count--;

        return out;
    }

    @Override
    public void push(T item) {
        add(item);
    }

    @Override
    public T pop() {
        // TODO prevent popping from an empty array

        return remove((head + count - 1) % items.length);
    }

    public boolean isEmpty() {
        return count == 0;
    }

    private void resize() {
        T[] expanded = f.newArray(items.length * 2);

        /**
         * We copy the current items to the beginning
         * of a new backing array.
         */
        for (int i = 0; i < count; i++) {
            expanded[i] = items[head];
            head = (head + 1) % items.length;
        }

        head = 0;
        items = expanded;
    }

    private int tail() {
        return (head + count) % items.length;
    }

}
