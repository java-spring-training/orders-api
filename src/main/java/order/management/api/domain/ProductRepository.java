package order.management.api.domain;

import order.management.api.domain.entities.object.Product;
import order.management.api.domain.value.object.ProductCode;

/**
 * ProductRepository
 */
public interface ProductRepository {
    Product getProductByProductCode(ProductCode productCode);
}
