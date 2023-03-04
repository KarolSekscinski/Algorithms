package pl.edu.pw.ee;

import org.junit.Test;
import pl.edu.pw.ee.services.Sorting;

import java.util.Arrays;
import java.util.Random;

import static org.junit.Assert.assertEquals;

public class InsertionSortPerformanceTest {
    //given
    private Sorting insertionSort = new InsertionSort();

    private int sizeOfArray = 8000;

    @Test
    public void insertionSortPerformanceTestForPessimisticData() {
        //given
        double[] nums = new double[sizeOfArray];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = nums.length - i;
        }

        //when
        long timeToSort = System.nanoTime();
        insertionSort.sort(nums);
        long time = System.nanoTime() - timeToSort;

        //then
        System.out.println("Test pesymistyczny: " + time / 1000000);

    }

    @Test
    public void insertionSortPerformanceTestForOptimisticData() {
        //given
        double[] nums = new double[sizeOfArray];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = i;
        }

        //when
        long timeToSort = System.nanoTime();
        insertionSort.sort(nums);
        long time = System.nanoTime() - timeToSort;

        //then
        System.out.println("Test optymistyczny: " + time / 1000000);

    }

    @Test
    public void insertionSortPerformanceTestForRandomData() {
        //given
        double[] nums = new double[sizeOfArray];
        Random number = new Random(213);
        for (int i = 0; i < nums.length; i++) {
            nums[i] = number.nextDouble();
        }


        //when
        long timeToSort = System.nanoTime();
        insertionSort.sort(nums);
        long time = System.nanoTime() - timeToSort;

        //then
        System.out.println("Test losowy: " + time / 1000000);

    }
}
