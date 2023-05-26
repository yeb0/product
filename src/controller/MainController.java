package controller;

import common.exception.CustomException;
import common.type.ErrorCode;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import service.HelpService;
import service.ProductService;

public class MainController {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    System.out.println("상점코드 교환 프로그램입니다.");
    System.out.println("명령어를 입력하세요. 명령어 확인 : HELP");
    // 컨트롤러 생성
    // DispatcherController 생성
    DispatcherController dispatcherController = new DispatcherController();
    String input;
    while (!(input = sc.nextLine()).equals("END")) {
      try {
        dispatcherController.run(input);
        System.out.print("명령어를 입력해 주세요. ->");
      } catch (CustomException e) {
        System.out.println(e.getMessage());
      }
    }
  }
}