package order.controller.results.object;

import com.fasterxml.jackson.annotation.JsonGetter;
import java.util.Date;
import java.util.List;

public class OrderResult {
    private int orderNumber;
    private Date orderDate;
    private String status;
    private CustomerResult customerResult;
    private List<OrderDetailResult> orderDetailResultList;

    public OrderResult(int orderNumber, Date orderDate, String status, CustomerResult customerResult) {
        this.orderNumber = orderNumber;
        this.orderDate = orderDate;
        this.status = status;
        this.customerResult = customerResult;
    }

    public int getOrderNumber() {
        return orderNumber;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public String getStatus() {
        return status;
    }

    @JsonGetter("customer")
    public CustomerResult getCustomerResult() {
        return customerResult;
    }

    public void setOrderDetailResultList(List<OrderDetailResult> orderDetailResultList) {
        this.orderDetailResultList = orderDetailResultList;
    }

    @JsonGetter("orderDetail")
    public List<OrderDetailResult> getOrderDetailResultList() {
        return orderDetailResultList;
    }
}