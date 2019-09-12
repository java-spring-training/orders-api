package order.repository.factory;

import order.domain.entities.object.Customer;
import order.domain.entities.object.Order;
import order.domain.entities.object.OrderDetail;
import order.domain.value.object.OrderNumber;
import order.repository.model.OrderDetailModel;
import order.repository.model.OrderModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class OrderFactory {

    @Autowired
    private OrderDetailFactory orderDetailFactory;
    @Autowired
    private ProductFactory productFactory;
    @Autowired
    private CustomerFactory customerFactory;
    @Autowired
    private EmployeeFactory employeeFactory;

    public List<Order> toListOrder(List<OrderModel> orderModelList) {

        return orderModelList.stream().map(this::toOrder).collect(Collectors.toList());
    }

    public Order toOrder(OrderModel orderModel) {

        List<OrderDetail> orderDetailList = new ArrayList<>();
        for(OrderDetailModel orderDetailModel: orderModel.getOrderDetailModelList()) {
            OrderDetail orderDetail = orderDetailFactory.toOrderDetail(orderDetailModel);
            orderDetailList.add(orderDetail);
        }

        Customer customer = customerFactory.toCustomer(orderModel.getCustomerModel());

        OrderNumber orderNumber = new OrderNumber(orderModel.getOrderNumber());
        Order order = new Order(
                orderNumber
                , orderModel.getOrderDate()
                , orderModel.getRequiredDate()
                , orderModel.getShippedDate()
                , orderModel.getStatus()
                , orderModel.getComments()
                , customer
        );
        order.setOrderDetailList(orderDetailList);

        return order;
    }
}