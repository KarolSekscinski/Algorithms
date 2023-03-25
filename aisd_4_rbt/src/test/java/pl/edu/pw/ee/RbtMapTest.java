package pl.edu.pw.ee;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class RbtMapTest {

    private RbtMap rbt;

    @Before
    public void setUp() {
        rbt = new RbtMap();
    }

    @Test
    public void setAndGetValueTest() {
        //given
        rbt.setValue('A', 0);
        //when
        int actual = (int) rbt.getValue('A');
        //then
        int expected = 0;
        Assert.assertEquals(expected, actual);
    }

    @Test(expected = IllegalArgumentException.class)
    public void setWhenKeyIsNull() {
        //when
        rbt.setValue(null, null);
        //then
        assert false;
    }

    @Test(expected = IllegalArgumentException.class)
    public void getWhenKeyIsNull() {
        //when
        rbt.getValue(null);
        //then
        assert false;
    }
}
