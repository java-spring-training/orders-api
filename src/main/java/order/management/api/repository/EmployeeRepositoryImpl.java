package order.management.api.repository;

import order.management.api.domain.EmployeeRepository;
import order.management.api.domain.entities.object.Employee;
import order.management.api.domain.value.object.EmployeeNumber;
import order.management.api.repository.mapper.EmployeeModel;
import order.management.api.repository.mapper.EmployeeRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;

@Repository
public class EmployeeRepositoryImpl extends JdbcDaoSupport implements EmployeeRepository {

    private EmployeeRowMapper employeeRowMapper;
    private EmployeeFactory employeeFactory;

    @Autowired
    public EmployeeRepositoryImpl(DataSource dataSource, EmployeeRowMapper employeeRowMapper,
            EmployeeFactory employeeFactory) {
        this.setDataSource(dataSource);
        this.employeeRowMapper = employeeRowMapper;
        this.employeeFactory = employeeFactory;
    }

    @Override
    public Employee getEmployeeByEmployeeNumber(EmployeeNumber employeeNumber) {

        String sql = "SELECT * FROM employees WHERE employeeNumber = ?";
        EmployeeModel employeeModel = this.getJdbcTemplate().queryForObject(sql, employeeRowMapper,
                employeeNumber.getNumber());

        return employeeFactory.toEmployee(employeeModel);
    }
}
