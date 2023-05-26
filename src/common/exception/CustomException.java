package common.exception;

import common.type.ErrorCode;

public class CustomException extends RuntimeException {
  private ErrorCode errorCode;
  private String errorMessage;

  public CustomException(ErrorCode errorCode, String message) {
    this.errorCode = errorCode;
    this.errorMessage = errorCode.getDescription() + " : " + message;
  }

  public CustomException(ErrorCode errorCode) {
    this.errorCode = errorCode;
    this.errorMessage = errorCode.getDescription();
  }
  @Override
  public String getMessage() {
    return errorMessage;
  }
}
