package com.habibu.repository;
import com.habibu.model.Supplier;
import io.springlets.data.jpa.repository.DetachableJpaRepository;
import org.springframework.roo.addon.layers.repository.jpa.annotations.RooJpaRepository;
import com.habibu.model.City;
import com.habibu.model.Country;
import com.habibu.model.Region;
import org.springframework.transaction.annotation.Transactional;

/**
 * = SupplierRepository
 *
 * TODO Auto-generated class documentation
 *
 */
@RooJpaRepository(entity = Supplier.class)
@Transactional(readOnly = true)
public interface SupplierRepository extends DetachableJpaRepository<Supplier, Long>, SupplierRepositoryCustom {

    /**
     * TODO Auto-generated method documentation
     *
     * @param country
     * @return Long
     */
    public abstract long countByCountry(Country country);

    /**
     * TODO Auto-generated method documentation
     *
     * @param city
     * @return Long
     */
    public abstract long countByCity(City city);

    /**
     * TODO Auto-generated method documentation
     *
     * @param region
     * @return Long
     */
    public abstract long countByRegion(Region region);
}
