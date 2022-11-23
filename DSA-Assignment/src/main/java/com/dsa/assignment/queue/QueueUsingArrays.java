package com.dsa.assignment.queue;

public class QueueUsingArrays {

    private int head;
    private int tail;
    private int size;
    private int[] queue;

    public QueueUsingArrays(int size) {
        this.size = size;
        this.head = 1;
        this.tail = 1;
        this.queue = new int[size];
    }

    public boolean isEmpty() {
        return this.tail == this.head;
    }

    public boolean isFull() {
        return this.tail == this.head + 1;
    }

    public void enqueue(int value) {
        if(isFull()) {
            System.out.println("Queue Overflow");
            return;
        }
        queue[tail] = value;
        tail = tail == size ? 1 : tail + 1;
    }

    public int dequeue() {
        if(isEmpty()) {
            System.out.println("Queue Underflow");
            return -1;
        }
        int returnValue = queue[head];
        head = head == size ? 1 : head + 1;
        return returnValue;
    }

    public void display() {
        int position;
        for(position = head; position < tail; position++) {
            System.out.println(queue[position]);
            if(position == size) position = 0;
        }
    }
}
