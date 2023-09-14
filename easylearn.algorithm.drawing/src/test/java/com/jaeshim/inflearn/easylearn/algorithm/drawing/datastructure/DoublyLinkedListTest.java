package com.jaeshim.inflearn.easylearn.algorithm.drawing.datastructure;

import static org.assertj.core.api.Assertions.*;

import com.jaeshim.inflearn.easylearn.algorithm.drawing.datastructure.code.DoubleNode;
import com.jaeshim.inflearn.easylearn.algorithm.drawing.datastructure.code.DoublyLinkedList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class DoublyLinkedListTest {

  DoublyLinkedList linkedList;

  @BeforeEach
  void before(){
    linkedList = new DoublyLinkedList();
  }

  @Test
  @DisplayName("리스트가 비었을 때 첫 삽입")
  void insertInit(){
    linkedList.insertAt(0,1);
    linkedList.printAll();

    assertThat(linkedList.getHead().data).isEqualTo(1);
    assertThat(linkedList.getTail().data).isEqualTo(1);
  }

  @Test
  @DisplayName("데이터가 여러건 있을 때 0번 인덱스에 삽입")
  void insertFirst(){
    //초기데이터 생성
    linkedList.insertAt(0,1);
    linkedList.printAll();
    System.out.println("==");

    linkedList.insertAt(0,2);
    assertThat(linkedList.getHead().data).isEqualTo(2);
    assertThat(linkedList.getTail().data).isEqualTo(1);
    linkedList.printAll();
    System.out.println("==");

    //추가생성
    linkedList.insertAt(0,3);
    assertThat(linkedList.getHead().data).isEqualTo(3);
    assertThat(linkedList.getTail().data).isEqualTo(1);
    linkedList.printAll();
    System.out.println("==");
  }

  @Test
  @DisplayName("마지막 인덱스에 삽입")
  void insertLast(){
    //초기데이터 생성
    linkedList.insertAt(0,1);
    linkedList.printAll();
    System.out.println("==");

    linkedList.insertLast(2);
    linkedList.insertLast(3);
    linkedList.insertLast(4);
    assertThat(linkedList.getHead().data).isEqualTo(1);
    assertThat(linkedList.getTail().data).isEqualTo(4);
    linkedList.printAll();
    System.out.println("==");
  }

  @Test
  @DisplayName("인덱스 범위를 초과할 때 마지막 인덱스에 삽입하는지 확인")
  void insertInvalidIdx(){
    //초기데이터 생성
    linkedList.insertAt(0,1);
    linkedList.printAll();
    System.out.println("==");

    linkedList.insertAt(1000,2);
    linkedList.insertAt(1000,3);
    linkedList.insertAt(1000,4);
    assertThat(linkedList.getHead().data).isEqualTo(1);
    assertThat(linkedList.getTail().data).isEqualTo(4);
    linkedList.printAll();
    System.out.println("==");
  }

  @Test
  @DisplayName("데이터를 생성한 후 개수 체크")
  void checkCountAfterInsert(){
    linkedList.insertAt(0,1);
    linkedList.insertAt(0,2);
    linkedList.insertAt(0,3);
    linkedList.insertAt(0,4);
    linkedList.printAll();
    System.out.println("==");

    assertThat(linkedList.count).isEqualTo(4);
  }

  @Test
  @DisplayName("리스트가 비었을 때 삭제 시 null 리턴")
  void deleteWhenEmpty(){
    DoubleNode node = linkedList.deleteAt(0);
    assertThat(node).isNull();
  }

  @Test
  @DisplayName("데이터가 1개 있을 때 첫번째 인덱스 제거")
  void deleteWhenOnlyOne(){
    linkedList.insertLast(1);
    linkedList.printAll();
    System.out.println("==");

    DoubleNode node = linkedList.deleteAt(0);
    assertThat(node.data).isEqualTo(1);
    assertThat(linkedList.count).isEqualTo(0);
  }

  @Test
  @DisplayName("데이터가 여러개 있을 때 첫번째 인덱스 제거")
  void deleteIdxZeroWhenMany(){
    linkedList.insertLast(1);
    linkedList.insertLast(2);
    linkedList.insertLast(3);
    linkedList.printAll();
    System.out.println("==");

    DoubleNode node = linkedList.deleteAt(0);
    linkedList.printAll();
    System.out.println("==");

    assertThat(node.data).isEqualTo(1);
    assertThat(linkedList.getHead().data).isEqualTo(2);
    assertThat(linkedList.getTail().data).isEqualTo(3);
    assertThat(linkedList.count).isEqualTo(2);
  }

  @Test
  @DisplayName("데이터가 1개 있을 때 마지막 인덱스 제거")
  void deleteWhenOnlyOneWithDeleteLast(){
    linkedList.insertLast(1);
    linkedList.printAll();
    System.out.println("==");

    DoubleNode node = linkedList.deleteLast();
    assertThat(node.data).isEqualTo(1);
    assertThat(linkedList.count).isEqualTo(0);
  }

  @Test
  @DisplayName("데이터가 여러개 있을 때 마지막 인덱스 제거")
  void deleteLastWhenMany(){
    linkedList.insertLast(1);
    linkedList.insertLast(2);
    linkedList.insertLast(3);
    linkedList.printAll();
    System.out.println("==");

    DoubleNode node = linkedList.deleteLast();
    linkedList.printAll();
    System.out.println("==");

    assertThat(node.data).isEqualTo(3);
    assertThat(linkedList.getTail().data).isEqualTo(2);
    assertThat(linkedList.count).isEqualTo(2);
  }

  @Test
  @DisplayName("데이터가 1개 있을 때 인덱스 범위를 넘어가는 경우")
  void deleteInvalidIndexWhenOnlyOne(){
    linkedList.insertLast(1);

    DoubleNode node = linkedList.deleteAt(999);
    assertThat(node.data).isEqualTo(1);
    assertThat(linkedList.count).isEqualTo(0);
  }
  @Test
  @DisplayName("데이터가 여러개 있을 때 인덱스 범위를 넘어가는 경우 마지막 인덱스 제거")
  void deleteInvalidIndexWhenMany(){
    linkedList.insertLast(1);
    linkedList.insertLast(2);
    linkedList.insertLast(3);

    DoubleNode node = linkedList.deleteAt(999);
    linkedList.printAll();
    System.out.println("==");

    assertThat(node.data).isEqualTo(3);
    assertThat(linkedList.getHead().data).isEqualTo(1);
    assertThat(linkedList.getTail().data).isEqualTo(2);
    assertThat(linkedList.count).isEqualTo(2);
  }

  @Test
  @DisplayName("데이터가 여러개 있을 때 중간 인덱스 삭제")
  void deleteIdx(){
    linkedList.insertLast(1);
    linkedList.insertLast(2);
    linkedList.insertLast(3);
    linkedList.insertLast(4);

    DoubleNode node = linkedList.deleteAt(1);
    assertThat(node.data).isEqualTo(2);
    assertThat(linkedList.count).isEqualTo(3);
    assertThat(linkedList.getHead().data).isEqualTo(1);
    assertThat(linkedList.getTail().data).isEqualTo(4);
  }

  @Test
  @DisplayName("데이터가 1개 있을 때 0번 인덱스 읽기")
  void readWhenOnlyOne(){
    linkedList.insertLast(1);

    DoubleNode node = linkedList.readAt(0);
    assertThat(node.data).isEqualTo(1);
  }

  @Test
  @DisplayName("데이터가 여러개 있을 때 head, tail 읽기")
  void readWhenMany(){
    linkedList.insertLast(1);
    linkedList.insertLast(2);
    linkedList.insertLast(3);
    linkedList.insertLast(4);

    assertThat(linkedList.readAt(0).data).isEqualTo(1);
    assertThat(linkedList.readAt(3).data).isEqualTo(4);
  }

  @Test
  @DisplayName("데이터가 여러개 있을 때 중간 인덱스 읽기")
  void readIdx(){
    linkedList.insertLast(1);
    linkedList.insertLast(2);
    linkedList.insertLast(3);
    linkedList.insertLast(4);

    assertThat(linkedList.readAt(1).data).isEqualTo(2);
  }


}
