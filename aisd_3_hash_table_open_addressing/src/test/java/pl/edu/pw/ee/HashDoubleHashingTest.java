package pl.edu.pw.ee;

import org.junit.Test;
import pl.edu.pw.ee.services.HashTableForOpenAddressing;

import static org.junit.Assert.assertEquals;
import static pl.edu.pw.ee.HashTesting.getIndexOfElem;
import static pl.edu.pw.ee.HashTesting.getNumOfElems;

public class HashDoubleHashingTest {

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowExceptionWhenInitialSizeIsLowerThanOne() {
        // given
        int initialSize = 0;

        // when
        HashTableForOpenAddressing<Double> unusedHash = new HashDoubleHashingForOpenAddressing<>(initialSize);

        // then
        assert false;
    }

    @Test
    public void shouldCorrectlyAddNewElemsWhenNotExistInHashTable() {
        // given
        HashTableForOpenAddressing<String> emptyHash = new HashDoubleHashingForOpenAddressing<>();
        String newEleme = "nothing special";

        // when
        int nOfElemsBeforePut = getNumOfElems(emptyHash);
        emptyHash.put(newEleme);
        int nOfElemsAfterPut = getNumOfElems(emptyHash);

        // then
        assertEquals(0, nOfElemsBeforePut);
        assertEquals(1, nOfElemsAfterPut);
    }

    @Test
    public void shouldCorrectlyCountIdInHashBasedOnSizeOfHashAndAddedValue() {
        //given
        HashTableForOpenAddressing<Integer> hashTable = new HashDoubleHashingForOpenAddressing<>(10);

        //when
        hashTable.put(10);
        hashTable.put(20);
        hashTable.put(90);

        //then
        int expectedSize = 3;
        int actualSize = getNumOfElems(hashTable);
        int hashOfFirstElem = getIndexOfElem(hashTable, 10);
        int hashOfSecondElem = getIndexOfElem(hashTable, 20);
        int hashOfThirdElem = getIndexOfElem(hashTable, 90);
        assertEquals(expectedSize, actualSize);
        assertEquals(0, hashOfFirstElem);
        assertEquals(7, hashOfSecondElem);
        assertEquals(4, hashOfThirdElem);
    }

    @Test
    public void shouldCorrectlyCountIdInHashBasedOnSizeOfHashAndAddedValueForExtremeIntegers() {
        //given
        HashTableForOpenAddressing<Integer> hashTable = new HashDoubleHashingForOpenAddressing<>(10);
        //when
        hashTable.put(Integer.MAX_VALUE);
        hashTable.put(Integer.MIN_VALUE);
        int expectedSize = 2;

        //then

        int actualSize = getNumOfElems(hashTable);
        int hashOfFirstElem = getIndexOfElem(hashTable, Integer.MAX_VALUE);
        int hashOfSecondElem = getIndexOfElem(hashTable, Integer.MIN_VALUE);
        assertEquals(expectedSize, actualSize);
        assertEquals(7, hashOfFirstElem);
        assertEquals(8, hashOfSecondElem);
    }

    @Test
    public void shouldCorrectlyCountIdInHashBasedOnSizeOfHashAndAddedValueForExtremeDoubles() {
        //given
        HashTableForOpenAddressing<Double> hashTable = new HashDoubleHashingForOpenAddressing<>(10);
        //when
        hashTable.put(Double.MAX_VALUE);
        hashTable.put(Double.MIN_VALUE);
        int expectedSize = 2;

        //then

        int actualSize = getNumOfElems(hashTable);
        int hashOfFirstElem = getIndexOfElem(hashTable, Double.MAX_VALUE);
        int hashOfSecondElem = getIndexOfElem(hashTable, Double.MIN_VALUE);
        assertEquals(expectedSize, actualSize);

        assertEquals(2, hashOfFirstElem);
        assertEquals(1, hashOfSecondElem);
    }

    @Test(expected = ArithmeticException.class)
    public void shouldCorrectlyWorkWhenStartingSizeEqualsThree() {
        //given
        HashTableForOpenAddressing<Double> hashTable = new HashDoubleHashingForOpenAddressing<>(3);
        //when
        hashTable.put(3.);
        hashTable.put(2.);
        hashTable.put(1.);
        hashTable.delete(3.);
        hashTable.delete(2.);
        hashTable.delete(1.);

        //then
        assert false;
    }

    @Test
    public void shouldCorrectlyGetAllElemsWhenAddedValuesWithSameHashCode() {
        //given
        HashTableForOpenAddressing<Integer> hashTable = new HashDoubleHashingForOpenAddressing<>(10);
        hashTable.put(10);
        hashTable.put(20);
        hashTable.put(90);
        hashTable.put(40);
        int expectedSize = 4;
        //when
        int actualSize = getNumOfElems(hashTable);
        int firstElem = hashTable.get(10);
        int secondElem = hashTable.get(20);
        int thirdElem = hashTable.get(90);
        int fourthElem = hashTable.get(40);
        //then
        assertEquals(10, firstElem);
        assertEquals(20, secondElem);
        assertEquals(90, thirdElem);
        assertEquals(40, fourthElem);
        assertEquals(expectedSize, actualSize);
    }

