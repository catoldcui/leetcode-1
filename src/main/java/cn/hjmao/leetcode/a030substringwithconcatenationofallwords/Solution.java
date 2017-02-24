package cn.hjmao.leetcode.a030substringwithconcatenationofallwords;

import java.util.*;

/**
 * Created by hjmao.
 *
 * URL:
 * =====
 * https://leetcode.com/problems/substring-with-concatenation-of-all-words
 *
 * Desc:
 * =====
 * You are given a string, s, and a list of words, *words*,
 * that are all of the same length.
 *
 * Find all starting indices of substring(s) in s
 * that is a concatenation of each word in *words* exactly once and without any intervening characters.
 *
 * For example, given:
 * s: "barfoothefoobarman"
 * words: ["foo", "bar"]
 *
 * You should return the indices: [0,9].
 *
 * (order does not matter).
 */

public class Solution {
  public List<Integer> slowFindSubstring(String s, String[] words) {
    List<Integer> indices = new ArrayList<>();
    if (s == null || words == null || words.length == 0 || s.length() < words.length * words[0].length()) {
      return indices;
    }
    Map<String, Integer> wordCountMap = new HashMap<>();
    for (String word : words) {
      wordCountMap.put(word, wordCountMap.getOrDefault(word, 0) + 1);
    }

    int wordLength = words[0].length();
    int wordCount = words.length;
    for (int i = 0; i <= s.length() - wordLength * wordCount; i++) {
      Map<String, Integer> myMap = new HashMap<>();
      for (int j = 0; j < wordCount; j++) {
        String thisSubString = s.substring(i + j * wordLength, i + (j + 1) * wordLength);
        if (!wordCountMap.containsKey(thisSubString)) {
          break;
        }
        int count = myMap.getOrDefault(thisSubString, 0) + 1;
        if (count > wordCountMap.getOrDefault(thisSubString, 0)) {
          break;
        }
        myMap.put(thisSubString, count);
      }
      if (myMap.equals(wordCountMap)) {
        indices.add(i);
      }
    }

    return indices;
  }

  /**
   * @from https://discuss.leetcode.com/topic/35676/accepted-java-solution-12ms-with-explanation
   */
  public List<Integer> findSubstring(String s, String[] words) {
    List<Integer> indices = new ArrayList<>();
    if (s == null || words == null || words.length == 0 || s.length() < words.length * words[0].length()) {
      return indices;
    }

    int wordCount = words.length;

    // map each string in words array to some index and compute target counters
    Map<String, Integer> mapping = new HashMap<>();
    int [][] table = new int[2][wordCount];
    int mismatches = 0;
    int index = 0;
    for (int i = 0; i < wordCount; ++i) {
      Integer mapped = mapping.get(words[i]);
      if (mapped == null) {
        ++mismatches;
        mapping.put(words[i], index);
        mapped = index++;
      }
      ++table[0][mapped];
    }

    // find all occurrences at string S and map them to their current integer,
    // -1 means no such string is in words array
    int stringLength = s.length();
    int wordLength = words[0].length();
    int last = stringLength - wordLength + 1;
    int [] smapping = new int[last];
    for (int i = 0; i < last; ++i) {
      String section = s.substring(i, i + wordLength);
      Integer mapped = mapping.get(section);
      if (mapped == null) {
        smapping[i] = -1;
      } else {
        smapping[i] = mapped;
      }
    }

    // fix the number of linear scans
    for (int i = 0; i < wordLength; ++i) {
      // reset scan variables
      int currentFailures = mismatches; //number of current mismatches
      int left = i;
      int right = i;
      Arrays.fill(table[1], 0);
      // here, simple solve the minimum-window-substring problem
      while (right < last) {
        while (currentFailures > 0 && right < last) {
          int target = smapping[right];
          if (target != -1 && ++table[1][target] == table[0][target]) {
            --currentFailures;
          }
          right += wordLength;
        }
        while (currentFailures == 0 && left < right) {
          int target = smapping[left];
          if (target != -1 && --table[1][target] == table[0][target] - 1) {
            int length = right - left;
            //instead of checking every window, we know exactly the length we want
            if ((length / wordLength) ==  wordCount) {
              indices.add(left);
            }
            ++currentFailures;
          }
          left += wordLength;
        }
      }

    }
    return indices;
  }
}
