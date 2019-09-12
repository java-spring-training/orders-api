package order.repository.factory;

import order.domain.entities.object.OrderDetail;
import order.domain.value.object.OrderNumber;
import order.domain.value.object.ProductCode;
import order.repository.model.OrderDetailModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OrderDetailFactory {

    @Autowired
    private ProductFactory productFactory;

    public OrderDetail toOrderDetail(OrderDetailModel orderDetailModel) {

        OrderNumber orderNumber = new OrderNumber(orderDetailModel.getOrderNumber());
        ProductCode productCode = new ProductCode(orderDetailModel.getProductCode());

        OrderDetail orderDetail = new OrderDetail(
                orderNumber
                , productCode
                , orderDetailModel.getQuantityOrdered()
                , orderDetailModel.getPriceEach()
                , orderDetailModel.getOrderLineNumber()
                , productFactory.toProduct(orderDetailModel.getProductModel())
        );

        return orderDetail;
    }
}