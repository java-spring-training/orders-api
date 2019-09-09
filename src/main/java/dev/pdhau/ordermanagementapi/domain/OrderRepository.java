package dev.pdhau.ordermanagementapi.domain;

import dev.pdhau.ordermanagementapi.domain.entities.object.Order;

public interface OrderRepository {

    public boolean add(Order order);
}
