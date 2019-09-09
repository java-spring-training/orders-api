package dev.pdhau.ordermanagementapi.repository.mapper;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class OrderModel {

    private int orderNumber;

    private String orderDate;

    private String requiredDate;

    private String shippedDate;

    private String status;

    private String comments;

    private int customerNumber;
}
