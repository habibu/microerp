package com.habibu.repository;
import io.springlets.data.jpa.repository.support.QueryDslRepositorySupportExt;
import org.springframework.roo.addon.layers.repository.jpa.annotations.RooJpaRepositoryCustomImpl;
import com.habibu.model.SoldProduct;
import com.habibu.model.QSoldProduct;
import com.querydsl.core.types.Path;
import com.querydsl.jpa.JPQLQuery;
import io.springlets.data.domain.GlobalSearch;
import io.springlets.data.jpa.repository.support.QueryDslRepositorySupportExt.AttributeMappingBuilder;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;

/**
 * = SoldProductRepositoryImpl
 *
 * TODO Auto-generated class documentation
 *
 */
@RooJpaRepositoryCustomImpl(repository = SoldProductRepositoryCustom.class)
@Transactional(readOnly = true)
public class SoldProductRepositoryImpl extends QueryDslRepositorySupportExt<SoldProduct> implements SoldProductRepositoryCustom {

    /**
     * Default constructor
     */
    SoldProductRepositoryImpl() {
        super(SoldProduct.class);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param globalSearch
     * @param pageable
     * @return Page
     */
    public Page<SoldProduct> findAll(GlobalSearch globalSearch, Pageable pageable) {
        QSoldProduct soldProduct = QSoldProduct.soldProduct;
        JPQLQuery<SoldProduct> query = from(soldProduct);
        Path<?>[] paths = new Path<?>[] {  };
        applyGlobalSearch(globalSearch, query, paths);
        AttributeMappingBuilder mapping = buildMapper();
        applyPagination(pageable, query, mapping);
        applyOrderById(query);
        return loadPage(query, pageable, soldProduct);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param ids
     * @param globalSearch
     * @param pageable
     * @return Page
     */
    public Page<SoldProduct> findAllByIdsIn(List<Long> ids, GlobalSearch globalSearch, Pageable pageable) {
        QSoldProduct soldProduct = QSoldProduct.soldProduct;
        JPQLQuery<SoldProduct> query = from(soldProduct);
        Path<?>[] paths = new Path<?>[] {  };
        applyGlobalSearch(globalSearch, query, paths);
        // Also, filter by the provided ids
        query.where(soldProduct.id.in(ids));
        AttributeMappingBuilder mapping = buildMapper();
        applyPagination(pageable, query, mapping);
        applyOrderById(query);
        return loadPage(query, pageable, soldProduct);
    }
}
