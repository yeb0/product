package controller;

import common.exception.CustomException;
import common.type.ErrorCode;
import service.ProductService;

public class ClaimController implements Controller {

  private final ProductService productService;

  public ClaimController(ProductService productService) {
    this.productService = productService;
  }

  @Override
  public String command(String input) {
    isValidation(input);
    String inputShopCode = input.substring(0, 6);
    String inputProductCode = input.substring(6, 15);
    productService.claimProduct(inputShopCode, inputProductCode);
    return "Claim 명령어가 실행되었습니다.";
  }

  public static boolean isValidation(String input) {
    //ABcde2312312123
    if (input.length() != 15) {
      throw new CustomException(ErrorCode.COMMAND_NEXT_INVALID);
    }
    return true;
  }
}
