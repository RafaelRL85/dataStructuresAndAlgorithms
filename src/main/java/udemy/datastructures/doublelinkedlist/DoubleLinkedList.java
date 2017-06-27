package udemy.datastructures.doublelinkedlist;

/** Basic implementation of double linked list
 * basically an add and remove method
 * Double Linked list is almost the same as linked list, it only adds a previous component on the node
 * Created by rafae on 6/26/2017.
 */
public class DoubleLinkedList {

    //the head is basically the middle element if you want to call it like that
    private DoubleLinkedNode head;

    public DoubleLinkedNode getHead() {
        return head;
    }

    public void setHead(DoubleLinkedNode head) {
        this.head = head;
    }

    /**
     * this is the add method, it checks if the current space is available
     * and if not then it searches for the next available one
     * @param root
     * the param root is used on the constructor on the node
     * so the node is always initialized with null on both sides except the middle.
     */
    public void add(int root){
        //creates a new node with the root element
        DoubleLinkedNode doubleLinkedNode = new DoubleLinkedNode(root);

        //checks if the linked list is empty or if this is the first element
        //if it is then it assigns the new element to the head
        if(head == null){
            head = doubleLinkedNode;
        }
        //if it is not empty then it begins the search for an empty one
        else {
            //we create a current node to keep track of where we are
            DoubleLinkedNode current = head;
            //while the current element has a next value we start advancing the list
            while(current.getNext() != null){
                //when the next value is not null the we advance +1
                //meaning current is now the next element so we advance forward
                current = current.getNext();
            }
            //once the current element has NO next value
            //we assume that the current one is 1 element before the element we want to add
            doubleLinkedNode.setPreviouos(current);
            //so the current element is the next element of the current one
            current.setNext(doubleLinkedNode);
        }

    }

    /**
     * remove a record with the root that matches the parameter
     *
     * example:
     * {5,1,7} lets say we need to remove 1
     *
     * @param remove
     * @return a boolean to say if it removed or not the element
     *
     */
    public boolean remove(int remove){
        //following the example remove 1
        //   null->5->1  5->1->7   1-> 7 -> null

        if(head == null) {
            return false;
        }

        DoubleLinkedNode current = head;
        //seach for the element
        while(current.getNext() != null){
            //if where we are is the one we are looking for
            if(current.getRoot() == remove){
                //then check if the current one has a previous
                //return since there is no trace of the element we wanted to remove
                return rearrangeList(current);


            }
            // condition to exit the while loop
            current = current.getNext();
        }
        if (current.getRoot() == remove){
            //then check if the current one has a previous
            //return since there is no trace of the element we wanted to remove
            return rearrangeList(current);

        }

        return false;
    }

    private boolean rearrangeList(DoubleLinkedNode doubleLinkedNode){
        if(doubleLinkedNode.getPreviouos() != null){
            //if it does then get the previous and change the value
            //now the example would be null->5-7
            doubleLinkedNode.getPreviouos().setNext(doubleLinkedNode.getNext());
        }
        //check if the current has a next value which it does
        if(doubleLinkedNode.getNext() != null){
            //then get the next and change its value and it would be:
            // 5->7->null
            doubleLinkedNode.getNext().setPreviouos(doubleLinkedNode.getPreviouos());
        }
        return true;
    }

    @Override
    public String toString() {
        DoubleLinkedNode current = head;
        StringBuilder stringToReturn = new StringBuilder();
        stringToReturn.append(head.getRoot());
        while(current.getNext() != null){
            stringToReturn.append("->").append(current.getNext().getRoot());
            current = current.getNext();
        }
        return stringToReturn.toString();
    }
}
