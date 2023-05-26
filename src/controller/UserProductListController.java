package controller;

import common.exception.CustomException;
import common.type.ErrorCode;
import service.ProductService;

public class UserProductListController implements Controller{
  private final ProductService productService;

  public UserProductListController(ProductService productService) {
    this.productService = productService;
  }

  @Override
  public String command(String input) {
    if (!input.equals("GET_LIST")) {
      throw new CustomException(ErrorCode.COMMAND_NEXT_INVALID);
    }
    productService.getUserProductList();
    return null;
  }
}
