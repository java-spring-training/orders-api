package order.management.api.repository.mapper;

import java.math.BigDecimal;
import java.util.Date;

public class OrderModel {

    private int orderNumber;
    private Date orderDate;
    private String status;
    private String productCode;
    private String productName;
    private BigDecimal buyPrice;
    private int quantityOrdered;
    private int customerNumber;
    private String customerName;
    private String phone;
    private String country;
    private int salesRepEmployeeNumber;
    private String employeeEmail;

    public OrderModel(int orderNumber, Date orderDate, String status, String productCode, String productName,
            BigDecimal buyPrice, int quantityOrdered, int customerNumber, String customerName, String phone,
            String country, int salesRepEmployeeNumber, String employeeEmail) {
        this.orderNumber = orderNumber;
        this.orderDate = orderDate;
        this.status = status;
        this.productCode = productCode;
        this.productName = productName;
        this.buyPrice = buyPrice;
        this.quantityOrdered = quantityOrdered;
        this.customerNumber = customerNumber;
        this.customerName = customerName;
        this.phone = phone;
        this.country = country;
        this.salesRepEmployeeNumber = salesRepEmployeeNumber;
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

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
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

    public int getQuantityOrdered() {
        return quantityOrdered;
    }

    public void setQuantityOrdered(int quantityOrdered) {
        this.quantityOrdered = quantityOrdered;
    }

    public int getCustomerNumber() {
        return customerNumber;
    }

    public void setCustomerNumber(int customerNumber) {
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

    public int getSalesRepEmployeeNumber() {
        return salesRepEmployeeNumber;
    }

    public void setSalesRepEmployeeNumber(int salesRepEmployeeNumber) {
        this.salesRepEmployeeNumber = salesRepEmployeeNumber;
    }

    public String getEmployeeEmail() {
        return employeeEmail;
    }

    public void setEmployeeEmail(String employeeEmail) {
        this.employeeEmail = employeeEmail;
    }
}
