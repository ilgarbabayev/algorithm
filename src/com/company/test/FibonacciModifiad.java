package com.company.test;

import java.math.BigInteger;

public class FibonacciModifiad {

  public static void main(String[] args) {
    BigInteger r = fibonacciModified(0, 1, 6);

    System.out.println(r);
  }

  public static BigInteger fibonacciModified(int t1, int t2, int n) {
    BigInteger tt1 = BigInteger.valueOf(t1);
    BigInteger tt2 = BigInteger.valueOf(t2);

    BigInteger fib = BigInteger.ZERO;

    while (n > 2) {
      fib = tt1.add(tt2.multiply(tt2));
      tt1 = tt2;
      tt2 = fib;
      --n;
    }

    return fib;
  }

}
