package order.management.api.domain;

import order.management.api.domain.entities.object.Customer;
import order.management.api.domain.value.object.CustomerNumber;

/**
 * CustomerRepository
 */
public interface CustomerRepository {
    Customer getCustomerByCustomerNumber(CustomerNumber customerNumber);
}
