package api.repository;

import api.controller.OrderRequestBody;
import api.domain.entities.object.Order;
import api.domain.entities.object.OrderDetail;
import api.domain.values.object.OrderID;
import org.springframework.stereotype.Component;

@Component
public class OrderFactory {
    public Order toOrder(OrderRequestBody orderRequestBody) {
        OrderDetail orderDetail = new OrderDetail(
                orderRequestBody.getQuanlityOrdered(),
                orderRequestBody.getPriceEach(),
                orderRequestBody.getOrderLineNumber());
        Order order = new Order(new OrderID(orderRequestBody.getOrderId()), orderRequestBody.getOrderDate(),
                orderRequestBody.getRequiredDate(),
                orderRequestBody.getShippedDate(),
                orderRequestBody.getStatus(),
                orderRequestBody.getComments(),
                orderRequestBody.getCustomerNumber(),
                orderDetail);

        return order;
    }
}
