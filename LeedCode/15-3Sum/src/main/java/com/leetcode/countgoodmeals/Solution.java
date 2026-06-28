package com.leetcode.countgoodmeals;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Solution {

  public static final int MODULE = 1_000_000_000 + 7;

  public int countPairs(int[] deliciousness) {
    long start = System.nanoTime();

    Set<Integer> powersOfTwo = new HashSet<>();
    for (int i = 0; i <= 31; i++) {
      powersOfTwo.add((int) Math.pow(2, i));
    }

    HashMap<Integer, Integer> duplicates = new HashMap<>();
    HashMap<Integer, Integer> singleNumberPairs = new HashMap<>();
    int delicious;
    for(int i = 0; i < deliciousness.length; i++) {
      delicious = deliciousness[i];
      Integer count = duplicates.getOrDefault(delicious, 0);
      Integer pairsCount = singleNumberPairs.getOrDefault(delicious, 0);

      int newCount = count + 1;
      int newPairCount = pairsCount;

      if (newCount > 1 && powersOfTwo.contains(delicious+delicious)) {
        newPairCount += newCount - 1;
      }

      duplicates.put(delicious, newCount);
      singleNumberPairs.put(delicious, newPairCount);
    }

    deliciousness = toArray(duplicates.keySet());

    int result = 0;
    int x, y;

    for(int i = 0; i < deliciousness.length; i++) {
      x = deliciousness[i];
      Integer xCount = duplicates.get(x);
      Integer xCountPairs = singleNumberPairs.get(x);
      result += xCountPairs;
      for(int j = i + 1; j < deliciousness.length; j++) {

        y = deliciousness[j];
        if (powersOfTwo.contains(x+y)) {
          result += xCount * duplicates.get(y);
        }
      }
    }

    System.out.println("Time: " + ((System.nanoTime() - start) / 1_000_000) + "ms");
    return result;
  }


  public static int[] toArray(java.util.Collection<Integer> list) {
    int[] array = new int[list.size()];
    Iterator<Integer> iterator = list.iterator();
    int i = 0;
    while (iterator.hasNext()) {
      array[i++] = iterator.next();
    }
    return array;
  }
}
