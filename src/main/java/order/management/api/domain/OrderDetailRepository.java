package order.management.api.domain;

import order.management.api.domain.entities.object.OrderDetail;
import order.management.api.domain.value.object.OrderNumber;

import java.util.List;

public interface OrderDetailRepository {
    List<OrderDetail> getOrderDetailByOrderNumber(OrderNumber orderNumber);
}
