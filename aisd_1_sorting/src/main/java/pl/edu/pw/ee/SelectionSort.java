package pl.edu.pw.ee;

import pl.edu.pw.ee.services.Sorting;

public class SelectionSort implements Sorting {

    @Override
    public void sort(double[] nums) {
        if (nums == null) {
            throw new IllegalArgumentException
                    ("Array given to the method cannot be null");
        }
        int n = nums.length;
        int maxValId;
        for (int i = 0; i < n - 1; i++) {
            maxValId = i;

            for (int j = i + 1; j < n; j++) {
                if (nums[j] < nums[maxValId]) {
                    maxValId = j;
                }
            }
            swap(nums, maxValId, i);
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
