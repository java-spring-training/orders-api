package order.management.api.domain;

import java.util.List;

import order.management.api.domain.entities.object.Order;
import order.management.api.domain.value.object.OrderNumber;

public interface OrderRepository {
    List<Order> getOrdersByOrderNumber(OrderNumber orderNumber);
}
