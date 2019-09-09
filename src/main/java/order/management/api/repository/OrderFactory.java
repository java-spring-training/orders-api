package order.management.api.repository;

import order.management.api.domain.entities.object.Order;
import order.management.api.domain.value.object.CustomerNumber;
import order.management.api.domain.value.object.OrderNumber;
import order.management.api.repository.mapper.OrderModel;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class OrderFactory {
    public List<Order> toListOrder(List<OrderModel> orderModelList) {

        return orderModelList.stream().map(this::toOrder).collect(Collectors.toList());
    }

    public Order toOrder(OrderModel orderModel) {

        OrderNumber orderNumber = new OrderNumber(orderModel.getOrderNumber());
        CustomerNumber customerNumber = new CustomerNumber(orderModel.getCustomerNumber());

        return new Order(orderNumber, orderModel.getOrderDate(), orderModel.getRequiredDate(),
                orderModel.getShippedDate(), orderModel.getStatus(), orderModel.getComments(),
                customerNumber);
    }
}
