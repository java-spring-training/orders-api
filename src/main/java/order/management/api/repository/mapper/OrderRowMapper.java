package order.management.api.repository.mapper;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

@Component
public class OrderRowMapper implements RowMapper<OrderModel> {

    @Override
    public OrderModel mapRow(ResultSet resultSet, int numRows) throws SQLException {

        int orderNumber = resultSet.getInt("orderNumber");
        Date orderDate = resultSet.getDate("orderDate");
        Date requiredDate = resultSet.getDate("requiredDate");
        Date shippedDate = resultSet.getDate("shippedDate");
        String status = resultSet.getString("status");
        String comments = resultSet.getString("comments");
        int customerNumber = resultSet.getInt("customerNumber");

        return new OrderModel(orderNumber, orderDate, requiredDate, shippedDate, status, comments, customerNumber);
    }
}
