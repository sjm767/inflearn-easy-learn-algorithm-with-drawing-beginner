package com.jaeshim.inflearn.easylearn.algorithm.drawing.datastructure;

import static org.assertj.core.api.Assertions.*;

import com.jaeshim.inflearn.easylearn.algorithm.drawing.datastructure.code.Queue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class QueueTest {

  Queue queue;

  @BeforeEach
  void before() {
    queue = new Queue();
  }

  @Test
  @DisplayName("한 건 생성 후 확인")
  void oneData(){
    queue.enqueue(1);
    queue.printAll();

    assertThat(queue.front()).isEqualTo(1);
  }

  @Test
  @DisplayName("여러 건 생성 후 확인")
  void multiData(){
    queue.enqueue(1);
    queue.enqueue(2);
    queue.enqueue(3);
    queue.enqueue(4);
    queue.printAll();

    assertThat(queue.front()).isEqualTo(1);
  }

  @Test
  @DisplayName("큐가 비었을 때 삭제")
  void emptyQueue() {
    Integer data = queue.deque();

    assertThat(data).isNull();
  }


  @Test
  @DisplayName("여러 건 생성 후 삭제")
  void multiDataRemove(){
    queue.enqueue(1);
    queue.enqueue(2);
    queue.enqueue(3);
    queue.enqueue(4);
    queue.printAll();
    System.out.println("==");

    assertThat(queue.isEmpty()).isFalse();
    assertThat(queue.front()).isEqualTo(1);

    queue.deque();
    assertThat(queue.front()).isEqualTo(2);
    queue.deque();
    assertThat(queue.front()).isEqualTo(3);
    queue.deque();
    assertThat(queue.front()).isEqualTo(4);
    queue.deque();

    queue.printAll();
    System.out.println("==");

    assertThat(queue.isEmpty()).isTrue();
  }

  @Test
  @DisplayName("데이터 여러 건 생성 후 front 확인")
  void front(){
    queue.enqueue(1);
    queue.enqueue(2);
    queue.enqueue(3);

    Integer data = queue.front();
    assertThat(data).isEqualTo(1);
  }

}
