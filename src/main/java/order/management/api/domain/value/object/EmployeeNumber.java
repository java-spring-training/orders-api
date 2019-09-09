package order.management.api.domain.value.object;

import javax.validation.constraints.NotNull;

/**
 * EmployeeNumber
 */
public class EmployeeNumber {
    @NotNull
    private int number;

    public EmployeeNumber(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }
}