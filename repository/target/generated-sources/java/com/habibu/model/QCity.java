package com.habibu.model;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QCity is a Querydsl query type for City
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QCity extends EntityPathBase<City> {

    private static final long serialVersionUID = -2022452354L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QCity city = new QCity("city");

    public final SetPath<CustomerOrder, QCustomerOrder> customerOrders = this.<CustomerOrder, QCustomerOrder>createSet("customerOrders", CustomerOrder.class, QCustomerOrder.class, PathInits.DIRECT2);

    public final StringPath description = createString("description");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final SetPath<Party, QParty> parties = this.<Party, QParty>createSet("parties", Party.class, QParty.class, PathInits.DIRECT2);

    public final QRegion region;

    public final SetPath<Store, QStore> stores = this.<Store, QStore>createSet("stores", Store.class, QStore.class, PathInits.DIRECT2);

    public final SetPath<Supplier, QSupplier> suppliers = this.<Supplier, QSupplier>createSet("suppliers", Supplier.class, QSupplier.class, PathInits.DIRECT2);

    public final NumberPath<Integer> version = createNumber("version", Integer.class);

    public QCity(String variable) {
        this(City.class, forVariable(variable), INITS);
    }

    public QCity(Path<? extends City> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QCity(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QCity(PathMetadata metadata, PathInits inits) {
        this(City.class, metadata, inits);
    }

    public QCity(Class<? extends City> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.region = inits.isInitialized("region") ? new QRegion(forProperty("region"), inits.get("region")) : null;
    }

}

