package pl.edu.pw.ee;

import org.junit.Test;
import pl.edu.pw.ee.services.Sorting;

import java.util.Arrays;
import java.util.Random;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class InsertionSortTest {

    private static final double S = 0;

    private Sorting insertionSort = new InsertionSort();

    @Test(expected = IllegalArgumentException.class)
    public void arrayIsNull() {
        //given
        double[] nums = null;

        //when
        insertionSort.sort(nums);

        //then
        assert false;
    }

    @Test
    public void shouldSortCorrectlyWhenArrayIsEmpty() {
        //given
        double[] nums = {};

        //when
        insertionSort.sort(nums);

        //then
        int expectedSize = 0;
        assertEquals(expectedSize, nums.length);
    }

    @Test
    public void shouldSortCorrectlyWhenOneElement() {
        //given
        double[] nums = {1};

        //when
        insertionSort.sort(nums);

        //then
        int expectedSize = 1;
        assertEquals(expectedSize, nums.length);

    }

    @Test
    public void shouldSortCorrectlyWhenTwoElements() {
        //given
        double[] nums = {6, 1};

        //when
        insertionSort.sort(nums);

        //then
        double[] expected = {1, 6};
        assertArrayEquals(expected, nums, S);

    }

    @Test
    public void shouldSortCorrectlyWhenThreeElements() {
        //given
        double[] nums = {6, 1, 9};

        //when
        insertionSort.sort(nums);

        //then
        double[] expected = {1, 6, 9};
        assertArrayEquals(expected, nums, S);

    }

    @Test
    public void shouldSortCorrectlyWhenThereAreTheSameNumbers() {
        //given
        double[] nums = {6, 1, 6, 8};

        //when
        insertionSort.sort(nums);

        //then
        double[] expected = {1, 6, 6, 8};
        assertArrayEquals(expected, nums, S);

    }

    @Test
    public void shouldSortCorrectlyWhenOnlyFirstIsUnsortedNumsOdd() {
        //given
        double[] nums = {6, 1, 5, 8, 9};

        //when
        insertionSort.sort(nums);

        //then
        double[] expected = {1, 5, 6, 8, 9};
        assertArrayEquals(expected, nums, S);

    }

    @Test
    public void shouldSortCorrectlyWhenOnlyFirstIsUnsortedNumsEven() {
        //given
        double[] nums = {6, 1, 5, 8};

        //when
        insertionSort.sort(nums);

        //then
        double[] expected = {1, 5, 6, 8};
        assertArrayEquals(expected, nums, S);

    }

    @Test
    public void shouldSortCorrectlyWhenOnlyLastIsUnsortedNumsEven() {
        //given
        double[] nums = {1, 5, 8, 6};

        //when
        insertionSort.sort(nums);

        //then
        double[] expected = {1, 5, 6, 8};
        assertArrayEquals(expected, nums, S);

    }

    @Test
    public void shouldSortCorrectlyWhenOnlyLastIsUnsortedNumsOdd() {
        //given
        double[] nums = {1, 3, 5, 8, 6};

        //when
        insertionSort.sort(nums);

        //then
        double[] expected = {1, 3, 5, 6, 8};
        assertArrayEquals(expected, nums, S);

    }

    @Test
    public void shouldSortCorrectlyWhenAllNumsInOrder() {
        //given
        double[] nums = {1, 2, 3, 4, 5};

        //when
        insertionSort.sort(nums);

        //then
        double[] expected = {1, 2, 3, 4, 5};
        assertArrayEquals(expected, nums, S);
    }

    @Test
    public void shouldSortCorrectlyWhenAllNumsInDescOrder() {
        //given
        double[] nums = {5, 4, 3, 2, 1};

        //when
        insertionSort.sort(nums);

        //then
        double[] expected = {1, 2, 3, 4, 5};
        assertArrayEquals(expected, nums, S);
    }

    @Test
    public void shouldSortCorrectlyWhenNumsIsUnsorted() {
        //given
        double[] nums = {15, 9, 1, 2, 14, 8, 7, 6, 10, 13, 12, 3, 4, 5, 11};

        //when
        insertionSort.sort(nums);

        //then
        double[] expected = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15};
        assertArrayEquals(expected, nums, S);
    }

    @Test
    public void shouldSortCorrectlyWhenNumsIsBigAndGeneratedRandomlyDataSet() {
        //given
        double[] nums = new double[100000];
        double[] expected = new double[100000];
        int n = nums.length;
        Random number = new Random(213);
        for (int i = 0; i < n - 1; i++) {
            nums[i] = number.nextDouble();
        }
        System.arraycopy(nums, 0, expected, 0, n);

        //when
        insertionSort.sort(nums);

        //then
        Arrays.sort(expected);
        assertArrayEquals(expected, nums, S);

    }

    @Test
    public void shouldSortCorrectlyWhenNumsIsBigAndPositiveDataSet() {
        //given
        double[] nums = new double[100000];
        double[] expected = new double[100000];
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            nums[i] = i + 0.21 * i;
        }
        System.arraycopy(nums, 0, expected, 0, n);

        //when
        insertionSort.sort(nums);

        //then
        Arrays.sort(expected);
        assertArrayEquals(expected, nums, S);
    }
}
