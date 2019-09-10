package api.service;

import api.domain.OrderRepository;
import api.domain.entities.object.Order;
import api.exception.ApiException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

@Service
public class OrderService {
    private OrderRepository orderRepository;

    @Autowired
    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public boolean editOrder(Order order, String productCode) throws ApiException {
        try {
            if (orderRepository.isExisted(order.getOrderID().getOrderID())) {
                orderRepository.editOrder(order);
            }

            if (orderRepository.isExistedOrderDetail(order.getOrderID().getOrderID(), productCode)) {
                orderRepository.editOrderDetail(order, productCode);
            }
            return true;
        } catch (DataAccessException ex) {
            throw new ApiException("DB ERROR!!!");
        }
    }
}
