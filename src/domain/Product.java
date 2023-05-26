package domain;

public class Product {
  private String shopCode;
  private String productCode;

  public Product() {};

  public Product( String productCode) {
    this.productCode = productCode;
  }

  public String getShopCode() {
    return shopCode;
  }

  public void setShopCode(String shopCode) {
    this.shopCode = shopCode;
  }

  public String getProductCode() {
    return productCode;
  }

  public void setProductCode(String productCode) {
    this.productCode = productCode;
  }


  @Override
  public String toString() {
    return "Product{" +
        "shopCode='" + shopCode + '\'' +
        ", productCode='" + productCode + '\'' +
        '}';
  }
}
