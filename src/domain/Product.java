package domain;

public class Product {
  private String shopCode;
  private String productCode;

  public Product() {};

  public Product( String productCode) {
    this.productCode = productCode;
  }



  public String getProductCode() {
    return productCode;
  }



  @Override
  public String toString() {
    return "Product{" +
        "shopCode='" + shopCode + '\'' +
        ", productCode='" + productCode + '\'' +
        '}';
  }
}
