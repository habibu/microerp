package com.habibu.repository;
import io.springlets.data.jpa.repository.support.QueryDslRepositorySupportExt;
import org.springframework.roo.addon.layers.repository.jpa.annotations.RooJpaRepositoryCustomImpl;
import com.habibu.model.Shipper;
import com.habibu.model.QShipper;
import com.habibu.model.ShipperPhoneFormBean;
import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.Path;
import com.querydsl.jpa.JPQLQuery;
import io.springlets.data.domain.GlobalSearch;
import io.springlets.data.jpa.repository.support.QueryDslRepositorySupportExt.AttributeMappingBuilder;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;

/**
 * = ShipperRepositoryImpl
 *
 * TODO Auto-generated class documentation
 *
 */
@RooJpaRepositoryCustomImpl(repository = ShipperRepositoryCustom.class)
@Transactional(readOnly = true)
public class ShipperRepositoryImpl extends QueryDslRepositorySupportExt<Shipper> implements ShipperRepositoryCustom {

    /**
     * Default constructor
     */
    ShipperRepositoryImpl() {
        super(Shipper.class);
    }

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    public static final String COMPANY_NAME = "companyName";

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    public static final String PHONE = "phone";

    /**
     * TODO Auto-generated method documentation
     *
     * @param globalSearch
     * @param pageable
     * @return Page
     */
    public Page<Shipper> findAll(GlobalSearch globalSearch, Pageable pageable) {
        QShipper shipper = QShipper.shipper;
        JPQLQuery<Shipper> query = from(shipper);
        Path<?>[] paths = new Path<?>[] { shipper.companyName, shipper.phone };
        applyGlobalSearch(globalSearch, query, paths);
        AttributeMappingBuilder mapping = buildMapper().map(COMPANY_NAME, shipper.companyName).map(PHONE, shipper.phone);
        applyPagination(pageable, query, mapping);
        applyOrderById(query);
        return loadPage(query, pageable, shipper);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param ids
     * @param globalSearch
     * @param pageable
     * @return Page
     */
    public Page<Shipper> findAllByIdsIn(List<Long> ids, GlobalSearch globalSearch, Pageable pageable) {
        QShipper shipper = QShipper.shipper;
        JPQLQuery<Shipper> query = from(shipper);
        Path<?>[] paths = new Path<?>[] { shipper.companyName, shipper.phone };
        applyGlobalSearch(globalSearch, query, paths);
        // Also, filter by the provided ids
        query.where(shipper.id.in(ids));
        AttributeMappingBuilder mapping = buildMapper().map(COMPANY_NAME, shipper.companyName).map(PHONE, shipper.phone);
        applyPagination(pageable, query, mapping);
        applyOrderById(query);
        return loadPage(query, pageable, shipper);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param formBean
     * @param globalSearch
     * @param pageable
     * @return Page
     */
    public Page<Shipper> findByPhone(ShipperPhoneFormBean formBean, GlobalSearch globalSearch, Pageable pageable) {
        QShipper shipper = QShipper.shipper;
        JPQLQuery<Shipper> query = from(shipper);
        if (formBean != null) {
            BooleanBuilder searchCondition = new BooleanBuilder();
            if (formBean.getPhone() != null) {
                searchCondition.and(shipper.phone.eq(formBean.getPhone()));
            }
            if (searchCondition.hasValue()) {
                query.where(searchCondition);
            }
        }
        Path<?>[] paths = new Path<?>[] { shipper.companyName, shipper.phone };
        applyGlobalSearch(globalSearch, query, paths);
        AttributeMappingBuilder mapping = buildMapper().map(COMPANY_NAME, shipper.companyName).map(PHONE, shipper.phone);
        applyPagination(pageable, query, mapping);
        applyOrderById(query);
        return loadPage(query, pageable, shipper);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param formBean
     * @return Long
     */
    public long countByPhone(ShipperPhoneFormBean formBean) {
        QShipper shipper = QShipper.shipper;
        JPQLQuery<Shipper> query = from(shipper);
        BooleanBuilder searchCondition = new BooleanBuilder();
        if (formBean.getPhone() != null) {
            searchCondition.and(shipper.phone.eq(formBean.getPhone()));
        }
        if (searchCondition.hasValue()) {
            query.where(searchCondition);
        }
        return query.fetchCount();
    }
}
