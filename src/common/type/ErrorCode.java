package common.type;

public enum ErrorCode {
  INVALID_INPUT("잘못된 입력입니다."),
  ALREADY_PRODUCT("이미 교환이 완료된 상품입니다."),
  NOT_SAME_SHOP_CODE("상점 코드가 일치하지 않습니다"),
  NOT_EXIST_COMMAND("해당 명령어는 존재하지 않습니다. 명령어 모음 : HELP"),
  NOT_FOUND_PRODUCT_CODE("해당 상품코드의 상품이 존재하지 않습니다."),
  COMMAND_NEXT_INVALID("명령어 뒤의 문자를 잘못 입력하였습니다."),
  ONLY_NUMBER_PRODUCT_CODE("상품코드는 오직 숫자 0~9로만 이루어져 있습니다."),
  ;
  private final String description;
  ErrorCode(String description) {
    this.description = description;
  }

  public String getDescription() {
    return description;
  }
}
