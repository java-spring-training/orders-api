package order.repository;

import order.domain.OrderRepository;
import order.domain.entities.object.Order;
import order.repository.extractor.OrderExtractor;
import order.repository.factory.OrderFactory;
import order.repository.model.OrderModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;

@Repository
public class OrderRepositoryImpl extends JdbcDaoSupport implements OrderRepository {

    final static int LIMIT = 50;
    @Autowired
    private OrderFactory orderFactory;

    @Autowired
    public OrderRepositoryImpl(DataSource dataSource) {
        this.setDataSource(dataSource);
    }

    public List<Order> getAll() {
        String sql = "SELECT orders.*, orderdetails.*, products.*, customers.*, employees.* " +
                "FROM orders, orderdetails, products, customers " +
                "LEFT JOIN employees " +
                "ON customers.salesRepEmployeeNumber = employees.employeeNumber " +
                "WHERE " +
                "orders.orderNumber = orderdetails.orderNumber " +
                "AND orders.customerNumber = customers.customerNumber " +
                "AND products.productCode = orderdetails.productCode " +
                "LIMIT " + LIMIT;

        List<OrderModel> orderModelList = (List<OrderModel>) this.getJdbcTemplate().query(sql, new OrderExtractor());

        return orderFactory.toListOrder(orderModelList);
    }
}