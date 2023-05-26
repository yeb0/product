package service;

import java.sql.SQLOutput;

public class HelpService {
  public void getHelp() {
    System.out.println("---------------------------------------------");
    System.out.println("CHECK [상품코드입력]");
    System.out.println("사용법 설명 : CHECK 명령어와 상품코드를 입력해야합니다.");
    System.out.println("해당 명령어 설명 : 상품 교환 여부 확인입니다. 교환이 가능할 경우엔 true, 아닐 경우엔 false");
    System.out.println("만약, 없는 코드를 입력할 경우 오류");
    System.out.println("입력 예시 : CHECK 132 421 122");
    System.out.println();
    System.out.println("CLAIM [상점코드입력] [상품코드입력]");
    System.out.println("설명 : CLAIM 명령어와 상점코드, 상품코드를 순서대로 입력해야합니다.");
    System.out.println("입력 예시 : CLAIM Abcde 132 421 122");
    System.out.println();
    System.out.println("LIST GET");
    System.out.println("설명 : 현재 진열되어 있는 상품코드와 교환가능여부를 보여줍니다.");
    System.out.println("입력 예시 : LIST GET");
    System.out.println();
    System.out.println();
    System.out.println("---------------------------------------------");
    System.out.println("성공적으로 명령어를 불러왔습니다.");
  }
}
