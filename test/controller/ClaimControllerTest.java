package controller;

import static org.junit.jupiter.api.Assertions.*;

import common.exception.CustomException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import service.ProductService;

class ClaimControllerTest {
  @Test
  @DisplayName("CLAIM_상품코드와_상점코드의_문자열_길이가_15가_아닌_경우")
  void inputCode_length_not_15_failed () {
    // given - 이러한 데이터가 주어질 때
    ProductService service = new ProductService();
    ClaimController controller = new ClaimController(service);
    String input = "ABcde2312312123124214";
    // then - 무엇을 했다.
    // when - 그것에 대한 결과는 이래야 한다.
    assertThrows(CustomException.class, () -> {
      controller.command(input);
    });
  }
}