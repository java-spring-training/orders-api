package api.domain.entities.object;

import api.domain.value.object.OrderNumber;

import java.util.Date;

public class Order {
    private OrderNumber orderNumber;
    private Date orderDate;
    private String status;
    private Customer customer;

    public Order(OrderNumber orderNumber, Date orderDate, String status, Customer customer) {
        this.orderNumber = orderNumber;
        this.orderDate = orderDate;
        this.status = status;
        this.customer = customer;
    }

    public OrderNumber getOrderNumber() {
        return orderNumber;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public String getStatus() {
        return status;
    }

    public Customer getCustomer() {
        return customer;
    }
}
