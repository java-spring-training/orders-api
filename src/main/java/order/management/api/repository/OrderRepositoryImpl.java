package order.management.api.repository;

import order.management.api.domain.OrderRepository;
import order.management.api.domain.entities.object.Order;
import order.management.api.domain.value.object.OrderNumber;
import order.management.api.repository.mapper.OrderModel;
import order.management.api.repository.mapper.OrderRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import java.util.List;

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
    public List<Order> getOrdersByOrderNumber(OrderNumber orderNumber) {

        String sql = "SELECT\n" +
                "orders.orderNumber AS `orderNumber`,\n" +
                "orders.orderDate AS `orderDate`,\n" +
                "orders.status AS `status`,\n" +
                "products.productCode AS `productCode`,\n" +
                "products.productName AS `productName`,\n" +
                "orderdetails.priceEach AS `buyPrice`,\n" +
                "orderdetails.quantityOrdered AS `quantityOrdered`,\n" +
                "customers.customerNumber AS `customerNumber`,\n" +
                "customers.customerName AS `customerName`,\n" +
                "customers.phone AS `phone`,\n" +
                "customers.country AS `country`,\n" +
                "customers.salesRepEmployeeNumber AS `salesRepEmployeeNumber`,\n" +
                "employees.email AS `employeeEmail`\n" +
            "FROM orders\n" +
            "INNER JOIN orderdetails\n" +
                "ON orders.orderNumber = orderdetails.orderNumber\n" +
            "INNER JOIN products\n" +
                "ON orderdetails.productCode = products.productCode\n" +
            "INNER JOIN customers\n" +
                "ON customers.customerNumber = orders.customerNumber\n" +
            "INNER JOIN employees\n" +
                "ON customers.salesRepEmployeeNumber = employees.employeeNumber\n" +
            "WHERE orders.orderNumber = ?";

        List<OrderModel> orderModels = this.getJdbcTemplate().query(sql, orderRowMapper, orderNumber.getNumber());

        return orderFactory.toOrders(orderModels);
    }
}
