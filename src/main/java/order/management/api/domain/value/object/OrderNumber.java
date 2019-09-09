package order.management.api.domain.value.object;

import javax.validation.constraints.NotNull;

/**
 * OrderNumber
 */
public class OrderNumber {
    @NotNull
    private int number;

    public OrderNumber(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }
}