package com.leetcode.snippets.a167twosumiiinputarrayissorted;

/**
 * Created by hjmao.
 * <p>
 * URL:
 * =====
 * https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/
 * <p>
 * Desc:
 * =====
 * Given an array of integers that is already sorted in ascending order,
 * find two numbers such that they add up to a specific target number.
 * <p>
 * The function twoSum should return indices of the two numbers
 * such that they add up to the target, where index1 must be less than index2.
 * <p>
 * Note:
 * <p>
 * Your returned answers (both index1 and index2) are not zero-based.
 * You may assume that each input would have exactly one solution
 * and you may not use the same element twice.
 * Example:
 * <p>
 * Input: numbers = [2,7,11,15], target = 9
 * Output: [1,2]
 * Explanation: The sum of 2 and 7 is 9. Therefore index1 = 1, index2 = 2.
 */

public class Solution {
    protected static final boolean SOLUTION_DONE = true;

    public int[] twoSum(int[] nums, int target) {

        for (int i = 0; i < nums.length; i++) {
            int res = binarySearch(nums, target - nums[i], i + 1, nums.length - 1);
            if (res != -1) {
                return new int[]{i + 1, res + 1};
            }
        }
        return new int[]{};
    }

    private int binarySearch(int[] nums, int target, int l, int r) {
        int mid = (l + r) / 2;
        while (l < r) {
            if(target == nums[mid]) {
                return mid;
            } else if (target < nums[mid]) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
            mid = (l + r) / 2;
//            System.out.println(String.format("l:%s, r:%s", l, r));
        }
        return target == nums[mid] ? mid : -1;
    }
}