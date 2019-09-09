package order.management.api.repository.mapper;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class CustomerRowMapper implements RowMapper<CustomerModel> {

    @Override
    public CustomerModel mapRow(ResultSet resultSet, int numRows) throws SQLException {

        Integer customerNumber = resultSet.getInt("customerNumber");
        String customerName = resultSet.getString("customerName");
        String contactLastName = resultSet.getString("contactLastName");
        String contactFirstName = resultSet.getString("contactFirstName");
        String phone = resultSet.getString("phone");
        String addressLine1 = resultSet.getString("addressLine1");
        String addressLine2 = resultSet.getString("addressLine2");
        String city = resultSet.getString("city");
        String state = resultSet.getString("state");
        String postalCode = resultSet.getString("postalCode");
        String country = resultSet.getString("country");
        Integer salesRepEmployeeNumber = resultSet.getInt("salesRepEmployeeNumber");
        BigDecimal creditLimit = resultSet.getBigDecimal("creditLimit");

        return new CustomerModel(customerNumber, customerName, contactLastName, contactFirstName, phone, addressLine1,
                addressLine2, city, state, postalCode, country, salesRepEmployeeNumber, creditLimit);
    }
}
