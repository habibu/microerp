package com.habibu.repository;
import com.habibu.model.Category;
import io.springlets.data.jpa.repository.DetachableJpaRepository;
import org.springframework.roo.addon.layers.repository.jpa.annotations.RooJpaRepository;

/**
 * = CategoryRepository
 *
 * TODO Auto-generated class documentation
 *
 */
@RooJpaRepository(entity = Category.class)
public interface CategoryRepository extends DetachableJpaRepository<Category, Long>, CategoryRepositoryCustom {
}
