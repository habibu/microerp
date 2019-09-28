package com.habibu.service.api;
import com.habibu.model.PurchaseOrder;
import io.springlets.data.web.validation.ValidatorService;
import io.springlets.format.EntityResolver;
import org.springframework.roo.addon.layers.service.annotations.RooService;
import com.habibu.model.Product;
import io.springlets.data.domain.GlobalSearch;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * = PurchaseOrderService
 *
 * TODO Auto-generated class documentation
 *
 */
@RooService(entity = PurchaseOrder.class)
public interface PurchaseOrderService extends EntityResolver<PurchaseOrder, Long>, ValidatorService<PurchaseOrder> {

    /**
     * TODO Auto-generated method documentation
     *
     * @param id
     * @return PurchaseOrder
     */
    public abstract PurchaseOrder findOne(Long id);

    /**
     * TODO Auto-generated method documentation
     *
     * @param purchaseOrder
     */
    public abstract void delete(PurchaseOrder purchaseOrder);

    /**
     * TODO Auto-generated method documentation
     *
     * @param entities
     * @return List
     */
    public abstract List<PurchaseOrder> save(Iterable<PurchaseOrder> entities);

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
     * @return PurchaseOrder
     */
    public abstract PurchaseOrder save(PurchaseOrder entity);

    /**
     * TODO Auto-generated method documentation
     *
     * @param id
     * @return PurchaseOrder
     */
    public abstract PurchaseOrder findOneForUpdate(Long id);

    /**
     * TODO Auto-generated method documentation
     *
     * @param ids
     * @return List
     */
    public abstract List<PurchaseOrder> findAll(Iterable<Long> ids);

    /**
     * TODO Auto-generated method documentation
     *
     * @return List
     */
    public abstract List<PurchaseOrder> findAll();

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
    public abstract Page<PurchaseOrder> findAll(GlobalSearch globalSearch, Pageable pageable);

    /**
     * TODO Auto-generated method documentation
     *
     * @param ids
     * @param globalSearch
     * @param pageable
     * @return Page
     */
    public abstract Page<PurchaseOrder> findAllByIdsIn(List<Long> ids, GlobalSearch globalSearch, Pageable pageable);

    /**
     * TODO Auto-generated method documentation
     *
     * @param product
     * @param globalSearch
     * @param pageable
     * @return Page
     */
    public abstract Page<PurchaseOrder> findByProduct(Product product, GlobalSearch globalSearch, Pageable pageable);

    /**
     * TODO Auto-generated method documentation
     *
     * @param product
     * @return Long
     */
    public abstract long countByProduct(Product product);
}
