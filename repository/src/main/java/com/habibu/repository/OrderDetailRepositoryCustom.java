package com.habibu.repository;
import com.habibu.model.OrderDetail;
import org.springframework.roo.addon.layers.repository.jpa.annotations.RooJpaRepositoryCustom;
import com.habibu.model.CustomerOrder;
import com.habibu.model.Product;
import io.springlets.data.domain.GlobalSearch;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * = OrderDetailRepositoryCustom
 *
 * TODO Auto-generated class documentation
 *
 */
@RooJpaRepositoryCustom(entity = OrderDetail.class)
public interface OrderDetailRepositoryCustom {

    /**
     * TODO Auto-generated method documentation
     *
     * @param product
     * @param globalSearch
     * @param pageable
     * @return Page
     */
    public abstract Page<OrderDetail> findByProduct(Product product, GlobalSearch globalSearch, Pageable pageable);

    /**
     * TODO Auto-generated method documentation
     *
     * @param customerOrder
     * @param globalSearch
     * @param pageable
     * @return Page
     */
    public abstract Page<OrderDetail> findByCustomerOrder(CustomerOrder customerOrder, GlobalSearch globalSearch, Pageable pageable);

    /**
     * TODO Auto-generated method documentation
     *
     * @param globalSearch
     * @param pageable
     * @return Page
     */
    public abstract Page<OrderDetail> findAll(GlobalSearch globalSearch, Pageable pageable);

    /**
     * TODO Auto-generated method documentation
     *
     * @param ids
     * @param globalSearch
     * @param pageable
     * @return Page
     */
    public abstract Page<OrderDetail> findAllByIdsIn(List<Long> ids, GlobalSearch globalSearch, Pageable pageable);
}
