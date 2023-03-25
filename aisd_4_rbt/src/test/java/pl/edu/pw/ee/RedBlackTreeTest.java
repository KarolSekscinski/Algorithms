package pl.edu.pw.ee;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class RedBlackTreeTest {

    private RedBlackTree blackTree;

    @Before
    public void setUp() {
        blackTree = new RedBlackTree();
    }

    @Test
    public void getPreOrderTest() {
        //given
        blackTree.put('A', 0);
        blackTree.put('B', 0);
        blackTree.put('C', 0);
        blackTree.put('D', 0);
        blackTree.put('E', 0);
        blackTree.put('F', 0);
        blackTree.put('G', 0);
        blackTree.put('H', 0);
        blackTree.put('I', 0);
        blackTree.put('J', 0);
        blackTree.put('K', 0);
        blackTree.put('L', 0);
        blackTree.put('M', 0);
        blackTree.put('N', 0);
        blackTree.put('O', 0);
        //when
        String actual = blackTree.getPreOrder();
        //then
        String expected = "H:0 D:0 B:0 A:0 C:0 F:0 E:0 G:0 L:0 J:0 I:0 K:0 N:0 M:0 O:0";
        Assert.assertEquals(expected, actual);

    }

    @Test
    public void getInOrderTest() {
        //given
        blackTree.put('A', 0);
        blackTree.put('B', 0);
        blackTree.put('C', 0);
        blackTree.put('D', 0);
        blackTree.put('E', 0);
        blackTree.put('F', 0);
        blackTree.put('G', 0);
        blackTree.put('H', 0);
        blackTree.put('I', 0);
        blackTree.put('J', 0);
        blackTree.put('K', 0);
        blackTree.put('L', 0);
        blackTree.put('M', 0);
        blackTree.put('N', 0);
        blackTree.put('O', 0);
        //when
        String actual = blackTree.getInOrder();
        //then
        String expected = "A:0 B:0 C:0 D:0 E:0 F:0 G:0 H:0 I:0 J:0 K:0 L:0 M:0 N:0 O:0";
        Assert.assertEquals(expected, actual);

    }

    @Test
    public void getPostOrderTest() {
        //given
        blackTree.put('A', 0);
        blackTree.put('B', 0);
        blackTree.put('C', 0);
        blackTree.put('D', 0);
        blackTree.put('E', 0);
        blackTree.put('F', 0);
        blackTree.put('G', 0);
        blackTree.put('H', 0);
        blackTree.put('I', 0);
        blackTree.put('J', 0);
        blackTree.put('K', 0);
        blackTree.put('L', 0);
        blackTree.put('M', 0);
        blackTree.put('N', 0);
        blackTree.put('O', 0);
        //when
        String actual = blackTree.getPostOrder();
        //then
        String expected = "A:0 C:0 B:0 E:0 G:0 F:0 D:0 I:0 K:0 J:0 M:0 O:0 N:0 L:0 H:0";
        Assert.assertEquals(expected, actual);

    }

    @Test
    public void getTest() {
        //given
        blackTree.put('A', 0);
        blackTree.put('B', 1);
        blackTree.put('C', 2);
        //when
        int value1 = 0;
        int value2 = 1;
        int value3 = 2;
        //then
        Assert.assertEquals(blackTree.get('A'), value1);
        Assert.assertEquals(blackTree.get('B'), value2);
        Assert.assertEquals(blackTree.get('C'), value3);

    }

    @Test
    public void deleteMaxTest() {
        //given
        blackTree.put('A', 0);
        blackTree.put('B', 0);
        blackTree.put('C', 0);
        blackTree.put('D', 0);
        blackTree.put('E', 0);
        blackTree.put('F', 0);
        blackTree.put('G', 0);
        blackTree.put('H', 0);
        blackTree.put('I', 0);
        blackTree.put('J', 0);
        blackTree.put('K', 0);
        blackTree.put('L', 0);
        blackTree.put('M', 0);
        blackTree.put('N', 0);
        blackTree.put('O', 0);
        //when
        blackTree.deleteMax();
        //then
        String expected = "A:0 B:0 C:0 D:0 E:0 F:0 G:0 H:0 I:0 J:0 K:0 L:0 M:0 N:0";
        Assert.assertEquals(expected, blackTree.getInOrder());
    }

    @Test(expected = IllegalArgumentException.class)
    public void addNull() {
        //when
        blackTree.put(null, null);
        //then
        assert false;

    }

    @Test
    public void rotateRightTest() {
        //given
        blackTree.put('W', 0);
        blackTree.put('E', 0);
        blackTree.put('R', 0);
        blackTree.put('O', 0);
        //when
        String actual = blackTree.getInOrder();
        //then
        String expected = "E:0 O:0 R:0 W:0";
        Assert.assertEquals(expected, actual);
    }

    @Test(expected = IllegalArgumentException.class)
    public void getWhenNull() {
        //when
        blackTree.get(null);
        //then
        assert false;
    }








}