    @Test
    public void shouldCorrectlyDeleteAllElemsWhenAddedValuesWithSameHashCode() {
        //given
        HashTableForOpenAddressing<Integer> hashTable = new HashDoubleHashingForOpenAddressing<>(10);
        hashTable.put(10);
        hashTable.put(20);
        hashTable.put(90);
        hashTable.put(40);
        //when
        hashTable.delete(10);
        hashTable.delete(20);
        hashTable.delete(90);
        hashTable.delete(40);

        //then
        int expectedSize = 0;
        int actualSize = getNumOfElems(hashTable);
        assertEquals(expectedSize, actualSize);
    }

    @Test
    public void shouldCorrectlyPuttingDiffrentElemsWithTheSameHashCode() {
        //given
        HashTableForOpenAddressing<Integer> hashTable = new HashDoubleHashingForOpenAddressing<>(10);
        hashTable.put(10);
        hashTable.put(20);
        hashTable.put(90);
        hashTable.put(40);
        //when
        int hashOfFirstElem = getIndexOfElem(hashTable, 10);
        int hashOfSecondElem = getIndexOfElem(hashTable, 20);
        int hashOfThirdElem = getIndexOfElem(hashTable, 90);
        int hashOfFourthElem = getIndexOfElem(hashTable, 40);

        //then
        assertEquals(0, hashOfFirstElem);
        assertEquals(7, hashOfSecondElem);
        assertEquals(4, hashOfThirdElem);
        assertEquals(6, hashOfFourthElem);
    }

    @Test
    public void shouldCorrectlyAddElemWhichIsntAlreadyInHashTable() {
        //given
        HashTableForOpenAddressing<String> hashTable = new HashDoubleHashingForOpenAddressing<>();
        hashTable.put("a");
        hashTable.put("b");
        hashTable.put("c");
        //when
        int expectedSizeBefore = 3;
        int actualSizeBefore = getNumOfElems(hashTable);
        hashTable.put("d");
        int expectedSizeAfter = 4;
        int actualSizeAfter = getNumOfElems(hashTable);
        //then
        assertEquals(expectedSizeBefore, actualSizeBefore);
        assertEquals(expectedSizeAfter, actualSizeAfter);
    }

    @Test
    public void shouldCorrectlyAddElemWhichIsAlreadyInHashTable() {
        //given
        HashTableForOpenAddressing<String> hashTable = new HashDoubleHashingForOpenAddressing<>();
        hashTable.put("a");
        hashTable.put("b");
        hashTable.put("c");
        int expectedSizeBefore = 3;
        int actualSizeBefore = getNumOfElems(hashTable);
        //when
        hashTable.put("a");
        //then
        int expectedSizeAfter = 3;
        int actualSizeAfter = getNumOfElems(hashTable);
        assertEquals(expectedSizeBefore, actualSizeBefore);
        assertEquals(expectedSizeAfter, actualSizeAfter);
    }

