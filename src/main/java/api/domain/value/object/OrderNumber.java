package api.domain.value.object;

import org.glassfish.jersey.internal.guava.Preconditions;

public class OrderNumber {
    private int orderNumber;

    public OrderNumber(int orderNumber) {
        Preconditions.checkArgument(orderNumber > 0, "OrderNumber must be > 0");
        this.orderNumber = orderNumber;
    }

    public int getOrderNumber() {
        return orderNumber;
    }
}
