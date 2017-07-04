package udemy.datastructures.prefixtree;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by rafae on 7/3/2017.
 */
public class PrefixNode {

    char root;
    Set<Long> matchingIds;
    Map<Character, PrefixNode> children;

    public PrefixNode() {
    }

    public PrefixNode(char root) {
        //The initial value for the node
        this.root = root;
        //Matching ids means if there are other ids outthere with the same value
        this.matchingIds = null;
        //a node can have children but the first time they are always null
        this.children = null;
    }

    /**This just calls the private method we dont want anybody to worry about
     * how we implement it so thats why we hide it
     * Always starts as 0 position
     *
     * @param string
     * @param id
     */
    public boolean insert(String string, Long id){
        return insert(string,0,id);
    }

    /**
     *This handles the insert
     * the string is the word we want to insert as nodes
     * position will always start as 0 first time
     * it will increment with recursion
     * Id is just the id of the word we will store
     * @param string
     * @param position
     * @param id
     */
    private boolean insert(String string, int position, Long id){
        //first we verify if the string is not invalid
       if(string == null || string.length() <=0 ){
           return false;
       }
       if(position >= string.length()){
           return false;
       }
       //second we check it this is the first time this loop (recursion) runs
        //we do this by verifying the children, if there are none then we create one
       if(children == null){
           children = new HashMap<Character, PrefixNode>(string.length());
       }
       //third we store the character we need
        char c = string.charAt(position);
        //with that character we verify if the children already have that
        PrefixNode node = children.get(c);

        //if they dont
        if(node == null) {
            //we create a nnew node
            node = new PrefixNode(c);
            //and then store it in the children
            children.put(c,node);
        }
        //if we find that the position we currently are is the same as the length
        //then we are finished
        if(position == string.length()-1){
            if(node.matchingIds == null) {
                //when we are finished we create a new hashset
                node.matchingIds = new HashSet<Long>();

            }
            //and add the id of this node
            node.matchingIds.add(id);
            return true;
        } else {
            //if we are not finished, call this same method but with the position moved +1
            position = ++position;
            return node.insert(string,position,id);
        }

    }

    public Set<Long> search(String string){
        return search(string,0);
    }

    /**
     * This will search for us given a string to search in and position 0 to start
     * This will use recursion in case it doesnt find it on the first try
     *
     *
     * WARNING CHILDREN!!!!
     * In this example I use null as return values
     * NEVER DO THIS :D!
     * That is a matter for some more explanation but I am using it here just
     * to convey the sense of not finding anything ok? :D!
     * @param string
     * @param position
     * @return
     */
    private Set<Long> search(String string, int position){
        if(string == null || string.length() <= 0){
            return null;
        }
        if(children == null) {
            return null;
        }
        char c = string.charAt(position);
        PrefixNode node = children.get(c);
        if(node == null){
            return null;
        }
        if(position == string.length()-1) {
            return node.matchingIds;
        }
        position = ++position;
        return node.search(string,position);
    }
}
