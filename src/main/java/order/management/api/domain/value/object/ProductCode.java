package order.management.api.domain.value.object;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

/**
 * ProductCode
 */
public class ProductCode {
    @NotEmpty
    @Size(min = 15, max = 15, message = "Product code must contain 15 characters")
    private String code;

    public ProductCode(@Size(min = 15, max = 15, message = "Product code must contain 15 characters") String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }
}
