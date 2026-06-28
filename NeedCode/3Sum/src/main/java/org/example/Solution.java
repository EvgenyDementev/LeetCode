package org.example;

import java.util.*;

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Set<String> unique = new HashSet<>();
        List<List<Integer>> res = new ArrayList<>();

        // O(log n)
        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 2; i++) {
            res.addAll(sum2(nums, i, -nums[i], unique));
        }

        return res;
    }

    private List<List<Integer>> sum2(int[] nums, int initial, int target, Set<String> unique) {
        List<List<Integer>> res = new ArrayList<>();

        int start = initial + 1;
        int end = nums.length - 1;

        while (start < end) {
            switch (Integer.compare(nums[start] + nums[end], target)) {
                case 0:
                    var key = String.format("%d:%d:%d", nums[initial], nums[start], nums[end]);
                    if (!unique.contains(key)) {
                        res.add(List.of(nums[initial], nums[start], nums[end]));
                        unique.add(key);
                    }
                    start++;
                    break;
                case 1:
                    end--;
                    break;
                case -1:
                    start++;
                    break;
            }
        }

        return res;
    }
}
