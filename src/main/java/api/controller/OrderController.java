package api.controller;

import api.config.ApiConfig;
import api.domain.entities.object.OrderDetail;
import api.exception.DBException;
import api.exception.ParameterInvalidException;
import api.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class OrderController {

    private OrderService orderService;
    private OrderResponseFactory orderResponseFactory;

    @Autowired
    public OrderController(OrderService orderService, OrderResponseFactory orderResponseFactory) {
        this.orderService = orderService;
        this.orderResponseFactory = orderResponseFactory;
    }

    @GetMapping(ApiConfig.LIST_ORDER_BY_CUSTOMER_URL)
    public OrderResponse ordersByCustomerNumber(
            @Valid @ModelAttribute OrderModelAttribute orderModelAttribute,
            BindingResult bindingResult) throws ParameterInvalidException, DBException {

        if (bindingResult.hasErrors()) {
            throw new ParameterInvalidException(getErrorMessage(bindingResult));
        }

        List<OrderDetail> orderList = orderService.getOrdersByCustomer(orderModelAttribute.getCustomerNumber());
        return orderResponseFactory.toOrderResponse(orderList);
    }

    private String getErrorMessage(BindingResult bindingResult) {

        StringBuilder message = new StringBuilder();
        bindingResult.getFieldErrors().forEach(fieldError -> message
                .append(fieldError.getField())
                .append(fieldError.getDefaultMessage()));
        return message.toString();
    }
}
