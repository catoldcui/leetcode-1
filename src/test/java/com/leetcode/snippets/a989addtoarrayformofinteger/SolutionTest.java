package com.leetcode.snippets.a989addtoarrayformofinteger;

import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

import static org.testng.Assert.assertEquals;

public class SolutionTest {
    private Solution solution = new Solution();

    @Test(enabled = Solution.SOLUTION_DONE)
    public void testAddToArrayForm1() {
        int[] A = new int[]{1, 2, 0, 0};
        int K = 34;
        List<Integer> expected = Arrays.asList(1, 2, 3, 4);
        assertEquals(solution.addToArrayForm(A, K), expected);
    }

    @Test(enabled = Solution.SOLUTION_DONE)
    public void testAddToArrayForm2() {
        int[] A = new int[]{2, 7, 4};
        int K = 181;
        List<Integer> expected = Arrays.asList(4, 5, 5);
        assertEquals(solution.addToArrayForm(A, K), expected);
    }

    @Test(enabled = Solution.SOLUTION_DONE)
    public void testAddToArrayForm3() {
        int[] A = new int[]{2, 1, 5};
        int K = 806;
        List<Integer> expected = Arrays.asList(1, 0, 2, 1);
        assertEquals(solution.addToArrayForm(A, K), expected);
    }

    @Test(enabled = Solution.SOLUTION_DONE)
    public void testAddToArrayForm4() {
        int[] A = new int[]{9, 9, 9, 9, 9, 9, 9, 9, 9, 9};
        int K = 1;
        List<Integer> expected = Arrays.asList(1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
        assertEquals(solution.addToArrayForm(A, K), expected);
    }

    @Test(enabled = Solution.SOLUTION_DONE)
    public void testAddToArrayForm5() {
        int[] A = new int[]{0};
        int K = 1000;
        List<Integer> expected = Arrays.asList(1, 0, 0, 0);
        assertEquals(solution.addToArrayForm(A, K), expected);
    }
}
