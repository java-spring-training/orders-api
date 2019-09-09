package api.controller;

import api.config.ApiConfig;
import api.domain.entities.object.Customers;
import api.exception.DataNotFoundException;
import api.exception.ParameterInvalidException;
import api.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class CustomerController {

    private static final String DELIMITER = ", ";

    private CustomerService customerService;
    private CustomerRequestFactory factory;

    @Autowired
    public CustomerController(final CustomerService customerService, final CustomerRequestFactory factory) {

        this.customerService = customerService;
        this.factory = factory;
    }

    @PostMapping(ApiConfig.ADD_CUSTOMER_URL)
    public CustomerResponse addCustomer(final @Valid @RequestBody CustomerRequestBody requestBody,
                final BindingResult bindingResult) throws ParameterInvalidException, DataNotFoundException {

        if(bindingResult.hasErrors()) {
            throw new ParameterInvalidException(getErrorMessage(bindingResult));
        }

        final Customers customers = factory.toCustomers(requestBody);
        customerService.addCustomer(customers);
        return new CustomerResponse(HttpStatus.OK.value());
    }

    private String getErrorMessage(BindingResult bindingResult) {

        final StringBuilder message = new StringBuilder();
        bindingResult.getFieldErrors().forEach(fieldError -> message
                .append(fieldError.getDefaultMessage())
                .append(DELIMITER));
        message.setLength(message.length() - 2);
        return message.toString();
    }
}
