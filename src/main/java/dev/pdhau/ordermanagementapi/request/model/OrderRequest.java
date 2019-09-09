package dev.pdhau.ordermanagementapi.request.model;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonFormat;

import dev.pdhau.ordermanagementapi.domain.entities.object.Order;
import dev.pdhau.ordermanagementapi.domain.entities.object.OrderDetail;
import dev.pdhau.ordermanagementapi.domain.value.object.CustomerNumberObject;
import dev.pdhau.ordermanagementapi.domain.value.object.OrderNumberObject;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderRequest {

    @NotNull(message = "orderNumber is required")
    @Min(value = 1)
    private Integer orderNumber;

    @NotNull(message = "orderDate is required")
    @JsonFormat(pattern="yyyy-MM-dd")
    private String orderDate;

    @NotNull(message = "requiredDate is required")
    @JsonFormat(pattern="yyyy-MM-dd")
    private String requiredDate;

    @JsonFormat(pattern="yyyy-MM-dd")
    private String shippedDate;

    @NotNull(message = "status is required")
    @Size(max = 15)
    private String status;

    private String comments;

    @NotNull(message = "customerNumber is required")
    private int customerNumber;

    @Valid
    private List<@Valid  OrderDetailRequest> orderDetails = new ArrayList<>();

    public Order toDomainEntity() {
        Order order = new Order();
        order.setOrderNumber(new OrderNumberObject(this.getOrderNumber()));
        order.setOrderDate(this.getOrderDate());
        order.setRequiredDate(this.getRequiredDate());
        order.setShippedDate(this.getShippedDate());
        order.setStatus(this.getStatus());
        order.setComments(this.getComments());
        order.setCustomerNumber(new CustomerNumberObject(this.getCustomerNumber()));
        List<OrderDetail> orderDetailsDomain = new ArrayList<>();
        this.orderDetails.forEach((orderDetailRequest) -> {
            OrderDetail orderDetail = orderDetailRequest.toDomainEntity();
            orderDetail.setOrderNumber(new OrderNumberObject(this.getOrderNumber()));
            orderDetailsDomain.add(orderDetail);
        });

        order.setOrderDetails(orderDetailsDomain);

        return order;
    }
}
