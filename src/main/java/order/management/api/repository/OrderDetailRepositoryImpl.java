package order.management.api.repository;

import order.management.api.domain.OrderDetailRepository;
import order.management.api.domain.entities.object.OrderDetail;
import order.management.api.domain.value.object.OrderNumber;
import order.management.api.repository.mapper.OrderDetailModel;
import order.management.api.repository.mapper.OrderDetailRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;

@Repository
public class OrderDetailRepositoryImpl extends JdbcDaoSupport implements OrderDetailRepository {

    private OrderDetailRowMapper orderDetailRowMapper;
    private OrderDetailFactory orderDetailFactory;

    @Autowired
    public OrderDetailRepositoryImpl(DataSource dataSource, OrderDetailRowMapper orderDetailRowMapper, OrderDetailFactory orderDetailFactory) {
        this.setDataSource(dataSource);
        this.orderDetailRowMapper = orderDetailRowMapper;
        this.orderDetailFactory = orderDetailFactory;
    }

    @Override
    public List<OrderDetail> getOrderDetailByOrderNumber(OrderNumber orderNumber) {
        String sql = "SELECT * FROM orderdetails WHERE `orderNumber` = ? LIMIT 10";
        List<OrderDetailModel> orderDetailModelList = this.getJdbcTemplate().query(sql, orderDetailRowMapper, orderNumber.getNumber());

        return orderDetailFactory.toListOrderDetail(orderDetailModelList);
    }
}
