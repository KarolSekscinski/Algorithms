package pl.edu.pw.ee;

import org.junit.Test;
import pl.edu.pw.ee.services.Sorting;

import java.util.Random;

public class SelectionSortPerformanceTest {
    private Sorting selectionSort = new SelectionSort();

    private int sizeOfArray = 4000;

    @Test
    public void selectionSortPerformanceTestForPessimisticData() {
        //given
        double[] nums = new double[sizeOfArray];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = nums.length - i;
        }

        //when
        long timeToSort = System.nanoTime();
        selectionSort.sort(nums);
        long time = System.nanoTime() - timeToSort;

        //then
        System.out.println("Test pesymistyczny: " + time / 1000000);

    }

    @Test
    public void selectionSortPerformanceTestForOptimisticData() {
        //given
        double[] nums = new double[sizeOfArray];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = i;
        }

        //when
        long timeToSort = System.nanoTime();
        selectionSort.sort(nums);
        long time = System.nanoTime() - timeToSort;

        //then
        System.out.println("Test optymistyczny: " + time / 1000000);

    }

    @Test
    public void selectionSortPerformanceTestForRandomData() {
        //given
        double[] nums = new double[sizeOfArray];
        Random number = new Random(213);
        for (int i = 0; i < nums.length; i++) {
            nums[i] = number.nextDouble();
        }


        //when
        long timeToSort = System.nanoTime();
        selectionSort.sort(nums);
        long time = System.nanoTime() - timeToSort;

        //then
        System.out.println("Test losowy: " + time / 1000000);

    }
}
