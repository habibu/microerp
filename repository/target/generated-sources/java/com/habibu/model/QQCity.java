package com.habibu.model;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QQCity is a Querydsl query type for QCity
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QQCity extends EntityPathBase<QCity> {

    private static final long serialVersionUID = 1740273097L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QQCity qCity = new QQCity("qCity");

    public final SetPath<CustomerOrder, QCustomerOrder> customerOrders = this.<CustomerOrder, QCustomerOrder>createSet("customerOrders", CustomerOrder.class, QCustomerOrder.class, PathInits.DIRECT2);

    public final StringPath description = createString("description");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final SetPath<Party, QParty> parties = this.<Party, QParty>createSet("parties", Party.class, QParty.class, PathInits.DIRECT2);

    public final QRegion region;

    public final SetPath<Store, QStore> stores = this.<Store, QStore>createSet("stores", Store.class, QStore.class, PathInits.DIRECT2);

    public final SetPath<Supplier, QSupplier> suppliers = this.<Supplier, QSupplier>createSet("suppliers", Supplier.class, QSupplier.class, PathInits.DIRECT2);

    public final NumberPath<Integer> version = createNumber("version", Integer.class);

    public QQCity(String variable) {
        this(QCity.class, forVariable(variable), INITS);
    }

    public QQCity(Path<? extends QCity> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QQCity(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QQCity(PathMetadata metadata, PathInits inits) {
        this(QCity.class, metadata, inits);
    }

    public QQCity(Class<? extends QCity> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.region = inits.isInitialized("region") ? new QRegion(forProperty("region"), inits.get("region")) : null;
    }

}

