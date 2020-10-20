package com.leetcode.snippets.a001twosum;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by hjmao on 17/01/2017.
 * <p>
 * URL:
 * =====
 * https://leetcode.com/problems/two-sum/
 * <p>
 * Desc:
 * =====
 * Given an array of integers,
 * return indices of the two numbers such that they add up to a specific target.
 * You may assume that each input would have exactly one solution.
 */

public class Solution {
    protected static final boolean SOLUTION_DONE = true;

    public int[] twoSum(int[] nums, int target) {

        Map<Integer, Integer> numsMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int temp = target - nums[i];
            if (numsMap.containsKey(nums[i])) {
                return new int[]{numsMap.get(nums[i]), i};
            } else {
                numsMap.putIfAbsent(temp, i);
            }
        }
        return new int[]{};
    }
}
