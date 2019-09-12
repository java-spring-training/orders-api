package order.repository.model;

import java.math.BigDecimal;

public class OrderDetailModel {
    private Integer orderNumber;
    private String productCode;
    private Integer quantityOrdered;
    private BigDecimal priceEach;
    private Integer orderLineNumber;
    private ProductModel productModel;
    private OrderModel orderModel;

    public OrderDetailModel(Integer orderNumber, String productCode, Integer quantityOrdered, BigDecimal priceEach, Integer orderLineNumber) {
        this.orderNumber = orderNumber;
        this.productCode = productCode;
        this.quantityOrdered = quantityOrdered;
        this.priceEach = priceEach;
        this.orderLineNumber = orderLineNumber;
    }

    public Integer getOrderNumber() {
        return orderNumber;
    }

    public String getProductCode() {
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

    public ProductModel getProductModel() {
        return productModel;
    }

    public OrderModel getOrderModel() {
        return orderModel;
    }

    public void setProductModel(ProductModel productModel) {
        this.productModel = productModel;
    }

    public void setOrderModel(OrderModel orderModel) {
        this.orderModel = orderModel;
    }
}
