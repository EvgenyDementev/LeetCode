package com.leetcode;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class UtilsTest {

  public static final int MODULE = 1_000_000_000 + 7;

  @Test
  @DisplayName("factorial 1")
  void factorial1() {
    assertEquals(1, Utils.factorial(0));
    assertEquals(1, Utils.factorial(1));
    assertEquals(2, Utils.factorial(2));
    assertEquals(6, Utils.factorial(3));
    assertEquals(345079539, Utils.factorial(1086, MODULE));
  }

  @Test
  @DisplayName("binomial 1")
  void binomial1() {
    assertEquals(0, Utils.binomCoeff(0, 2, MODULE));
    assertEquals(0, Utils.binomCoeff(1, 2, MODULE));
    assertEquals(1, Utils.binomCoeff(2, 2, MODULE));
    assertEquals(3, Utils.binomCoeff(3, 2, MODULE));
    assertEquals(6, Utils.binomCoeff(4, 2, MODULE));
    assertEquals(10, Utils.binomCoeff(5, 2, MODULE));
    assertEquals(15, Utils.binomCoeff(6, 2, MODULE));
    assertEquals(21, Utils.binomCoeff(7, 2, MODULE));
    assertEquals(28, Utils.binomCoeff(8, 2, MODULE));
    assertEquals(36, Utils.binomCoeff(9, 2, MODULE));
    assertEquals(45, Utils.binomCoeff(10, 2, MODULE));
    assertEquals(55, Utils.binomCoeff(11, 2, MODULE));
    assertEquals(66, Utils.binomCoeff(12, 2, MODULE));
    assertEquals(78, Utils.binomCoeff(13, 2, MODULE));
    assertEquals(91, Utils.binomCoeff(14, 2, MODULE));
    assertEquals(589155, Utils.binomCoeff(1086, 2, MODULE));
  }
}