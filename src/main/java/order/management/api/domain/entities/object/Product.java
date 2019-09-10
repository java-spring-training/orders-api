package order.management.api.domain.entities.object;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import order.management.api.domain.value.object.ProductCode;

/**
 * Product
 */
public class Product {

    @NotNull
    private ProductCode productCode;

    @NotEmpty
    private String productName;

    public Product(@NotNull ProductCode productCode, @NotEmpty String productName) {
        this.productCode = productCode;
        this.productName = productName;
    }

    public ProductCode getProductCode() {
        return productCode;
    }

    public void setProductCode(ProductCode productCode) {
        this.productCode = productCode;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }
}