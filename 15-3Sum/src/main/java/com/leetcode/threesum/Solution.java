package com.leetcode.threesum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {

  public List<List<Integer>> threeSum(int[] nums) {
    long start = System.nanoTime();
    List<List<Integer>> result = new ArrayList<>(nums.length);

    // Prepare
    Arrays.sort(nums);
    int firstPositiveIndex = 0;
    int negativeLength = 0;
    List<Integer> numsFiltered = new ArrayList<>();
    for (int i = 0; i < nums.length; i++) {
      if (i == 0 || i == 1 || nums[i] == 0 || (nums[i] != nums[i-2])) {
        numsFiltered.add(nums[i]);
        if ((nums[i] >= 0) && (firstPositiveIndex == 0)) {
          firstPositiveIndex = numsFiltered.size() - 1;
        }
        if ((nums[i] <= 0)) {
          negativeLength = numsFiltered.size();
        }
      }
    }
    nums = numsFiltered.stream().mapToInt(i->i).toArray();

    // Func

    Map<Integer, List<List<Integer>>> mult = new HashMap<>();

    for(int i=0; i<Math.min(negativeLength, nums.length - 2); i++) {
      if (i != 0 && nums[i] == nums[i-1]) {
        continue;
      }
      for(int j=i+1; j<nums.length; j++) {
        if (j != i+1 && nums[j] == nums[j-1]) {
          continue;
        }
        for(int k=(Math.max(firstPositiveIndex, j+1)); k<nums.length; k++) {
          if (k != j+1 && nums[k] == nums[k-1]) {
            continue;
          }
          int sum = nums[i]+nums[j]+nums[k];
          if (sum > 0) {
            break;
          } else if (sum < 0) {
            continue;
          }

          List<Integer> ok = new ArrayList<>();
          ok.add(nums[i]);
          ok.add(nums[j]);
          ok.add(nums[k]);
          result.add(ok);
          break;
        }
      }
    }

    System.out.println("Finish time = " + (System.nanoTime() - start) / 1_000_000);
    System.out.println("result size = " + result.size());

    return result;
  }
}
