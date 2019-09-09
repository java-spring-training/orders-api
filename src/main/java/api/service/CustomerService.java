package api.service;

import api.domain.CustomerRepository;
import api.domain.EmployeeRepository;
import api.domain.entities.object.Customers;
import api.exception.DataNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

@Service
public class CustomerService {

    private CustomerRepository customerRepository;
    private EmployeeRepository employeeRepository;

    @Autowired
    public CustomerService(final CustomerRepository customerRepository,
               final EmployeeRepository employeeRepository) {

        this.customerRepository = customerRepository;
        this.employeeRepository = employeeRepository;
    }

    public void addCustomer(final Customers customers) throws DataNotFoundException {

        if (customerRepository.isExisted(customers.getCustomerNumber().getCustomerNumber())) {
            throw new DataNotFoundException("Customer number is existed");
        }

        if (!ObjectUtils.isEmpty(customers.getSalesRepEmployeeNumber())) {
            if (!employeeRepository.isExisted(customers.getSalesRepEmployeeNumber())) {
                throw new DataNotFoundException("Employee number is not existed");
            }
        }

        customerRepository.addCustomer(customers);
    }
}
