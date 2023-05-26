package controller;

import static org.junit.jupiter.api.Assertions.*;

import common.exception.CustomException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import service.ProductService;

class UserProductListControllerTest {
  @Test
  @DisplayName("명령어_CREATE_PRODUCT이_아닐_경우")
  void productCommand_failed () {
    // given - 이러한 데이터가 주어질 때
    ProductService service = new ProductService();
    UserProductListController controller = new UserProductListController(service);
    String input = "get_list"; // GET_LIST
    // then - 무엇을 했다.
    // when - 그것에 대한 결과는 이래야 한다.
    assertThrows(CustomException.class, () -> {
      controller.command(input);
    });
  }
}