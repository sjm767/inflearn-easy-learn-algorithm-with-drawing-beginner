package com.jaeshim.inflearn.easylearn.algorithm.drawing.datastructure;

import static org.assertj.core.api.Assertions.*;

import com.jaeshim.inflearn.easylearn.algorithm.drawing.datastructure.code.LinkedList;
import com.jaeshim.inflearn.easylearn.algorithm.drawing.datastructure.code.Node;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LinkedListTest {

  LinkedList linkedList;

  @BeforeEach
  void before(){
    linkedList = new LinkedList();
  }

  @Test
  @DisplayName("전체 데이터 출력")
  void printAll(){
    linkedList.printAll();
  }

  @Test
  @DisplayName("연결리스트 초기화")
  void clear(){
    linkedList.insertAt(3,1);
    assertThat(linkedList.count).isEqualTo(1);

    linkedList.clear();
    assertThat(linkedList.count).isEqualTo(0);
    assertThat(linkedList.readAt(0)).isNull();
    assertThat(linkedList.readAt(1)).isNull();
  }

   @Test
  @DisplayName("존재하지 않는 인덱스에 삽입")
  void insertAbnormal(){
    linkedList.insertAt(3,1);
    assertThat(linkedList.readAt(0).data).isEqualTo(1);

    linkedList.insertAt(3,2);
    assertThat(linkedList.readAt(1).data).isEqualTo(2);
  }
  
  @Test
  @DisplayName("헤드에 삽입")
  void insertHead(){
    linkedList.insertAt(0,1);
    linkedList.insertAt(0,2);
    assertThat(linkedList.readAt(0).data).isEqualTo(2);
  }

  @Test
  @DisplayName("중간에 삽입")
  void insertAtMiddle(){
    linkedList.insertAt(0,1);
    linkedList.insertAt(1,2);
    linkedList.insertAt(2,3);
    linkedList.insertAt(2,9);

    linkedList.printAll();
    assertThat(linkedList.readAt(2).data).isEqualTo(9);
  }

  @Test
  @DisplayName("마지막에 삽입")
  void insertAtLast(){
    linkedList.insertLast(1);
    linkedList.insertLast(2);
    linkedList.insertLast(3);
    linkedList.printAll();

    assertThat(linkedList.readAt(2).data).isEqualTo(3);

  }

  @Test
  @DisplayName("처음 삭제")
  void deleteFirst(){
    linkedList.insertLast(1);
    linkedList.insertLast(2);
    linkedList.printAll();
    System.out.println("==");
    assertThat(linkedList.count).isEqualTo(2);

    Node deleteNode1 = linkedList.deleteAt(0);
    assertThat(deleteNode1.data).isEqualTo(1);
    linkedList.printAll();
    System.out.println("==");

    Node deleteNode2 = linkedList.deleteAt(0);
    assertThat(deleteNode2.data).isEqualTo(2);
    linkedList.printAll();
    System.out.println("==");
  }

  @Test
  @DisplayName("중간 삭제")
  void deleteIndex(){
    linkedList.insertLast(1);
    linkedList.insertLast(2);
    linkedList.insertLast(3);
    linkedList.printAll();
    System.out.println("==");

    Node node = linkedList.deleteAt(1);
    assertThat(node.data).isEqualTo(2);
    linkedList.printAll();
    System.out.println("==");
  }
  @Test
  @DisplayName("마지막 삭제")
  void deleteLast(){
    linkedList.insertLast(1);
    linkedList.insertLast(2);
    linkedList.insertLast(3);
    linkedList.printAll();
    System.out.println("==");

    Node node1 = linkedList.deleteLast();
    assertThat(node1.data).isEqualTo(3);
    linkedList.printAll();
    System.out.println("==");
    Node node2 = linkedList.deleteLast();
    assertThat(node2.data).isEqualTo(2);
    linkedList.printAll();
    System.out.println("==");
    Node node3 = linkedList.deleteLast();
    assertThat(node3.data).isEqualTo(1);
    linkedList.printAll();
    System.out.println("==");

  }
  @Test
  @DisplayName("존재하지 않는 인덱스 삭제")
  void deleteAbnormal(){
    linkedList.insertLast(1);
    linkedList.insertLast(2);
    linkedList.insertLast(3);
    linkedList.printAll();
    System.out.println("==");

    Node node = linkedList.deleteAt(3);
    assertThat(node.data).isEqualTo(3);
    linkedList.printAll();
    System.out.println("==");
  }

  @Test
  @DisplayName("빈 삭제")
  void deleteEmpty(){
    Node node = linkedList.deleteAt(0);
    assertThat(node).isNull();
  }
}
