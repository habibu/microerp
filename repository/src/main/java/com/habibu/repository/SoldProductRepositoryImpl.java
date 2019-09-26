package com.habibu.repository;

import io.springlets.data.jpa.repository.support.QueryDslRepositorySupportExt;
import org.springframework.roo.addon.layers.repository.jpa.annotations.RooJpaRepositoryCustomImpl;
import com.habibu.model.SoldProduct;

/**
 * = SoldProductRepositoryImpl
 *
 * Implementation of SoldProductRepositoryCustom
 *
 */
@RooJpaRepositoryCustomImpl(repository = SoldProductRepositoryCustom.class)
public class SoldProductRepositoryImpl extends QueryDslRepositorySupportExt<SoldProduct> implements SoldProductRepositoryCustom{

    /**
     * Default constructor
     */
    SoldProductRepositoryImpl() {
        super(SoldProduct.class);
    }
}