package ds.linkedList;

import lombok.Builder;
import lombok.NoArgsConstructor;

/**
 * A sample node for the linked list
 */
@NoArgsConstructor
public class LinkedListNode {
    int data;
    LinkedListNode next;

    public LinkedListNode(int data) {
        this.data = data;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof LinkedListNode)) return false;

        LinkedListNode that = (LinkedListNode) o;

        if (data != that.data) return false;
        if (next == null) {
            return that.next == null;
        }
        return next.equals(that.next);
    }

    @Override
    public int hashCode() {
        int result = data;
        result = 31 * result + next.hashCode();
        return result;
    }

    /**
     * Prints the linked list in the following format
     * 1 -> 2 -> 3 -> ....
     * @return
     */
    @Override
    public String toString() {
        String linkedListString = "\t Linked List : ";
        LinkedListNode currentNode = this;
        while (currentNode.next != null) {
            linkedListString += currentNode.data + " -> ";
            currentNode = currentNode.next;
        }
        linkedListString += currentNode.data;
        return linkedListString;
    }
}

