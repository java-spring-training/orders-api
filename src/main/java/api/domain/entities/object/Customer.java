package api.domain.entities.object;

import api.domain.value.object.CustomerNumber;

public class Customer {
    private CustomerNumber customerNumber;
    private String customerName;
    private String phone;
    private String country;
    private Employee employee;

    public Customer(CustomerNumber customerNumber, String customerName, String phone, String country, Employee employee) {
        this.customerNumber = customerNumber;
        this.customerName = customerName;
        this.phone = phone;
        this.country = country;
        this.employee = employee;
    }

    public String getCustomerName() {
        return customerName;
    }

    public String getPhone() {
        return phone;
    }

    public String getCountry() {
        return country;
    }

    public Employee getEmployee() {
        return employee;
    }
}
