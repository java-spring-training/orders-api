package dev.pdhau.ordermanagementapi.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import dev.pdhau.ordermanagementapi.exception.AddOrderFailedException;
import dev.pdhau.ordermanagementapi.exception.ParameterInvalidException;
import dev.pdhau.ordermanagementapi.request.model.OrderRequest;
import dev.pdhau.ordermanagementapi.response.AddOrderResponse;
import dev.pdhau.ordermanagementapi.response.ErrorDetail;
import dev.pdhau.ordermanagementapi.service.OrderService;

@ControllerAdvice
@RestController
public class OrderController {

    private OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping("/api/v1/order/add")
    public AddOrderResponse add(@Valid @RequestBody OrderRequest order,
            BindingResult bindingResult) 
            throws ParameterInvalidException, AddOrderFailedException {
        if (bindingResult.hasErrors()) {
            ParameterInvalidException exception = new ParameterInvalidException("Validate error");
            exception.setErrorDetails(getErrorDetails(bindingResult));
            throw exception;
        }

        if (!orderService.add(order)) {
            AddOrderFailedException exception = new AddOrderFailedException("Error occur when adding order");
            exception.setErrorDetails(new ArrayList<>());
            throw exception;
        }

        return new AddOrderResponse();
    }

    private List<ErrorDetail> getErrorDetails(BindingResult bindingResult) {
        List<ErrorDetail> errorDetails = new ArrayList<>();
        bindingResult.getFieldErrors().forEach(fieldError -> {
            errorDetails.add(new ErrorDetail(fieldError.getField(), fieldError.getDefaultMessage()));
        });
        return errorDetails;
    }
}
