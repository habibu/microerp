package com.habibu.repository;

import io.springlets.data.jpa.repository.support.QueryDslRepositorySupportExt;
import org.springframework.roo.addon.layers.repository.jpa.annotations.RooJpaRepositoryCustomImpl;
import com.habibu.model.Shipper;

/**
 * = ShipperRepositoryImpl
 *
 * Implementation of ShipperRepositoryCustom
 *
 */
@RooJpaRepositoryCustomImpl(repository = ShipperRepositoryCustom.class)
public class ShipperRepositoryImpl extends QueryDslRepositorySupportExt<Shipper> implements ShipperRepositoryCustom{

    /**
     * Default constructor
     */
    ShipperRepositoryImpl() {
        super(Shipper.class);
    }
}