package com.company.FAANG.dynamic;

import java.util.Arrays;

public class MaximumTastiness {
    /*
    You are given an array of positive integers price where price[i] denotes the price of the ith candy and a positive integer k.

    The store sells baskets of k distinct candies. The tastiness of a candy basket is the smallest absolute difference of the prices of any two candies in the basket.

    Return the maximum tastiness of a candy basket.



    Example 1:

    Input: price = [13,5,1,8,21,2], k = 3
    Output: 8
    Explanation: Choose the candies with the prices [13,5,21].
    The tastiness of the candy basket is: min(|13 - 5|, |13 - 21|, |5 - 21|) = min(8, 8, 16) = 8.
    It can be proven that 8 is the maximum tastiness that can be achieved.
    Example 2:

    Input: price = [1,3,1], k = 2
    Output: 2
    Explanation: Choose the candies with the prices [1,3].
    The tastiness of the candy basket is: min(|1 - 3|) = min(2) = 2.
    It can be proven that 2 is the maximum tastiness that can be achieved.
    Example 3:

    Input: price = [7,7,7,7], k = 2
    Output: 0
    Explanation: Choosing any two distinct candies from the candies we have will result in a tastiness of 0.


    Constraints:

    2 <= k <= price.length <= 105
    1 <= price[i] <= 109
     */

    public static void main(String[] args) {
        int[] price = {13, 5, 1, 8, 21, 2};
        int k = 3;

        System.out.println(maximumTastiness(price, k));
    }

    private static int maximumTastiness(int[] price, int k) {
        Arrays.sort(price);
        int n = price.length;
        int left = 0;
        int right = price[n-1] - price[0];

        while (left < right) {
            int mid = (right + left + 1) / 2;

            int last = price[0];
            int count = 1;
            for (int i = 1; i < price.length; i++) {
                if (price[i] - last >= mid) {
                    last = price[i];
                    count++;
                    if (count == k) {
                        break;
                    }
                }
            }

            if (count < k) {
                right = mid - 1;
            } else {
                left = mid;
            }
        }

        return left;
    }
}
