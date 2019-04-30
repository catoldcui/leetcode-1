package cn.hjmao.leetcode.a016threesumclosest;

import java.util.Arrays;

/**
 * Created by hjmao.
 *
 * URL:
 * =====
 * https://leetcode.com/problems/3sum-closest/
 *
 * Desc:
 * =====
 * Given an array S of n integers,
 * find three integers in S such that the sum is closest to a given number, target.
 * Return the sum of the three integers.
 * You may assume that each input would have exactly one solution.
 *
 * For example, given array S = {-1 2 1 -4}, and target = 1.
 * The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
 */

public class Solution {
  protected int brutalForceSolution(int[] nums, int target) {
    int closestValue = Integer.MAX_VALUE;
    int minDelta = Integer.MAX_VALUE;
    for (int i = 0; i < nums.length; i++) {
      for (int j = i + 1; j < nums.length; j++) {
        for (int k = j + 1; k < nums.length; k++) {
          int thisSum = nums[i] + nums[j] + nums[k];
          int thisDelta = Math.abs(thisSum - target);
          if (thisDelta < minDelta) {
            minDelta = thisDelta;
            closestValue = thisSum;
          }
          if (minDelta == 0) {
            return closestValue;
          }
        }
      }
    }

    return closestValue;
  }

  protected int threeSumClosest1(int[] nums, int target) {
    Arrays.sort(nums);

    int closestValue = Integer.MAX_VALUE;
    int minDelta = Integer.MAX_VALUE;
    for (int left = 0; left < nums.length - 2; left++) {
      if (left > 0 && nums[left] == nums[left - 1]) {
        continue;
      }
      int middle = left + 1;
      int right = nums.length - 1;
      while (middle < right) {
        int thisSum = nums[left] + nums[middle] + nums[right];
        int thisDelta = Math.abs(thisSum - target);
        if (thisDelta < minDelta) {
          minDelta = thisDelta;
          closestValue = thisSum;
        }
        if (minDelta == 0) {
          return closestValue;
        }

        if (thisSum > target) {
          right--;
        } else {
          middle++;
        }
      }
    }
    return closestValue;
  }

  public int threeSumClosest(int[] nums, int target) {
    return threeSumClosest1(nums, target);
  }
}
