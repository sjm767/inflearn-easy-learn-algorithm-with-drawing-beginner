package com.jaeshim.inflearn.easylearn.algorithm.drawing.algorithm;

import static org.assertj.core.api.Assertions.*;

import com.jaeshim.inflearn.easylearn.algorithm.drawing.algorithm.code.Recursion;
import java.util.HashMap;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RecursionTest {

  @Test
  @DisplayName("0~10까지 출력하는 재귀함수 호출")
  void printNumbers() {
    Recursion.printNumbers(0, 10);
  }

  @Test
  @DisplayName("팩토리얼 함수 호출")
  void factorial() {
    int result = Recursion.factorial(5);
    assertThat(result).isEqualTo(120);

    int result2 = Recursion.factorial(3);
    assertThat(result2).isEqualTo(6);

    int result3 = Recursion.factorial(0);
    assertThat(result3).isEqualTo(1);
  }

  @Test
  @DisplayName("배열의 합 계산")
  void arraySum() {
    int arr[] = {1, 2, 3, 4, 5};
    int arr2[] = {1, 2, 3, 4, 5, 6, 7};
    int arr3[] = {3, 6, 9};

    int result = Recursion.arraySum(arr);
    int result2 = Recursion.arraySum(arr2);
    int result3 = Recursion.arraySum(arr3);

    assertThat(result).isEqualTo(15);
    assertThat(result2).isEqualTo(28);
    assertThat(result3).isEqualTo(18);
  }

  @Test
  @DisplayName("문자열의 길이 게산. (char 배열)")
  void strLengthChar() {
    char[] str = {'H', 'e', 'l', 'l', 'o'};

    int result = Recursion.strLength(str);

    assertThat(result).isEqualTo(5);
  }

  @Test
  @DisplayName("문자열의 길이 게산. (String)")
  void strLengthString() {
    String str = "jaeshim";

    int result = Recursion.strLength(str);

    assertThat(result).isEqualTo(7);
  }

  @Test
  @DisplayName("지수함수")
  void power() {
    int num = 2;
    int pow = 5;

    int result = Recursion.power(num, pow);
    assertThat(result).isEqualTo(32);

    num = 3;
    pow = 2;
    result = Recursion.power(num, pow);
    assertThat(result).isEqualTo(9);
  }

  @Test
  @DisplayName("하노이의 탑")
  void hanoi() {
    int count = 3;
    String from = "A";
    String to = "C";
    String temp = "B";

    Recursion.hanoi(count, from, to, temp);

  }

  @Test
  @DisplayName("피보나치 버전1 : 중복계산")
  void fibonacci1() {
    int n = 40;

    long startTime = System.currentTimeMillis();

    int result = Recursion.fibonacci1(n);

    long endTime = System.currentTimeMillis();
    System.out.println("Elapsed Time: " + (endTime - startTime) + "ms");

    assertThat(result).isEqualTo(102334155);

  }

  @Test
  @DisplayName("피보나치 버전2 : 메모이제이션")
  void fibonacci2() {
    int n = 40;

    long startTime = System.currentTimeMillis();

    int result = Recursion.fibonacci2(n, new HashMap<>());

    long endTime = System.currentTimeMillis();
    System.out.println("Elapsed Time: " + (endTime - startTime) + "ms");

    assertThat(result).isEqualTo(102334155);
  }

  @Test
  @DisplayName("피보나치 버전3 : 타뷸레이션")
  void fibonacci3() {
    int n = 40;

    long startTime = System.currentTimeMillis();

    int result = Recursion.fibonacci3(n);
    assertThat(result).isEqualTo(102334155);

    long endTime = System.currentTimeMillis();
    System.out.println("Elapsed Time: " + (endTime - startTime) + "ms");

    assertThat(result).isEqualTo(102334155);
  }

}
