package order.management.api.service;

import order.management.api.domain.CustomerRepository;
import order.management.api.domain.EmployeeRepository;
import order.management.api.domain.OrderDetailRepository;
import order.management.api.domain.OrderRepository;
import order.management.api.domain.ProductRepository;
import order.management.api.domain.entities.object.Customer;
import order.management.api.domain.entities.object.Employee;
import order.management.api.domain.entities.object.Order;
import order.management.api.domain.entities.object.OrderDetail;
import order.management.api.domain.entities.object.Product;
import order.management.api.domain.value.object.OrderNumber;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderService {

    private OrderRepository orderRepository;
    private OrderDetailRepository orderDetailRepository;
    private ProductRepository productRepository;
    private CustomerRepository customerRepository;
    private EmployeeRepository employeeRepository;

    @Autowired
    public OrderService(OrderRepository orderRepository, OrderDetailRepository orderDetailRepository,
            ProductRepository productRepository, CustomerRepository customerRepository,
            EmployeeRepository employeeRepository) {
        this.orderRepository = orderRepository;
        this.orderDetailRepository = orderDetailRepository;
        this.productRepository = productRepository;
        this.customerRepository = customerRepository;
        this.employeeRepository = employeeRepository;
    }

    public Order getOrderByOrderNumber(OrderNumber orderNumber) {

        Order order = orderRepository.getOrderByOrderNumber(orderNumber);

        List<OrderDetail> orderDetails = orderDetailRepository.getOrderDetailByOrderNumber(orderNumber);
        orderDetails = orderDetails.stream().map(this::mapProductToOrderDetail).collect(Collectors.toList());
        order.setOrderDetails(orderDetails);

        Customer customer = customerRepository.getCustomerByCustomerNumber(order.getCustomerNumber());
        Employee salesRepEmployee = employeeRepository.getEmployeeByEmployeeNumber(customer.getSalesRepEmployeeNumber());
        customer.setSalesRepEmployee(salesRepEmployee);
        order.setCustomer(customer);

        return order;
    }

    private OrderDetail mapProductToOrderDetail(OrderDetail orderDetail) {

        Product product = productRepository.getProductByProductCode(orderDetail.getProductCode());
        orderDetail.setProduct(product);

        return orderDetail;
    }
}
