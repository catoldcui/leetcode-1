package com.leetcode.snippets.a002addtwonumbers;

import cn.hjmao.utils.list.ListNode;

/**
 * Created by hjmao on 17/01/2017.
 * <p>
 * URL:
 * =====
 * https://leetcode.com/problems/add-two-numbers/
 * <p>
 * Desc:
 * =====
 * You are given two non-empty linked lists representing two non-negative integers.
 * The digits are stored in reverse order and each of their nodes contain a single digit.
 * Add the two numbers and return it as a linked list.
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 * <p>
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 0 -> 8
 */


public class Solution {
    protected static final boolean SOLUTION_DONE = true;

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode res = null;
        int acc = 0;
        ListNode cur = new ListNode(0);
        while (l1 != null && l2 != null) {
            int sum = l1.val + l2.val + acc;
            acc = sum / 10;
            l1 = l1.next;
            l2 = l2.next;
            cur.next = new ListNode(sum % 10);
            if (res == null) {
                res = cur.next;
            }
            cur = cur.next;
        }
        while (l1 != null) {
            int sum = l1.val + acc;
            acc = sum / 10;
            cur.next = new ListNode(sum % 10);
            l1 = l1.next;
            cur = cur.next;
        }
        while (l2 != null) {
            int sum = l2.val + acc;
            acc = sum / 10;
            cur.next = new ListNode(sum % 10);
            l2 = l2.next;
            cur = cur.next;
        }
        if (acc == 1) {
            cur.next = new ListNode(1);
        }
        return res;
    }
}
