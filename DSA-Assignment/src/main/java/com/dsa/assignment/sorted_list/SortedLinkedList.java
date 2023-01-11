package main.java.com.dsa.assignment.sorted_list;

import main.java.com.dsa.assignment.queue.Node;

public class SortedLinkedList {

    // Head of the linked list
    private Node head;

    // Constructor to create an empty linked list
    public SortedLinkedList() {
        head = null;
    }

    // Method to add a new element to the linked list
    public void add(int data) {
        if(isDuplicate(data)) return;

        
        // Create a new node with the given data
        Node newNode = new Node(data);

        // If the linked list is empty, set the new node as the head
        if (head == null) {
            head = newNode;
            return;
        }

        // Find the correct position for the new node in the sorted list
        Node current = head;
        Node prev = null;
        while (current != null && data > current.data) {
            prev = current;
            current = current.next;
        }

        // Insert the new node at the correct position
        if (prev == null) {
            // Insert at the beginning of the list
            newNode.next = head;
            head = newNode;
        } else {
            // Insert after the prev node
            newNode.next = prev.next;
            prev.next = newNode;
        }

    }

    // Method to remove an element from the linked list
    public void remove(int data) {

        

        // If the linked list is empty, return
        if (head == null) {
            return;
        }

        // If the element to be removed is the head, set the head to the next element
        if (head.data == data) {
            head = head.next;
            return;
        }

        // Find the element to be removed
        Node current = head;
        Node prev = null;
        while (current != null && current.data != data) {
            prev = current;
            current = current.next;
        }

        // If the element was not found, return
        if (current == null) {
            return;
        }

        // Remove the element
        prev.next = current.next;

    }

    public boolean find(int data) {
        
        // Start at the head of the linked list
        Node current = head;

        // Search for the element until we reach the end of the list
        while (current != null && current.data <= data) {
            if (current.data == data) {
                return true;
            }
            current = current.next;
        }
        return false;
    }


    // Method to print the linked list
    public void print() {
        // Start at the head of the linked list
        Node current = head;

        // Print each element until we reach the end of the list
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }

    // Method to check if the element is already in the linked list
    public boolean isDuplicate(int data){
        // Start at the head of the linked list
        Node temp = head;
        // Compare each element with the new element
        while (temp != null) {
            // if the element is already in the linked list return true
            if (temp.data == data) {
                return true;
            }
            temp = temp.next;
        }
        return false;
    }


}

