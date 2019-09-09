package api.repository;

import api.domain.CustomerRepository;
import api.domain.entities.object.Customers;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;

@Repository
public class CustomerRepositoryImpl extends JdbcDaoSupport implements CustomerRepository {

    private Logger log = LoggerFactory.getLogger(CustomerRepositoryImpl.class);

    @Autowired
    public CustomerRepositoryImpl(final DataSource dataSource) {

        this.setDataSource(dataSource);
    }

    @Override
    public void addCustomer(final Customers customer) {

        final String sql = "INSERT INTO customers (customerNumber, customerName, contactLastName, contactFirstName,"
                + "phone, addressLine1, addressLine2, city, state, postalCode, country, salesRepEmployeeNumber,"
                + "creditLimit) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        this.getJdbcTemplate().update(sql, customer.getCustomerNumber().getCustomerNumber(),
                customer.getCustomerName(), customer.getContactLastName(), customer.getContactFirstName(),
                customer.getPhone(), customer.getAddressLine1(),
                customer.getAddressLine2(), customer.getCity(), customer.getState(),
                customer.getPostalCode(), customer.getCountry(),
                customer.getSalesRepEmployeeNumber(), customer.getCreditLimit());
        log.info("Add new customer successfully");
    }

    @Override
    public boolean isExisted(final int customerNumber) {

        final String sql = "SELECT COUNT(1) FROM customers WHERE customerNumber = ?";
        final int result = this.getJdbcTemplate().queryForObject(sql, new Object[]{customerNumber}, Integer.class);
        return result > 0;
    }
}
