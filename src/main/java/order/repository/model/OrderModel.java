package order.repository.model;

import java.util.Date;
import java.util.List;

public class OrderModel {
    private Integer orderNumber;
    private Date orderDate;
    private Date requiredDate;
    private Date shippedDate;
    private String status;
    private String comments;
    private Integer customerNumber;
    private List<OrderDetailModel> orderDetailModelList;
    private CustomerModel customerModel;

    public OrderModel(Integer orderNumber, Date orderDate, Date requiredDate, Date shippedDate, String status, String comments, Integer customerNumber) {
        this.orderNumber = orderNumber;
        this.orderDate = orderDate;
        this.requiredDate = requiredDate;
        this.shippedDate = shippedDate;
        this.status = status;
        this.comments = comments;
        this.customerNumber = customerNumber;
    }

    public Integer getOrderNumber() {
        return orderNumber;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public Date getRequiredDate() {
        return requiredDate;
    }

    public Date getShippedDate() {
        return shippedDate;
    }

    public String getStatus() {
        return status;
    }

    public String getComments() {
        return comments;
    }

    public Integer getCustomerNumber() {
        return customerNumber;
    }

    public void setOrderDetailModelList(List<OrderDetailModel> orderDetailModelList) {
        this.orderDetailModelList = orderDetailModelList;
    }

    public List<OrderDetailModel> getOrderDetailModelList(){
        return this.orderDetailModelList;
    }

    public void setCustomerModel(CustomerModel customerModel) {
        this.customerModel = customerModel;
    }

    public CustomerModel getCustomerModel() {
        return customerModel;
    }
}
