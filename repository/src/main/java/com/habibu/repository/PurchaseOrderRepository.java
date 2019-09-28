package com.habibu.repository;
import com.habibu.model.PurchaseOrder;
import io.springlets.data.jpa.repository.DetachableJpaRepository;
import org.springframework.roo.addon.layers.repository.jpa.annotations.RooJpaRepository;
import com.habibu.model.Product;
import org.springframework.transaction.annotation.Transactional;

/**
 * = PurchaseOrderRepository
 *
 * TODO Auto-generated class documentation
 *
 */
@RooJpaRepository(entity = PurchaseOrder.class)
@Transactional(readOnly = true)
public interface PurchaseOrderRepository extends DetachableJpaRepository<PurchaseOrder, Long>, PurchaseOrderRepositoryCustom {

    /**
     * TODO Auto-generated method documentation
     *
     * @param product
     * @return Long
     */
    public abstract long countByProduct(Product product);
}
