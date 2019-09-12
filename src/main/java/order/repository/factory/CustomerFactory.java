package order.repository.factory;

import order.domain.entities.object.Customer;
import order.domain.entities.object.Employee;
import order.domain.value.object.CustomerNumber;
import order.repository.model.CustomerModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CustomerFactory {

    @Autowired
    private EmployeeFactory employeeFactory;

    public Customer toCustomer(CustomerModel customerModel) {

        CustomerNumber customerNumber = new CustomerNumber(customerModel.getCustomerNumber());
        Employee employee = employeeFactory.toEmployee(customerModel.getEmployeeModel());

        return new Customer(
                customerNumber
                , customerModel.getCustomerName()
                , customerModel.getContactLastName()
                , customerModel.getContactFirstName()
                , customerModel.getPhone()
                , customerModel.getAddressLine1()
                , customerModel.getAddressLine2()
                , customerModel.getCity()
                , customerModel.getState()
                , customerModel.getPostalCode()
                , customerModel.getCountry()
                , employee
                , customerModel.getCreditLimit()
        );
    }
}