package example.service;

import example.controller.ProductRequest;
import example.domain.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {
    private final ProductRepository productRepository;

    @Autowired
    public ProductService(final ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public void addProduct(ProductRequest productRequest) {
        productRepository.addProduct(productRequest.getProductCode(),
                                     productRequest.getProductName(),
                                     productRequest.getBuyPrice(),productRequest.getMsrp(),
                                     productRequest.getProductDescription(),productRequest.getProductLine(),
                                     productRequest.getProductScale(), productRequest.getProductVendor(),
                                     productRequest.getQuantityInStock());
    }

}
