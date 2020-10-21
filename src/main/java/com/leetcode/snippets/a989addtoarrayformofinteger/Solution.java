package com.leetcode.snippets.a989addtoarrayformofinteger;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by hjmao.
 * <p>
 * URL:
 * =====
 * https://leetcode.com/problems/add-to-array-form-of-integer/
 * <p>
 * Desc:
 * =====
 * For a non-negative integer X, the array-form of X is an array of its digits in left to right order. For example, if X = 1231, then the array form is [1,2,3,1].
 * <p>
 * <p>
 * <p>
 * Given the array-form A of a non-negative integer X, return the array-form of the integer X+K.
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * <p>
 * Input: A = [1,2,0,0], K = 34
 * Output: [1,2,3,4]
 * Explanation: 1200 + 34 = 1234
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * Example 2:
 * <p>
 * <p>
 * Input: A = [2,7,4], K = 181
 * Output: [4,5,5]
 * Explanation: 274 + 181 = 455
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * Example 3:
 * <p>
 * <p>
 * Input: A = [2,1,5], K = 806
 * Output: [1,0,2,1]
 * Explanation: 215 + 806 = 1021
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * Example 4:
 * <p>
 * <p>
 * Input: A = [9,9,9,9,9,9,9,9,9,9], K = 1
 * Output: [1,0,0,0,0,0,0,0,0,0,0]
 * Explanation: 9999999999 + 1 = 10000000000
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * Note：
 * <p>
 * <p>
 * 1 <= A.length <= 10000
 * 0 <= A[i] <= 9
 * 0 <= K <= 10000
 * If A.length > 1, then A[0] != 0
 */

/**
 * 使用LinkedList更快速在数组中插入数据
 */
public class Solution {
    protected static final boolean SOLUTION_DONE = true;

    public List<Integer> addToArrayForm(int[] A, int K) {
        LinkedList<Integer> res = new LinkedList<>();
        int acc = K;
        for (int i = A.length - 1; i >= 0; i--) {
            int temp = A[i] + acc;
            acc = temp / 10;
            res.addFirst(temp % 10);
        }
        while (acc > 0) {
            res.addFirst(acc % 10);
            acc = acc / 10;
        }
        return res;
    }
}
