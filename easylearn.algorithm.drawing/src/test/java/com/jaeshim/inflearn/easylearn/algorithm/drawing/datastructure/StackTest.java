package com.jaeshim.inflearn.easylearn.algorithm.drawing.datastructure;

import static org.assertj.core.api.Assertions.*;

import com.jaeshim.inflearn.easylearn.algorithm.drawing.datastructure.code.Stack;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class StackTest {

  Stack stack;

  @BeforeEach
  public void before() {
    stack = new Stack();
  }

  @Test
  @DisplayName("간단한 insert")
  void insert() {
    stack.push(1);
    stack.push(2);
    stack.push(3);
    stack.printAll();

    assertThat(stack.peek()).isEqualTo(3);
  }

  @Test
  @DisplayName("데이터 3개 넣은 후 1개빼고 확인")
  void insert3remove1() {
    stack.push(1);
    stack.push(2);
    stack.push(3);

    stack.pop();

    stack.printAll();
    assertThat(stack.peek()).isEqualTo(2);
  }

  @Test
  @DisplayName("데이터 3개 넣은 후 다 제거한 뒤 비어있는지 확인")
  void empty() {
    stack.push(1);
    stack.push(2);
    stack.push(3);

    stack.pop();
    stack.pop();
    stack.pop();

    assertThat(stack.isEmpty()).isTrue();
  }

  @Test
  @DisplayName("스택이 비었을 때 제거하면 null을 리턴하는지 확인")
  void emptyStackPopReturnNull() {
    Integer data = stack.pop();
    assertThat(data).isNull();
  }

  @Test
  @DisplayName("스택이 비었을 때 peek하면 null을 리턴하는지 확인")
  void emptyStackPeekReturnNull(){
    Integer data = stack.peek();
    assertThat(data).isNull();
  }

}
