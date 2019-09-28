package com.habibu.repository;
import com.habibu.model.PurchaseOrder;
import org.springframework.roo.addon.layers.repository.jpa.annotations.RooJpaRepositoryCustom;
import com.habibu.model.Product;
import io.springlets.data.domain.GlobalSearch;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * = PurchaseOrderRepositoryCustom
 *
 * TODO Auto-generated class documentation
 *
 */
@RooJpaRepositoryCustom(entity = PurchaseOrder.class)
public interface PurchaseOrderRepositoryCustom {

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
}
