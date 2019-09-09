package dev.pdhau.ordermanagementapi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev.pdhau.ordermanagementapi.domain.OrderRepository;
import dev.pdhau.ordermanagementapi.request.model.OrderRequest;

@Service
public class OrderService {

    private OrderRepository orderRepository;

    @Autowired
    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public boolean add(OrderRequest order) {

        return orderRepository.add(order.toDomainEntity());
    }
}
