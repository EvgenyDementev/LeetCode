package com.leetcode.threesum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SolutionSlow {

  public final int ZERO = 100001;

  private int wrapZero(int num) {
    return num == 0
        ? ZERO
        : num;
  }

  public List<List<Integer>> threeSum(int[] nums) {
    List<List<Integer>> result = new ArrayList<>();

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
//    System.out.println(Arrays.stream(nums).boxed().collect(Collectors.toList()));
    nums = numsFiltered.stream().mapToInt(i->i).toArray();
    System.out.println("pos index = " + firstPositiveIndex);
    if (nums.length > 0) {
      System.out.println("pos num = " + nums[firstPositiveIndex]);
    }
    System.out.println("neg length = " + negativeLength);
    if (negativeLength > 0) {
      System.out.println("neg last = " + nums[negativeLength-1]);
    }


    // Func
    long countAll = 0, countDifferent = 0, countSumIsZero = 0,
        countMulCollision = 0, countMulAbsCollision = 0, countLigth = 0, countDeep = 0;

    Map<Integer, Map<Integer, List<List<Integer>>>> mult = new HashMap<>();

    for(int i=0; i<negativeLength; i++) {
      for(int j=i; j<nums.length; j++) {
        for(int k=(Math.max(firstPositiveIndex, j)); k<nums.length; k++) {
          countAll++;
          if (i==j || i==k || j==k) {
            continue;
          }
          countDifferent++;
          if (nums[i]+nums[j]+nums[k] != 0) {
            continue;
          }
          countSumIsZero++;

          int mul = (wrapZero(nums[i])) * (wrapZero(nums[j])) * (wrapZero(nums[k]));
          int mulMod = (wrapZero(Math.abs(nums[i]))) * (wrapZero(Math.abs(nums[j]))) * (wrapZero(Math.abs(nums[k])));

          List<Integer> ok = null;
          Map<Integer, List<List<Integer>>> multCollision = mult.get(mul);
          List<List<Integer>> multModCollision = null;
          if (multCollision != null) {
            multModCollision = multCollision.get(mulMod);
            if (multModCollision != null) {
              ok = new ArrayList<>();
              ok.add(nums[i]);
              ok.add(nums[j]);
              ok.add(nums[k]);
              countLigth++;
              if (lightSearch(multModCollision, ok)) {
                continue;
              }
              countDeep++;
              if (deepSearch(multModCollision, ok)) {
                continue;
              }
            } else {
              countMulAbsCollision++;
            }
          } else {
            countMulCollision++;
          }

          if (ok == null) {
            ok = new ArrayList<>();
            ok.add(nums[i]);
            ok.add(nums[j]);
            ok.add(nums[k]);
          }
          result.add(ok);

          if (multCollision == null) {
            multCollision = new HashMap<>();
            mult.put(mul, multCollision);
          }
          if (multModCollision == null) {
            multModCollision = new ArrayList<>();
            multCollision.put(mulMod, multModCollision);
          }
          multModCollision.add(ok);

        }
      }
    }

    System.out.println("countAll = " + countAll);
    System.out.println("countDifferent = " + countDifferent);
    System.out.println("countSumIsZero = " + countSumIsZero);
    System.out.println("countMulCollision = " + countMulCollision);
    System.out.println("countMulAbsCollision = " + countMulAbsCollision);
    System.out.println("countLigth = " + countLigth);
    System.out.println("countDeep = " + countDeep);
    return result;
  }

  private boolean lightSearch(List<List<Integer>> result, List<Integer> ok) {

    for (List<Integer> list: result) {
      if (list.get(0).equals(ok.get(0))
          && list.get(1).equals(ok.get(1))
          && list.get(2).equals(ok.get(2))) {
        return true;
      }
    }

    return false;
  }

  private boolean deepSearch(List<List<Integer>> result, List<Integer> ok) {

    for (List<Integer> list: result) {
      if (list.containsAll(ok) && ok.containsAll(list)) {
        return true;
      }
    }

    return false;
  }
}