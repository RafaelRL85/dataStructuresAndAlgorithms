package udemy.datastructures.doublelinkedlist;

/**
 * Created by rafae on 6/26/2017.
 */
public class DoubleLinkedNode {

    private int root;
    private DoubleLinkedNode next;
    private DoubleLinkedNode previouos;

    public DoubleLinkedNode(int root) {
        this.root = root;
    }

    public int getRoot() {
        return root;
    }

    public void setRoot(int root) {
        this.root = root;
    }

    public DoubleLinkedNode getNext() {
        return next;
    }

    public void setNext(DoubleLinkedNode next) {
        this.next = next;
    }

    public DoubleLinkedNode getPreviouos() {
        return previouos;
    }

    public void setPreviouos(DoubleLinkedNode previouos) {
        this.previouos = previouos;
    }

    @Override
    public String toString() {
        return "DoubleLinkedNode{" +
                "root=" + root +
                ", next=" + next +
                ", previouos=" + previouos +
                '}';
    }
}
