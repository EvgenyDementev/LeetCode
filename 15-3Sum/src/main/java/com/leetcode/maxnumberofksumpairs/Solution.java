package com.leetcode.maxnumberofksumpairs;

public class Solution {

  public int maxOperations(int[] nums, int k) {

    int max = 0;
    for (int num : nums) {
      max = Math.max(max, num);
    }
    int[] map = new int[max + 1];

    int res = 0;
    for (int num : nums) {
      if (k - num >= 0 && k - num <= max && map[k - num] > 0) {
        res += 1;
        map[k - num]--;
      } else {
        map[num]++;
      }
    }

    return res;
  }
}
