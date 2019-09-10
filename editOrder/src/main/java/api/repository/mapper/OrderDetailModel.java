package api.repository.mapper;

public class OrderDetailModel {

    private String productCode;


    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public OrderDetailModel(String productCode) {
        this.productCode = productCode;
    }
}
