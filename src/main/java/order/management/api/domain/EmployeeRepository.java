package order.management.api.domain;

import order.management.api.domain.entities.object.Employee;
import order.management.api.domain.value.object.EmployeeNumber;

/**
 * EmployeeRepository
 */
public interface EmployeeRepository {
    Employee getEmployeeByEmployeeNumber(EmployeeNumber employeeNumber);
}
