package com.habibu.repository;
import com.habibu.model.City;
import org.springframework.roo.addon.layers.repository.jpa.annotations.RooJpaRepositoryCustom;
import com.habibu.model.Region;
import io.springlets.data.domain.GlobalSearch;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * = CityRepositoryCustom
 *
 * TODO Auto-generated class documentation
 *
 */
@RooJpaRepositoryCustom(entity = City.class)
public interface CityRepositoryCustom {

    /**
     * TODO Auto-generated method documentation
     *
     * @param region
     * @param globalSearch
     * @param pageable
     * @return Page
     */
    public abstract Page<City> findByRegion(Region region, GlobalSearch globalSearch, Pageable pageable);

    /**
     * TODO Auto-generated method documentation
     *
     * @param globalSearch
     * @param pageable
     * @return Page
     */
    public abstract Page<City> findAll(GlobalSearch globalSearch, Pageable pageable);

    /**
     * TODO Auto-generated method documentation
     *
     * @param ids
     * @param globalSearch
     * @param pageable
     * @return Page
     */
    public abstract Page<City> findAllByIdsIn(List<Long> ids, GlobalSearch globalSearch, Pageable pageable);
}
