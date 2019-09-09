package order.management.api.controller;

import java.util.List;

public class OrderResult {

    private Integer orderNumber;
    private String orderDate;
    private String status;
    private String customerName;
    private String phone;
    private String country;
    private String employeeEmail;
    private List<OrderDetailResult> orderDetailResults;

    public OrderResult(Integer orderNumber, String orderDate, String status, String customerName, String phone,
            String country, String employeeEmail, List<OrderDetailResult> orderDetailResults) {
        this.orderNumber = orderNumber;
        this.orderDate = orderDate;
        this.status = status;
        this.customerName = customerName;
        this.phone = phone;
        this.country = country;
        this.employeeEmail = employeeEmail;
        this.orderDetailResults = orderDetailResults;
    }

    public Integer getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(Integer orderNumber) {
        this.orderNumber = orderNumber;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
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

    public String getEmployeeEmail() {
        return employeeEmail;
    }

    public void setEmployeeEmail(String employeeEmail) {
        this.employeeEmail = employeeEmail;
    }

    public List<OrderDetailResult> getOrderDetailResults() {
        return orderDetailResults;
    }

    public void setOrderDetailResults(List<OrderDetailResult> orderDetailResults) {
        this.orderDetailResults = orderDetailResults;
    }
}
