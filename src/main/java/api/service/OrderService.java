package api.service;

import api.domain.OrderRepository;
import api.domain.entities.object.OrderDetail;
import api.exception.DBException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {
    private OrderRepository orderRepository;

    @Autowired
    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public List<OrderDetail> getOrdersByCustomer(int id) throws DBException {

        List<OrderDetail> result = null;
        try {
            result = orderRepository.getOrdersByCustomerNumber(id);
        } catch (DataAccessException ex) {
            throw new DBException("DB ERROR");
        }
        return result;
    }
}
