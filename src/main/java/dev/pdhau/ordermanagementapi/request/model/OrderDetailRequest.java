package dev.pdhau.ordermanagementapi.request.model;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import dev.pdhau.ordermanagementapi.domain.entities.object.OrderDetail;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderDetailRequest {

    @NotEmpty(message = "productCode is required")
    @Size(max = 15)
    private String productCode;

    @NotNull(message = "quantityOrdered is required")
    private Integer quantityOrdered;

    @NotNull(message = "priceEach is required")
    private Float priceEach;

    @NotNull(message = "orderLineNumber is required")
    private Integer orderLineNumber;

    public OrderDetail toDomainEntity() {
        OrderDetail orderDetail = new OrderDetail();
        orderDetail.setProductCode(this.getProductCode());
        orderDetail.setQuantityOrdered(this.getQuantityOrdered());
        orderDetail.setPriceEach(this.getPriceEach());
        orderDetail.setOrderLineNumber(this.getOrderLineNumber());

        return orderDetail;
    }
}
