package com.habibu.model;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QShipper is a Querydsl query type for Shipper
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QShipper extends EntityPathBase<Shipper> {

    private static final long serialVersionUID = 199362158L;

    public static final QShipper shipper = new QShipper("shipper");

    public final StringPath companyName = createString("companyName");

    public final SetPath<CustomerOrder, QCustomerOrder> customerOrders = this.<CustomerOrder, QCustomerOrder>createSet("customerOrders", CustomerOrder.class, QCustomerOrder.class, PathInits.DIRECT2);

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath phone = createString("phone");

    public final NumberPath<Integer> version = createNumber("version", Integer.class);

    public QShipper(String variable) {
        super(Shipper.class, forVariable(variable));
    }

    public QShipper(Path<? extends Shipper> path) {
        super(path.getType(), path.getMetadata());
    }

    public QShipper(PathMetadata metadata) {
        super(Shipper.class, metadata);
    }

}

