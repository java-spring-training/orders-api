package example.controller;

import example.service.ProductService;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {

    private final ProductService productService;

    @Autowired
    public ProductController(final ProductService productService) {
        this.productService = productService;
    }

    @PostMapping(value = "/v1/addProduct")
    public Success addProduct(@Valid @RequestBody ProductRequest productRequest,
                              BindingResult bindingResult) throws ParameterInvalidException
    {

        if(bindingResult.hasErrors()) {
            throw new ParameterInvalidException("Parameter invalid");
        }
        productService.addProduct(productRequest);
        return Success.builder().code(HttpStatus.OK.value())
                      .message("Success")
                      .detail("Add product is success")
                      .build();
    }
}
