package order.management.api.domain.entities.object;

import order.management.api.domain.value.object.EmployeeNumber;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

/**
 * Employee
 */
public class Employee {
    @NotNull
    private EmployeeNumber employeeNumber;

    @NotEmpty
    @Email
    private String email;

    public Employee(@NotNull EmployeeNumber employeeNumber, @NotEmpty @Email String email) {
        this.employeeNumber = employeeNumber;
        this.email = email;
    }

    public EmployeeNumber getEmployeeNumber() {
        return employeeNumber;
    }

    public void setEmployeeNumber(EmployeeNumber employeeNumber) {
        this.employeeNumber = employeeNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
