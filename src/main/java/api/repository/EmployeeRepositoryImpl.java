package api.repository;

import api.domain.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;
import javax.sql.DataSource;

@Repository
public class EmployeeRepositoryImpl extends JdbcDaoSupport implements EmployeeRepository {

    @Autowired
    public EmployeeRepositoryImpl(final DataSource dataSource) {

        this.setDataSource(dataSource);
    }

    @Override
    public boolean isExisted(final int employeeNumber) {

        final String sql = "SELECT COUNT(1) FROM employees WHERE employeeNumber = ?";
        final int result = this.getJdbcTemplate().queryForObject(sql, new Object[] {employeeNumber}, Integer.class);
        return result > 0;
    }
}
