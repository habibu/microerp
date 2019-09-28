package com.habibu.repository;
import com.habibu.model.Region;
import org.springframework.roo.addon.layers.repository.jpa.annotations.RooJpaRepository;
import org.springframework.roo.addon.layers.repository.jpa.annotations.finder.RooFinder;
import com.habibu.model.Country;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;

/**
 * = RegionRepository
 *
 * TODO Auto-generated class documentation
 *
 */
@RooJpaRepository(entity = Region.class, finders = { @RooFinder(value = "findByCountryIdOrderByDescriptionAsc", returnType = Region.class) })
@Transactional(readOnly = true)
public interface RegionRepository extends ReadOnlyRepository<Region, Long>, RegionRepositoryCustom {

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
     * @param id
     * @param pageable
     * @return Page
     */
    public abstract Page<Region> findByCountryIdOrderByDescriptionAsc(Long id, Pageable pageable);

    /**
     * TODO Auto-generated method documentation
     *
     * @param id
     * @return Long
     */
    public abstract long countByCountryIdOrderByDescriptionAsc(Long id);
}
