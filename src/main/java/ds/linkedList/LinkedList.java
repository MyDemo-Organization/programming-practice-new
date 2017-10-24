package ds.linkedList;

import lombok.extern.log4j.Log4j;
import sun.awt.image.ImageWatched;

/**
 * This class represents the linked list
 */
@Log4j
public class LinkedList {
    /**
     * Pushes the node in front of the head or before the head
     * @param head Head Node of the given linked list
     * @param data Data to be added in the node
     * @return head pointer of the modified linked list
     */
    public LinkedListNode push(LinkedListNode head, int data) {
        LinkedListNode newNode = new LinkedListNode();
        newNode.data = data;
        if (head == null) {
            return newNode;
        }

        // push the new node as the head
        newNode.next = head;
        return newNode;
    }

    /**
     * Insert the node after the given node
     */
    public void insertAfter(LinkedListNode previousNode, int data) {
        // base case
        if (previousNode == null) {
            return;
        }
        LinkedListNode newNode = new LinkedListNode(data);
        LinkedListNode tempNode = previousNode.next;
        previousNode.next = newNode;
        newNode.next = tempNode;
    }

    /**
     * Appends the new Node at the end
     * @param head Head node of the current Linked list
     * @param data data to be inserted in the end
     * @return Head node of the modified linked list
     */
    public LinkedListNode append(LinkedListNode head, int data) {
        LinkedListNode newNode = new LinkedListNode(data);
        // base case
        if (head == null) {
            return newNode;
        }

        LinkedListNode currentNode = head;
        while (currentNode.next != null) {
            currentNode = currentNode.next;
        }

        currentNode.next = newNode;
        return head;
    }

    /**
     * Deletes the first occurrence of the key
     * @param head
     * @param key
     * @return
     */
    public LinkedListNode delete(LinkedListNode head, int key) {
        // base case 1:  empty linked list
        if (head == null) {
            System.out.println("Can not delete from an empty Linked List");
            return head;
        }

        // base case 2 :  Head has the key
        if (head.data == key) {
            return head.next;
        }

        LinkedListNode currentNode = head;

        while (currentNode.next != null && currentNode.next.data != key) {
            currentNode = currentNode.next;
        }

        // check if we have reached the end!
        if (currentNode.next == null) {
            System.out.println("No such key found!!");
        } else {
            currentNode.next = currentNode.next.next;
        }

        // key was not found
        return head;

    }

    /**
     * Deletes the node at the given index
     * @param head
     * @param index
     * @return head node
     */
    public LinkedListNode deleteIndex(LinkedListNode head, int index) {
        // base case 1 : empty list
        if (head == null) {
            System.out.println("ALERT: Can not delete from an empty list!");
            return head;
        }

        // base case 2 : negative index
        if (index < 0) {
            System.out.println("ALERT : Index can not be negative!");
            return head;
        }

        // base case 3 : 0th index or the head node itself
        if (index == 0) {
            return head.next;
        }

        LinkedListNode currentNode = head;
        int counter = 0;
        while (currentNode.next != null && counter < index - 1) {
            currentNode = currentNode.next;
            counter++;
        }

        if (currentNode.next == null) {
            System.out.println("ALERT : Index out of range!");
        } else {
            currentNode.next = currentNode.next.next;
        }

        return head;

    }


    /**
     * Returns the length of a Linked List
     * @param head
     * @return
     */
    public int length(LinkedListNode head) {
         int length = 0;
        while (head != null) {
            head = head.next;
            length ++;
        }

        return length;
    }
}
