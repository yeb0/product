package controller;

import common.exception.CustomException;
import common.type.ErrorCode;
import service.HelpService;

public class HelpController implements Controller {

  private final HelpService helpService;

  public HelpController(HelpService helpService) {
    this.helpService = helpService;
  }

  @Override
  public String command(String input) {
    if (input.equals("HELP")) {
      helpService.getHelp();
    }
    return "HELP 명령어가 실행되었습니다.";
  }
}
