package dev.pdhau.ordermanagementapi.repository;

import java.math.BigDecimal;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import dev.pdhau.ordermanagementapi.domain.OrderRepository;
import dev.pdhau.ordermanagementapi.domain.entities.object.Order;
import dev.pdhau.ordermanagementapi.domain.entities.object.OrderDetail;

@Repository
public class OrderRepositoryImpl extends JdbcDaoSupport implements OrderRepository {

    @Autowired
    public OrderRepositoryImpl(DataSource dataSource) {
        this.setDataSource(dataSource);
    }

    @Override
    public boolean add(Order order) {
        String orderSql = "INSERT INTO orders ("+
                                "orderNumber,"+
                                "orderDate,"+
                                "requiredDate,"+
                                "shippedDate,"+
                                "status,"+
                                "comments,"+
                                "customerNumber"+
                            ") VALUES(?, ?, ?, ?, ?, ?, ?)";
        this.getJdbcTemplate().update(orderSql, 
                order.getOrderNumber().getNumberObject(),
                order.getOrderDate(),
                order.getRequiredDate(),
                order.getShippedDate(),
                order.getStatus(),
                order.getComments(),
                order.getCustomerNumber().getNumberObject());
        String orderDetailSql = "INSERT INTO orderdetails ("+
                                    "orderNumber,"+
                                    "productCode,"+
                                    "quantityOrdered,"+
                                    "priceEach,"+
                                    "orderLineNumber"+
                                ") VALUES(?, ?, ?, ?, ?)";
        List<OrderDetail> orderDetails = order.getOrderDetails();

        this.getJdbcTemplate().batchUpdate(orderDetailSql, new BatchPreparedStatementSetter(){
        
            @Override
            public void setValues(PreparedStatement ps, int i) throws SQLException {
                ps.setInt(1, orderDetails.get(i).getOrderNumber().getNumberObject());
                ps.setString(2, orderDetails.get(i).getProductCode());
                ps.setInt(3, orderDetails.get(i).getQuantityOrdered());
                ps.setBigDecimal(4, BigDecimal.valueOf(orderDetails.get(i).getPriceEach()));
                ps.setInt(5, orderDetails.get(i).getOrderLineNumber());
            }
        
            @Override
            public int getBatchSize() {
                return orderDetails.size();
            }
        });

        return true;
    }
}
