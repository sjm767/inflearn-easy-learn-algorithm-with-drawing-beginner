package com.jaeshim.inflearn.easylearn.algorithm.drawing.algorithm;

import static org.assertj.core.api.Assertions.*;

import com.jaeshim.inflearn.easylearn.algorithm.drawing.algorithm.code.Sort;
import java.util.Arrays;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class SortTest {
  @Test
  @DisplayName("버블 정렬")
  void bubbleSort(){
    int arr[] = {4,2,3,1};
    int expect[] = {1,2,3,4};

    Sort.bubbleSort(arr);

    Arrays.stream(arr).forEach(value -> System.out.print(value+" "));
    System.out.println();

    assertThat(Arrays.equals(arr,expect)).isTrue();
  }

  @Test
  @DisplayName("선택 정렬")
  void selectionSort(){
    int arr[] = {6,3,4,1,2,5};
    int expect[] = {1,2,3,4,5,6};

    Sort.selectionSort(arr);

    Arrays.stream(arr).forEach(value -> System.out.print(value+" "));
    System.out.println();

    assertThat(Arrays.equals(arr,expect)).isTrue();

  }

  @Test
  @DisplayName("삽입 정렬")
  void insertionSort(){
    int arr[] = {4,1,5,3,6,2};
    int expect[] = {1,2,3,4,5,6};

    Sort.insertionSort(arr);

    Arrays.stream(arr).forEach(value -> System.out.print(value+" "));
    System.out.println();

    assertThat(Arrays.equals(arr,expect)).isTrue();
  }
}
