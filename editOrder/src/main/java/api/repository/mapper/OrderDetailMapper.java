package api.repository.mapper;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class OrderDetailMapper implements RowMapper<OrderDetailModel> {

    @Override
    public OrderDetailModel mapRow(ResultSet resultSet, int i) throws SQLException {

        String productCode = resultSet.getString("productCode");

        return new OrderDetailModel(productCode);
    }
}
