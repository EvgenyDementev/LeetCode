package com.leetcode.threesum;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.leetcode.TestUtils;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class SolutionTest {

  @Test
  @DisplayName("[] = []")
  void empty() {
    List<List<Integer>> lists = new Solution().threeSum(new int[]{});
    assertEquals(0, lists.size());
  }

  @Test
  @DisplayName("[0,0,0] = [0,0,0]")
  void zeros() {
    List<List<Integer>> lists = new Solution().threeSum(new int[]{0,0,0});
    assertEquals(1, lists.size());
    TestUtils.checklistEntry(lists.get(0), 0, 0, 0);
  }

}