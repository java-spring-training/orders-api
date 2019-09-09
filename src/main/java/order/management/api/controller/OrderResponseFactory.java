package order.management.api.controller;

import order.management.api.domain.entities.object.Order;
import order.management.api.domain.entities.object.OrderDetail;

import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class OrderResponseFactory {

    public OrderResponse toOrderResponse(List<Order> ordersList) {

        return new OrderResponse(toListOrderResult(ordersList));
    }

    public List<OrderResult> toListOrderResult(List<Order> ordersList) {

        return ordersList.stream().map(this::toOrderResult).collect(Collectors.toList());
    }

    private OrderResult toOrderResult(Order order) {

        Integer orderNumber = order.getOrderNumber().getNumber();
        String orderDate = order.getOrderDate().toString();
        String status = order.getStatus();
        List<OrderDetailResult> orderDetailResults = toOrderDetailResultList(order);
        String customerName = order.getCustomer().getCustomerName();
        String phone = order.getCustomer().getPhone();
        String country = order.getCustomer().getCountry();
        String employeeEmail = order.getCustomer().getSalesRepEmployee().getEmail();

        return new OrderResult(orderNumber, orderDate, status, customerName, phone, country, employeeEmail,
                orderDetailResults);
    }

    private List<OrderDetailResult> toOrderDetailResultList(Order order) {
        return order.getOrderDetails().stream().map(this::toOrderDetailResult).collect(Collectors.toList());
    }

    private OrderDetailResult toOrderDetailResult(OrderDetail orderDetail) {

        String productName = orderDetail.getProduct().getProductName();
        BigDecimal buyPrice = orderDetail.getPriceEach();

        return new OrderDetailResult(productName, buyPrice);
    }
}
