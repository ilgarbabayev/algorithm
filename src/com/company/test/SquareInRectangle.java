package com.company.test;

public class SquareInRectangle {

    public static void main(String[] args) {
        System.out.println(2 % 4);
        System.out.println(1 % 4);
        System.out.println(3 % 4);
//        System.out.println(getCount(3, 5));
//        gcd(2,6);
    }

    private static int getCount(int h, int w) {
        int min = Math.min(h, w);
        int max = Math.max(h, w);

        for (int i = 1; i <= min; i++) {
            int r = min % i;
            System.out.print(r + " ");

            if (r == 0) {
                int r2 = min / i;
                System.out.print(r2 + " ");
                int count = (min*max) % (r2*r2);
                System.out.print(count  + " ");
                System.out.println();
                if (count == 0) return  (min*max) / (r2*r2);
            }
        }

        return 0;
    }

    private static int gcd(int a, int b) {
        System.out.println(a + " : " +b);
        if (b==0) return a;
        return gcd(b,a%b);
    }
}
