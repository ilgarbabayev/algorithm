package com.company.FAANG.string;

import java.util.HashMap;
import java.util.Map;

/*
You are given an array of positive integers nums and want to erase a subarray containing unique elements. The score you get by erasing the subarray is equal to the sum of its elements.

Return the maximum score you can get by erasing exactly one subarray.

An array b is called to be a subarray of a if it forms a contiguous subsequence of a, that is, if it is equal to a[l],a[l+1],...,a[r] for some (l,r).



Example 1:

Input: nums = [4,2,4,5,6]
Output: 17
Explanation: The optimal subarray here is [2,4,5,6].
Example 2:

Input: nums = [5,2,1,2,5,2,1,2,5]
Output: 8
Explanation: The optimal subarray here is [5,2,1] or [1,2,5].


Constraints:

1 <= nums.length <= 105
1 <= nums[i] <= 104
 */

public class MaximumErasureValue {

    public static void main(String[] args) {
        int[] nums1 = new int[] {4,2,4,5,6};
        int[] nums2 = new int[] {5,2,1,2,5,2,1,2,5};
        int[] nums3 = new int[] {187,470,25,436,538,809,441,167,477,110,275,133,666,345,411,459,490,266,987,965,429,166,809,340,467,318,125,
                165,809,610,31,585,970,306,42,189,169,743,78,810,70,382,367,490,787,670,476,278,775,673,299,19,893,817,971,458,409,886,434};

        System.out.println(maximumUniqueSubarray(nums1));
        System.out.println(maximumUniqueSubarray(nums2));
        System.out.println(maximumUniqueSubarray(nums3));
    }

    public static int maximumUniqueSubarray(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int init = nums[0];
        map.put(init, 0);
        int[] sum = new int[nums.length];
        sum[0] = init;
        int result = init;
        int l = 0;
        int r = 1;
        int subtract = 0;

        while (r < nums.length) {
            int i = nums[r];
            Integer n = map.get(i);
            if (n != null && n >= l) {
                l = n+1;
                result = Math.max(result, sum[r - 1] - subtract);
                subtract=sum[l - 1];

            }
            sum[r] = sum[r -1] + i;
            map.put(i, r);
            r++;
        }

        return Math.max(result, sum[r-1] - subtract);
    }
}
