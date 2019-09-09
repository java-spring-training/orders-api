package order.management.api.controller;

import java.math.BigDecimal;

/**
 * OrderDetailResult
 */
public class OrderDetailResult {
    private String productName;
    private BigDecimal buyPrice;

    public OrderDetailResult(String productName, BigDecimal buyPrice) {
        this.productName = productName;
        this.buyPrice = buyPrice;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public BigDecimal getBuyPrice() {
        return buyPrice;
    }

    public void setBuyPrice(BigDecimal buyPrice) {
        this.buyPrice = buyPrice;
    }
}