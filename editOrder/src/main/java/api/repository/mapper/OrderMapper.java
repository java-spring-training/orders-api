package api.repository.mapper;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import java.sql.ResultSet;
import java.sql.SQLException;
@Component
public class OrderMapper implements RowMapper<OrderModel> {

    @Override
    public OrderModel mapRow(ResultSet resultSet, int i) throws SQLException {

        String orderNumber = resultSet.getString("orderNumber");

        return new OrderModel(orderNumber);
    }
}
