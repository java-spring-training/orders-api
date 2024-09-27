package api.domain;

import api.domain.entities.object.OrderDetail;
import api.exception.DBException;

import java.util.List;

public interface OrderRepository {
    List<OrderDetail> getOrdersByCustomerNumber(int id) throws DBException;
}
