package udemy.datastructures.binarytree;

import java.util.List;

/**
 * Implementation of Binary Tree
 * Basically elements to the left are smaller than the root
 * (so the point of comparison)
 * if it goes to the right it is greater than root
 * Created by rafae on 6/23/2017.
 */
public class TreeNode {

    //this is the element to be inserted
    private int root;
    //this is just here to represent the left side of the node
    private TreeNode left;
    //this is just here to represent the right side of the node
    private TreeNode right;

    //with this constructor we send in the element to be inserted and it will create as null the two sides.
    public TreeNode(int root) {
        this.root = root;
    }

    /**
     *this method accepts the new element and it will check
     * if the new element is less thatn the original element
     * if it is it will check against one or both sides for null
     * if they aree null it will call the constructor to insert the new element
     * if they are not, it will call itself recursively to check against more nodes.
     * @param newRoot
     */
    public void addNode(int newRoot) {
        if(newRoot < root) {
            if(left == null) {
                left = new TreeNode(newRoot);
            } else {
                left.addNode(newRoot);
            }
        } else {
            if (right == null) {
                right = new TreeNode(newRoot);
            } else {
                right.addNode(newRoot);
            }
        }
    }

    //this will just return a list of ordered elements in ascending order
    public void preOrderTraversal(List<Integer> list){
        if (left != null) {
            left.preOrderTraversal(list);
        }
        list.add(root);
        if(right != null) {
            right.preOrderTraversal(list);
        }
    }

    //this regurns a list of ordered elements descending order
    public void postOrderTraversal(List<Integer> list){
        if(right != null) {
            right.postOrderTraversal(list);
        }
        list.add(root);
        if(left != null) {
            left.postOrderTraversal(list);
        }
    }

}
