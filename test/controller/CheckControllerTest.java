package controller;

import static org.junit.jupiter.api.Assertions.*;

import common.exception.CustomException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import service.ProductService;
import service.ProductServiceImpl;

class CheckControllerTest {
  @Test
  @DisplayName("CHECK_명령어_숫자_외의_다른_문자열_실패")
  void checkCommandString_failed() {
    // given - 이러한 데이터가 주어질 때
    ProductService service = new ProductServiceImpl();
    CheckController checkController = new CheckController(service);
    String input = "1234567ab";
    // then - 무엇을 했다.
    // when - 그것에 대한 결과는 이래야 한다.
    assertThrows(CustomException.class, () -> {
      checkController.command(input);
    });
  }
}