package com.leetcode;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;

public final class Utils {

  private Utils () {}

  public static List<Integer> toList(int[] array) {
    ArrayList<Integer> list = new ArrayList<>();
    for (int i : array) {
      list.add(i);
    }
    return list;
  }

  public static void checklistEntry(List<Integer> list, int x, int  y, int z) {

    ArrayList<Integer> copy = new ArrayList<>(list);
    int indexX = copy.indexOf(x);
    copy.remove(indexX);
    int indexY = copy.indexOf(y);
    copy.remove(indexX);
    int indexZ = copy.indexOf(z);

    assertTrue(indexX != -1);
    assertTrue(indexY != -1);
    assertTrue(indexZ != -1);
    indexY += 1;
    indexZ += 2;
    assertTrue(indexX != indexY);
    assertTrue(indexY != indexZ);
    assertTrue(indexX != indexZ);
  }

  public static void checklistEntry(List<Integer> list, List<Integer> resultList) {

    ArrayList<Integer> copy = new ArrayList<>(list);
    for (Integer result : resultList) {
      int index = copy.indexOf(result);
      assertTrue(index != -1,
          "Element " + result + " not found in the list: " + list);
      copy.remove(index);
    }
  }
}
