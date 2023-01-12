package main.java.com.dsa.assignment.utils;

import main.java.com.dsa.assignment.queue.ArrayQueue;
import main.java.com.dsa.assignment.queue.LinkedListQueue;
import main.java.com.dsa.assignment.sorted_list.SortedLinkedList;

import java.io.*;
import java.util.Scanner;

public class Menu {
    ArrayQueue arrayQueue;
    LinkedListQueue linkedListQueue;
    SortedLinkedList sortedLinkedList;
//    BST bst;
    Scanner scanner;

    public Menu() {
        arrayQueue = new ArrayQueue(Constants.MAX_QUEUE_SIZE);
        linkedListQueue = new LinkedListQueue();
        sortedLinkedList = new SortedLinkedList();
//        bst = new BST();
        scanner = new Scanner(System.in);
    }

    public void displayMenu() {
        System.out.println("Menu:");
        System.out.println("1. Input into Array Queue from File ");
        System.out.println("2. Input into Array Queue from command line ");
        System.out.println("3. Remove element from Array Queue ");
        System.out.println("4. Input into List Queue from File");
        System.out.println("5. Input into List Queue from command line");
        System.out.println("6. Remove element from List Queue");
        System.out.println("7. Input into Sorted List from File");
        System.out.println("8. Input into Sorted List from command line");
        System.out.println("9. Find element in Sorted List");
        System.out.println("10. Remove element in Sorted List");
        System.out.println("11. Input into BST from File");
        System.out.println("12. Input into BST from command line");
        System.out.println("13. Find element in BST");
        System.out.println("14. Remove element From BST");
        System.out.println("15. Print BST in order");
        System.out.println("16. Quit");
    }


    public void handleInput() {
        boolean quit = false;
        while (!quit) {
            displayMenu();
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
                    inputArrayQueueFromFile();
                    break;
                case 2:
                    inputArrayQueueFromCommandLine();
                    break;
                case 3:
                    removeArrayQueue();
                    break;
                case 4:
                    inputLinkedListQueueFromFile();
                    break;
                case 5:
                    inputLinkedListQueueFromCommandLine();
                    break;
                case 6:
                    removeElementFromLinkedListQueue();
                    break;
                case 7:
                    inputSortedListFromFile();
                    break;
                case 8:
                    inputSortedListFromCommandLine();
                    break;
                case 9:
                    findElementInSortedList();
                    break;
                case 10:
                    removeElementFromSortedList();
                    break;
//                case 11:
//                    inputBSTFromFile();
//                    break;
//                case 12:
//                    inputBSTFromCommandLine();
//                    break;
//                case 13:
//                    findElementInBST();
//                    break;
//                case 14:
//                    removeElementFromBST();
//                    break;
//                case 15:
//                    printBST();
//                    break;
                case 16:
                    quit = true;
                    break;
                default:
                    System.out.println("Invalid choice.");
                    break;
            }
        }
    }


    // method to read data from the given file/s and add it to the array queue
    private void inputArrayQueueFromFile() {
        System.out.println("Enter file names separated by commas: ");
        String fileNames = scanner.nextLine();
        String[] files = fileNames.split(",");
        long startTime = System.nanoTime();
        // iterate over each file and add its contents to the array
        for (String fileName : files) {
            File file = new File(fileName);
            try {
                Scanner fileScanner = new Scanner(file);
                while (fileScanner.hasNextLine()) {
                    // split the line incase the given file is csv
                    String[] line = fileScanner.nextLine().split(",");
                    for (String value : line) {
                        int data = Integer.parseInt(value);
                        arrayQueue.enqueue(data);
                    }
                }
                fileScanner.close();
            } catch (FileNotFoundException e) {
                System.out.println("File not found " + fileName);
            }
        }
        long endTime = System.nanoTime();
        long duration = endTime - startTime;
        System.out.println("Insertion time for array queue: " + duration + " nanoseconds");
    }

    // method to add the given data to the array queue
    private void inputArrayQueueFromCommandLine() {
        System.out.println("Enter element: ");
        int data = scanner.nextInt();
        arrayQueue.enqueue(data);
    }

    // method to remove the given data from the array queue
    private void removeArrayQueue() {
        long startTime = System.nanoTime();
        int removed = arrayQueue.dequeue();
        if (removed != -1) {
            System.out.println("Removed element: " + removed);
        } else {
            System.out.println("Queue is empty.");
        }
        long endTime = System.nanoTime();
        long duration = endTime - startTime;
        System.out.println("Deletion time for array queue: " + duration + " nanoseconds");
    }

    // method to read data from the given file/s and add it to the linked list queue
    private void inputLinkedListQueueFromFile() {
        System.out.println("Enter file names separated by commas: ");
        String fileNames = scanner.nextLine();
        String[] files = fileNames.split(",");
        long startTime = System.nanoTime();
        for (String fileName : files) {
            File file = new File(fileName);
            try {
                Scanner fileScanner = new Scanner(file);
                while (fileScanner.hasNextLine()) {
                    String[] line = fileScanner.nextLine().split(",");
                    for (String value : line) {
                        int data = Integer.parseInt(value);
                        linkedListQueue.enqueue(data);
                    }
                }
                fileScanner.close();
            } catch (FileNotFoundException e) {
                System.out.println("File not found " + fileName);
            }
        }
        long endTime = System.nanoTime();
        long duration = endTime - startTime;
        System.out.println("Insertion time for linked list queue: " + duration + " nanoseconds");
    }

    // method to add the given data to the linked list queue
    private void inputLinkedListQueueFromCommandLine() {
        System.out.println("Enter element: ");
        int data = scanner.nextInt();
        linkedListQueue.enqueue(data);
    }

    // method to remove the given data from the linked list queue
    private void removeElementFromLinkedListQueue() {
        long startTime = System.nanoTime();
        int removed = linkedListQueue.dequeue();
        if (removed != -1) {
            System.out.println("Removed element: " + removed);
        } else {
            System.out.println("Queue is empty.");
        }
        long endTime = System.nanoTime();
        long duration = endTime - startTime;
        System.out.println("Deletion time for linked list queue: " + duration + " nanoseconds");
    }

    // method to read data from the given file/s and add it to the sorted linked list
    private void inputSortedListFromFile() {
        System.out.println("Enter file names separated by commas: ");
        String fileNames = scanner.nextLine();
        String[] files = fileNames.split(",");
        long startTime = System.nanoTime();
        for (String fileName : files) {
            File file = new File(fileName);
            try {
                Scanner fileScanner = new Scanner(file);
                while (fileScanner.hasNextLine()) {
                    String[] line = fileScanner.nextLine().split(",");
                    for (String value : line) {
                        int data = Integer.parseInt(value);
                        sortedLinkedList.add(data);
                    }
                }
                fileScanner.close();
            } catch (FileNotFoundException e) {
                System.out.println("File not found " + fileName);
            }
        }
        long endTime = System.nanoTime();
        long duration = endTime - startTime;
        System.out.println("Insertion time for sorted linked list: " + duration + " nanoseconds");
    }

    // method to add the given data to the sorted linked list
    private void inputSortedListFromCommandLine() {
        System.out.println("Enter element: ");
        int data = scanner.nextInt();
        if(!sortedLinkedList.isDuplicate(data)) sortedLinkedList.add(data);
    }

    // method to find the given data to the sorted linked list
    private void findElementInSortedList() {
        long startTime = System.nanoTime();
        System.out.println("Enter element to find: ");
        int data = scanner.nextInt();
        boolean found = sortedLinkedList.find(data);
        if (found) {
            System.out.println("Element found.");
        } else {
            System.out.println("Element not found.");
        }
        long endTime = System.nanoTime();
        long duration = endTime - startTime;
        System.out.println("Search time for sorted linked list: " + duration + " nanoseconds");
    }

    // method to remove the given data from the sorted linked list
    private void removeElementFromSortedList() {
        long startTime = System.nanoTime();
        System.out.println("Enter element to remove: ");
        int data = scanner.nextInt();
        sortedLinkedList.remove(data);
        long endTime = System.nanoTime();
        long duration = endTime - startTime;
        System.out.println("Deletion time for sorted linked list: " + duration + " nanoseconds");
    }


