package com.company.FAANG.dynamic;

/*
You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed, the only constraint stopping you from robbing each of them is that adjacent houses have security systems connected and it will automatically contact the police if two adjacent houses were broken into on the same night.

Given an integer array nums representing the amount of money of each house, return the maximum amount of money you can rob tonight without alerting the police.



Example 1:

Input: nums = [1,2,3,1]
Output: 4
Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3).
Total amount you can rob = 1 + 3 = 4.
Example 2:

Input: nums = [2,7,9,3,1]
Output: 12
Explanation: Rob house 1 (money = 2), rob house 3 (money = 9) and rob house 5 (money = 1).
Total amount you can rob = 2 + 9 + 1 = 12.


Constraints:

1 <= nums.length <= 100
0 <= nums[i] <= 400
 */

public class HouseRobber {
    public static void main(String[] args) {
        int[] nums1 = {2,7,9,3,1};
        int[] nums2 = {2,1,1,2,0};

        System.out.println(rob(nums1));
//        System.out.println(rob(nums2));
    }

    public static int rob(int[] nums) {
        int n = nums.length;

        if (n == 1) return nums[0];

        nums[1] = Math.max(nums[0], nums[1]);

        for (int i = 2; i < n; i++) {
            nums[i] = Math.max(nums[i-1], nums[i] + nums[i-2]);
        }

        return nums[n-1];
    }
}
