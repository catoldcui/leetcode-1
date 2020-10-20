package com.leetcode.snippets.a043multiplystrings;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by hjmao.
 * <p>
 * URL:
 * =====
 * https://leetcode.com/problems/multiply-strings
 * <p>
 * Desc:
 * =====
 * Given two non-negative integers num1 and num2 represented as strings,
 * return the product of num1 and num2.
 * <p>
 * Note:
 * 1. The length of both num1 and num2 is < 110.
 * 2. Both num1 and num2 contains only digits 0-9.
 * 3. Both num1 and num2 does not contain any leading zero.
 * 4. You must not use any built-in BigInteger library
 * or convert the inputs to integer directly.
 */

public class Solution {
    protected static final boolean SOLUTION_DONE = true;

    public String multiply15ms(String num1, String num2) {
        if ("0".equals(num1) || "0".equals(num2)) {
            return "0";
        }
        final List<Integer> num1List = num1.chars().map(c -> c - '0').boxed().collect(Collectors.toList());
        final List<Integer> num2List = num2.chars().map(c -> c - '0').boxed().collect(Collectors.toList());
        List<Integer> first = num1.length() > num2.length() ? num1List : num2List;
        List<Integer> second = num1.length() > num2.length() ? num2List : num1List;
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < second.size(); i++) {
            int leftIndex = second.size() - 1 - i;
            multiply(first, second.get(leftIndex), i, res);
        }
        return res.stream().map(String::valueOf).collect(Collectors.joining());
    }

    private void multiply(List<Integer> source, int num, int offset, List<Integer> res) {
        int acc = 0;
        for (int i = source.size() - 1; i >= 0; i--) {
            int cur = source.get(i);
            int newValue = cur * num + acc;
            acc = add(res, offset, newValue);
            offset++;
        }
        while (acc > 0) {
            acc = add(res, offset, acc);
            offset++;
        }
    }

    private int add(List<Integer> res, int offset, int newValue) {
        int acc = 0;
        if (res.size() <= offset) {
            res.add(0, newValue % 10);
            acc = newValue / 10;
        } else {
            int targetIndex = res.size() - 1 - offset;
            final int i = res.get(targetIndex) + newValue;
            acc = i / 10;
            res.set(targetIndex, i % 10);
        }
        return acc;
    }

    public String multiply3ms(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) return "0";
        int l1 = num1.length(), l2 = num2.length();

        int[] sum = new int[l1 + l2];
        int carry = 0;
        int mul, arr_i = l1 + l2 - 1;
        for (int p1 = l1 - 1; p1 >= 0; p1--) {
            carry = 0;
            for (int p2 = l2 - 1; p2 >= 0; p2--) {
                arr_i = p1 + p2 + 1;
                mul = (num1.charAt(p1) - '0') * (num2.charAt(p2) - '0') + carry + sum[arr_i];
                carry = mul / 10;
                sum[arr_i] = mul % 10;
            }
            while (carry != 0) {
                arr_i--;
                int temp_sum = sum[arr_i] + carry;
                sum[arr_i] = temp_sum % 10;
                carry = temp_sum / 10;
            }
        }
        StringBuilder s = new StringBuilder();
        int j = 0;
        for (int i = 0; i < l1 + l2; i++) {
            if (sum[i] != 0) {
                j = i;
                break;
            }
        }
        for (int i = j; i < l1 + l2; i++) {
            s.append(sum[i]);
        }
        return s.toString();
    }

    public String multiply(String num1, String num2) {
        //base case
        if (num1.equals("0") || num2.equals("0")) return "0";
        //array larger than 218
        int[] ans = new int[400];
        //easy to use rather than num1.charAt[i]
        char[] n1 = num1.toCharArray();
        char[] n2 = num2.toCharArray();
        //add up two num, and put then in the corresponding         //index
        for (int i = num1.length() - 1, m = 0; i >= 0; i--, m++) {
            for (int j = num2.length() - 1, n = 0; j >= 0; j--, n++) {
                int temp = (n1[i] - 48) * (n2[j] - 48);
                ans[m + n] = ans[m + n] + temp;
            }
        }
        //calculate the final ans
        for (int i = 0; i < num1.length() + num2.length(); i++) {
            if (ans[i] >= 10) {
                ans[i + 1] += ans[i] / 10;
                ans[i] = ans[i] % 10;
            }
        }
        //convert to a String
        StringBuilder a = new StringBuilder();
        for (int i = num1.length() + num2.length() - 1; i >= 0; i--) {
            if (i == num1.length() + num2.length() - 1 && ans[i] == 0) {
                continue;
            }
            a.append((char) (ans[i] + 48));
        }
        return a.toString();
    }
}