//    private void inputBSTFromFile() {
//        System.out.println("Enter file names separated by commas: ");
//        String fileNames = scanner.nextLine();
//        String[] files = fileNames.split(",");
//        long startTime = System.nanoTime();
//        for (String fileName : files) {
//            File file = new File(fileName);
//            try {
//                Scanner fileScanner = new Scanner(file);
//                while (fileScanner.hasNextLine()) {
//                    String[] line = fileScanner.nextLine().split(",");
//                    for (String value : line) {
//                        int data = Integer.parseInt(value);
//                        if (!bst.isDuplicate(data)) bst.insert(data);
//                    }
//                }
//                fileScanner.close();
//            } catch (FileNotFoundException e) {
//                System.out.println("File not found " + fileName);
//            }
//        }
//        long endTime = System.nanoTime();
//        long duration = endTime - startTime;
//        System.out.println("Insertion time for BST: " + duration + " nanoseconds");
//    }
//
//    method to add the given data to the BST
//    private void inputBSTFromCommandLine() {
//        System.out.println("Enter element: ");
//        int data = scanner.nextInt();
//        if(!bst.isDuplicate(data)) bst.insert(data);
//    }
//
//    method to find the given element in the BST
//    private void findElementInBST() {
//        System.out.println("Enter element to find: ");
//        int data = scanner.nextInt();
//        long startTime = System.nanoTime();
//        boolean found = bst.find(data);
//        if (found) {
//            System.out.println("Element found.");
//        } else {
//            System.out.println("Element not found.");
//        }
//        long endTime = System.nanoTime();
//        long duration = endTime - startTime;
//        System.out.println("Search time for BST: " + duration + " nanoseconds");
//    }
//
//    method to remove the given data from the BST
//    private void removeElementFromBST() {
//        long startTime = System.nanoTime();
//        System.out.println("Enter element to remove: ");
//        int data = scanner.nextInt();
//        bst.remove(data);
//        long endTime = System.nanoTime();
//        long duration = endTime - startTime;
//        System.out.println("Deletion time for array queue: " + duration + " nanoseconds");
//    }
//
//    method to print the contents of the BST
//    private void printBST(){
//        bst.inOrder();
//    }






}