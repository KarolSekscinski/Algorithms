package pl.edu.pw.ee;

import org.junit.Test;
import pl.edu.pw.ee.services.HashTableForOpenAddressing;

import static org.junit.Assert.assertEquals;
import static pl.edu.pw.ee.HashTesting.getIndexOfElem;
import static pl.edu.pw.ee.HashTesting.getNumOfElems;

public class HashQuadraticProbingTest {

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowExceptionWhenInitialSizeIsLowerThanOne() {
        // given
        int initialSize = 0;
        int constValueOfA = 10;
        int constValueOfB = 15;

        // when
        HashTableForOpenAddressing<Double> unusedHash = new HashQuadraticProbingForOpenAddressing<>(initialSize, constValueOfA, constValueOfB);

        // then
        assert false;
    }

    @Test
    public void shouldCorrectlyAddNewElemsWhenNotExistInHashTable() {
        // given
        HashTableForOpenAddressing<String> emptyHash = new HashQuadraticProbingForOpenAddressing<>();
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
        HashTableForOpenAddressing<Integer> hashTable = new HashQuadraticProbingForOpenAddressing<>(10, 0.5, 0.5);

        //when
        hashTable.put(1);
        hashTable.put(11);
        hashTable.put(21);

        //then
        int expectedSize = 3;
        int actualSize = getNumOfElems(hashTable);
        int hashOfFirstElem = getIndexOfElem(hashTable, 1);
        int hashOfSecondElem = getIndexOfElem(hashTable, 11);
        int hashOfThirdElem = getIndexOfElem(hashTable, 21);
        assertEquals(expectedSize, actualSize);
        assertEquals(1, hashOfFirstElem);
        assertEquals(2, hashOfSecondElem);
        assertEquals(4, hashOfThirdElem);
    }

