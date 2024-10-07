import java.util.Arrays;

// Problem: https://leetcode.com/problems/sort-an-array/ 
// Merge sort
// Note: Originally tried Radix sort, but that did not work for negative numbers

class Solution {
    public int[] sortArray(int[] nums) {
        int n = nums.length;
        if (n <= 1) {
            return nums;
        }
        int mid = n / 2;
        int[] left = Arrays.copyOfRange(nums, 0, mid);
        int[] right = Arrays.copyOfRange(nums, mid, n);
        sortArray(left);
        sortArray(right);
        merge(left, right, nums);
        return nums;
    }

    public void merge(int[] left, int[] right, int[] nums) {
        int leftIndex = 0;
        int rightIndex = 0;
        int n = nums.length;
        while(leftIndex + rightIndex < n) {
            if (rightIndex == right.length || (leftIndex < left.length && left[leftIndex] < right[rightIndex])) {
                nums[leftIndex + rightIndex] = left[leftIndex];
                leftIndex++;
            } else {
                nums[leftIndex + rightIndex] = right[rightIndex];
                rightIndex++;
            }
        }
    }
}