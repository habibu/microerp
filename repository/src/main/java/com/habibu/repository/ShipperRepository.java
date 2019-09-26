package com.habibu.repository;
import com.habibu.model.Shipper;
import io.springlets.data.jpa.repository.DetachableJpaRepository;
import org.springframework.roo.addon.layers.repository.jpa.annotations.RooJpaRepository;

/**
 * = ShipperRepository
 *
 * TODO Auto-generated class documentation
 *
 */
@RooJpaRepository(entity = Shipper.class)
public interface ShipperRepository extends DetachableJpaRepository<Shipper, Long>, ShipperRepositoryCustom {
}
