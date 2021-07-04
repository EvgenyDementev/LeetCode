package com.leetcode.countgoodmeals;

import static org.junit.jupiter.api.Assertions.*;

import com.leetcode.Utils;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class SolutionFastTest {

  @Test
  @DisplayName("[1,3,5,7,9] = 4")
  void example1() {
    int count = new SolutionFast().countPairs(new int[]{1,3,5,7,9});
    assertEquals(4, count);
  }

  @Test
  @DisplayName("[1,1,1,3,3,3,7] = 15")
  void example2() {
    int count = new SolutionFast().countPairs(new int[]{1,1,1,3,3,3,7});
    assertEquals(15, count);
  }

  @Test
  @DisplayName("[64,64,64,...] = 528")
  void example3() {
    int count = new SolutionFast().countPairs(new int[]{64,64,64,64,64,64,64,64,64,64,64,64,64,64,64,64,64,64,64,64,64,64,64,64,64,64,64,64,64,64,64,64,64});
    assertEquals(528, count);
  }

  @Test
  @DisplayName("[big num] = 5007906")
  void timeLimit() {

    Scanner scanner = new Scanner(getClass().getClassLoader().getResourceAsStream("countgoodmeals/time-limit-input.txt"));
    List<Integer> result = new ArrayList<>();
    while(scanner.hasNextInt())
    {
      result.add(scanner.nextInt());
    }

    int count = new SolutionFast().countPairs(Utils.toArray(result));
    assertEquals(5007906, count);
  }
}