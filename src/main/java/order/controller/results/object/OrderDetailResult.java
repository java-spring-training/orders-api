package order.controller.results.object;

import com.fasterxml.jackson.annotation.JsonGetter;
import java.math.BigDecimal;

public class OrderDetailResult {
    private int quantityOrdered;
    private BigDecimal priceEach;
    private int orderLineNumber;
    private ProductResult productResult;

    public OrderDetailResult(int quantityOrdered, BigDecimal priceEach, int orderLineNumber, ProductResult productResult) {
        this.quantityOrdered = quantityOrdered;
        this.priceEach = priceEach;
        this.orderLineNumber = orderLineNumber;
        this.productResult = productResult;
    }

    public int getQuantityOrdered() {
        return quantityOrdered;
    }

    public BigDecimal getPriceEach() {
        return priceEach;
    }

    public int getOrderLineNumber() {
        return orderLineNumber;
    }

    @JsonGetter("product")
    public ProductResult getProductResult() {
        return productResult;
    }
}