    @Test
    public void shouldCorrectlyCountIdInHashBasedOnSizeOfHashAndAddedValueForExtremeIntegers() {
        //given
        HashTableForOpenAddressing<Integer> hashTable = new HashQuadraticProbingForOpenAddressing<>(10, 0.5, 0.5);
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
        HashTableForOpenAddressing<Double> hashTable = new HashQuadraticProbingForOpenAddressing<>(10, 0.5, 0.5);
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

    @Test
    public void shouldCorrectlyGetAllElemsWhenAddedValuesWithSameHashCode() {
        //given
        HashTableForOpenAddressing<Integer> hashTable = new HashQuadraticProbingForOpenAddressing<>(10, 0.5, 0.5);
        hashTable.put(1);
        hashTable.put(11);
        hashTable.put(21);
        hashTable.put(31);
        int expectedSize = 4;
        //when
        int actualSize = getNumOfElems(hashTable);
        int firstElem = hashTable.get(1);
        int secondElem = hashTable.get(11);
        int thirdElem = hashTable.get(21);
        int fourthElem = hashTable.get(31);
        //then
        assertEquals(1, firstElem);
        assertEquals(11, secondElem);
        assertEquals(21, thirdElem);
        assertEquals(31, fourthElem);
        assertEquals(expectedSize, actualSize);
    }

    @Test
    public void shouldCorrectlyDeleteAllElemsWhenAddedValuesWithSameHashCode() {
        //given
        HashTableForOpenAddressing<Integer> hashTable = new HashQuadraticProbingForOpenAddressing<>(10, 0.5, 0.5);
        hashTable.put(1);
        hashTable.put(11);
        hashTable.put(21);
        hashTable.put(31);
        //when
        hashTable.delete(1);
        hashTable.delete(11);
        hashTable.delete(31);
        hashTable.delete(21);

        //then
        int expectedSize = 0;
        int actualSize = getNumOfElems(hashTable);
        assertEquals(expectedSize, actualSize);
    }

    @Test
    public void shouldCorrectlyPuttingDiffrentElemsWithTheSameHashCode() {
        //given
        HashTableForOpenAddressing<Integer> hashTable = new HashQuadraticProbingForOpenAddressing<>(10, 0.5, 0.5);
        hashTable.put(1);
        hashTable.put(11);
        hashTable.put(21);
        hashTable.put(31);
        //when
        int hashOfFirstElem = getIndexOfElem(hashTable, 1);
        int hashOfSecondElem = getIndexOfElem(hashTable, 11);
        int hashOfThirdElem = getIndexOfElem(hashTable, 21);
        int hashOfFourthElem = getIndexOfElem(hashTable, 31);

        //then
        assertEquals(1, hashOfFirstElem);
        assertEquals(2, hashOfSecondElem);
        assertEquals(4, hashOfThirdElem);
        assertEquals(7, hashOfFourthElem);
    }

    @Test
    public void shouldCorrectlyAddElemWhichIsntAlreadyInHashTable() {
        //given
        HashTableForOpenAddressing<String> hashTable = new HashQuadraticProbingForOpenAddressing<>(10, 0.5, 0.5);
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
        HashTableForOpenAddressing<String> hashTable = new HashQuadraticProbingForOpenAddressing<>(10, 0.5, 0.5);
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
        HashTableForOpenAddressing<String> hashTable = new HashQuadraticProbingForOpenAddressing<>(10, 0.5, 0.5);
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
        HashTableForOpenAddressing<String> hashTable = new HashQuadraticProbingForOpenAddressing<>();
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
        HashTableForOpenAddressing<String> hashTable = new HashQuadraticProbingForOpenAddressing<>();
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
        HashTableForOpenAddressing<String> hashTable = new HashQuadraticProbingForOpenAddressing<>();
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
        HashTableForOpenAddressing<Integer> hashTable = new HashQuadraticProbingForOpenAddressing<>(10, 0.5, 0.5);
        hashTable.put(1);
        hashTable.put(11);
        hashTable.put(21);
        int expectedSizeBefore = 3;
        int actualSizeBefore = getNumOfElems(hashTable);
        int hashOfSecondElemBefore = getIndexOfElem(hashTable, 11);
        int hashOfThirdElemBefore = getIndexOfElem(hashTable, 21);
        //when
        hashTable.delete(1);
        //then
        int expectedSizeAfter = 2;
        int actualSizeAfter = getNumOfElems(hashTable);

        int secondElem = hashTable.get(11);
        int thirdElem = hashTable.get(21);

        int hashOfSecondElemAfter = getIndexOfElem(hashTable, 11);
        int hashOfThirdElemAfter = getIndexOfElem(hashTable, 21);
        assertEquals(expectedSizeBefore, actualSizeBefore);
        assertEquals(expectedSizeAfter, actualSizeAfter);
        assertEquals(hashOfSecondElemBefore, hashOfSecondElemAfter);
        assertEquals(hashOfThirdElemBefore, hashOfThirdElemAfter);
        assertEquals(11, secondElem);
        assertEquals(21, thirdElem);
    }

    @Test
    public void shouldCorrectlyDeleteMiddleElemAfterAddingAFewElemsToHashTableWhenEveryElemHasTheSameHashCode() {
        //given
        HashTableForOpenAddressing<Integer> hashTable = new HashQuadraticProbingForOpenAddressing<>(10, 0.5, 0.5);
        hashTable.put(1);
        hashTable.put(11);
        hashTable.put(21);
        int expectedSizeBefore = 3;
        int actualSizeBefore = getNumOfElems(hashTable);
        int hashOfFirstElemBefore = getIndexOfElem(hashTable, 1);
        int hashOfThirdElemBefore = getIndexOfElem(hashTable, 21);
        //when
        hashTable.delete(11);
        //then
        int expectedSizeAfter = 2;
        int actualSizeAfter = getNumOfElems(hashTable);

        int firstElem = hashTable.get(1);
        int thirdElem = hashTable.get(21);

        int hashOfFirstElemAfter = getIndexOfElem(hashTable, 1);
        int hashOfThirdElemAfter = getIndexOfElem(hashTable, 21);
        assertEquals(expectedSizeBefore, actualSizeBefore);
        assertEquals(expectedSizeAfter, actualSizeAfter);
        assertEquals(hashOfFirstElemBefore, hashOfFirstElemAfter);
        assertEquals(hashOfThirdElemBefore, hashOfThirdElemAfter);
        assertEquals(1, firstElem);
        assertEquals(21, thirdElem);
    }

    @Test
    public void shouldCorrectlyDeleteLastElemAfterAddingAFewElemsToHashTableWhenEveryElemHasTheSameHashCode() {

        //given
        HashTableForOpenAddressing<Integer> hashTable = new HashQuadraticProbingForOpenAddressing<>(10, 0.5, 0.5);
        hashTable.put(1);
        hashTable.put(11);
        hashTable.put(21);
        int expectedSizeBefore = 3;
        int actualSizeBefore = getNumOfElems(hashTable);
        int hashOfSecondElemBefore = getIndexOfElem(hashTable, 11);
        int hashOfFirstElemBefore = getIndexOfElem(hashTable, 1);
        //when
        hashTable.delete(21);
        //then
        int expectedSizeAfter = 2;
        int actualSizeAfter = getNumOfElems(hashTable);

        int firstElem = hashTable.get(1);
        int secondElem = hashTable.get(11);

        int hashOfFirstElemAfter = getIndexOfElem(hashTable, 1);
        int hashOfSecondElemAfter = getIndexOfElem(hashTable, 11);
        assertEquals(expectedSizeBefore, actualSizeBefore);
        assertEquals(expectedSizeAfter, actualSizeAfter);
        assertEquals(hashOfFirstElemBefore, hashOfFirstElemAfter);
        assertEquals(hashOfSecondElemBefore, hashOfSecondElemAfter);
        assertEquals(1, firstElem);
        assertEquals(11, secondElem);
    }
}
