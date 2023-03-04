package pl.edu.pw.ee;

import org.junit.Test;

import java.util.NoSuchElementException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class HashListChainingTest {

    private HashListChaining hash;

    @Test
    public void shouldHashCorrectlyForSizeOfPositiveNumber() {
        //given
        hash = new HashListChaining(50);

        //when

        hash.add(1.);
        hash.add(2.);
        hash.add(3.);
        //then
        int expectedSize = 3;
        int actualSize = hash.getnElem();
        assertEquals(expectedSize, actualSize);

    }

    @Test
    public void shouldDeleteFirstElemCorrectlyWhenSizeOfHashEqualsOne() {
        //given
        hash = new HashListChaining(1);

        //when
        hash.add(1.);
        hash.add(2.);
        hash.add(3.);

        hash.delete(1.);
        //then
        assertNull(hash.get(1.));
        assertEquals(2., hash.get(2.));
        assertEquals(3., hash.get(3.));
    }

    @Test
    public void shouldDeleteMiddleElemCorrectlyWhenSizeOfHashEqualsOne() {
        //given
        hash = new HashListChaining(1);

        //when
        hash.add(1.);
        hash.add(2.);
        hash.add(3.);

        hash.delete(2.);
        //then
        assertNull(hash.get(2.));
        assertEquals(1., hash.get(1.));
        assertEquals(3., hash.get(3.));
    }

    @Test
    public void shouldDeleteLastElemCorrectlyWhenSizeOfHashEqualsOne() {
        //given
        hash = new HashListChaining(1);

        //when
        hash.add(1);
        hash.add(2);
        hash.add(3);

        hash.delete(3);
        //then
        assertNull(hash.get(3));
        assertEquals(1, hash.get(1));
        assertEquals(2, hash.get(2));
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowExceptionWhenAddingNull() {
        //given
        hash = new HashListChaining(1);

        //when
        Double number = null;
        hash.add(number);
        //then
        assert false;
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowExceptionWhenDeletingNull() {
        //given
        hash = new HashListChaining(1);

        //when
        hash.delete(null);

        //then
        assert false;
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowExceptionWhenGettingNull() {
        //given
        hash = new HashListChaining(1);

        //when
        hash.get(null);

        //then
        assert false;
    }

    @Test(expected = NoSuchElementException.class)
    public void shouldActCorrectlyWhenTryingToDeleteItemWhichIsntInHash() {
        //given
        hash = new HashListChaining(1);

        //when
        hash.add(1.);
        hash.add(2.);
        hash.add(3.);

        hash.delete(4.);

        //then
        assert false;
    }

    @Test(expected = NoSuchElementException.class)
    public void shouldActCorretlyWhenTryingToDeleteItemWhichWasPreviousInHash() {
        //given
        hash = new HashListChaining(1);

        //when
        hash.add("A");
        hash.add("B");
        hash.add("C");

        hash.delete("B");

        //then
        hash.delete("B");
        assert false;
    }

    @Test
    public void shouldReturnCorrectValueWhenHashTableIsntEmpty() {
        //given
        hash = new HashListChaining(50);

        //when
        hash.add(1.);
        hash.add(2.);
        hash.add(3.);

        int actualSize = hash.getnElem();

        //then
        int expectedSize = 3;
        assertEquals(expectedSize, actualSize);
    }

    @Test
    public void shouldReturnProperSizeOfHashTableAfterAddingNewElem() {
        //given
        hash = new HashListChaining(50);

        //when
        hash.add("A");
        hash.add("B");
        hash.add("C");

        int actualSizeBefore = hash.getnElem();

        hash.add("D");

        int actualSizeAfter = hash.getnElem();
        //then
        int expectedSizeBefore = 3;
        int expectedSizeAfter = 4;
        assertEquals(expectedSizeBefore, actualSizeBefore);
        assertEquals(expectedSizeAfter, actualSizeAfter);
    }

    @Test
    public void shouldReturnProperSizeOfHashTableAfterAddingOldElem() {
        //given
        hash = new HashListChaining(1);

        //when
        hash.add(1.);
        hash.add(2.);
        hash.add(3.);

        int actualSizeBefore = hash.getnElem();

        hash.add(3.);

        int actualSizeAfter = hash.getnElem();
        //then
        int expectedSizeBefore = 3;
        int expectedSizeAfter = 3;
        assertEquals(expectedSizeBefore, actualSizeBefore);
        assertEquals(expectedSizeAfter, actualSizeAfter);
    }

    @Test
    public void shouldReturnProperSizeOfHashTableAfterDeletingOldElem() {
        //given
        hash = new HashListChaining(1);

        //when
        hash.add(1.);
        hash.add(2.);
        hash.add(3.);

        int actualSizeBefore = hash.getnElem();

        hash.delete(3.);

        int actualSizeAfter = hash.getnElem();
        //then
        int expectedSizeBefore = 3;
        int expectedSizeAfter = 2;
        assertEquals(expectedSizeBefore, actualSizeBefore);
        assertEquals(expectedSizeAfter, actualSizeAfter);
    }

    @Test(expected = NoSuchElementException.class)
    public void shouldReturnProperSizeOfHashTableAfterDeletingNonExistingElem() {
        //given
        hash = new HashListChaining(1);

        //when
        hash.add(1.);
        hash.add(2.);
        hash.add(3.);

        int actualSizeBefore = hash.getnElem();

        hash.delete(4.);

        int actualSizeAfter = hash.getnElem();

        //then
        int expectedSizeBefore = 3;
        int expectedSizeAfter = 3;
        assertEquals(expectedSizeBefore, actualSizeBefore);
        assertEquals(expectedSizeAfter, actualSizeAfter);
    }

    @Test(expected = IllegalStateException.class)
    public void shouldActCorrectlyWhenTryingToUseHashTableOfSizeLessThanOne() {
        //given
        hash = new HashListChaining(0);

        //when
        hash.add(1);

        //then
        assert false;
    }

    @Test
    public void shouldCorreclyAddGetAndDeleteTheSameElemInHashTable() {
        //given
        hash = new HashListChaining(1);

        //when
        hash.add(1.);
        hash.add(2.);
        hash.add(3.);

        hash.delete(2.);


        //then
        assertNull(hash.get(2.));
        hash.add(2.);
        double expected = 2.;
        assertEquals(expected, hash.get(2.));

    }

    @Test
    public void checkingPerformanceOnBigDataSet() {
        //given
        hash = new HashListChaining(100);

        //when
        for (int i = 0; i < 200000; i++) {
            hash.add(2. * i);
        }
        int expectedSize = 200000;

        //then
        assertEquals(expectedSize, hash.getnElem());

    }
}
