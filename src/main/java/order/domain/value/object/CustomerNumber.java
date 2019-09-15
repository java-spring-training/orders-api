package order.domain.value.object;

import org.glassfish.jersey.internal.guava.Preconditions;
import org.springframework.util.StringUtils;

public class CustomerNumber {
    Integer customerNumber;

    public CustomerNumber(Integer customerNumber) {
        Preconditions.checkArgument(customerNumber > 0, "customerNumber must be > 0");

        this.customerNumber = customerNumber;
    }

    public Integer value() {
        return customerNumber;
    }
}
