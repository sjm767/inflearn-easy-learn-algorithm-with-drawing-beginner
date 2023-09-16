package com.jaeshim.inflearn.easylearn.algorithm.drawing.algorithm.code;

import java.util.Arrays;

public final class Sort {

  private Sort() {
  }

  public static void bubbleSort(int arr[]) {
    for (int i = 0; i < arr.length - 1; i++) {
      for (int j = 0; j < arr.length - i - 1; j++) {
        if (arr[j + 1] < arr[j]) {
          int temp = arr[j + 1];
          arr[j + 1] = arr[j];
          arr[j] = temp;
        }
      }
    }
  }

  public static void selectionSort(int arr[]) {
    int minIdx = 0;
    for (int i = 0; i < arr.length - 1; i++) {
      minIdx = i;
      for (int j = i + 1; j < arr.length; j++) {
        if (arr[minIdx] > arr[j]) {
          minIdx = j;
        }
      }
      int temp = arr[i];
      arr[i] = arr[minIdx];
      arr[minIdx] = temp;
    }

  }

  public static void insertionSort(int arr[]) {
    int insertionData;
    int j;

    for (int i = 1; i < arr.length; i++) {
      insertionData = arr[i];
      for (j = i; j > 0; j--) {
        if (insertionData > arr[j - 1]) {
          break;
        }
        arr[j] = arr[j - 1];
      }
      arr[j] = insertionData;
    }
  }
}
