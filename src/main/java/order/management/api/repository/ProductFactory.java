package order.management.api.repository;

import order.management.api.domain.entities.object.Products;
import order.management.api.domain.value.object.ProductCode;
import order.management.api.repository.mapper.ProductsModel;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ProductFactory {

    public List<Products> toListProduct(List<ProductsModel> productsModelList) {

        return productsModelList.stream().map(this::toProduct).collect(Collectors.toList());
    }

    private Products toProduct(ProductsModel productsModel) {

        ProductCode productCode = new ProductCode(productsModel.getProductCode());

        return new Products(productCode, productsModel.getProductName());
    }
}
