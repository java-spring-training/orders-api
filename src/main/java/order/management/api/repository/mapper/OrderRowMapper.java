package order.management.api.repository.mapper;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

@Component
public class OrderRowMapper implements RowMapper<OrderModel> {

    @Override
    public OrderModel mapRow(ResultSet resultSet, int numRows) throws SQLException {

        int orderNumber = resultSet.getInt("orderNumber");
        Date orderDate = resultSet.getDate("orderDate");
        String status = resultSet.getString("status");
        String productCode = resultSet.getString("productCode");
        String productName = resultSet.getString("productName");
        BigDecimal buyPrice = resultSet.getBigDecimal("buyPrice");
        int quantityOrdered = resultSet.getInt("quantityOrdered");
        int customerNumber = resultSet.getInt("customerNumber");
        String customerName = resultSet.getString("customerName");
        String phone = resultSet.getString("phone");
        String country = resultSet.getString("country");
        int salesRepEmployeeNumber = resultSet.getInt("salesRepEmployeeNumber");
        String employeeEmail = resultSet.getString("employeeEmail");

        return new OrderModel(orderNumber, orderDate, status, productCode, productName, buyPrice, quantityOrdered,
                customerNumber, customerName, phone, country, salesRepEmployeeNumber, employeeEmail);
    }
}
