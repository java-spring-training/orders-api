package order.management.api.domain.entities.object;

import java.util.Date;
import java.util.List;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import order.management.api.domain.value.object.CustomerNumber;
import order.management.api.domain.value.object.OrderNumber;

import org.springframework.format.annotation.DateTimeFormat;

/**
 * Order
 */
public class Order {
    @NotNull
    private OrderNumber orderNumber;

    @NotNull
    @DateTimeFormat
    private Date orderDate;

    @NotNull
    @DateTimeFormat
    private Date requiredDate;

    @DateTimeFormat
    private Date shippedDate;

    @NotEmpty
    private String status;

    private String comments;

    @NotNull
    private CustomerNumber customerNumber;

    private List<OrderDetail> orderDetails;
    private Customer customer;

    public Order(@NotNull OrderNumber orderNumber, @NotNull Date orderDate, @NotNull Date requiredDate, Date shippedDate,
            @NotEmpty String status, String comments, @NotNull CustomerNumber customerNumber) {
        this.orderNumber = orderNumber;
        this.orderDate = orderDate;
        this.requiredDate = requiredDate;
        this.shippedDate = shippedDate;
        this.status = status;
        this.comments = comments;
        this.customerNumber = customerNumber;
    }

    public OrderNumber getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(OrderNumber orderNumber) {
        this.orderNumber = orderNumber;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public Date getRequiredDate() {
        return requiredDate;
    }

    public void setRequiredDate(Date requiredDate) {
        this.requiredDate = requiredDate;
    }

    public Date getShippedDate() {
        return shippedDate;
    }

    public void setShippedDate(Date shippedDate) {
        this.shippedDate = shippedDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public CustomerNumber getCustomerNumber() {
        return customerNumber;
    }

    public void setCustomerNumber(CustomerNumber customerNumber) {
        this.customerNumber = customerNumber;
    }

    public List<OrderDetail> getOrderDetails() {
        return orderDetails;
    }

    public void setOrderDetails(List<OrderDetail> orderDetails) {
        this.orderDetails = orderDetails;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}