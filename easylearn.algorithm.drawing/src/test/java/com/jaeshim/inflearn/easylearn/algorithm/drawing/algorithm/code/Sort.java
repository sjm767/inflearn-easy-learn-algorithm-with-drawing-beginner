package com.jaeshim.inflearn.easylearn.algorithm.drawing.algorithm.code;

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

  public static void mergeSort(int arr[], int leftIdx, int rightIdx) {
    if (leftIdx < rightIdx) {
      int midIdx = (leftIdx + rightIdx) / 2;
      mergeSort(arr, leftIdx, midIdx);
      mergeSort(arr, midIdx + 1, rightIdx);
      merge(arr, leftIdx, midIdx, rightIdx);
    }
  }

  private static void merge(int arr[], int leftIdx, int midIdx, int rightIdx) {
    int temp[] = new int[rightIdx + 1];

    int leftAreaIdx = leftIdx;
    int rightAreaIdx = midIdx + 1;
    int tempArrIdx = leftIdx;

    while (leftAreaIdx <= midIdx && rightAreaIdx <= rightIdx) {
      if (arr[leftAreaIdx] < arr[rightAreaIdx]) {
        temp[tempArrIdx++] = arr[leftAreaIdx++];
      } else {
        temp[tempArrIdx++] = arr[rightAreaIdx++];
      }
    }

    //좌측, 우측 남은 것 다 넣기
    if (leftAreaIdx > midIdx) {
      for (int i = rightAreaIdx; i <= rightIdx; i++) {
        temp[tempArrIdx++] = arr[i];
      }
    } else {
      for (int i = leftAreaIdx; i <= midIdx; i++) {
        temp[tempArrIdx++] = arr[i];
      }
    }

    for (int i = leftIdx; i <= rightIdx; i++) {
      arr[i] = temp[i];
    }
  }

  public static void quickSort(int arr[],int left,int right){
    if(left <= right){
      int pivot = divide(arr,left,right);
      quickSort(arr,left,pivot-1);
      quickSort(arr,pivot+1,right);
    }
  }
  private static int divide(int arr[], int left, int right ){
    int pivot = arr[left];
    int leftStartIdx = left + 1;
    int rightStartIdx = right;

    while(leftStartIdx <= rightStartIdx){
      while(leftStartIdx <= right && pivot >= arr[leftStartIdx]){
        leftStartIdx++;
      }
      while(rightStartIdx >= left +1 && arr[rightStartIdx] >= pivot){
        rightStartIdx--;
      }

      if(leftStartIdx <= rightStartIdx){
        swap(arr,leftStartIdx,rightStartIdx);
      }
    }

    swap(arr, left, rightStartIdx);
    return rightStartIdx;
  }

  private static void swap(int arr[], int aIdx,int bIdx){
    int temp = arr[aIdx];
    arr[aIdx] = arr[bIdx];
    arr[bIdx] = temp;
  }
}
