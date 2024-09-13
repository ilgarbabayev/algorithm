package com.company.FAANG.dynamic;

/*
There are several consecutive houses along a street, each of which has some money inside. There is also a robber, who wants to steal money from the homes, but he refuses to steal from adjacent homes.

The capability of the robber is the maximum amount of money he steals from one house of all the houses he robbed.

You are given an integer array nums representing how much money is stashed in each house. More formally, the ith house from the left has nums[i] dollars.

You are also given an integer k, representing the minimum number of houses the robber will steal from. It is always possible to steal at least k houses.

Return the minimum capability of the robber out of all the possible ways to steal at least k houses.



Example 1:

Input: nums = [2,3,5,9], k = 2
Output: 5
Explanation:
There are three ways to rob at least 2 houses:
- Rob the houses at indices 0 and 2. Capability is max(nums[0], nums[2]) = 5.
- Rob the houses at indices 0 and 3. Capability is max(nums[0], nums[3]) = 9.
- Rob the houses at indices 1 and 3. Capability is max(nums[1], nums[3]) = 9.
Therefore, we return min(5, 9, 9) = 5.
Example 2:

Input: nums = [2,7,9,3,1], k = 2
Output: 2
Explanation: There are 7 ways to rob the houses. The way which leads to minimum capability is to rob the house at index 0 and 4. Return max(nums[0], nums[4]) = 2.


Constraints:

1 <= nums.length <= 105
1 <= nums[i] <= 109
1 <= k <= (nums.length + 1)/2
 */

public class HouseRobber4 {
    public static void main(String[] args) {
        int[] nums = {2,7,9,3,1};
        int k = 2;

//        int[] nums = {1,2,4,4,5};
//        int k = 2;

        /*
            1,3
            1,3,5
            1,4
            1,5
            2,4
            2,5
            3,5
         */

        int result = minCapability(nums, 2);
        System.out.println(result);
    }

    public static int minCapability(int[] A, int k) {
        int left = A[0], right = A[0];
        for (int x : A) {
            left = Math.min(left, x);
            right = Math.max(right, x);
        }
        int n = A.length;

        while (left < right) {
            int mid = (left + right) / 2;
            int take = 0;

            for (int i = 0; i < n; ++i)
                if (A[i] <= mid) {
                    if (++take >= k) break;
                    i++;
                }

            if (take >= k)
                right = mid;
            else
                left = mid + 1;
        }
        return left; //left == right
    }
}
