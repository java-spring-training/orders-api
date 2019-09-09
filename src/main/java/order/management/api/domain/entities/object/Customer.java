package order.management.api.domain.entities.object;

import order.management.api.domain.value.object.CustomerNumber;
import order.management.api.domain.value.object.EmployeeNumber;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

public class Customer {
    @NotNull
    private CustomerNumber customerNumber;

    @NotEmpty
    private String customerName;

    @NotEmpty
    private String contactLastName;

    @NotEmpty
    private String contactFirstName;

    @NotEmpty
    private String phone;

    @NotEmpty
    private String addressLine1;

    private String addressLine2;

    @NotEmpty
    private String city;

    private String state;

    private String postalCode;

    @NotEmpty
    private String country;

    @NotNull
    private EmployeeNumber salesRepEmployeeNumber;

    private BigDecimal creditLimit;

    private Employee salesRepEmployee;

    public Customer(@NotNull CustomerNumber customerNumber, @NotEmpty String customerName, @NotEmpty String contactLastName, @NotEmpty String contactFirstName, @NotEmpty String phone, @NotEmpty String addressLine1, String addressLine2, @NotEmpty String city, String state, String postalCode, @NotEmpty String country, @NotNull EmployeeNumber salesRepEmployeeNumber, BigDecimal creditLimit) {
        this.customerNumber = customerNumber;
        this.customerName = customerName;
        this.contactLastName = contactLastName;
        this.contactFirstName = contactFirstName;
        this.phone = phone;
        this.addressLine1 = addressLine1;
        this.addressLine2 = addressLine2;
        this.city = city;
        this.state = state;
        this.postalCode = postalCode;
        this.country = country;
        this.salesRepEmployeeNumber = salesRepEmployeeNumber;
        this.creditLimit = creditLimit;
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

    public String getContactLastName() {
        return contactLastName;
    }

    public void setContactLastName(String contactLastName) {
        this.contactLastName = contactLastName;
    }

    public String getContactFirstName() {
        return contactFirstName;
    }

    public void setContactFirstName(String contactFirstName) {
        this.contactFirstName = contactFirstName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddressLine1() {
        return addressLine1;
    }

    public void setAddressLine1(String addressLine1) {
        this.addressLine1 = addressLine1;
    }

    public String getAddressLine2() {
        return addressLine2;
    }

    public void setAddressLine2(String addressLine2) {
        this.addressLine2 = addressLine2;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
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

    public BigDecimal getCreditLimit() {
        return creditLimit;
    }

    public void setCreditLimit(BigDecimal creditLimit) {
        this.creditLimit = creditLimit;
    }

    public Employee getSalesRepEmployee() {
        return salesRepEmployee;
    }

    public void setSalesRepEmployee(Employee salesRepEmployee) {
        this.salesRepEmployee = salesRepEmployee;
    }
}
