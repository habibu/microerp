package com.habibu.repository;
import com.habibu.model.Party;
import io.springlets.data.jpa.repository.DetachableJpaRepository;
import org.springframework.roo.addon.layers.repository.jpa.annotations.RooJpaRepository;
import com.habibu.model.City;
import com.habibu.model.Country;
import com.habibu.model.Region;
import org.springframework.transaction.annotation.Transactional;

/**
 * = PartyRepository
 *
 * TODO Auto-generated class documentation
 *
 */
@RooJpaRepository(entity = Party.class)
@Transactional(readOnly = true)
public interface PartyRepository extends DetachableJpaRepository<Party, Long>, PartyRepositoryCustom {

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
