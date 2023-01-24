package com.tme.productservice.domain.product;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional(readOnly = true)
@RequiredArgsConstructor
@Service
public class ProductQueryService {

    private final ProductRepository repository;

    // TODO: refactoring pagination
    public List<Product> findAll() {
        return repository.findAll();
    }

}
