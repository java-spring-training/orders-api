package api.domain.value.object;

import org.glassfish.jersey.internal.guava.Preconditions;

public class CustomerNumber {
    private int customerNumber;

    public CustomerNumber(int customerNumber) {
        Preconditions.checkArgument(customerNumber > 0, "CustomerNumber must be > 0");
        this.customerNumber = customerNumber;
    }

    public int getCustomerNumber() {
        return customerNumber;
    }
}
