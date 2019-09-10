package api.repository;

import api.domain.OrderRepository;
import api.domain.entities.object.Order;
import api.repository.mapper.OrderDetailMapper;
import api.repository.mapper.OrderDetailModel;
import api.repository.mapper.OrderMapper;
import api.repository.mapper.OrderModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;

@Repository
public class OrderRepositoryImpl extends JdbcDaoSupport implements OrderRepository {
    private OrderMapper orderMapper;
    private OrderDetailMapper orderDetailMapper;
    @Autowired
    public OrderRepositoryImpl (DataSource dataSource, OrderMapper orderMapper, OrderDetailMapper orderDetailMapper) {
        this.setDataSource(dataSource);
        this.orderMapper = orderMapper;
        this.orderDetailMapper = orderDetailMapper;
    }
    @Override
    public boolean editOrder (Order order) {
        String sqlEditOrder = "UPDATE orders SET " +
                "orderDate = ?, " +
                "requiredDate = ?, " +
                "shippedDate = ?, " +
                "status = ?, " +
                "comments = ?," +
                "customerNumber = ?" +
                " WHERE orderNumber = ?";
        this.getJdbcTemplate().update(sqlEditOrder,
                order.getOrderDate(),
                order.getRequiredDate(),
                order.getShippedDate(),
                order.getStatus(),
                order.getComments(),
                order.getCustomerNumber(),
                order.getOrderID().getOrderID());
        return true;
    }
    @Override
    public boolean editOrderDetail (Order order, String productCode) {
        String sqlEditOrderDetail = "UPDATE orderdetails" +
                " SET quantityOrdered = ?, priceEach = ?, orderLineNumber = ? " +
                " WHERE orderNumber = ?" +
                " AND productCode = ?";
        this.getJdbcTemplate().update(sqlEditOrderDetail,
                order.getOrderDetail().getQuanlityOrdered(),
                order.getOrderDetail().getPriceEach(),
                order.getOrderDetail().getOrderLineNumber(),
                order.getOrderID().getOrderID(),
                productCode);
        return true;
    }
    public boolean isExisted(int orderId) {
        String sqlFindOrder = "SELECT * FROM orders where orderNumber = ?";
        List<OrderModel> orderList = this.getJdbcTemplate().query(sqlFindOrder, orderMapper, orderId);
        if (orderList.size() > 0) {
            return true;
        }
        return false;
    }

    public boolean isExistedOrderDetail(int orderId, String productCode) {
        String sqlFindOrderDetail = "SELECT * FROM orderdetails where orderNumber = ? AND productCode = ?";
        List<OrderDetailModel> orderDetailList = this.getJdbcTemplate().query(sqlFindOrderDetail, orderDetailMapper, orderId, productCode);
        if (orderDetailList.size() > 0) {
            return true;
        }
        return false;
    }

}
