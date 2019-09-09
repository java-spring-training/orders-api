package order.management.api.repository;

import order.management.api.domain.CustomerRepository;
import order.management.api.domain.entities.object.Customer;
import order.management.api.domain.value.object.CustomerNumber;
import order.management.api.repository.mapper.CustomerModel;
import order.management.api.repository.mapper.CustomerRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;

@Repository
public class CustomerRepositoryImpl extends JdbcDaoSupport implements CustomerRepository {

    private CustomerRowMapper customerRowMapper;
    private CustomerFactory customerFactory;

    @Autowired
    public CustomerRepositoryImpl(DataSource dataSource, CustomerRowMapper customerRowMapper, CustomerFactory customerFactory) {
        this.setDataSource(dataSource);
        this.customerRowMapper = customerRowMapper;
        this.customerFactory = customerFactory;
    }

    @Override
    public Customer getCustomerByCustomerNumber(CustomerNumber customerNumber) {

        String sql = "SELECT * FROM customers WHERE customerNumber = ?";
        CustomerModel customerModel = this.getJdbcTemplate().queryForObject(sql, customerRowMapper, customerNumber.getNumber());

        return customerFactory.toCustomer(customerModel);
    }
}
