package com.leetcode.countgoodmeals;

public class SolutionFastest {

  int MOD = 1000000000 + 7;

  public int countPairs(int[] del) {
    if (del == null || del.length < 2){
      return 0;
    }
    int max = 0;
    for (int i: del){
      max = Math.max(max, i);
    }
    int temp = 2 * max;
    int[] map = new int[max + 1];
    long ret = 0;
    for (int num : del) {
      int power = 1;
      while (power <= temp && power - num <= max) {
        if (0 <= power - num) {
          ret += map[power - num];
        }
        power <<= 1;
      }

      map[num]++;
    }



    return (int) (ret % MOD);


  }
}
