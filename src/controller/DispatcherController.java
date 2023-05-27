package controller;

import common.exception.CustomException;
import common.type.ErrorCode;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import service.HelpService;
import service.ProductService;
import service.ProductServiceImpl;

public class DispatcherController {

  Map<String, Controller> controllers;

  public DispatcherController() {

    controllers = new HashMap<>();

    ProductService productService = new ProductServiceImpl();
    HelpService helpService = new HelpService();

    controllers.put("CHECK", new CheckController(productService));
    controllers.put("HELP", new HelpController(helpService));
    controllers.put("CLAIM", new ClaimController(productService));
    controllers.put("PRODUCT", new ProductController(productService));
    controllers.put("LIST", new ListController(productService));
    controllers.put("USER", new UserProductListController(productService));
  }

  public void isSupported(String controller) {
    if (!controllers.containsKey(controller)) {
      throw new CustomException(ErrorCode.NOT_EXIST_COMMAND);
    }
  }


  public void run(String input) {
    String[] split = input.split(" "); // 0번째 -> 명령어
    isSupported(split[0]);
    Controller controllerRun = controllers.get(split[0]);
    if (input.equals("HELP")) {
      controllerRun.command(input);
    }
    String result = "";
    for (int i = 1; i < split.length; i++) {
      result += split[i];
    }
    String s = result.replaceAll(" ", "");
    //ABcde1231231123
    controllerRun.command(s);
  }
}
