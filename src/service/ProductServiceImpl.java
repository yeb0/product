package service;

import common.exception.CustomException;
import common.type.ErrorCode;
import domain.Product;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class ProductServiceImpl implements ProductService{
  private static final String STRING_A_TO_Z = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
  final String shopCode = randomShopCode();
  static Map<String, Boolean> devProduct = new HashMap<>();
  static Map<String, Boolean> tradeProduct = new HashMap<>();
  static Map<String, String> userProduct = new HashMap<>();


  @Override
  public void createProduct() {
    // 개발자가 임의로 20개 상품 코드 생성
    for (int i = 0; i < 20; i++) {
      // product code 난수 생성
      Random random = new Random();
      StringBuilder sb = new StringBuilder(9);

      for (int j = 0; j < 9; j++) {
        int randomNumber = random.nextInt(10);
        sb.append(randomNumber);
      }
      // product code 끝
      Product pr = new Product(sb.toString());
      devProduct.put(pr.getProductCode(), true);
    }
    // 생성된 20개 중 10개 랜덤으로 추려서 교환 목록 상품 리스트에
    List<String> productList = new ArrayList<>(devProduct.keySet());

    Collections.shuffle(productList);
    for (int i = 0; i < 10; i++) {
      String productCode = productList.get(i);
      Boolean isAvailable = devProduct.get(productCode);
      tradeProduct.put(productCode, isAvailable);
    }
    System.out.println("성공적으로 상품코드들이 생성 후 진열되었습니다.");
  }

  @Override
  public void getProductList() {
    System.out.println("상점코드 : " + shopCode);
    for (String list : tradeProduct.keySet()) {
      Boolean value = tradeProduct.get(list);
      System.out.println("상품코드 : " + list + " 교환여부 : " + value);
    }
    System.out.println("성공적으로 상품들을 불러왔습니다.");
  }


  @Override
  public void getUserProductList() {
    for (String list : userProduct.keySet()) {
      String productCode = userProduct.get(list);
      System.out.println("상점코드 : " + shopCode + " 상품코드 : " + productCode);
    }
    System.out.println("성공적으로 상품들을 불러왔습니다.");
  }


  @Override
  public void checkProduct(String inputProductCode) {
    if (tradeProduct.containsKey(inputProductCode)) {
      System.out.println("상점 코드 : " + shopCode);
      System.out.println("교환할 수 있는 상품입니다. : " + inputProductCode);
    } else {
      throw new CustomException(ErrorCode.ALREADY_PRODUCT);
    }
    System.out.println("성공적으로 상점의 코드와 상품 코드를 불러왔습니다.");
  }

  @Override
  public void claimProduct(String inputShopCode, String inputProductCode) {
    if (!shopCode.equals(inputShopCode)) {
      throw new CustomException(ErrorCode.NOT_SAME_SHOP_CODE);
    }
    if (!tradeProduct.containsKey(inputProductCode)) {
      throw new CustomException(ErrorCode.NOT_FOUND_PRODUCT_CODE);
    }
    if (!tradeProduct.get(inputProductCode)) {
      throw new CustomException(ErrorCode.ALREADY_PRODUCT);
    }
    System.out.println("상점, 상품코드 둘 다 일치합니다. 교환합니다 !");
    tradeProduct.put(inputProductCode, false);
    userProduct.put(inputShopCode, inputProductCode);
    System.out.println("성공적으로 해당 상품을 교환했습니다.");
  }

  /**
   * 랜덤으로 상점코드를 만들어냅니다.
   */
  public static String randomShopCode() {
    Random random = new Random();
    StringBuilder sb = new StringBuilder(6);

    for (int i = 0; i < 6; i++) {
      int randomIndex = random.nextInt(STRING_A_TO_Z.length());
      char randomChar = STRING_A_TO_Z.charAt(randomIndex);
      sb.append(randomChar);
    }

    return sb.toString();
  }

  public String getShopCode() {
    return shopCode;
  }

  public static Map<String, Boolean> getDevProduct() {
    return devProduct;
  }

  public static Map<String, Boolean> getTradeProduct() {
    return tradeProduct;
  }

  public static Map<String, String> getUserProduct() {
    return userProduct;
  }

  public static void setDevProduct(Map<String, Boolean> devProduct) {
    ProductServiceImpl.devProduct = devProduct;
  }

  public static void setTradeProduct(Map<String, Boolean> tradeProduct) {
    ProductServiceImpl.tradeProduct = tradeProduct;
  }

  public static void setUserProduct(Map<String, String> userProduct) {
    ProductServiceImpl.userProduct = userProduct;
  }
}
