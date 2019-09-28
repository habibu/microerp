package com.habibu.repository;
import com.habibu.model.Product;
import io.springlets.data.jpa.repository.DetachableJpaRepository;
import org.springframework.roo.addon.layers.repository.jpa.annotations.RooJpaRepository;
import org.springframework.roo.addon.layers.repository.jpa.annotations.finder.RooFinder;
import com.habibu.model.Category;
import com.habibu.model.Supplier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;

/**
 * = ProductRepository
 *
 * TODO Auto-generated class documentation
 *
 */
@RooJpaRepository(entity = Product.class, finders = { @RooFinder(value = "findByDiscontinuedOrderByNameAsc", returnType = Product.class) })
@Transactional(readOnly = true)
public interface ProductRepository extends DetachableJpaRepository<Product, Long>, ProductRepositoryCustom {

    /**
     * TODO Auto-generated method documentation
     *
     * @param supplier
     * @return Long
     */
    public abstract long countBySupplier(Supplier supplier);

    /**
     * TODO Auto-generated method documentation
     *
     * @param category
     * @return Long
     */
    public abstract long countByCategory(Category category);

    /**
     * TODO Auto-generated method documentation
     *
     * @param discontinued
     * @param pageable
     * @return Page
     */
    public abstract Page<Product> findByDiscontinuedOrderByNameAsc(Boolean discontinued, Pageable pageable);

    /**
     * TODO Auto-generated method documentation
     *
     * @param discontinued
     * @return Long
     */
    public abstract long countByDiscontinuedOrderByNameAsc(Boolean discontinued);
}
