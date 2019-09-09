package dev.pdhau.ordermanagementapi.repository.mapper;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class OrderMapper implements RowMapper<OrderModel> {

    @Override
    public OrderModel mapRow(ResultSet resultSet, int rowNum) throws SQLException {

        int orderNumber = resultSet.getInt("orderNumber");
        String orderDate = resultSet.getString("orderDate");
        String requiredDate = resultSet.getString("requiredDate");
        String shippedDate = resultSet.getString("shippedDate");
        String status = resultSet.getString("status");
        String comments = resultSet.getString("comments");
        int customerNumber = resultSet.getInt("customerNumber");

        return new OrderModel(orderNumber, orderDate, requiredDate, shippedDate, status, comments, customerNumber);
    }
}
