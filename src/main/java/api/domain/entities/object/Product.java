package api.domain.entities.object;

import java.math.BigDecimal;

public class Product {
    private String productName;
    private BigDecimal buyPrice;

    public Product(String productName, BigDecimal buyPrice) {
        this.productName = productName;
        this.buyPrice = buyPrice;
    }

    public String getProductName() {
        return productName;
    }

    public BigDecimal getBuyPrice() {
        return buyPrice;
    }
}
