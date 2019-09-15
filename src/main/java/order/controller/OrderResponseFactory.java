package order.controller;

import order.controller.results.object.*;
import order.domain.entities.object.Order;
import order.domain.entities.object.OrderDetail;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class OrderResponseFactory {

    public OrderResponse toOrderResponse(List<Order> orderList) {

        return new OrderResponse(toListOrderResult(orderList));
    }

    public List<OrderResult> toListOrderResult (List<Order> orderList) {

        return orderList.stream().map(this::toOrderResult).collect(Collectors.toList());
    }

    private OrderResult toOrderResult(Order order) {
        List<OrderDetailResult> orderDetailResultList = new ArrayList<>();
        for(OrderDetail orderDetail: order.getOrderDetailList()) {
            ProductResult productResult = new ProductResult(
                    orderDetail.getProduct().getProductCode().value()
                    , orderDetail.getProduct().getProductName()
                    , orderDetail.getProduct().getBuyPrice()
            );

            OrderDetailResult orderDetailResult = new OrderDetailResult(
                    orderDetail.getQuantityOrdered()
                    , orderDetail.getPriceEach()
                    , orderDetail.getOrderLineNumber()
                    , productResult
            );

            orderDetailResultList.add(orderDetailResult);
        }

        EmployeeResult employeeResult = new EmployeeResult(order.getCustomer().getEmployee().getEmail());

        CustomerResult customerResult = new CustomerResult(
                order.getCustomer().getCustomerName()
                , order.getCustomer().getPhone()
                , order.getCustomer().getCity()
                , order.getCustomer().getCountry()
                , employeeResult
        );

        OrderResult orderResult = new OrderResult(
                order.getOrderNumber().value()
                , order.getOrderDate()
                , order.getStatus()
                , customerResult
        );

        orderResult.setOrderDetailResultList(orderDetailResultList);

        return orderResult;
    }
}
