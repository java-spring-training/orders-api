package order.management.api.repository.mapper;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class OrderDetailRowMapper implements RowMapper<OrderDetailModel> {

    @Override
    public OrderDetailModel mapRow(ResultSet resultSet, int numRows) throws SQLException {

        int orderNumber = resultSet.getInt("orderNumber");
        String productCode = resultSet.getString("productCode");
        int quantityOrdered = resultSet.getInt("quantityOrdered");
        BigDecimal priceEach = resultSet.getBigDecimal("priceEach");
        int orderLineNumber = resultSet.getInt("orderLineNumber");

        return new OrderDetailModel(orderNumber, productCode, quantityOrdered, priceEach, orderLineNumber);
    }
}
