package com.leetcode.twosum;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.leetcode.Utils;
import java.util.Arrays;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class SolutionTest {

  @Test
  @DisplayName("[] = []")
  void empty() {
    int[] array = new Solution().twoSum(new int[]{}, 0);
    assertEquals(0, array.length);
  }

  @Test
  @DisplayName("[0,0], 0 = [0,1]")
  void zeros() {
    int[] array = new Solution().twoSum(new int[]{0,0}, 0);
    assertEquals(2, array.length);
    Utils.checklistEntry(Utils.toList(array), Arrays.asList(0, 1));
  }

  @Test
  @DisplayName("[[-1,-2,-3,-4,-5], -8] = [2,4]")
  void minusEight() {
    int[] array = new Solution().twoSum(new int[]{-1,-2,-3,-4,-5}, -8);
    assertEquals(2, array.length);
    Utils.checklistEntry(Utils.toList(array), Arrays.asList(2, 4));
  }

}