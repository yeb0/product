package service;

public interface ProductService {
  /**
   * 상품코드 20개 생성 후
   * 상품진열 10개 랜덤
   */
  void createProduct();

  /**
   * 현재 진열되어 있는 상품들의 코드와 상점코드를 보여줍니다.
   */
  void getProductList();

  /**
   * 사용자가 교환한 상품의 코드와 해당 상품의 상점코드를 보여줍니다.
   */
  void getUserProductList();
  /**
   * 해당 상품이 교환 가능의 여부를 알려줍니다.
   * @param inputProductCode
   */
  void checkProduct(String inputProductCode);
  /**
   * 상점코드와 상품코드를 입력해 교환합니다.
   * @param inputShopCode
   * @param inputProductCode
   */
  void claimProduct(String inputShopCode, String inputProductCode);

}
