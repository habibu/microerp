package com.habibu.service.impl;
import com.habibu.service.api.PurchaseOrderService;
import org.springframework.roo.addon.layers.service.annotations.RooServiceImpl;
import com.habibu.model.Product;
import com.habibu.model.PurchaseOrder;
import com.habibu.repository.PurchaseOrderRepository;
import io.springlets.data.domain.GlobalSearch;
import io.springlets.data.web.validation.MessageI18n;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * = PurchaseOrderServiceImpl
 *
 * TODO Auto-generated class documentation
 *
 */
@RooServiceImpl(service = PurchaseOrderService.class)
@Service
@Transactional(readOnly = true)
public class PurchaseOrderServiceImpl implements PurchaseOrderService {

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    private PurchaseOrderRepository purchaseOrderRepository;

    /**
     * TODO Auto-generated constructor documentation
     *
     * @param purchaseOrderRepository
     */
    @Autowired
    public PurchaseOrderServiceImpl(PurchaseOrderRepository purchaseOrderRepository) {
        setPurchaseOrderRepository(purchaseOrderRepository);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @return PurchaseOrderRepository
     */
    public PurchaseOrderRepository getPurchaseOrderRepository() {
        return purchaseOrderRepository;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param purchaseOrderRepository
     */
    public void setPurchaseOrderRepository(PurchaseOrderRepository purchaseOrderRepository) {
        this.purchaseOrderRepository = purchaseOrderRepository;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param purchaseorder
     * @return Map
     */
    public Map<String, List<MessageI18n>> validate(PurchaseOrder purchaseorder) {
        Map<String, List<MessageI18n>> messages = new java.util.HashMap<String, List<MessageI18n>>();
        // TODO: IMPLEMENT HERE THE VALIDATION OF YOUR ENTITY
        return messages;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param purchaseOrder
     */
    @Transactional
    public void delete(PurchaseOrder purchaseOrder) {
        // Clear bidirectional many-to-one child relationship with Product
        if (purchaseOrder.getProduct() != null) {
            purchaseOrder.getProduct().getPurchaseOrders().remove(purchaseOrder);
        }
        getPurchaseOrderRepository().delete(purchaseOrder);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param entities
     * @return List
     */
    @Transactional
    public List<PurchaseOrder> save(Iterable<PurchaseOrder> entities) {
        return getPurchaseOrderRepository().save(entities);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param ids
     */
    @Transactional
    public void delete(Iterable<Long> ids) {
        List<PurchaseOrder> toDelete = getPurchaseOrderRepository().findAll(ids);
        getPurchaseOrderRepository().deleteInBatch(toDelete);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param entity
     * @return PurchaseOrder
     */
    @Transactional
    public PurchaseOrder save(PurchaseOrder entity) {
        return getPurchaseOrderRepository().save(entity);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param id
     * @return PurchaseOrder
     */
    public PurchaseOrder findOne(Long id) {
        return getPurchaseOrderRepository().findOne(id);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param id
     * @return PurchaseOrder
     */
    public PurchaseOrder findOneForUpdate(Long id) {
        return getPurchaseOrderRepository().findOneDetached(id);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param ids
     * @return List
     */
    public List<PurchaseOrder> findAll(Iterable<Long> ids) {
        return getPurchaseOrderRepository().findAll(ids);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @return List
     */
    public List<PurchaseOrder> findAll() {
        return getPurchaseOrderRepository().findAll();
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @return Long
     */
    public long count() {
        return getPurchaseOrderRepository().count();
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param globalSearch
     * @param pageable
     * @return Page
     */
    public Page<PurchaseOrder> findAll(GlobalSearch globalSearch, Pageable pageable) {
        return getPurchaseOrderRepository().findAll(globalSearch, pageable);
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
        return getPurchaseOrderRepository().findAllByIdsIn(ids, globalSearch, pageable);
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
        return getPurchaseOrderRepository().findByProduct(product, globalSearch, pageable);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param product
     * @return Long
     */
    public long countByProduct(Product product) {
        return getPurchaseOrderRepository().countByProduct(product);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @return Class
     */
    public Class<PurchaseOrder> getEntityType() {
        return PurchaseOrder.class;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @return Class
     */
    public Class<Long> getIdType() {
        return Long.class;
    }
}
