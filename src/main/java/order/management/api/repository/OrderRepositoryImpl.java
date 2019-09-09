package order.management.api.repository;

import order.management.api.domain.OrderRepository;
import order.management.api.domain.entities.object.Order;
import order.management.api.domain.value.object.OrderNumber;
import order.management.api.repository.mapper.OrderModel;
import order.management.api.repository.mapper.OrderRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;

@Repository
public class OrderRepositoryImpl extends JdbcDaoSupport implements OrderRepository {

    private OrderRowMapper orderRowMapper;
    private OrderFactory orderFactory;

    @Autowired
    public OrderRepositoryImpl(DataSource dataSource, OrderRowMapper orderRowMapper, OrderFactory orderFactory) {
        this.setDataSource(dataSource);
        this.orderRowMapper = orderRowMapper;
        this.orderFactory = orderFactory;
    }

    @Override
    public Order getOrderByOrderNumber(OrderNumber orderNumber) {

        String sql = "SELECT * FROM orders WHERE orderNumber = ?";
        OrderModel orderModel = this.getJdbcTemplate().queryForObject(sql, orderRowMapper, orderNumber.getNumber());

        return orderFactory.toOrder(orderModel);
    }
}
