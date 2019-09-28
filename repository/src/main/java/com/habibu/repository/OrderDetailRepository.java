package com.habibu.repository;
import com.habibu.model.OrderDetail;
import io.springlets.data.jpa.repository.DetachableJpaRepository;
import org.springframework.roo.addon.layers.repository.jpa.annotations.RooJpaRepository;
import com.habibu.model.CustomerOrder;
import com.habibu.model.Product;
import org.springframework.transaction.annotation.Transactional;

/**
 * = OrderDetailRepository
 *
 * TODO Auto-generated class documentation
 *
 */
@RooJpaRepository(entity = OrderDetail.class)
@Transactional(readOnly = true)
public interface OrderDetailRepository extends DetachableJpaRepository<OrderDetail, Long>, OrderDetailRepositoryCustom {

    /**
     * TODO Auto-generated method documentation
     *
     * @param product
     * @return Long
     */
    public abstract long countByProduct(Product product);

    /**
     * TODO Auto-generated method documentation
     *
     * @param customerOrder
     * @return Long
     */
    public abstract long countByCustomerOrder(CustomerOrder customerOrder);
}
