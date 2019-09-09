package order.management.api.controller;

import java.util.List;

public class OrderResponse {

    List<OrderResult> results;

    public OrderResponse(List<OrderResult> results) {
        this.results = results;
    }

    public List<OrderResult> getResults() {
        return results;
    }

    public void setResults(List<OrderResult> results) {
        this.results = results;
    }
}
