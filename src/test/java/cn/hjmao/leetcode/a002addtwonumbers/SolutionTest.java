package cn.hjmao.leetcode.a002addtwonumbers;

import cn.hjmao.utils.list.ListNode;
import cn.hjmao.utils.list.ListNodeUtils;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

/**
 * Created by hjmao on 18/01/2017.
 */
public class SolutionTest {

  private Solution solution;

  @BeforeMethod
  public void setUp() throws Exception {
    this.solution = new Solution();
  }

  @Test
  public void testAddTwoNumbers() throws Exception {
    ListNode l1 = new ListNode(2);
    l1.next = new ListNode(4);
    l1.next.next = new ListNode(3);

    ListNode l2 = new ListNode(5);
    l2.next = new ListNode(6);
    l2.next.next = new ListNode(4);

    ListNode expected = new ListNode(7);
    expected.next = new ListNode(0);
    expected.next.next = new ListNode(8);

    ListNode actual = this.solution.addTwoNumbers(l1, l2);
    assertTrue(ListNodeUtils.equals(actual, expected));
  }
}
