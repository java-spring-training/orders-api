package order.management.api.controller;

import java.math.BigDecimal;
import java.util.Date;

public class OrderResult {

    private int orderNumber;
    private Date orderDate;
    private String status;
    private String productName;
    private BigDecimal buyPrice;
    private String customerName;
    private String phone;
    private String country;
    private String employeeEmail;

    public OrderResult(int orderNumber, Date orderDate, String status, String productName, BigDecimal buyPrice,
            String customerName, String phone, String country, String employeeEmail) {
        this.orderNumber = orderNumber;
        this.orderDate = orderDate;
        this.status = status;
        this.productName = productName;
        this.buyPrice = buyPrice;
        this.customerName = customerName;
        this.phone = phone;
        this.country = country;
        this.employeeEmail = employeeEmail;
    }

    public int getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(int orderNumber) {
        this.orderNumber = orderNumber;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public BigDecimal getBuyPrice() {
        return buyPrice;
    }

    public void setBuyPrice(BigDecimal buyPrice) {
        this.buyPrice = buyPrice;
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
}
