package api.controller;

import api.domain.entities.object.Order;
import api.domain.entities.object.OrderDetail;
import api.exception.ApiException;
import api.exception.ParameterInvalidException;
import api.repository.OrderFactory;
import api.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class EditController {

    private OrderService orderService;
    private OrderFactory factory;
    @Autowired
    public EditController(OrderService orderService, OrderFactory orderFactory) {
        this.orderService = orderService;
        this.factory = orderFactory;
    }

    @PostMapping("/api/v1/order/edit")
    public CustomReponse editOrder(@Valid @RequestBody OrderRequestBody orderRequestBody, BindingResult bindingResult) throws ParameterInvalidException, ApiException {
            if(bindingResult.hasErrors()) {
                throw new ParameterInvalidException(getErrorMessage(bindingResult));
            }
            final Order orderData = factory.toOrder(orderRequestBody);
            orderService.editOrder(orderData, orderRequestBody.getProductCode());
            return new CustomReponse(HttpStatus.OK.value());
    }

    private String getErrorMessage(BindingResult bindingResult) {

        // Create message from BindingResult
        // Ex: 'name': must not be empty
        StringBuilder message = new StringBuilder();
        bindingResult.getFieldErrors().forEach(fieldError -> message
                .append("'")
                .append(fieldError.getField())
                .append("'")
                .append(": ")
                .append(fieldError.getDefaultMessage())
                .append(", "));
        return message.toString();
    }
}
