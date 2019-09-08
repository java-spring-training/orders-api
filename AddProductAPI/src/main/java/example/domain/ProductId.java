package example.domain;

public class ProductId {
    private String productCode;

    public ProductId(String productCode) {
        if (productCode.isEmpty() || productCode == null) {
            throw new IllegalArgumentException("productCode must be not null");
        }
        this.productCode = productCode;
    }
}
