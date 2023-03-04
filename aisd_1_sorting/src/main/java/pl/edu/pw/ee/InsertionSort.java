package pl.edu.pw.ee;

import pl.edu.pw.ee.services.Sorting;

public class InsertionSort implements Sorting {

    @Override
    public void sort(double[] nums) {
        if (nums == null) {
            throw new IllegalArgumentException
                    ("Array given to the method cannot be null");
        }
        int n = nums.length;

        for (int i = 1; i < n; i++) {
            int j = i - 1;
            while (j >= 0 && nums[j] > nums[j + 1]) {
                swap(nums, j, j + 1);
                j--;
            }
        }
    }

    private void swap(double[] nums, int firstId, int secondId) {
        if (firstId != secondId) {
            double firstVal = nums[firstId];
            nums[firstId] = nums[secondId];
            nums[secondId] = firstVal;

        }
    }
}
