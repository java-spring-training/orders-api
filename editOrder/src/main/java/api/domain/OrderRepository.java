package api.domain;

import api.domain.entities.object.Order;

public interface OrderRepository {
    boolean editOrder (Order order);
    boolean editOrderDetail (Order order, String productCode);
    boolean isExisted (int orderID);
    boolean isExistedOrderDetail (int orderID, String productCode);
}
