package order.management.api.domain.entities.object;

import java.math.BigDecimal;

import javax.validation.constraints.NotNull;

import order.management.api.domain.value.object.OrderNumber;
import order.management.api.domain.value.object.ProductCode;

/**
 * OrderDetail
 */
public class OrderDetail {
    @NotNull
    private OrderNumber orderNumber;

    @NotNull
    private ProductCode productCode;

    @NotNull
    private int quantityOrdered;

    @NotNull
    private BigDecimal priceEach;

    private Product product;

    public OrderDetail(@NotNull OrderNumber orderNumber, @NotNull ProductCode productCode, @NotNull int quantityOrdered,
            @NotNull BigDecimal priceEach) {
        this.orderNumber = orderNumber;
        this.productCode = productCode;
        this.quantityOrdered = quantityOrdered;
        this.priceEach = priceEach;
    }

    public OrderNumber getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(OrderNumber orderNumber) {
        this.orderNumber = orderNumber;
    }

    public ProductCode getProductCode() {
        return productCode;
    }

    public void setProductCode(ProductCode productCode) {
        this.productCode = productCode;
    }

    public int getQuantityOrdered() {
        return quantityOrdered;
    }

    public void setQuantityOrdered(int quantityOrdered) {
        this.quantityOrdered = quantityOrdered;
    }

    public BigDecimal getPriceEach() {
        return priceEach;
    }

    public void setPriceEach(BigDecimal priceEach) {
        this.priceEach = priceEach;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}