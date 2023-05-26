package controller;

import common.exception.CustomException;
import common.type.ErrorCode;
import service.ProductService;

public class ProductController implements Controller{

  private final ProductService productService;

  public ProductController(ProductService productService) {
    this.productService = productService;
  }

  @Override
  public String command(String input) {
    if (!input.equals("CREATE_PRODUCT")) {
      throw new CustomException(ErrorCode.COMMAND_NEXT_INVALID);
    }
    productService.createProduct();
    return "상품 생성 명령어가 실행되었습니다.";
  }
}
