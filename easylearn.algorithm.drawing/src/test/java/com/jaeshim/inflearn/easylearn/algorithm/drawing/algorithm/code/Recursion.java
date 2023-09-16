package com.jaeshim.inflearn.easylearn.algorithm.drawing.algorithm.code;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

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

  public static int power(int x, int n) {
    if (n == 0) {
      return 1;
    }
    return x * power(x, n - 1);
  }

  /*
  from: A
  to: C
  temp: B
   */
  public static void hanoi(int count, String from, String to, String temp) {
    if (count == 0) {
      return;
    }
    hanoi(count - 1, from, temp, to);
    System.out.println("원반" + count + "(을)를 " + from + "에서" + to + "로 이동");
    hanoi(count - 1, temp, to, from);
  }

  public static int fibonacci1(int n) {
    if (n == 0 || n == 1) {
      return n;
    }

    return fibonacci1(n - 2) + fibonacci1(n - 1);
  }

  public static int fibonacci2(int n, Map<Integer, Integer> fiboMem) {
    if (n == 0 || n == 1) {
      return n;
    }

    if (!fiboMem.containsKey(n)) {
      fiboMem.put(n, fibonacci2(n - 2, fiboMem) + fibonacci2(n - 1, fiboMem));
    }
    return fiboMem.get(n);
  }

  public static int fibonacci3(int n) {
    if (n == 0 || n == 1) {
      return n;
    }

    int sum = 0;
    int tempArr[] = new int[n];
    Arrays.fill(tempArr, 1);

    for (int i = 2; i < n; i++) {
      tempArr[i] = tempArr[i - 2] + tempArr[i - 1];
    }
    return tempArr[n - 1];
  }
}
