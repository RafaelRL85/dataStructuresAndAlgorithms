package udemy.datastructures.prefixtree;

import org.apache.commons.lang.ArrayUtils;
import org.junit.Assert;
import org.junit.Test;

import java.util.Set;

/**
 * Created by rafae on 7/3/2017.
 */
public class PrefixTreetest {

    @Test
    public void insertTest(){
        PrefixNode node = new PrefixNode();
        Assert.assertTrue(node.insert("tea", 1L));
        Assert.assertTrue(node.insert("te", 2L));
        Assert.assertTrue(node.insert("teas", 3L));
        Assert.assertTrue(node.insert("teaspoon", 4L));


    }

    @Test
    public void searchTest(){
        PrefixNode node = new PrefixNode();
        node.insert("tea", 10L);
        node.insert("tea", 13L);
        node.insert("ted", 20L);
        node.insert("true", 98L);

        Set<Long> ids =  node.search("tea");

        Assert.assertArrayEquals(ArrayUtils.toPrimitive(ids.toArray(new Long[1])), new long[]{10, 13});

        ids = node.search("true");

        Assert.assertArrayEquals(ArrayUtils.toPrimitive(ids.toArray(new Long[1])), new long[]{98});

    }
}
