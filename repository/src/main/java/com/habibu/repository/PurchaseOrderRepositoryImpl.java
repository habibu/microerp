package com.habibu.repository;
import io.springlets.data.jpa.repository.support.QueryDslRepositorySupportExt;
import org.springframework.roo.addon.layers.repository.jpa.annotations.RooJpaRepositoryCustomImpl;
import com.habibu.model.PurchaseOrder;
import com.habibu.model.Product;
import com.habibu.model.QPurchaseOrder;
import com.querydsl.core.types.Path;
import com.querydsl.jpa.JPQLQuery;
import io.springlets.data.domain.GlobalSearch;
import io.springlets.data.jpa.repository.support.QueryDslRepositorySupportExt.AttributeMappingBuilder;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

/**
 * = PurchaseOrderRepositoryImpl
 *
 * TODO Auto-generated class documentation
 *
 */
@RooJpaRepositoryCustomImpl(repository = PurchaseOrderRepositoryCustom.class)
@Transactional(readOnly = true)
public class PurchaseOrderRepositoryImpl extends QueryDslRepositorySupportExt<PurchaseOrder> implements PurchaseOrderRepositoryCustom {

    /**
     * Default constructor
     */
    PurchaseOrderRepositoryImpl() {
        super(PurchaseOrder.class);
    }

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    public static final String UNIT_COST = "unitCost";

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    public static final String ORDER_DATE = "orderDate";

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    public static final String QUANTITY = "quantity";

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    public static final String PRODUCT = "product";

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    public static final String EMPLOYEE = "employee";

    /**
     * TODO Auto-generated method documentation
     *
     * @param globalSearch
     * @param pageable
     * @return Page
     */
    public Page<PurchaseOrder> findAll(GlobalSearch globalSearch, Pageable pageable) {
        QPurchaseOrder purchaseOrder = QPurchaseOrder.purchaseOrder;
        JPQLQuery<PurchaseOrder> query = from(purchaseOrder);
        Path<?>[] paths = new Path<?>[] { purchaseOrder.product, purchaseOrder.employee, purchaseOrder.unitCost, purchaseOrder.quantity, purchaseOrder.orderDate };
        applyGlobalSearch(globalSearch, query, paths);
        AttributeMappingBuilder mapping = buildMapper().map(PRODUCT, purchaseOrder.product).map(EMPLOYEE, purchaseOrder.employee).map(UNIT_COST, purchaseOrder.unitCost).map(QUANTITY, purchaseOrder.quantity).map(ORDER_DATE, purchaseOrder.orderDate);
        applyPagination(pageable, query, mapping);
        applyOrderById(query);
        return loadPage(query, pageable, purchaseOrder);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param ids
     * @param globalSearch
     * @param pageable
     * @return Page
     */
    public Page<PurchaseOrder> findAllByIdsIn(List<Long> ids, GlobalSearch globalSearch, Pageable pageable) {
        QPurchaseOrder purchaseOrder = QPurchaseOrder.purchaseOrder;
        JPQLQuery<PurchaseOrder> query = from(purchaseOrder);
        Path<?>[] paths = new Path<?>[] { purchaseOrder.product, purchaseOrder.employee, purchaseOrder.unitCost, purchaseOrder.quantity, purchaseOrder.orderDate };
        applyGlobalSearch(globalSearch, query, paths);
        // Also, filter by the provided ids
        query.where(purchaseOrder.id.in(ids));
        AttributeMappingBuilder mapping = buildMapper().map(PRODUCT, purchaseOrder.product).map(EMPLOYEE, purchaseOrder.employee).map(UNIT_COST, purchaseOrder.unitCost).map(QUANTITY, purchaseOrder.quantity).map(ORDER_DATE, purchaseOrder.orderDate);
        applyPagination(pageable, query, mapping);
        applyOrderById(query);
        return loadPage(query, pageable, purchaseOrder);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param product
     * @param globalSearch
     * @param pageable
     * @return Page
     */
    public Page<PurchaseOrder> findByProduct(Product product, GlobalSearch globalSearch, Pageable pageable) {
        QPurchaseOrder purchaseOrder = QPurchaseOrder.purchaseOrder;
        JPQLQuery<PurchaseOrder> query = from(purchaseOrder);
        Assert.notNull(product, "product is required");
        query.where(purchaseOrder.product.eq(product));
        Path<?>[] paths = new Path<?>[] { purchaseOrder.product, purchaseOrder.employee, purchaseOrder.unitCost, purchaseOrder.quantity, purchaseOrder.orderDate };
        applyGlobalSearch(globalSearch, query, paths);
        AttributeMappingBuilder mapping = buildMapper().map(PRODUCT, purchaseOrder.product).map(EMPLOYEE, purchaseOrder.employee).map(UNIT_COST, purchaseOrder.unitCost).map(QUANTITY, purchaseOrder.quantity).map(ORDER_DATE, purchaseOrder.orderDate);
        applyPagination(pageable, query, mapping);
        applyOrderById(query);
        return loadPage(query, pageable, purchaseOrder);
    }
}
