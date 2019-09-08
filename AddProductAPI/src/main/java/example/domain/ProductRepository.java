package example.domain;

import java.math.BigDecimal;

public interface ProductRepository {
    void addProduct(String code,String name, BigDecimal buyPrice,
                    BigDecimal msrp, String description, String line,
                    String scale, String vendor, int quantityInStock);
}
