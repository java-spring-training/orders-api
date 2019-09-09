package order.management.api.controller;

import order.management.api.domain.entities.object.Order;
import order.management.api.domain.value.object.OrderNumber;
import order.management.api.exception.ParameterInvalidException;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import order.management.api.service.OrderService;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import java.util.ArrayList;
import java.util.List;

@RestController
public class OrderController {

    private Logger log = Logger.getLogger(ApiErrorHandler.class);

    private OrderService orderService;
    private OrderResponseFactory factory;

    @Autowired
    public OrderController(OrderService orderService, OrderResponseFactory factory) {
        this.orderService = orderService;
        this.factory = factory;
    }

    /**
     * 
     * @param orderModelAttribute
     * @param bindingResult
     * @return
     * @throws ParameterInvalidException
     */
    @GetMapping("/orders")
    public OrderResponse listOrderWithRequestParameters(
            @Valid @ModelAttribute OrderModelAttribute orderModelAttribute,
            BindingResult bindingResult) throws ParameterInvalidException {

        if(bindingResult.hasErrors()) {
            throw new ParameterInvalidException(getErrorMessage(bindingResult));
        }

        log.info("API With Request Parameters");

        OrderNumber orderNumber = new OrderNumber(orderModelAttribute.getOrderNumber());

        Order order = orderService.getOrderByOrderNumber(orderNumber);
        List<Order> ordersList = new ArrayList<>();
        ordersList.add(order);
        return factory.toOrderResponse(ordersList);
    }

    private String getErrorMessage(BindingResult bindingResult) {

        // Create message from BindingResult
        // Ex: 'name': must not be empty
        StringBuilder message = new StringBuilder();
        bindingResult.getFieldErrors().forEach(fieldError -> message.append("'").append(fieldError.getField())
                .append("'").append(": ").append(fieldError.getDefaultMessage()).append(", "));

        return message.toString();
    }
}
