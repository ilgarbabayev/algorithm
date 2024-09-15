package com.company.FAANG.array;

import java.util.Arrays;

public class ProductExceptSelf {
    public static void main(String[] args) {
        int[] price1 = {1,2,3,4};
        int[] price2 = {-1,1,0,-3,3};
        int[] price3 = {2,3,4,5};

//        System.out.println(Arrays.toString(productExceptSelf(price1)));
//        System.out.println(Arrays.toString(productExceptSelf(price2)));
        System.out.println(Arrays.toString(productExceptSelf(price3)));
    }

    public static int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int ans[] = new int[n];
        Arrays.fill(ans, 1);
        int curr = 1;
        for(int i = 0; i < n; i++) {
            ans[i] *= curr;
            curr *= nums[i];
        }
        curr = 1;
        for(int i = n - 1; i >= 0; i--) {
            ans[i] *= curr;
            curr *= nums[i];
        }
        return ans;
    }

    public int[] productExceptSelf_Detailed(int[] nums) {
        int n = nums.length;
        int pre[] = new int[n];
        int suff[] = new int[n];
        pre[0] = 1;
        suff[n - 1] = 1;

        for(int i = 1; i < n; i++) {
            pre[i] = pre[i - 1] * nums[i - 1];
        }
        for(int i = n - 2; i >= 0; i--) {
            suff[i] = suff[i + 1] * nums[i + 1];
        }

        int ans[] = new int[n];
        for(int i = 0; i < n; i++) {
            ans[i] = pre[i] * suff[i];
        }
        return ans;
    }
}
