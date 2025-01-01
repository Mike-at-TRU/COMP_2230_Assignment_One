package com.digiteched.javadsa;

import com.digiteched.javadsa.exceptions.FailedToDequeueFromEmptyQueueException;
import com.digiteched.javadsa.interfaces.IQueue;

class Node<T> {
    private T data;

    private Node<T> next;

    public Node(T data) {
        this.data = data;
        next = null;
    }

    public T value() {
        return data;
    }

    public Node<T> getNext() {
        return next;
    }

    public void setNext(Node<T> n) {
        next = n;
    }

    public void removeNext() {
        next = null;
    }
}

public class LinkedQueue<T> implements IQueue<T> {
    Node<T> head;

    Node<T> tail;

    private int count;

    public LinkedQueue() {
        head = null;

        tail = null;

        count = 0;
    }

    @Override
    public void enqueue(T item) {
        Node<T> nextNode = new Node<T>(item);

        if(isEmpty()){
            head = nextNode;
        } else{
            // We remove from head and queue at tail
            tail.setNext(nextNode);
        }

        // The new node is now at the back of the line
        tail = nextNode;

        count++;
    }

    @Override
    public T dequeue() {
        if(isEmpty()){
            throw new FailedToDequeueFromEmptyQueueException();
        }

        T out = head.value();

        head = head.getNext();

        count--;

        return out;
    }

    @Override
    public int size() {
        return count;
    }

    public boolean isEmpty(){
        return head == null;
    }
}
