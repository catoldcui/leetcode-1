package com.leetcode.snippets.a067addbinary;

/**
 * Created by hjmao.
 * <p>
 * URL:
 * =====
 * https://leetcode.com/problems/add-binary/
 * <p>
 * Desc:
 * =====
 * Given two binary strings, return their sum (also a binary string).
 * <p>
 * The input strings are both non-empty and contains only characters 1 or 0.
 */

/**
 * 当根据变量设置先后时，一定要保证所有条件一致，比如
 * <code>
 *     l = aChars.length > bChars.length ? aChars : bChars;
 *     s = aChars.length > bChars.length ? bChars : aChars;
 * </code>
 * 如果<code>s = aChars.length < bChars.length ? bChars : aChars;</code>当字符串长度一样是，会导致l==s，应该使用<-
 */
public class Solution {
    protected static final boolean SOLUTION_DONE = true;

    public String addBinary(String a, String b) {
        final char[] aChars = a.toCharArray();
        final char[] bChars = b.toCharArray();

        char[] l, s;
        l = aChars.length > bChars.length ? aChars : bChars;
        s = aChars.length > bChars.length ? bChars : aChars;
        int acc = 0;
        final int[] resInt = new int[l.length];
        int i = 0;
        for (; i < s.length; i++) {
            int temp = s[s.length - 1 - i] + l[l.length - 1 - i] - 2 * '0' + acc;
            resInt[resInt.length - 1 - i] = temp % 2;
            acc = temp / 2;
        }
        while (i < l.length) {
            int temp = l[l.length - 1 - i] - '0' + acc;
            resInt[resInt.length - 1 - i] = temp % 2;
            acc = temp / 2;
            i++;
        }
        StringBuilder sb = new StringBuilder();
        if (acc == 1) {
            sb.append((char) (acc + '0'));
        }

        for (int j = 0; j < resInt.length; j++) {
            sb.append((char) (resInt[j] + '0'));
        }
        return sb.toString();
    }
}
