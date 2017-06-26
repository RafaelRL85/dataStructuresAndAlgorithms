package udemy.datastructures.linkedlist;

/**This is just the node class
 * current value and next one
 * Created by rafae on 6/24/2017.
 */
public class LinkedNode {

    //value for the node
    private int root;
    //next value for the node
    private LinkedNode next;

    public LinkedNode(int head) {
        this.root = head;
    }

    public int getRoot() {
        return root;
    }

    public void setRoot(int root) {
        this.root = root;
    }

    public LinkedNode getNext() {
        return next;
    }

    public void setNext(LinkedNode next) {
        this.next = next;
    }
}
