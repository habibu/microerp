package com.habibu.repository;

import io.springlets.data.jpa.repository.support.QueryDslRepositorySupportExt;
import org.springframework.roo.addon.layers.repository.jpa.annotations.RooJpaRepositoryCustomImpl;
import com.habibu.model.OrderDetail;

/**
 * = OrderDetailRepositoryImpl
 *
 * Implementation of OrderDetailRepositoryCustom
 *
 */
@RooJpaRepositoryCustomImpl(repository = OrderDetailRepositoryCustom.class)
public class OrderDetailRepositoryImpl extends QueryDslRepositorySupportExt<OrderDetail> implements OrderDetailRepositoryCustom{

    /**
     * Default constructor
     */
    OrderDetailRepositoryImpl() {
        super(OrderDetail.class);
    }
}