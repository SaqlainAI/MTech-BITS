package com.dsa.assignment.queue;

public class QueueUsingLinkedList {

    private Node head;
    private Node tail;

    public QueueUsingLinkedList() {
        head = null;
        tail = null;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public void enqueue(Node node) {
        if(isEmpty()) {
            head = node;
            tail = node;
            return;
        }
        tail.next = node;
        tail = node;
    }

    public void traversal() {
        Node current = head; //temporary pointer to point to head
        while(current != null) { //iterating over queue
            System.out.print(current.data+"\t");
            current = current.next;
        }
        System.out.println("");
    }

    public int dequeue() {
        if(isEmpty()) {
            System.out.println("Queue Underflow\n");
            return -1;
        }
        int value = head.data;
        head = head.next;
        return value;
    }
}
