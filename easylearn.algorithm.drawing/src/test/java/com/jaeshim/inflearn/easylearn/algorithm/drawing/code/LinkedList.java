package com.jaeshim.inflearn.easylearn.algorithm.drawing.code;

public class LinkedList {

  public int count;
  public Node head;

  public LinkedList() {
    this.head = null;
    this.count = 0;
  }

  public void printAll() {
    Node currentNode = head;

    while (currentNode != null) {
      System.out.println(currentNode.data);
      currentNode = currentNode.next;
    }
  }

  public void insertAt(int index, int data) {
    Node newNode = new Node(data);

    if (head == null) {
      this.head = newNode;
      this.count++;
      return;
    }

    if (index == 0) {
      newNode.next = this.head;
      this.head = newNode;
      this.count++;
      return;
    }

    Node currentNode = this.head;
    int currentIdx = 0;

    while (currentNode.next != null) {
      if (currentIdx == index - 1) {
        break;
      }
      currentNode = currentNode.next;
      currentIdx++;
    }
    //마지막 노드가 아닌 경우
    if (currentNode.next != null) {
      newNode.next = currentNode.next;
    }
    currentNode.next = newNode;
    this.count++;
  }

  public void insertLast(int data) {
    insertAt(this.count, data);
  }

  public Node deleteAt(int index) {
    //연결리스트가 비었으면 null리턴
    if (this.head == null) {
      return null;
    }

    //인덱스 범위를 초과하면 마지막 인덱스 읽기
    if (index >= count) {
      return deleteLast();
    }

    Node currentNode = this.head;
    Node deleteNode = null;

    if (index == 0) {
      deleteNode = this.head;
      this.head = this.head.next;
      this.count--;
      return deleteNode;
    }

    for (int i = 0; i < index - 1; i++) {
      currentNode = currentNode.next;
    }
    deleteNode = currentNode.next;
    currentNode.next = deleteNode.next;
    this.count--;

    return deleteNode;
  }

  public Node deleteLast() {
    return deleteAt(this.count - 1);
  }

  public void clear() {
    this.head = null;
    count = 0;
  }

  public Node readAt(int index) {
    if (index >= count) {
      return null;
    }

    Node currentNode = this.head;
    for (int i = 0; i < index; i++) {
      currentNode = currentNode.next;
    }

    return currentNode;
  }
}
