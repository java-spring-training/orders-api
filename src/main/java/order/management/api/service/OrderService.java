package order.management.api.service;

import order.management.api.domain.OrderRepository;
import order.management.api.domain.entities.object.Order;
import order.management.api.domain.value.object.OrderNumber;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    private OrderRepository orderRepository;

    @Autowired
    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public List<Order> getOrdersByOrderNumber(OrderNumber orderNumber) {

        return orderRepository.getOrdersByOrderNumber(orderNumber);
    }
}
