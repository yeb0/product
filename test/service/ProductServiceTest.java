package service;

import static org.junit.jupiter.api.Assertions.*;

import common.exception.CustomException;
import common.type.ErrorCode;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

class ProductServiceTest {

  private static final String STRING_A_TO_Z = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";

  @BeforeEach
  void beforeEach() {
    String randomShopCode = randomShopCode();
  }
  @AfterEach
  void afterEach() {
    ProductServiceImpl.setDevProduct(new HashMap<>());
    ProductServiceImpl.setTradeProduct(new HashMap<>());
  }


  private String randomShopCode() {
    Random random = new Random();
    StringBuilder sb = new StringBuilder(6);

    for (int i = 0; i < 6; i++) {
      int randomIndex = random.nextInt(STRING_A_TO_Z.length());
      char randomChar = STRING_A_TO_Z.charAt(randomIndex);
      sb.append(randomChar);
    }

    return sb.toString();
  }
  @Test
  @DisplayName("createProduct 메서드가 상품 코드와 진열 여부를 정확히 생성하는지 확인")
  void createProductTest() {
    // given - 이러한 데이터가 주어질 때
    ProductService service = new ProductServiceImpl();
    // then - 무엇을 했다.
    service.createProduct();
    // when - 그것에 대한 결과는 이래야 한다.
    Map<String, Boolean> devProduct = ProductServiceImpl.getDevProduct();
    Map<String, Boolean> tradeProduct = ProductServiceImpl.getTradeProduct();

    // 생성된 상품 코드 개수 확인 (list test 확인 가능)
    assertEquals(20, devProduct.size());

    // 상품 코드가 10개로 추려졌는지 확인
    assertEquals(10, tradeProduct.size());

    // 상품 코드와 진열 여부가 정확히 매핑되었는지 확인
    for (Map.Entry<String, Boolean> entry : tradeProduct.entrySet()) {
      String productCode = entry.getKey();
      Boolean isAvailable = entry.getValue();

      assertTrue(devProduct.containsKey(productCode));
      assertEquals(isAvailable, devProduct.get(productCode));
    }
  }

  @Test
  @DisplayName("상품이_교환가능이_아닐_경우")
  void checkProduct_failed () {
    // given - 이러한 데이터가 주어질 때
    ProductService service = new ProductServiceImpl();
    service.createProduct();
    String productCode = "123456789";

    // when - 무엇을 했다.
    Executable executable = () -> service.checkProduct(productCode);

    // then - 그것에 대한 결과는 이래야 한다.
    CustomException exception = assertThrows(CustomException.class, executable);
    assertEquals(ErrorCode.ALREADY_PRODUCT.getDescription(), exception.getMessage());
  }

  @Test
  @DisplayName("상품_교환_실패_상점코드가_다를_경우")
  void sameShopCode_failed () {
    // given - 이러한 데이터가 주어질 때
    ProductService service = new ProductServiceImpl();
    service.createProduct();
    String productCode = "123456789";
    String shopCode = "abcdef";
    // then - 무엇을 했다.
    // when - 그것에 대한 결과는 이래야 한다.
    assertThrows(CustomException.class, () -> {
      service.claimProduct(shopCode, productCode);
    });
  }
  @Test
  @DisplayName("상품_교환_실패_상품코드가_다르거나_목록에_없는_경우")
  void none_or_dif_claimProductCode_failed () {
    // given - 이러한 데이터가 주어질 때
    ProductService service = new ProductServiceImpl();
    service.createProduct();
    String randomShopCode = randomShopCode();
    //문자는 못들어오지만 다르거나, 목록에 없다는 전제 하에 사용하기 위함
    String productCode = "12345678z";
    // then - 무엇을 했다.

    // when - 그것에 대한 결과는 이래야 한다.
    assertThrows(CustomException.class, () -> {
      service.claimProduct(randomShopCode, productCode);
    });
  }

  @Test
  @DisplayName("상품_교환_실패_이미_교환한_상품일_경우")
  void alreadyProduct_failed () {
    // given - 이러한 데이터가 주어질 때
    ProductService service = new ProductServiceImpl();
    service.createProduct();
    String randomShopCode = randomShopCode();
    String productCode = "123456789";

    Map<String, Boolean> tradeProduct = ProductServiceImpl.getTradeProduct();
    tradeProduct.put(productCode, false);
    // then - 무엇을 했다.
    // when - 그것에 대한 결과는 이래야 한다.
    assertThrows(CustomException.class, () -> {
      service.claimProduct(randomShopCode, productCode);
    });
  }
}