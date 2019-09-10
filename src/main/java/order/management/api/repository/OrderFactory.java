package order.management.api.repository;

import order.management.api.domain.entities.object.Customer;
import order.management.api.domain.entities.object.Employee;
import order.management.api.domain.entities.object.Order;
import order.management.api.domain.entities.object.OrderDetail;
import order.management.api.domain.entities.object.Product;
import order.management.api.domain.value.object.CustomerNumber;
import order.management.api.domain.value.object.EmployeeNumber;
import order.management.api.domain.value.object.OrderNumber;
import order.management.api.domain.value.object.ProductCode;
import order.management.api.repository.mapper.OrderModel;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class OrderFactory {

    public List<Order> toOrders(List<OrderModel> orderModels) {

        return orderModels.stream().map(this::toOrder).collect(Collectors.toList());
    }

    private Order toOrder(OrderModel orderModel) {

        OrderNumber orderNumber = new OrderNumber(orderModel.getOrderNumber());
        Date orderDate = orderModel.getOrderDate();
        String status = orderModel.getStatus();
        CustomerNumber customerNumber = new CustomerNumber(orderModel.getCustomerNumber());

        ProductCode productCode = new ProductCode(orderModel.getProductCode());
        Product product = new Product(productCode, orderModel.getProductName());

        EmployeeNumber employeeNumber = new EmployeeNumber(orderModel.getSalesRepEmployeeNumber());
        Employee salesRepEmployee = new Employee(employeeNumber, orderModel.getEmployeeEmail());

        Customer customer = new Customer(customerNumber, orderModel.getCustomerName(), orderModel.getPhone(), orderModel.getCountry(), employeeNumber);
        customer.setSalesRepEmployee(salesRepEmployee);

        OrderDetail orderDetail = new OrderDetail(orderNumber, productCode, orderModel.getQuantityOrdered(),
                orderModel.getBuyPrice());
        orderDetail.setProduct(product);

        Order order = new Order(orderNumber, orderDate, status, customerNumber);
        order.setCustomer(customer);
        order.setOrderDetail(orderDetail);

        return order;
    }
}
