package com.habibu.repository;
import io.springlets.data.jpa.repository.support.QueryDslRepositorySupportExt;
import org.springframework.roo.addon.layers.repository.jpa.annotations.RooJpaRepositoryCustomImpl;
import com.habibu.model.OrderDetail;
import com.habibu.model.CustomerOrder;
import com.habibu.model.Product;
import com.habibu.model.QOrderDetail;
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
 * = OrderDetailRepositoryImpl
 *
 * TODO Auto-generated class documentation
 *
 */
@RooJpaRepositoryCustomImpl(repository = OrderDetailRepositoryCustom.class)
@Transactional(readOnly = true)
public class OrderDetailRepositoryImpl extends QueryDslRepositorySupportExt<OrderDetail> implements OrderDetailRepositoryCustom {

    /**
     * Default constructor
     */
    OrderDetailRepositoryImpl() {
        super(OrderDetail.class);
    }

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    public static final String QUANTITY = "quantity";

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    public static final String CUSTOMER_ORDER = "customerOrder";

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    public static final String PRODUCT = "product";

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    public static final String UNIT_PRICE = "unitPrice";

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    public static final String DISCOUNT = "discount";

    /**
     * TODO Auto-generated method documentation
     *
     * @param globalSearch
     * @param pageable
     * @return Page
     */
    public Page<OrderDetail> findAll(GlobalSearch globalSearch, Pageable pageable) {
        QOrderDetail orderDetail = QOrderDetail.orderDetail;
        JPQLQuery<OrderDetail> query = from(orderDetail);
        Path<?>[] paths = new Path<?>[] { orderDetail.customerOrder, orderDetail.product, orderDetail.unitPrice, orderDetail.quantity, orderDetail.discount };
        applyGlobalSearch(globalSearch, query, paths);
        AttributeMappingBuilder mapping = buildMapper().map(CUSTOMER_ORDER, orderDetail.customerOrder).map(PRODUCT, orderDetail.product).map(UNIT_PRICE, orderDetail.unitPrice).map(QUANTITY, orderDetail.quantity).map(DISCOUNT, orderDetail.discount);
        applyPagination(pageable, query, mapping);
        applyOrderById(query);
        return loadPage(query, pageable, orderDetail);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param ids
     * @param globalSearch
     * @param pageable
     * @return Page
     */
    public Page<OrderDetail> findAllByIdsIn(List<Long> ids, GlobalSearch globalSearch, Pageable pageable) {
        QOrderDetail orderDetail = QOrderDetail.orderDetail;
        JPQLQuery<OrderDetail> query = from(orderDetail);
        Path<?>[] paths = new Path<?>[] { orderDetail.customerOrder, orderDetail.product, orderDetail.unitPrice, orderDetail.quantity, orderDetail.discount };
        applyGlobalSearch(globalSearch, query, paths);
        // Also, filter by the provided ids
        query.where(orderDetail.id.in(ids));
        AttributeMappingBuilder mapping = buildMapper().map(CUSTOMER_ORDER, orderDetail.customerOrder).map(PRODUCT, orderDetail.product).map(UNIT_PRICE, orderDetail.unitPrice).map(QUANTITY, orderDetail.quantity).map(DISCOUNT, orderDetail.discount);
        applyPagination(pageable, query, mapping);
        applyOrderById(query);
        return loadPage(query, pageable, orderDetail);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param customerOrder
     * @param globalSearch
     * @param pageable
     * @return Page
     */
    public Page<OrderDetail> findByCustomerOrder(CustomerOrder customerOrder, GlobalSearch globalSearch, Pageable pageable) {
        QOrderDetail orderDetail = QOrderDetail.orderDetail;
        JPQLQuery<OrderDetail> query = from(orderDetail);
        Assert.notNull(customerOrder, "customerOrder is required");
        query.where(orderDetail.customerOrder.eq(customerOrder));
        Path<?>[] paths = new Path<?>[] { orderDetail.customerOrder, orderDetail.product, orderDetail.unitPrice, orderDetail.quantity, orderDetail.discount };
        applyGlobalSearch(globalSearch, query, paths);
        AttributeMappingBuilder mapping = buildMapper().map(CUSTOMER_ORDER, orderDetail.customerOrder).map(PRODUCT, orderDetail.product).map(UNIT_PRICE, orderDetail.unitPrice).map(QUANTITY, orderDetail.quantity).map(DISCOUNT, orderDetail.discount);
        applyPagination(pageable, query, mapping);
        applyOrderById(query);
        return loadPage(query, pageable, orderDetail);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param product
     * @param globalSearch
     * @param pageable
     * @return Page
     */
    public Page<OrderDetail> findByProduct(Product product, GlobalSearch globalSearch, Pageable pageable) {
        QOrderDetail orderDetail = QOrderDetail.orderDetail;
        JPQLQuery<OrderDetail> query = from(orderDetail);
        Assert.notNull(product, "product is required");
        query.where(orderDetail.product.eq(product));
        Path<?>[] paths = new Path<?>[] { orderDetail.customerOrder, orderDetail.product, orderDetail.unitPrice, orderDetail.quantity, orderDetail.discount };
        applyGlobalSearch(globalSearch, query, paths);
        AttributeMappingBuilder mapping = buildMapper().map(CUSTOMER_ORDER, orderDetail.customerOrder).map(PRODUCT, orderDetail.product).map(UNIT_PRICE, orderDetail.unitPrice).map(QUANTITY, orderDetail.quantity).map(DISCOUNT, orderDetail.discount);
        applyPagination(pageable, query, mapping);
        applyOrderById(query);
        return loadPage(query, pageable, orderDetail);
    }
}
