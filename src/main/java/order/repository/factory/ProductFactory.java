package order.repository.factory;

import order.domain.entities.object.Product;
import order.domain.value.object.ProductCode;
import order.repository.model.ProductModel;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ProductFactory {

    public List<Product> toListProduct(List<ProductModel> productModelList) {

        return productModelList.stream().map(this::toProduct).collect(Collectors.toList());
    }

    public Product toFirstProduct(List<ProductModel> productModelList) {
        return toProduct(productModelList.get(0));
    }

    public Product toProduct(ProductModel productModel) {

        ProductCode productCode = new ProductCode(productModel.getProductCode());

        return new Product(
                productCode
                , productModel.getProductName()
                , productModel.getProductLine()
                , productModel.getProductScale()
                , productModel.getProductVendor()
                , productModel.getProductDescription()
                , productModel.getQuantityInStock()
                , productModel.getBuyPrice()
                , productModel.getMsrp()
        );
    }
}