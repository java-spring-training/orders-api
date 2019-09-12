package order.repository.factory;

import order.domain.entities.object.Employee;
import order.domain.value.object.EmployeeNumber;
import order.repository.model.EmployeeModel;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class EmployeeFactory {

    public Employee toEmployee(EmployeeModel employeeModel) {

        EmployeeNumber employeeNumber = new EmployeeNumber(employeeModel.getEmployeeNumber());

        return new Employee(
                employeeNumber
                , employeeModel.getLastName()
                , employeeModel.getFirstName()
                , employeeModel.getExtension()
                , employeeModel.getEmail()
                , employeeModel.getOfficeCode()
                , employeeModel.getReportsTo()
                , employeeModel.getJobTitle()
        );
    }
}