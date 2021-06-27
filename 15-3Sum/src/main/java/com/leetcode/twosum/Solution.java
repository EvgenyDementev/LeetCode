package com.leetcode.twosum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
  public int[] twoSum(int[] nums, int target) {
    int sum;
    List<Integer> sourceArray = new ArrayList<>(nums.length);
    for (int num : nums) {
      sourceArray.add(num);
    }

    Arrays.sort(nums);
    for (int i = 0; i < Math.max(nums.length - 1, 0); i++) {
      if (i != 0 && nums[i] == nums[i-1]) {
        continue;
      }
      for (int j = i+1; j < nums.length; j++) {
        sum = nums[i] + nums[j];
        if (sum == target) {
          int indexI = sourceArray.indexOf(nums[i]);
          int indexJ = sourceArray.lastIndexOf(nums[j]);
          return new int[]{indexI, indexJ};
        } else if (sum > target) {
          break;
        }
      }
    }
    return new int[]{};
  }
}