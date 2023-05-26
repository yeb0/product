package controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import common.exception.CustomException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class DispatcherControllerTest {
  @Test
  @DisplayName("명령어_입력_성공")
  void command_success() {
    //given - 뭐가 주어질 때.
    DispatcherController dispatcherController = new DispatcherController();
    String input = "HELP";
    //then - 무엇을 했다.
    boolean containsKey = dispatcherController.controllers.containsKey(input);
    //when - 그것에 대한 결과는 이렇게 나와야 한다.
    assertEquals(true, containsKey);
  }
  @Test
  @DisplayName("명령어_입력_실패")
  void command_failed() {
    //given
    DispatcherController dispatcherController = new DispatcherController();
    String input = "help";
    //then
    boolean containsKey = dispatcherController.controllers.containsKey(input);
    //when
    assertEquals(false, containsKey);
    assertThrows(CustomException.class, () -> {
    dispatcherController.run(input);
    });
  }
}