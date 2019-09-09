package order.management.api.repository;

import order.management.api.domain.entities.object.Customer;
import order.management.api.domain.value.object.CustomerNumber;
import order.management.api.domain.value.object.EmployeeNumber;
import order.management.api.repository.mapper.CustomerModel;

import java.math.BigDecimal;

import org.springframework.stereotype.Component;

@Component
public class CustomerFactory {
    public Customer toCustomer(CustomerModel customerModel) {

        CustomerNumber customerNumber = new CustomerNumber(customerModel.getCustomerNumber());
        String customerName = customerModel.getCustomerName();
        String contactLastName = customerModel.getContactLastName();
        String contactFirstName = customerModel.getContactFirstName();
        String phone = customerModel.getPhone();
        String addressLine1 = customerModel.getAddressLine1();
        String addressLine2 = customerModel.getAddressLine2();
        String city = customerModel.getCity();
        String state = customerModel.getState();
        String postalCode = customerModel.getPostalCode();
        String country = customerModel.getCountry();
        EmployeeNumber salesRepEmployeeNumber = new EmployeeNumber(customerModel.getSalesRepEmployeeNumber());
        BigDecimal creditLimit = customerModel.getCreditLimit();

        return new Customer(customerNumber, customerName, contactLastName, contactFirstName, phone, addressLine1,
                addressLine2, city, state, postalCode, country, salesRepEmployeeNumber, creditLimit);
    }
}
