package order.domain.value.object;

import org.glassfish.jersey.internal.guava.Preconditions;

public class EmployeeNumber {
    Integer employeeNumber;

    public EmployeeNumber(Integer employeeNumber) {
        Preconditions.checkArgument(employeeNumber > 0, "employeeNumber must be > 0");

        this.employeeNumber = employeeNumber;
    }

    public Integer getEmployeeNumber() {
        return employeeNumber;
    }
}
