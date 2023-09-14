package com.jaeshim.inflearn.easylearn.algorithm.drawing.datastructure.code;

public class DoublyLinkedList {

  public int count;
  private DoubleNode head;
  private DoubleNode tail;

  public DoublyLinkedList() {
    this.head = null;
    this.tail = null;
    this.count = 0;
  }

  public void printAll() {
    DoubleNode currentNode = head;

    while (currentNode != null) {
      System.out.println(currentNode.data);
      currentNode = currentNode.next;
    }
  }

  public void insertAt(int index, int data) {
    DoubleNode newNode = new DoubleNode(data);

    if (head == null) {
      this.head = newNode;
      this.tail = newNode;
      this.count++;
      return;
    }

    //첫번쨰 인덱스 삽입
    if (index == 0) {
      newNode.next = this.head;
      this.head.prev = newNode;
      this.head = newNode;
    }
    //마지막 인덱스 삽입
    else if ((index == this.count) || (index > this.count)) {
      newNode.prev = this.tail;
      this.tail.next = newNode;
      this.tail = newNode;
    } else {
      DoubleNode currentNode = this.head;

      for (int i = 0; i < index - 1; i++) {
        currentNode = currentNode.next;
      }

      newNode.next = currentNode.next;
      currentNode.next.prev = newNode;
      newNode.prev = currentNode;
      currentNode.next = newNode;
    }

    this.count++;
  }

  public void insertLast(int data) {
    insertAt(this.count, data);
  }

  public DoubleNode deleteAt(int index) {
    //연결리스트가 비었으면 null리턴
    if (this.head == null) {
      return null;
    }

    //인덱스 범위를 초과하면 마지막 인덱스 제거
    if (index >= count) {
      return deleteLast();
    }

    DoubleNode currentNode = this.head;
    DoubleNode deleteNode = null;

    //첫번째 인덱스 제거
    if (index == 0) {
      deleteNode = this.head;
      if (this.head.next == null) { //데이터가 하나 남은 경우
        this.head = null;
        this.tail = null;
      } else {
        this.head = this.head.next;
        this.head.prev = null;
        deleteNode.next = null;
      }
    }//마지막 인덱스 제거
    else if (index == count - 1) {
      deleteNode = this.tail;
      this.tail.prev.next = null;
      this.tail = deleteNode.prev;
      deleteNode.prev = null;
    } else {
      for (int i = 0; i < index - 1; i++) {
        currentNode = currentNode.next;
      }
      deleteNode = currentNode.next;
      currentNode.next = deleteNode.next;
      currentNode.next.prev = currentNode;

      deleteNode.next = null;
      deleteNode.prev = null;
    }
    this.count--;
    return deleteNode;
  }

  public DoubleNode deleteLast() {
    return deleteAt(this.count - 1);
  }

  public void clear() {
    this.head = null;
    this.tail = null;
    count = 0;
  }

  public DoubleNode readAt(int index) {
    if (index >= count) {
      return null;
    }

    if (index == 0) {
      return this.head;
    } else if (index == count - 1) {
      return this.tail;
    }

    DoubleNode currentNode = this.head;
    for (int i = 0; i < index; i++) {
      currentNode = currentNode.next;
    }
    return currentNode;
  }


  public DoubleNode getTail() {
    return this.tail;
  }

  public DoubleNode getHead() {
    return this.head;
  }

}