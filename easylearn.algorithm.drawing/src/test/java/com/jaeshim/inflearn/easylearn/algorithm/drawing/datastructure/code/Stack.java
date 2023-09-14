package com.jaeshim.inflearn.easylearn.algorithm.drawing.datastructure.code;

public class Stack {

  private LinkedList linkedList;

  public Stack(){
    linkedList = new LinkedList();
  }

  public void push(int data){
    linkedList.insertAt(0,data);
  }

  public Integer pop(){
    Node node = linkedList.deleteAt(0);

    if(node == null){
      return null;
    }
    return node.data;
  }

  public Integer peek(){
    Node node = linkedList.readAt(0);

    if(node == null){
      return null;
    }
    return node.data;
  }

  public boolean isEmpty(){
    return (linkedList.count == 0);
  }

  public void printAll(){
    linkedList.printAll();
  }

}
