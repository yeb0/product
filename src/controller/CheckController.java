package controller;

import common.exception.CustomException;
import common.type.ErrorCode;
import service.ProductService;

public class CheckController implements Controller{

  private final ProductService productService;

  public CheckController(ProductService productService) {
    this.productService = productService;
  }

  @Override
  public String command(String input) { // 상품코드 입력
    String productCode2 = input.substring(0, 9);
    // 만약 잘못된 형식의 코드
    if (!input.matches("[0-9]+")) {
      throw new CustomException(ErrorCode.ONLY_NUMBER_PRODUCT_CODE);
    }
    productService.checkProduct(productCode2);
    return "교환 물품 조회 성공";
  }
}
