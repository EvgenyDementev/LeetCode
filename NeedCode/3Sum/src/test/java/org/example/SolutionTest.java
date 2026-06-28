package org.example;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void threeSum() {

        var res = new Solution().threeSum(new int[]{-1,0,1,2,-1,-4});

        assertEquals(2, res.size());
        assertExpectedResult(res, -1, -1, 2);
        assertExpectedResult(res, -1, 0, 1);
    }

    private static void assertExpectedResult(List<List<Integer>> res, int one, int two, int three) {
        assertTrue(res.stream()
                .filter(list -> list.size() == 3)
                .filter(list -> list.getFirst().equals(one))
                .filter(list -> list.get(1).equals(two))
                .anyMatch(list -> list.get(2).equals(three)));
    }
}