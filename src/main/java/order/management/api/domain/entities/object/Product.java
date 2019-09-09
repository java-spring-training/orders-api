package order.management.api.domain.entities.object;

import java.math.BigDecimal;

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

    @NotEmpty
    private String productLine;

    @NotEmpty
    private String productScale;

    @NotEmpty
    private String productVendor;

    @NotEmpty
    private String productDescription;

    @NotNull
    private int quantityInStock;

    @NotNull
    private BigDecimal buyPrice;

    @NotNull
    private BigDecimal MSRP;

    public Product(@NotNull ProductCode productCode, @NotEmpty String productName, @NotEmpty String productLine,
            @NotEmpty String productScale, @NotEmpty String productVendor, @NotEmpty String productDescription,
            @NotNull int quantityInStock, @NotNull BigDecimal buyPrice, @NotNull BigDecimal mSRP) {
        this.productCode = productCode;
        this.productName = productName;
        this.productLine = productLine;
        this.productScale = productScale;
        this.productVendor = productVendor;
        this.productDescription = productDescription;
        this.quantityInStock = quantityInStock;
        this.buyPrice = buyPrice;
        MSRP = mSRP;
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

    public String getProductLine() {
        return productLine;
    }

    public void setProductLine(String productLine) {
        this.productLine = productLine;
    }

    public String getProductScale() {
        return productScale;
    }

    public void setProductScale(String productScale) {
        this.productScale = productScale;
    }

    public String getProductVendor() {
        return productVendor;
    }

    public void setProductVendor(String productVendor) {
        this.productVendor = productVendor;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    public int getQuantityInStock() {
        return quantityInStock;
    }

    public void setQuantityInStock(int quantityInStock) {
        this.quantityInStock = quantityInStock;
    }

    public BigDecimal getBuyPrice() {
        return buyPrice;
    }

    public void setBuyPrice(BigDecimal buyPrice) {
        this.buyPrice = buyPrice;
    }

    public BigDecimal getMSRP() {
        return MSRP;
    }

    public void setMSRP(BigDecimal mSRP) {
        MSRP = mSRP;
    }
}