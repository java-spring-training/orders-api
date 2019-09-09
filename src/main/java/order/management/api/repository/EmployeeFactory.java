package order.management.api.repository;

import order.management.api.domain.entities.object.Employee;
import order.management.api.domain.value.object.EmployeeNumber;
import order.management.api.repository.mapper.EmployeeModel;

import org.springframework.stereotype.Component;

@Component
public class EmployeeFactory {
    public Employee toEmployee(EmployeeModel customerModel) {

        EmployeeNumber employeeNumber = new EmployeeNumber(customerModel.getEmployeeNumber());
        String lastName = customerModel.getLastName();
        String firstName = customerModel.getFirstName();
        String extension = customerModel.getExtension();
        String email = customerModel.getEmail();
        String officeCode = customerModel.getOfficeCode();
        EmployeeNumber reportsTo = new EmployeeNumber(customerModel.getReportsTo());
        String jobTitle = customerModel.getJobTitle();

        return new Employee(employeeNumber, lastName, firstName, extension, email, officeCode, reportsTo, jobTitle);
    }
}
