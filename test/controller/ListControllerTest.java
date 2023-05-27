package controller;

import static org.junit.jupiter.api.Assertions.*;

import common.exception.CustomException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import service.ProductService;
import service.ProductServiceImpl;

class ListControllerTest {
  @Test
  @DisplayName("명령어_GET이_아닐_경우")
  void listCommand_failed () {
    // given - 이러한 데이터가 주어질 때
    ProductService service = new ProductServiceImpl();
    ListController controller = new ListController(service);
    String input = "get"; // GET
    // then - 무엇을 했다.
    // when - 그것에 대한 결과는 이래야 한다.
    assertThrows(CustomException.class, () -> {
      controller.command(input);
    });
  }
}