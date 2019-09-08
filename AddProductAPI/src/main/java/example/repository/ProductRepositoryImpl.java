package example.repository;

import example.domain.ProductRepository;

import java.math.BigDecimal;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.PreparedStatementCallback;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

@Repository
public class ProductRepositoryImpl extends JdbcDaoSupport implements ProductRepository {

    @Autowired
    public ProductRepositoryImpl(DataSource dataSource) {
        this.setDataSource(dataSource);
    }

    @Override
    public void addProduct(String code, String name, BigDecimal buyPrice, BigDecimal msrp, String description,
                           String line, String scale, String vendor, int quantityInStock) {

        String sql = "INSERT INTO `products`(`productCode`, `productName`, `productLine`, " + "`productScale`, " +
                     "`productVendor`, `productDescription`, `quantityInStock`, `buyPrice`, `MSRP`)" + " VALUES (?,?,"
                     + "?,?,?,?,?,?,?)";

        this.getJdbcTemplate().execute(sql, new PreparedStatementCallback<String>() {
            @Override
            public String doInPreparedStatement(PreparedStatement preparedStatement) throws SQLException,
                                                                                        DataAccessException
            {
                preparedStatement.setString(1, code);
                preparedStatement.setString(2, name);
                preparedStatement.setString(3, line);
                preparedStatement.setString(4, scale);
                preparedStatement.setString(5, vendor);
                preparedStatement.setString(6, description);
                preparedStatement.setInt(7, quantityInStock);
                preparedStatement.setBigDecimal(8, buyPrice);
                preparedStatement.setBigDecimal(9, msrp);
                preparedStatement.executeUpdate();
                return null;
            }
        });
    }
}
