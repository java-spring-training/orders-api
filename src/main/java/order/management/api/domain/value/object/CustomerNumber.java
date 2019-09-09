package order.management.api.domain.value.object;

import javax.validation.constraints.NotNull;

/**
 * CustomerNumber
 */
public class CustomerNumber {
    @NotNull
    private Integer number;

    public CustomerNumber(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }
}