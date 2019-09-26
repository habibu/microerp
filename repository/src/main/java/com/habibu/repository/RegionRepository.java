package com.habibu.repository;
import com.habibu.model.Region;
import org.springframework.roo.addon.layers.repository.jpa.annotations.RooJpaRepository;

/**
 * = RegionRepository
 *
 * TODO Auto-generated class documentation
 *
 */
@RooJpaRepository(entity = Region.class)
public interface RegionRepository extends ReadOnlyRepository<Region, Long>, RegionRepositoryCustom {
}
