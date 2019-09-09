package dev.pdhau.ordermanagementapi.domain.entities.object;

import dev.pdhau.ordermanagementapi.domain.value.object.OrderNumberObject;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderDetail {

    private OrderNumberObject orderNumber;

    private String productCode;

    private Integer quantityOrdered;

    private Float priceEach;

    private Integer orderLineNumber;
}
