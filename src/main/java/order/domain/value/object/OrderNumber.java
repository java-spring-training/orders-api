package order.domain.value.object;

import org.glassfish.jersey.internal.guava.Preconditions;
import org.springframework.util.StringUtils;

public class OrderNumber {
    Integer orderNumber;

    public OrderNumber(Integer orderNumber) {
        Preconditions.checkArgument(orderNumber > 0, "orderNumber must be > 0");

        this.orderNumber = orderNumber;
    }

    public Integer value() {
        return orderNumber;
    }
}
