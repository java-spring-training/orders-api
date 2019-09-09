package order.management.api.domain;

import order.management.api.domain.entities.object.Order;
import order.management.api.domain.value.object.OrderNumber;

public interface OrderRepository {
    Order getOrderByOrderNumber(OrderNumber orderNumber);
}
