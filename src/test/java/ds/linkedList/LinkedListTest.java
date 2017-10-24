package ds.linkedList;

import org.apache.log4j.BasicConfigurator;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;

/**
 * Created by alimuk on 8/25/17.
 */
@RunWith(MockitoJUnitRunner.class)
public class LinkedListTest {
    LinkedListNode headNode;
    LinkedListNode resultNode;

    LinkedList linkedList = new LinkedList();

    @Before
    public void setup() {
        BasicConfigurator.configure();
        headNode = new LinkedListNode(1);
        LinkedListNode node2 = new LinkedListNode(2);
        LinkedListNode node3 = new LinkedListNode(3);
        LinkedListNode node4 = new LinkedListNode(4);
        LinkedListNode node5 = new LinkedListNode(5);
        headNode.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        System.out.println("Initially... ");
        System.out.println(headNode);
    }

    @Test
    public void testPush() {
        System.out.println("\n=== push(head, data) ===");

        System.out.println("-> Pushing 5 in an empty linked list");
        LinkedListNode node1 = new LinkedListNode(5);
        LinkedListNode resultHead = linkedList.push(null, 5);
        assertEquals(resultHead, node1);
        System.out.println("\t Linked List : " + resultHead);

        System.out.println("-> Pushing 6 in a non-empty linked list");
        resultHead = linkedList.push(resultHead, 6);
        assertEquals(resultHead.data, 6);
        System.out.println("\t Linked List : " + resultHead);
    }

    @Test
    public void testInsertAfter() {
        System.out.println("\n=== insertAfter(node, data) ===");
        LinkedListNode node1 = new LinkedListNode(1);
        LinkedListNode node2 = new LinkedListNode(2);
        LinkedListNode node3 = new LinkedListNode(3);
        LinkedListNode node4 = new LinkedListNode(4);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        System.out.println(node1);
        linkedList.insertAfter(node3, 10);

        System.out.println("After adding 10 after node3");
        System.out.println(node1);

        linkedList.insertAfter(node1, 20);
        System.out.println("After adding 20 after node1 : ");
        System.out.println(node1);

        linkedList.insertAfter(null, 30);
        System.out.println("Handled successfully the null case");
    }

    @Test
    public void testAppend() {
        System.out.println("\n=== append(head, data) ===");

        LinkedListNode node1 = new LinkedListNode(1);
        System.out.println("-> Appending 1 into an empty linked list");
        LinkedListNode resultNode = linkedList.append(null, 1);
        assertEquals(resultNode, node1);
        System.out.println(node1);

        System.out.println("-> Appending 2 into a non empty linked list");
        resultNode = linkedList.append(node1, 2);
        assertEquals(resultNode.data, 1);
        System.out.println(node1);
    }

    @Test
    public void testDelete() {
        System.out.println("=== delete(head, key) ===");

        System.out.println("-> Deleting 1 from the beginning");
        resultNode = linkedList.delete(headNode, 1);
        System.out.println(resultNode);
        assertEquals(resultNode.data, 2);

        System.out.println("-> Deleting 5 from the end");
        resultNode = linkedList.delete(resultNode, 5);
        System.out.println(resultNode);
        assertEquals(resultNode.data, 2);

        System.out.println("-> Deleting 3 from the middle");
        resultNode = linkedList.delete(resultNode, 3);
        System.out.println(resultNode);
        assertEquals(resultNode.data, 2);
        assertEquals(resultNode.next.data, 4);

        System.out.println("Deleting a non present key (10)");
        resultNode = linkedList.delete(resultNode, 10);
        System.out.println(resultNode);
        assertEquals(resultNode.data, 2);
    }

    @Test
    public void testDeleteIndex() {
        System.out.println("=== delete(key, index) ===");

        System.out.println("-> Checking for negative index (-1)");
        resultNode = linkedList.deleteIndex(headNode, -1);
        System.out.println(resultNode);
        assertEquals(resultNode.data,1);

        System.out.println("-> Checking for the index out of range (5)");
        resultNode = linkedList.deleteIndex(resultNode, 5);
        System.out.println(resultNode);
        assertEquals(resultNode.data, 1);

        System.out.println("Removing the head node itself (0)");
        resultNode = linkedList.deleteIndex(resultNode,0);
        System.out.println(resultNode);
        assertEquals(resultNode.data, 2);

        System.out.println("Removing the last node (3)");
        resultNode = linkedList.deleteIndex(resultNode, 3);
        System.out.println(resultNode);
        assertEquals(resultNode.data, 2);


        System.out.println("Removing from the middle (1)");
        resultNode = linkedList.deleteIndex(resultNode, 1);
        System.out.println(resultNode);
        assertEquals(resultNode.data, 2);
        assertEquals(resultNode.next.data, 4);
    }

    @Test
    public void testLength() {
        System.out.println("\n== length() ==\n");
        System.out.println("-> Initial lentgh should be 5");
        assertEquals(linkedList.length(headNode),5);
        System.out.println(linkedList.length(headNode));

        System.out.println("-> After deleting one element length should be 4");
        resultNode = linkedList.deleteIndex(headNode, 0);
        assertEquals(linkedList.length(resultNode),4);
        System.out.println(linkedList.length(resultNode));
        System.out.println(resultNode);

        System.out.println("Finding length of an empty list!");
        assertEquals(linkedList.length(null), 0);
        System.out.println(linkedList.length(null));

    }
}
