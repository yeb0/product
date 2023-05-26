package controller;

import common.exception.CustomException;
import common.type.ErrorCode;
import service.ProductService;

public class ListController implements Controller{

  private final ProductService productService;

  public ListController(ProductService productService) {
    this.productService = productService;
  }
  @Override
  public String command(String input) {
    if (!input.equals("GET")) {
      throw new CustomException(ErrorCode.COMMAND_NEXT_INVALID);
    }
    productService.getProductList();
    return null;
  }
}
