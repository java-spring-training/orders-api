package order.management.api.controller;

import javax.validation.constraints.*;

public class OrderModelAttribute {

    @NotNull
    @Min(value = 0)
    private Integer orderNumber;

    public Integer getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(Integer orderNumber) {
        this.orderNumber = orderNumber;
    }
}
