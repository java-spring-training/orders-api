package order.repository.mapper;

import order.repository.model.EmployeeModel;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class EmployeeMapper implements RowMapper<EmployeeModel> {
    @Override
    public EmployeeModel mapRow(ResultSet resultSet, int  rowNum) throws SQLException {
        Integer employeeNumber = resultSet.getInt("employeeNumber");
        String lastName = resultSet.getString("lastName");
        String firstName = resultSet.getString("firstName");
        String extension = resultSet.getString("extension");
        String email = resultSet.getString("email");
        String officeCode = resultSet.getString("officeCode");
        Integer reportsTo = resultSet.getInt("reportsTo");
        String jobTitle = resultSet.getString("jobTitle");

        return new EmployeeModel(
                employeeNumber
                , lastName
                , firstName
                , extension
                , email
                , officeCode
                , reportsTo
                , jobTitle
        );
    }
}