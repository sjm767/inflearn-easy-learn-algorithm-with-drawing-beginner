package com.jaeshim.inflearn.easylearn.algorithm.drawing.datastructure.code;

public class Deque {

  private DoublyLinkedList linkedList;

  public Deque() {
    this.linkedList = new DoublyLinkedList();
  }

  public void printAll() {
    this.linkedList.printAll();
  }

  public void addFirst(int data) {
    this.linkedList.insertAt(0, data);
  }

  public void addLast(int data) {
    this.linkedList.insertLast(data);
  }

  public Integer removeFirst() {
    DoubleNode node = this.linkedList.deleteAt(0);
    return validateAndGetData(node);
  }

  public Integer removeLast() {
    DoubleNode node = this.linkedList.deleteLast();
    return validateAndGetData(node);
  }

  public boolean isEmpty() {
    return this.linkedList.count == 0;
  }

  public Integer getFrontData() {
    DoubleNode node = this.linkedList.readAt(0);
    return validateAndGetData(node);
  }

  public Integer getLastData() {
    DoubleNode node = this.linkedList.readAt(this.linkedList.count - 1);
    return validateAndGetData(node);
  }

  private static Integer validateAndGetData(DoubleNode node) {
    if (node == null) {
      return null;
    }
    return node.data;
  }


}
