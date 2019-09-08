package order.management.api.domain;

import order.management.api.domain.entities.object.Products;

import java.util.List;

public interface ProductRepository {

    List<Products> getAll();
}
