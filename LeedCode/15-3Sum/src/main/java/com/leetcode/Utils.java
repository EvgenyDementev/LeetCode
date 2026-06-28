package com.leetcode;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class Utils {

  private Utils() {}

  public static List<Integer> toList(int[] array) {
    ArrayList<Integer> list = new ArrayList<>();
    for (int i : array) {
      list.add(i);
    }
    return list;
  }

  public static int[] toArray(Collection<Integer> list) {
    int[] array = new int[list.size()];
    Iterator<Integer> iterator = list.iterator();
    int i = 0;
    while (iterator.hasNext()) {
      array[i++] = iterator.next();
    }
    return array;
  }

  public static long factorial(int number) {
    return factorial(number, Integer.MAX_VALUE);
  }

  public static long factorial(int number, int mod) {
    long result = 1;
    for (int factor = 2; factor <= number; factor++) {
      result = (result * factor) % mod;
    }
    return result;
  }

  public static int binomCoeff(int n, int k, int mod) {
    long factorialNMinus2 = Utils.factorial(n - 2, mod);
    long factorialN = (factorialNMinus2 * (n-1) * n);
    long result = (factorialN / (2 * factorialNMinus2));
    return (int) result;
  }
}
