package example.controller;

import java.math.BigDecimal;
import javax.validation.constraints.NotNull;
import lombok.Getter;

@Getter
public class ProductRequest {
    @NotNull
    private String productCode;
    @NotNull
    private String productName;
    @NotNull
    private String productLine;
    @NotNull
    private String productScale;
    @NotNull
    private String productVendor;
    @NotNull
    private String productDescription;
    @NotNull
    private int quantityInStock;
    @NotNull
    private BigDecimal buyPrice;
    @NotNull
    private BigDecimal msrp;
}
