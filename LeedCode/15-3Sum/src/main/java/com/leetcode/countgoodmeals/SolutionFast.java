package com.leetcode.countgoodmeals;

import java.util.HashMap;
import java.util.Map;

public class SolutionFast {

  public int countPairs(int[] deliciousness) {
    Map<Integer, Integer> nums = new HashMap<>();
    long total = 0;
    for (int i = 0; i < deliciousness.length; i++) {
      int num = deliciousness[i];
      for (int j = 0; j < 22; j++) {
        int target = (int)Math.pow(2, j);
        if (nums.containsKey(target - num)) {
          total += nums.get(target - num);
        }
      }

      nums.put(num, nums.getOrDefault(num, 0) + 1);
    }

    return (int)(total % 1_000_000_007);
  }
}
