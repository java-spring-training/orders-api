package dev.pdhau.ordermanagementapi.domain.entities.object;

import java.util.List;

import dev.pdhau.ordermanagementapi.domain.value.object.CustomerNumberObject;
import dev.pdhau.ordermanagementapi.domain.value.object.OrderNumberObject;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Order {

    private OrderNumberObject orderNumber;

    private String orderDate;

    private String requiredDate;

    private String shippedDate;

    private String status;

    private String comments;

    private CustomerNumberObject customerNumber;

    private List<OrderDetail> orderDetails;
}