    @Test
    public void shouldCorrectlyAddAndDeleteAllElemsWithDiffrentHashCode() {
        //given
        HashTableForOpenAddressing<String> hashTable = new HashDoubleHashingForOpenAddressing<>();
        hashTable.put("a");
        hashTable.put("b");
        hashTable.put("c");
        int expectedSizeBefore = 3;
        int actualSizeBefore = getNumOfElems(hashTable);
        //when
        hashTable.delete("a");
        hashTable.delete("b");
        hashTable.delete("c");
        //then
        int expectedSizeAfter = 0;
        int actualSizeAfter = getNumOfElems(hashTable);
        assertEquals(expectedSizeBefore, actualSizeBefore);
        assertEquals(expectedSizeAfter, actualSizeAfter);
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldCorrectlyThrowExceptionWhenTryingtoAddNullToHashTable() {
        //given
        HashTableForOpenAddressing<String> hashTable = new HashDoubleHashingForOpenAddressing<>();
        hashTable.put("a");
        hashTable.put("b");
        hashTable.put("c");
        String nullString = null;
        //when
        hashTable.put(nullString);
        //then
        assert false;
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldCorrectlyThrowExceptionWhenTryingToGetNullFromHashTable() {
        //given
        HashTableForOpenAddressing<String> hashTable = new HashDoubleHashingForOpenAddressing<>();
        hashTable.put("a");
        hashTable.put("b");
        hashTable.put("c");
        String nullString = null;
        //when
        hashTable.get(nullString);
        //then
        assert false;
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldCorrectlyThrowExceptionWhenTryingToDeleteNullFromHashTable() {
        //given
        HashTableForOpenAddressing<String> hashTable = new HashDoubleHashingForOpenAddressing<>();
        hashTable.put("a");
        hashTable.put("b");
        hashTable.put("c");
        String nullString = null;
        //when
        hashTable.delete(nullString);
        //then
        assert false;
    }

    @Test
    public void shouldCorrectlyDeleteFirstElemAfterAddingAFewElemsToHashTableWhenEveryElemHasTheSameHashCode() {
        //given
        HashTableForOpenAddressing<Integer> hashTable = new HashDoubleHashingForOpenAddressing<>(10);
        hashTable.put(10);
        hashTable.put(20);
        hashTable.put(90);
        int expectedSizeBefore = 3;
        int actualSizeBefore = getNumOfElems(hashTable);
        int hashOfSecondElemBefore = getIndexOfElem(hashTable, 20);
        int hashOfThirdElemBefore = getIndexOfElem(hashTable, 90);
        //when
        hashTable.delete(10);
        //then
        int expectedSizeAfter = 2;
        int actualSizeAfter = getNumOfElems(hashTable);

        int secondElem = hashTable.get(20);
        int thirdElem = hashTable.get(90);

        int hashOfSecondElemAfter = getIndexOfElem(hashTable, 20);
        int hashOfThirdElemAfter = getIndexOfElem(hashTable, 90);
        assertEquals(expectedSizeBefore, actualSizeBefore);
        assertEquals(expectedSizeAfter, actualSizeAfter);
        assertEquals(hashOfSecondElemBefore, hashOfSecondElemAfter);
        assertEquals(hashOfThirdElemBefore, hashOfThirdElemAfter);
        assertEquals(20, secondElem);
        assertEquals(90, thirdElem);
    }

    @Test
    public void shouldCorrectlyDeleteMiddleElemAfterAddingAFewElemsToHashTableWhenEveryElemHasTheSameHashCode() {
        //given
        HashTableForOpenAddressing<Integer> hashTable = new HashDoubleHashingForOpenAddressing<>(10);
        hashTable.put(10);
        hashTable.put(20);
        hashTable.put(90);
        int expectedSizeBefore = 3;
        int actualSizeBefore = getNumOfElems(hashTable);
        int hashOfFirstElemBefore = getIndexOfElem(hashTable, 10);
        int hashOfThirdElemBefore = getIndexOfElem(hashTable, 90);
        //when
        hashTable.delete(20);
        //then
        int expectedSizeAfter = 2;
        int actualSizeAfter = getNumOfElems(hashTable);

        int firstElem = hashTable.get(10);
        int thirdElem = hashTable.get(90);

        int hashOfFirstElemAfter = getIndexOfElem(hashTable, 10);
        int hashOfThirdElemAfter = getIndexOfElem(hashTable, 90);
        assertEquals(expectedSizeBefore, actualSizeBefore);
        assertEquals(expectedSizeAfter, actualSizeAfter);
        assertEquals(hashOfFirstElemBefore, hashOfFirstElemAfter);
        assertEquals(hashOfThirdElemBefore, hashOfThirdElemAfter);
        assertEquals(10, firstElem);
        assertEquals(90, thirdElem);
    }

    @Test
    public void shouldCorrectlyDeleteLastElemAfterAddingAFewElemsToHashTableWhenEveryElemHasTheSameHashCode() {

        //given
        HashTableForOpenAddressing<Integer> hashTable = new HashLinearProbingForOpenAddressing<>(10);
        hashTable.put(10);
        hashTable.put(20);
        hashTable.put(90);
        int expectedSizeBefore = 3;
        int actualSizeBefore = getNumOfElems(hashTable);
        int hashOfSecondElemBefore = getIndexOfElem(hashTable, 20);
        int hashOfFirstElemBefore = getIndexOfElem(hashTable, 10);
        //when
        hashTable.delete(90);
        //then
        int expectedSizeAfter = 2;
        int actualSizeAfter = getNumOfElems(hashTable);

        int firstElem = hashTable.get(10);
        int secondElem = hashTable.get(20);

        int hashOfFirstElemAfter = getIndexOfElem(hashTable, 10);
        int hashOfSecondElemAfter = getIndexOfElem(hashTable, 20);
        assertEquals(expectedSizeBefore, actualSizeBefore);
        assertEquals(expectedSizeAfter, actualSizeAfter);
        assertEquals(hashOfFirstElemBefore, hashOfFirstElemAfter);
        assertEquals(hashOfSecondElemBefore, hashOfSecondElemAfter);
        assertEquals(10, firstElem);
        assertEquals(20, secondElem);
    }
}
