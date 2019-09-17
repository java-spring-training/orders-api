package order.repository.extractor;

import order.repository.model.*;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

public class OrderExtractor implements ResultSetExtractor {

    public Object extractData(ResultSet resultSet) throws SQLException, DataAccessException {
        Map<Integer, OrderModel> orderMap = new HashMap<Integer, OrderModel>();

        while (resultSet.next()) {
            int orderNumber = resultSet.getInt("OrderNumber");
            OrderModel order = orderMap.get(orderNumber);
            if (order == null) {
                Date orderDate = resultSet.getDate("orderDate");
                Date requiredDate = resultSet.getDate("requiredDate");
                Date shippedDate = resultSet.getDate("shippedDate");
                String status = resultSet.getString("status");
                String comments = resultSet.getString("comments");
                Integer customerNumber = resultSet.getInt("customerNumber");

                order = new OrderModel(
                        orderNumber
                        , orderDate
                        , requiredDate
                        , shippedDate
                        , status
                        , comments
                        , customerNumber
                );

                orderMap.put(orderNumber, order);
            }

            List orderDetailModelList = order.getOrderDetailModelList();

            if (orderDetailModelList == null) {
                orderDetailModelList = new ArrayList<OrderDetailModel>();
                order.setOrderDetailModelList(orderDetailModelList);
            }

            String productCode = resultSet.getString("productCode");
            Integer quantityOrdered = resultSet.getInt("quantityOrdered");
            BigDecimal priceEach = resultSet.getBigDecimal("priceEach");
            Integer orderLineNumber = resultSet.getInt("orderLineNumber");

            OrderDetailModel orderDetailModel = new OrderDetailModel(
                    orderNumber
                    , productCode
                    , quantityOrdered
                    , priceEach
                    , orderLineNumber
            );

            String productName = resultSet.getString("productName");
            String productLine = resultSet.getString("productLine");
            String productScale = resultSet.getString("productScale");
            String productVendor = resultSet.getString("productVendor");
            String productDescription = resultSet.getString("productDescription");
            int quantityInStock = resultSet.getInt("quantityInStock");
            BigDecimal buyPrice = resultSet.getBigDecimal("buyPrice");
            BigDecimal msrp = resultSet.getBigDecimal("MSRP");

            ProductModel productModel = new ProductModel(productCode, productName,
                    productLine, productScale, productVendor, productDescription,
                    quantityInStock, buyPrice, msrp);

            orderDetailModel.setProductModel(productModel);

            orderDetailModelList.add(orderDetailModel);

            Integer employeeNumber = resultSet.getInt("employeeNumber");
            String lastName = resultSet.getString("lastName");
            String firstName = resultSet.getString("firstName");
            String extension = resultSet.getString("extension");
            String email = resultSet.getString("email");
            String officeCode = resultSet.getString("officeCode");
            Integer reportsTo = resultSet.getInt("reportsTo");
            String jobTitle = resultSet.getString("jobTitle");

            EmployeeModel employeeModel = new EmployeeModel(
                    employeeNumber
                    , lastName
                    , firstName
                    , extension
                    , email
                    , officeCode
                    , reportsTo
                    , jobTitle
            );

            Integer customerNumber = resultSet.getInt("customerNumber");
            String customerName = resultSet.getString("customerName");
            String contactLastName = resultSet.getString("contactLastName");
            String contactFirstName = resultSet.getString("contactFirstName");
            String phone = resultSet.getString("phone");
            String addressLine1 = resultSet.getString("addressLine1");
            String addressLine2 = resultSet.getString("addressLine2");
            String city = resultSet.getString("city");
            String state = resultSet.getString("state");
            String postalCode = resultSet.getString("postalCode");
            String country = resultSet.getString("country");
            Integer salesRepEmployeeNumber = resultSet.getInt("salesRepEmployeeNumber");
            BigDecimal creditLimit = resultSet.getBigDecimal("creditLimit");


            CustomerModel customerModel = new CustomerModel(
                    customerNumber
                    , customerName
                    , contactLastName
                    , contactFirstName
                    , phone
                    , addressLine1
                    , addressLine2
                    , city
                    , state
                    , postalCode
                    , country
                    , salesRepEmployeeNumber
                    , creditLimit
            );

            customerModel.setEmployeeModel(employeeModel);
            order.setCustomerModel(customerModel);
        }

        return new ArrayList<OrderModel>(orderMap.values());
    }
}
