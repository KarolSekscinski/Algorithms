package pl.edu.pw.ee;

import org.junit.Test;
import pl.edu.pw.ee.services.Sorting;

import java.util.Random;

public class HeapSortPerformanceTest {
    private Sorting heapSort = new HeapSort();

    private int sizeOfArray = 4000;

    @Test
    public void heapSortPerformanceTestForPessimisticData() {
        //given
        double[] nums = new double[sizeOfArray];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = nums.length - i;
        }

        //when
        long timeToSort = System.nanoTime();

        heapSort.sort(nums);
        long time = System.nanoTime() - timeToSort;

        //then
        System.out.println("Test pesymistyczny: " + time / 1000000);

    }

    @Test
    public void heapSortPerformanceTestForOptimisticData() {
        //given
        double[] nums = new double[sizeOfArray];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = i;
        }

        //when
        long timeToSort = System.nanoTime();
        heapSort.sort(nums);
        long time = System.nanoTime() - timeToSort;

        //then
        System.out.println("Test optymistyczny: " + time / 1000000);

    }

    @Test
    public void heapSortPerformanceTestForRandomData() {
        //given
        double[] nums = new double[sizeOfArray];
        Random number = new Random(213);
        for (int i = 0; i < nums.length; i++) {
            nums[i] = number.nextDouble();
        }


        //when
        long timeToSort = System.nanoTime();
        heapSort.sort(nums);
        long time = System.nanoTime() - timeToSort;

        //then
        System.out.println("Test losowy: " + time / 1000000);

    }
}
