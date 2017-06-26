package udemy.datastructures.linkedlist;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by rafae on 6/24/2017.
 */
public class LinkedListTest {

    @Test
    public void addTest(){
        LinkedList linkedList = new LinkedList();
        linkedList.add(5);
        linkedList.add(2);
        linkedList.add(9);
        linkedList.add(0);
        linkedList.add(7);

        LinkedNode node = linkedList.getHead();
        Assert.assertEquals(5,node.getRoot());
        node = node.getNext();
        Assert.assertEquals(2,node.getRoot());


    }
}
