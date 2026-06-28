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

  @Test
  @DisplayName("[-1,0,1,2,-1,-4] = [[-1,-1,2],[-1,0,1]]")
  void ex1() {
    List<List<Integer>> lists = new Solution().threeSum(new int[]{-1,0,1,2,-1,-4});
    assertEquals(2, lists.size());
    TestUtils.checklistEntry(lists.get(0), -1, -1, 2);
    TestUtils.checklistEntry(lists.get(1), -1, 0, 1);
  }

  @Test
  @DisplayName("[-1,0,1,2,-1,-4,-2,-3,3,0,4] = [[-4,0,4],[-4,1,3],[-3,-1,4],[-3,0,3],[-3,1,2],[-2,-1,3],[-2,0,2],[-1,-1,2],[-1,0,1]]")
  void ex2() {
    List<List<Integer>> lists = new Solution().threeSum(new int[]{-1,0,1,2,-1,-4,-2,-3,3,0,4});
    assertEquals(9, lists.size());
  }

}