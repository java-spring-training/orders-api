package order.management.api.repository;

import order.management.api.domain.entities.object.Product;
import order.management.api.domain.value.object.ProductCode;
import order.management.api.repository.mapper.ProductModel;

import java.math.BigDecimal;

import org.springframework.stereotype.Component;

@Component
public class ProductFactory {
    public Product toProduct(ProductModel customerModel) {

        ProductCode productCode = new ProductCode(customerModel.getProductCode());
        String productName = customerModel.getProductName();
        String productLine = customerModel.getProductLine();
        String productScale = customerModel.getProductScale();
        String productVendor = customerModel.getProductVendor();
        String productDescription = customerModel.getProductDescription();
        int quantityInStock = customerModel.getQuantityInStock();
        BigDecimal buyPrice = customerModel.getBuyPrice();
        BigDecimal mSRP = customerModel.getMSRP();

        return new Product(productCode, productName, productLine, productScale, productVendor, productDescription,
                quantityInStock, buyPrice, mSRP);
    }
}
