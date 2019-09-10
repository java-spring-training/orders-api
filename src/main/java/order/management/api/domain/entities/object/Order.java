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

    @NotEmpty
    private String status;

    private CustomerNumber customerNumber;

    private OrderDetail orderDetail;
    private Customer customer;

    public Order(@NotNull OrderNumber orderNumber, @NotNull Date orderDate, @NotEmpty String status,
            CustomerNumber customerNumber) {
        this.orderNumber = orderNumber;
        this.orderDate = orderDate;
        this.status = status;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public CustomerNumber getCustomerNumber() {
        return customerNumber;
    }

    public void setCustomerNumber(CustomerNumber customerNumber) {
        this.customerNumber = customerNumber;
    }

    public OrderDetail getOrderDetail() {
        return orderDetail;
    }

    public void setOrderDetail(OrderDetail orderDetail) {
        this.orderDetail = orderDetail;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}