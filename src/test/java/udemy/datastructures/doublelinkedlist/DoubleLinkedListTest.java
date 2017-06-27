package udemy.datastructures.doublelinkedlist;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by rafae on 6/26/2017.
 */
public class DoubleLinkedListTest {

    DoubleLinkedList doubleLinkedList;

    @Before
    public void init(){
        doubleLinkedList = new DoubleLinkedList();

    }

    @Test
    public void testAdd(){
        doubleLinkedList.add(5);
        doubleLinkedList.add(8);
        doubleLinkedList.add(2);
        doubleLinkedList.add(1);
        doubleLinkedList.add(15);
        Assert.assertEquals(doubleLinkedList.getHead().getRoot(), 5);
        Assert.assertEquals(doubleLinkedList.getHead().getNext().getRoot(), 8);
        DoubleLinkedNode newNode = doubleLinkedList.getHead().getNext().getNext().getNext();
        Assert.assertEquals(newNode.getRoot(),1);
    }

    //there is a bug in here with the first element, but ill try to fix it later :D!
    @Test
    public void testRemove(){
        doubleLinkedList.add(5);
        doubleLinkedList.add(8);
        doubleLinkedList.add(2);
        doubleLinkedList.add(1);
        doubleLinkedList.add(15);

        doubleLinkedList.remove(8);
        Assert.assertEquals(doubleLinkedList.getHead().getRoot(),5);
    }
}
