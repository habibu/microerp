package com.habibu.repository;

import io.springlets.data.jpa.repository.support.QueryDslRepositorySupportExt;
import org.springframework.roo.addon.layers.repository.jpa.annotations.RooJpaRepositoryCustomImpl;
import com.habibu.model.Product;

/**
 * = ProductRepositoryImpl
 *
 * Implementation of ProductRepositoryCustom
 *
 */
@RooJpaRepositoryCustomImpl(repository = ProductRepositoryCustom.class)
public class ProductRepositoryImpl extends QueryDslRepositorySupportExt<Product> implements ProductRepositoryCustom{

    /**
     * Default constructor
     */
    ProductRepositoryImpl() {
        super(Product.class);
    }
}