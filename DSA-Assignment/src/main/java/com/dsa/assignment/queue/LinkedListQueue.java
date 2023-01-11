package main.java.com.dsa.assignment.queue;

public class LinkedListQueue {

    private Node head;
    private Node tail;

    public LinkedListQueue() {
        head = null;
        tail = null;
    }

    public boolean isEmpty() {
        return head == null;
    }

    // method to add an element to the queue
    public void enqueue(int data) {
        // check if the element is already in the queue
        if(isDuplicate(data)) return ;
        // create a new node for the element
        Node node = new Node(data);
        if(isEmpty()) {
            head = node;
            tail = node;
            return;
        }
        // add the element to the tail of the queue
        tail.next = node;
        tail = node;
    }

    // method to print the queue
    public void traversal() {
        Node current = head; //temporary pointer to point to head
        while(current != null) { //iterating over queue
            System.out.print(current.data+"\t");
            current = current.next;
        }
        System.out.println("");
    }

    // remove element from the queue
    public int dequeue() {
        // check if the queue is empty
        if(isEmpty()) {
            System.out.println("Queue Underflow\n");
            return -1;
        }
        // move head to the next position
        int value = head.data;
        head = head.next;
        return value;
    }


    //  // method to check if the given element is in the queue
    public boolean isDuplicate(int data){
        // iterate through the queue starting from the head and check if the element is in the queue
        Node temp = head;
        while (temp != null) {
            if (temp.data == data) {
                return true;
            }
            temp = temp.next;
        }
        return false;
    }
}
