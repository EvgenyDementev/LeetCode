package com.leetcode.maxnumberofksumpairs;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class SolutionTest {

  @Test
  @DisplayName("[1,2,3,4], 5 = 2")
  void example1() {
    int count = new Solution().maxOperations(new int[]{1,2,3,4}, 5);
    assertEquals(2, count);
  }

  @Test
  @DisplayName("[3,1,3,4,3], 6 = 1")
  void example2() {
    int count = new Solution().maxOperations(new int[]{3,1,3,4,3}, 6);
    assertEquals(1, count);
  }

  @Test
  @DisplayName("[2,5,4,4,1,3,4,4,1,4,4,1,2,1,2,2,3,2,4,2], 3 = 4")
  void example3() {
    int count = new Solution().maxOperations(new int[]{2,5,4,4,1,3,4,4,1,4,4,1,2,1,2,2,3,2,4,2}, 3);
    assertEquals(4, count);
  }
}