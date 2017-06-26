package udemy.datastructures.linkedlist;

/**
 * This is a simple implementation of LinkedList :D!
 * Created by rafae on 6/24/2017.
 */
public class LinkedList {

    //This is the initial node, a node has a head and a next pointer

    private LinkedNode head;

    public LinkedNode getHead() {
        return head;
    }

    public void setHead(LinkedNode head) {
        this.head = head;
    }


    //with this method you can create a new node and add it, you need only the integer value
    public void add(int newRoot){
        //create the node with the NEXT value null
        LinkedNode node = new LinkedNode(newRoot);
        //verify if the current head is present if it is not then this will be the first one
        if (head == null){
            head = node;
        }
        //if not null then create a new node and assign the current one to it
        //this is done to enter the while loop
        //once inside the loop you canverify if the current node has a next value
        //if it does not then assign the current node with the next one
        //this is done until a next value is empty so we can exit and assign
        else {
            LinkedNode currentNode = head;
            while(currentNode.getNext() != null){
                currentNode = currentNode.getNext();
            }
            //once we exit out of the while we know that the "next" space is empty so we can assign a new node to it
            currentNode.setNext(node);
        }
    }
}

