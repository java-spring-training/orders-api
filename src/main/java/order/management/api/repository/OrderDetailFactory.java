package order.management.api.repository;

import order.management.api.domain.entities.object.OrderDetail;
import order.management.api.domain.value.object.OrderNumber;
import order.management.api.domain.value.object.ProductCode;
import order.management.api.repository.mapper.OrderDetailModel;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class OrderDetailFactory {

    public List<OrderDetail> toListOrderDetail(List<OrderDetailModel> orderDetailModelList) {

        return orderDetailModelList.stream().map(this::toOrderDetail).collect(Collectors.toList());
    }

    private OrderDetail toOrderDetail(OrderDetailModel orderDetailModel) {

        OrderNumber orderNumber = new OrderNumber(orderDetailModel.getOrderNumber());
        ProductCode productCode = new ProductCode(orderDetailModel.getProductCode());

        return new OrderDetail(orderNumber, productCode, orderDetailModel.getQuantityOrdered(), orderDetailModel.getPriceEach(), orderDetailModel.getOrderLineNumber());
    }
}
