package order.management.api.repository;

import order.management.api.domain.ProductRepository;
import order.management.api.domain.entities.object.Product;
import order.management.api.domain.value.object.ProductCode;
import order.management.api.repository.mapper.ProductModel;
import order.management.api.repository.mapper.ProductRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;

@Repository
public class ProductRepositoryImpl extends JdbcDaoSupport implements ProductRepository {

    private ProductRowMapper productRowMapper;
    private ProductFactory productFactory;

    @Autowired
    public ProductRepositoryImpl(DataSource dataSource, ProductRowMapper productRowMapper,
            ProductFactory productFactory) {
        this.setDataSource(dataSource);
        this.productRowMapper = productRowMapper;
        this.productFactory = productFactory;
    }

    @Override
    public Product getProductByProductCode(ProductCode productCode) {

        String sql = "SELECT * FROM products WHERE productCode = ?";
        ProductModel productModel = this.getJdbcTemplate().queryForObject(sql, productRowMapper, productCode.getCode());

        return productFactory.toProduct(productModel);
    }
}
