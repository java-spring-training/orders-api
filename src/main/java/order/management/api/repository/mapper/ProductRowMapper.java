package order.management.api.repository.mapper;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class ProductRowMapper implements RowMapper<ProductModel> {

    @Override
    public ProductModel mapRow(ResultSet resultSet, int numRows) throws SQLException {

        String productCode = resultSet.getString("productCode");
        String productName = resultSet.getString("productName");
        String productLine = resultSet.getString("productLine");
        String productScale = resultSet.getString("productScale");
        String productVendor = resultSet.getString("productVendor");
        String productDescription = resultSet.getString("productDescription");
        Integer quantityInStock = resultSet.getInt("quantityInStock");
        BigDecimal buyPrice = resultSet.getBigDecimal("buyPrice");
        BigDecimal mSRP = resultSet.getBigDecimal("MSRP");

        return new ProductModel(productCode, productName, productLine, productScale, productVendor, productDescription, quantityInStock, buyPrice, mSRP);
    }
}
