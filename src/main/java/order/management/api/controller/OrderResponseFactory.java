package order.management.api.controller;

import order.management.api.domain.entities.object.Order;

import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.Date;
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

        int orderNumber = order.getOrderNumber().getNumber();
        Date orderDate = order.getOrderDate();
        String status = order.getStatus();
        String productName = order.getOrderDetail().getProduct().getProductName();
        BigDecimal buyPrice = order.getOrderDetail().getPriceEach();
        String customerName = order.getCustomer().getCustomerName();
        String phone = order.getCustomer().getPhone();
        String country = order.getCustomer().getCountry();
        String employeeEmail = order.getCustomer().getSalesRepEmployee().getEmail();

        return new OrderResult(orderNumber, orderDate, status, productName, buyPrice, customerName, phone, country,
                employeeEmail);
    }
}
