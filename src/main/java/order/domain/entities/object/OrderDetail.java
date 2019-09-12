package order.domain.entities.object;

import order.domain.value.object.OrderNumber;
import order.domain.value.object.ProductCode;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.math.BigDecimal;

public class OrderDetail {
    @NotNull
    private OrderNumber orderNumber;
    @NotNull
    private ProductCode productCode;
    @Size(min = 1)
    private Integer quantityOrdered;
    private BigDecimal priceEach;
    @NotNull
    private Integer orderLineNumber;

    private Product product;

    /**
     *
     * @param orderNumber
     * @param productCode
     * @param quantityOrdered
     * @param priceEach
     * @param orderLineNumber
     * @param product
     */
    public OrderDetail(@NotNull OrderNumber orderNumber, @NotNull ProductCode productCode, @Size(min = 1) Integer quantityOrdered, BigDecimal priceEach, @NotNull Integer orderLineNumber, Product product) {
        this.orderNumber = orderNumber;
        this.productCode = productCode;
        this.quantityOrdered = quantityOrdered;
        this.priceEach = priceEach;
        this.orderLineNumber = orderLineNumber;
        this.product = product;
    }

    public OrderNumber getOrderNumber() {
        return orderNumber;
    }

    public ProductCode getProductCode() {
        return productCode;
    }

    public Integer getQuantityOrdered() {
        return quantityOrdered;
    }

    public BigDecimal getPriceEach() {
        return priceEach;
    }

    public Integer getOrderLineNumber() {
        return orderLineNumber;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Product getProduct() {
        return product;
    }
}
