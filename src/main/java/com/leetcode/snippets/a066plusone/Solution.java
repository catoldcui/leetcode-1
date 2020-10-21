package com.leetcode.snippets.a066plusone;

/**
 * Created by hjmao.
 * <p>
 * URL:
 * =====
 * https://leetcode.com/problems/plus-one
 * <p>
 * Desc:
 * =====
 * Given a non-empty array of digits representing a non-negative integer,
 * plus one to the integer.
 * <p>
 * The digits are stored such that the most significant digit is at the head of the list,
 * and each element in the array contain a single digit.
 * <p>
 * You may assume the integer does not contain any leading zero, except the number 0 itself.
 */

public class Solution {
    protected static final boolean SOLUTION_DONE = true;

    public int[] plusOne(int[] digits) {
        int acc = 1;
        for (int i = digits.length - 1; i >= 0; i--) {
            int temp = digits[i] + acc;
            acc = temp / 10;
            digits[i] = temp % 10;
            if(acc == 0) {
                return digits;
            }
        }
        int[] res = digits;
        if (acc == 1) {
            res = new int[digits.length + 1];
            res[0] = 1;
            for (int i = 0; i < digits.length; i++) {
                res[i + 1] = digits[i];
            }
        }
        return res;
    }
}
