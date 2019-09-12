package order.controller;

import order.config.ApiConfig;
import order.domain.entities.object.Order;
import order.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class OrderController {
    final static String API_GET_ORDERS = "/api/v1/orders";

    private OrderService orderService;
    private OrderResponseFactory factory;
    private ApiConfig apiConfig;

    @Autowired
    public OrderController(OrderService orderService,
                           OrderResponseFactory factory,
                           ApiConfig apiConfig) {
        this.orderService = orderService;
        this.factory = factory;
        this.apiConfig = apiConfig;
    }

    @GetMapping(API_GET_ORDERS)
    public OrderResponse listAllOrder() {
        List<Order> orderList = orderService.getAll();
        return factory.toOrderResponse(orderList);
    }
}
