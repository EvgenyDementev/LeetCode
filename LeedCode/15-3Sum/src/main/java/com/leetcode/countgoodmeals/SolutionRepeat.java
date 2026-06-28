package com.leetcode.countgoodmeals;

public class SolutionRepeat {

  public static final int MODULE = 1_000_000_007;

  public int countPairs(int[] del) {

    int max = 0;
    for (int num : del) {
      max = Math.max(max, num);
    }

    int dMax = 2 * max;

    int[] map = new int[max + 1];
    long res = 0;
    for (int num : del) {
      int power = 1;
      while(power <= dMax && power - num <= max) {
        if (power - num >= 0) {
          res += map[power - num];
        }
        power *= 2;
      }
      map[num]++;
    }

    return (int) (res % MODULE);
  }
}
