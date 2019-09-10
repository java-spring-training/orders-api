package order.management.api.domain.value.object;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

/**
 * ProductCode
 */
public class ProductCode {
    @Size(min = 15, max = 15)
    private String code;

    public ProductCode(@Size(min = 15, max = 15) String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }
}
