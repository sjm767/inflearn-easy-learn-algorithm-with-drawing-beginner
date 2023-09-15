package com.jaeshim.inflearn.easylearn.algorithm.drawing.algorithm.code;

import java.util.Arrays;

public final class Recursion {

  private Recursion() {
  }

  public static void printNumbers(int number, int max) {
    System.out.println(number);
    if (number == max) {
      return;
    }
    printNumbers(number + 1, max);
  }

  public static int factorial(int number) {
    if (number == 0 || number == 1) {
      return 1;
    }

    return number * factorial(number - 1);

  }

  public static int arraySum(int[] arr) {
    if (arr.length == 1) {
      return arr[0];
    }
    return arr[arr.length - 1] + arraySum(Arrays.copyOfRange(arr, 0, arr.length - 1));
  }

  public static int strLength(char[] str) {
    if (str.length == 1) {
      return 1;
    }

    return 1 + strLength(Arrays.copyOfRange(str, 0, str.length - 1));
  }

  public static int strLength(String str) {
    if (str.length() == 1) {
      return 1;
    }

    return 1 + strLength(str.substring(0, str.length() - 1));
  }
  public static int power(int x, int n){
    if(n == 0){
      return 1;
    }
    return x * power(x,n-1);
  }
}
