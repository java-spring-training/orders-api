package order.controller.results.object;

import com.fasterxml.jackson.annotation.JsonGetter;

public class CustomerResult {
    private String customerName;
    private String phone;
    private String city;
    private String country;
    private EmployeeResult employeeResult;

    public CustomerResult(String customerName, String phone, String city, String country, EmployeeResult employeeResult) {
        this.customerName = customerName;
        this.phone = phone;
        this.city = city;
        this.country = country;
        this.employeeResult = employeeResult;
    }

    public String getCustomerName() {
        return customerName;
    }

    public String getPhone() {
        return phone;
    }

    public String getCity() {
        return city;
    }

    public String getCountry() {
        return country;
    }

    @JsonGetter("employee")
    public EmployeeResult getEmployeeResult() {
        return employeeResult;
    }
}