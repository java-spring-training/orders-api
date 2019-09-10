package api.domain.entities.object;

public class OrderDetail {

    private Integer quanlityOrdered;
    private Integer priceEach;
    private Integer orderLineNumber;

    public OrderDetail(Integer quanlityOrdered, Integer priceEach, Integer orderLineNumber) {
        this.quanlityOrdered = quanlityOrdered;
        this.priceEach = priceEach;
        this.orderLineNumber = orderLineNumber;
    }

    public Integer getQuanlityOrdered() {
        return quanlityOrdered;
    }

    public void setQuanlityOrdered(Integer quanlityOrdered) {
        this.quanlityOrdered = quanlityOrdered;
    }

    public Integer getPriceEach() {
        return priceEach;
    }

    public void setPriceEach(Integer priceEach) {
        this.priceEach = priceEach;
    }

    public Integer getOrderLineNumber() {
        return orderLineNumber;
    }

    public void setOrderLineNumber(Integer orderLineNumber) {
        this.orderLineNumber = orderLineNumber;
    }
}
