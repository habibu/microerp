package com.habibu.model;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QEmployee is a Querydsl query type for Employee
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QEmployee extends EntityPathBase<Employee> {

    private static final long serialVersionUID = -699998399L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QEmployee employee = new QEmployee("employee");

    public final QParty _super;

    //inherited
    public final StringPath address;

    // inherited
    public final QCity city;

    // inherited
    public final QCountry country;

    //inherited
    public final NumberPath<Long> id;

    //inherited
    public final StringPath phone;

    //inherited
    public final StringPath postalCode;

    // inherited
    public final QRegion region;

    //inherited
    public final NumberPath<Integer> version;

    public QEmployee(String variable) {
        this(Employee.class, forVariable(variable), INITS);
    }

    public QEmployee(Path<? extends Employee> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QEmployee(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QEmployee(PathMetadata metadata, PathInits inits) {
        this(Employee.class, metadata, inits);
    }

    public QEmployee(Class<? extends Employee> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this._super = new QParty(type, metadata, inits);
        this.address = _super.address;
        this.city = _super.city;
        this.country = _super.country;
        this.id = _super.id;
        this.phone = _super.phone;
        this.postalCode = _super.postalCode;
        this.region = _super.region;
        this.version = _super.version;
    }

}

