package com.example;

import java.util.*;

public class SlidingWindows {
    // https://leetcode.com/problems/sliding-window-maximum/
    public static int[] maxSlidingWindow(int[] nums, int k) {

        List<Integer> numsList = Arrays.stream(nums).boxed().toList();
        for (int i = 0; i <= nums.length - k; i++) {
            List<Integer> subArr = numsList.subList(i, (i + k));
            int[] temp = numsList.stream().mapToInt(num -> num).toArray();
            System.out.println(subArr);
        }

        return nums;
    }

    public static void slidingWindowSkeleton(int[] nums, int windowSize) {
        List<Integer> numsList = Arrays.stream(nums).boxed().toList();
        int slidingInterval = 1;
        for (int idx = 0; idx <= numsList.size() - windowSize; idx += slidingInterval) {
            List<Integer> arrWindow = numsList.subList(idx, (idx + windowSize));
            System.out.println(arrWindow);
        }
    }

    public static void main(String[] args) {
        slidingWindowSkeleton(new int[] { 1, 3, -1, -3, 5, 3, 6, 7 }, 3);
    }
}