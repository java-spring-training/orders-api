package api.controller;

import api.domain.entities.object.Customers;
import api.domain.value.object.CustomerNumber;
import org.springframework.stereotype.Component;

@Component
public class CustomerRequestFactory {

    public Customers toCustomers(CustomerRequestBody requestBody) {

        final CustomerNumber customerNumber = new CustomerNumber(requestBody.getCustomerNumber());

        return new Customers(customerNumber, requestBody.getCustomerName(), requestBody.getContactLastName(),
                requestBody.getContactFirstName(), requestBody.getPhone(), requestBody.getAddressLine1(),
                requestBody.getAddressLine2(), requestBody.getCity(), requestBody.getState(),
                requestBody.getPostalCode(), requestBody.getCountry(), requestBody.getSalesRepEmployeeNumber(),
                requestBody.getCreditLimit());
    }
}
