package com.example;

import java.util.*;

public class LeetCode {

    // Given an array of numbers and a target, this method returns the two indicies in the array that add up to the target. 
    public int[] twoSum(int[] nums, int target) {
        
        // Throw the input array into a HashMap to speed up searching.
        HashMap<Integer, Integer> lookup = new HashMap<Integer, Integer>();
        for(int i = 0; i < nums.length; i++){
            lookup.put(nums[i], i);
        }
        
        // For each value x in the array, attempt to find target-x in the array. Once we find that value, get both indicies and return.
        for(int i = 0; i < nums.length; i++){
            int fixed = nums[i];
            int testVal = target - fixed;
            if(lookup.containsKey(testVal) && lookup.get(testVal) != i){
                int[] retVal = new int[2];
                retVal[0] = i;
                retVal[1] = lookup.get(testVal);
                return retVal;
            }
        }
        
        // If this gets returned then no answer existed for the given inputs.
        return null;
    }

    public static void main(String[] args){

    }
}
