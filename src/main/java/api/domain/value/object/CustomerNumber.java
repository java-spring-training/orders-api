package api.domain.value.object;

import org.springframework.util.ObjectUtils;

public class CustomerNumber {

    private int customerNumber;

    public CustomerNumber(int customerNumber) {

        this.checkValidation(customerNumber);

        this.customerNumber = customerNumber;
    }

    public int getCustomerNumber() {

        return customerNumber;
    }

    public void setCustomerNumber(int customerNumber) {

        this.customerNumber = customerNumber;
    }

    private void checkValidation(final Integer customerNumber) {

        if (ObjectUtils.isEmpty(customerNumber)) {
            throw new IllegalArgumentException("customerNumber must not be null");
        }

        if (customerNumber < 0) {
            throw new IllegalArgumentException("customerNumber is invalid");
        }
    }
}
