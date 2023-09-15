package com.jaeshim.inflearn.easylearn.algorithm.drawing.datastructure;

import static org.assertj.core.api.Assertions.*;

import com.jaeshim.inflearn.easylearn.algorithm.drawing.datastructure.code.Deque;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class DequeTest {

  Deque deque;

  @BeforeEach
  void before() {
    deque = new Deque();
  }

  @Test
  @DisplayName("Empty 체크")
  void isEmpty() {
    assertThat(deque.isEmpty()).isTrue();

    deque.addFirst(1);

    assertThat(deque.isEmpty()).isFalse();
  }

  @Test
  @DisplayName("덱의 처음에 삽입")
  void addFirst() {
    deque.addFirst(1);
    deque.addFirst(2);
    deque.addFirst(3);
    deque.printAll();
    System.out.println("==");

    assertThat(deque.getFrontData()).isEqualTo(3);
    assertThat(deque.getLastData()).isEqualTo(1);

  }

  @Test
  @DisplayName("덱의 마지막에 삽입")
  void addLast() {
    deque.addLast(1);
    deque.addLast(2);
    deque.addLast(3);
    deque.printAll();
    System.out.println("==");

    assertThat(deque.getFrontData()).isEqualTo(1);
    assertThat(deque.getLastData()).isEqualTo(3);
  }

  @Test
  @DisplayName("덱에 섞어서 삽입")
  void addComplex() {
    deque.addFirst(1);
    deque.addFirst(2);
    deque.addLast(3);
    deque.addLast(4);

    deque.printAll();
    System.out.println("==");

    assertThat(deque.getFrontData()).isEqualTo(2);
    assertThat(deque.getLastData()).isEqualTo(4);
  }

  @Test
  @DisplayName("빈 덱 삭제")
  void emptyDeque() {
    assertThat(deque.removeFirst()).isNull();
    assertThat(deque.removeLast()).isNull();
  }

  @Test
  @DisplayName("덱에서 처음 삭제")
  void removeFirst() {
    deque.addLast(1);
    deque.addLast(2);

    Integer data = deque.removeFirst();
    assertThat(data).isEqualTo(1);

  }

  @Test
  @DisplayName("덱에서 마지막 삭제")
  void removeLast() {
    deque.addLast(1);
    deque.addLast(2);

    Integer data = deque.removeLast();
    assertThat(data).isEqualTo(2);
  }

}
