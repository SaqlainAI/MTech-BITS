package main.java.com.dsa.assignment.queue;

public class ArrayQueue {

    // position of head in the queue
    private int head;
    // position of tail in the queue
    private int tail;
    // size of the queue
    private int size;
    // array of elements
    private int[] queue;

    public ArrayQueue(int size) {
        this.size = size;
        this.head = -1;
        this.tail = -1;
        this.queue = new int[size];
    }

    // method to check if the queue is empty
    public boolean isEmpty() {
        return this.head == -1;
    }

    // method to check if the queue is full
    public boolean isFull() {
        return (this.tail + 1) % queue.length == this.head;
    }

    // method to add an element to the queue
    public void enqueue(int value) {
        // check if the queue is full
        if(isFull()) {
            System.out.println("Queue Overflow");
            return;
        }
        // check for existence of the element
        if(isDuplicate(value)) {
            return;
        }
        // move the tail to the next position
        tail = (tail + 1) % queue.length;
        // add the element at the tail of the queue
        queue[tail] = value;
        // have valid head position when first element is added
        if(head == -1) head = tail;
    }

    // remove element from the queue
    public int dequeue() {
        // check if the queue is empty
        if(isEmpty()) {
            System.out.println("Queue Underflow");
            return -1;
        }
        // get the element from the head of the queue
        int returnValue = queue[head];
        // mark the queue as empty if there are no more elements
        if(head == tail) {
            head = -1;
            tail = -1;
        } else {
            head = (head + 1) % queue.length;
        }
        return returnValue;
    }

    // method to print the queue
    public void display() {
        // do nothing if the queue is empty
        if(isEmpty()) {
        System.out.println("Queue is empty");
            return;
        }
        // iterate through the queue and print the elements
        int position;
        for(position = head; position!= tail; position = (position + 1) % queue.length) {
            System.out.println(queue[position]);
        }
        System.out.println(queue[tail]);
    }

    // method to check if the given element is in the queue
    public boolean isDuplicate(int data) {
        int position;
        // iterate through the queue and check if the element is in the queue
        for(position = head; position!= tail; position = (position + 1) % queue.length) {
            if(data == queue[position]) return true;
        }
        return false;
    }


}
