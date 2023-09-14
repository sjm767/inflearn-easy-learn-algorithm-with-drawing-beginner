package com.jaeshim.inflearn.easylearn.algorithm.drawing.datastructure.code;

public class Queue {

  private DoublyLinkedList linkedList;

  public Queue() {
    this.linkedList = new DoublyLinkedList();
  }

  public void enqueue(int data){
    linkedList.insertAt(0,data);
  }

  public Integer deque(){
    DoubleNode node = linkedList.deleteLast();
    if(node == null){
      return null;
    }
    return node.data;
  }

  public Integer front(){
    return linkedList.readAt(linkedList.count-1).data;
  }

  public boolean isEmpty(){
    return  false;
  }

}
