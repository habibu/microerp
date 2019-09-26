package com.habibu.repository;
import com.habibu.model.SoldProduct;
import io.springlets.data.jpa.repository.DetachableJpaRepository;
import org.springframework.roo.addon.layers.repository.jpa.annotations.RooJpaRepository;

/**
 * = SoldProductRepository
 *
 * TODO Auto-generated class documentation
 *
 */
@RooJpaRepository(entity = SoldProduct.class)
public interface SoldProductRepository extends DetachableJpaRepository<SoldProduct, Long>, SoldProductRepositoryCustom {
}
