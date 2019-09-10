package order.management.api.domain.entities.object;

import order.management.api.domain.value.object.CustomerNumber;
import order.management.api.domain.value.object.EmployeeNumber;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class Customer {

    @NotNull
    private CustomerNumber customerNumber;

    @NotEmpty
    private String customerName;

    @NotEmpty
    private String phone;

    @NotEmpty
    private String country;

    @NotNull
    private EmployeeNumber salesRepEmployeeNumber;

    private Employee salesRepEmployee;

    public Customer(@NotNull CustomerNumber customerNumber, @NotEmpty String customerName, @NotEmpty String phone,
            @NotEmpty String country, @NotNull EmployeeNumber salesRepEmployeeNumber) {
        this.customerNumber = customerNumber;
        this.customerName = customerName;
        this.phone = phone;
        this.country = country;
        this.salesRepEmployeeNumber = salesRepEmployeeNumber;
    }

    public CustomerNumber getCustomerNumber() {
        return customerNumber;
    }

    public void setCustomerNumber(CustomerNumber customerNumber) {
        this.customerNumber = customerNumber;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public EmployeeNumber getSalesRepEmployeeNumber() {
        return salesRepEmployeeNumber;
    }

    public void setSalesRepEmployeeNumber(EmployeeNumber salesRepEmployeeNumber) {
        this.salesRepEmployeeNumber = salesRepEmployeeNumber;
    }

    public Employee getSalesRepEmployee() {
        return salesRepEmployee;
    }

    public void setSalesRepEmployee(Employee salesRepEmployee) {
        this.salesRepEmployee = salesRepEmployee;
    }
}
