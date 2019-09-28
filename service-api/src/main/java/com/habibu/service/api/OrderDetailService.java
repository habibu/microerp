package com.habibu.service.api;
import com.habibu.model.OrderDetail;
import io.springlets.data.web.validation.ValidatorService;
import io.springlets.format.EntityResolver;
import org.springframework.roo.addon.layers.service.annotations.RooService;
import com.habibu.model.CustomerOrder;
import com.habibu.model.Product;
import io.springlets.data.domain.GlobalSearch;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * = OrderDetailService
 *
 * TODO Auto-generated class documentation
 *
 */
@RooService(entity = OrderDetail.class)
public interface OrderDetailService extends EntityResolver<OrderDetail, Long>, ValidatorService<OrderDetail> {

    /**
     * TODO Auto-generated method documentation
     *
     * @param id
     * @return OrderDetail
     */
    public abstract OrderDetail findOne(Long id);

    /**
     * TODO Auto-generated method documentation
     *
     * @param orderDetail
     */
    public abstract void delete(OrderDetail orderDetail);

    /**
     * TODO Auto-generated method documentation
     *
     * @param entities
     * @return List
     */
    public abstract List<OrderDetail> save(Iterable<OrderDetail> entities);

    /**
     * TODO Auto-generated method documentation
     *
     * @param ids
     */
    public abstract void delete(Iterable<Long> ids);

    /**
     * TODO Auto-generated method documentation
     *
     * @param entity
     * @return OrderDetail
     */
    public abstract OrderDetail save(OrderDetail entity);

    /**
     * TODO Auto-generated method documentation
     *
     * @param id
     * @return OrderDetail
     */
    public abstract OrderDetail findOneForUpdate(Long id);

    /**
     * TODO Auto-generated method documentation
     *
     * @param ids
     * @return List
     */
    public abstract List<OrderDetail> findAll(Iterable<Long> ids);

    /**
     * TODO Auto-generated method documentation
     *
     * @return List
     */
    public abstract List<OrderDetail> findAll();

    /**
     * TODO Auto-generated method documentation
     *
     * @return Long
     */
    public abstract long count();

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
     * @return Long
     */
    public abstract long countByCustomerOrder(CustomerOrder customerOrder);

    /**
     * TODO Auto-generated method documentation
     *
     * @param product
     * @return Long
     */
    public abstract long countByProduct(Product product);
}
