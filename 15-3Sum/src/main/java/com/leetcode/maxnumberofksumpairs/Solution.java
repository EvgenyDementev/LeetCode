package com.leetcode.maxnumberofksumpairs;

import java.util.HashMap;
import java.util.Map;

public class Solution {

  public int maxOperations(int[] nums, int k) {

    Map<Integer, Integer> map = new HashMap<>(nums.length);

    int res = 0;
    for (int num : nums) {
      Integer count = map.getOrDefault(k - num, 0);
      if (count > 0) {
        res += 1;
        map.put(k - num, count-1);
      } else {
        map.put(num, map.getOrDefault(num, 0) + 1);
      }
    }

    return res;
  }
}
