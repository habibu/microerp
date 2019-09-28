package com.habibu.repository;
import com.habibu.model.SoldProduct;
import io.springlets.data.jpa.repository.DetachableJpaRepository;
import org.springframework.roo.addon.layers.repository.jpa.annotations.RooJpaRepository;
import org.springframework.transaction.annotation.Transactional;

/**
 * = SoldProductRepository
 *
 * TODO Auto-generated class documentation
 *
 */
@RooJpaRepository(entity = SoldProduct.class)
@Transactional(readOnly = true)
public interface SoldProductRepository extends DetachableJpaRepository<SoldProduct, Long>, SoldProductRepositoryCustom {
}
