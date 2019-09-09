package api.controller;

import api.domain.entities.object.Customers;
import api.domain.value.object.CustomerNumber;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;
import java.math.BigDecimal;

@Component
public class CustomerRequestFactory {

    public Customers toCustomers(CustomerRequestBody requestBody) {

        final CustomerNumber customerNumber = new CustomerNumber(Integer.parseInt(requestBody.getCustomerNumber()));
        BigDecimal creditLimit = null;
        if (!ObjectUtils.isEmpty(requestBody.getCreditLimit())) {
            creditLimit = new BigDecimal(requestBody.getCreditLimit());
        }

        Integer salesRepEmployeeNumber = null;
        if (!ObjectUtils.isEmpty(requestBody.getSalesRepEmployeeNumber())) {
            salesRepEmployeeNumber = Integer.parseInt(requestBody.getSalesRepEmployeeNumber());
        }

        return new Customers(customerNumber, requestBody.getCustomerName(), requestBody.getContactLastName(),
                requestBody.getContactFirstName(), requestBody.getPhone(), requestBody.getAddressLine1(),
                requestBody.getAddressLine2(), requestBody.getCity(), requestBody.getState(),
                requestBody.getPostalCode(), requestBody.getCountry(), salesRepEmployeeNumber, creditLimit);
    }
}
