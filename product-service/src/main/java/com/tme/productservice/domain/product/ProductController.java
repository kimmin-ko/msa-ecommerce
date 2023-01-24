package com.tme.productservice.domain.product;

import com.tme.productservice.common.response.CommonResponse;
import com.tme.productservice.domain.product.converter.web.DtoConverter;
import com.tme.productservice.domain.product.dto.web.ProductResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@RequestMapping("/product-service")
@RestController
public class ProductController {

    private final Environment env;
    private final ProductService service;
    private final ProductQueryService queryService;

    @GetMapping("/health-check")
    public String status() {
        return String.format("It's working in product service on port %s", env.getProperty("local.server.port"));
    }

    @GetMapping("/products")
    public CommonResponse<List<ProductResponse>> getProducts() {
        List<Product> products = queryService.findAll();
        List<ProductResponse> responses = products.stream()
                .map(DtoConverter::toProductResponse)
                .collect(Collectors.toList());
        return CommonResponse.withBody(responses);
    }

}
