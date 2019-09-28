package com.habibu.repository;
import com.habibu.model.Product;
import org.springframework.roo.addon.layers.repository.jpa.annotations.RooJpaRepositoryCustom;
import com.habibu.model.Category;
import com.habibu.model.Supplier;
import io.springlets.data.domain.GlobalSearch;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * = ProductRepositoryCustom
 *
 * TODO Auto-generated class documentation
 *
 */
@RooJpaRepositoryCustom(entity = Product.class)
public interface ProductRepositoryCustom {

    /**
     * TODO Auto-generated method documentation
     *
     * @param supplier
     * @param globalSearch
     * @param pageable
     * @return Page
     */
    public abstract Page<Product> findBySupplier(Supplier supplier, GlobalSearch globalSearch, Pageable pageable);

    /**
     * TODO Auto-generated method documentation
     *
     * @param category
     * @param globalSearch
     * @param pageable
     * @return Page
     */
    public abstract Page<Product> findByCategory(Category category, GlobalSearch globalSearch, Pageable pageable);

    /**
     * TODO Auto-generated method documentation
     *
     * @param globalSearch
     * @param pageable
     * @return Page
     */
    public abstract Page<Product> findAll(GlobalSearch globalSearch, Pageable pageable);

    /**
     * TODO Auto-generated method documentation
     *
     * @param ids
     * @param globalSearch
     * @param pageable
     * @return Page
     */
    public abstract Page<Product> findAllByIdsIn(List<Long> ids, GlobalSearch globalSearch, Pageable pageable);
}
