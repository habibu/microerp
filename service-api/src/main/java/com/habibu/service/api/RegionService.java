package com.habibu.service.api;
import com.habibu.model.Region;
import io.springlets.data.web.validation.ValidatorService;
import io.springlets.format.EntityResolver;
import org.springframework.roo.addon.layers.service.annotations.RooService;
import com.habibu.model.Country;
import io.springlets.data.domain.GlobalSearch;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * = RegionService
 *
 * TODO Auto-generated class documentation
 *
 */
@RooService(entity = Region.class)
public interface RegionService extends EntityResolver<Region, Long>, ValidatorService<Region> {

    /**
     * TODO Auto-generated method documentation
     *
     * @param id
     * @return Region
     */
    public abstract Region findOne(Long id);

    /**
     * TODO Auto-generated method documentation
     *
     * @param ids
     * @return List
     */
    public abstract List<Region> findAll(Iterable<Long> ids);

    /**
     * TODO Auto-generated method documentation
     *
     * @return List
     */
    public abstract List<Region> findAll();

    /**
     * TODO Auto-generated method documentation
     *
     * @return Long
     */
    public abstract long count();

    /**
     * TODO Auto-generated method documentation
     *
     * @param globalSearch
     * @param pageable
     * @return Page
     */
    public abstract Page<Region> findAll(GlobalSearch globalSearch, Pageable pageable);

    /**
     * TODO Auto-generated method documentation
     *
     * @param ids
     * @param globalSearch
     * @param pageable
     * @return Page
     */
    public abstract Page<Region> findAllByIdsIn(List<Long> ids, GlobalSearch globalSearch, Pageable pageable);

    /**
     * TODO Auto-generated method documentation
     *
     * @param country
     * @param globalSearch
     * @param pageable
     * @return Page
     */
    public abstract Page<Region> findByCountry(Country country, GlobalSearch globalSearch, Pageable pageable);

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
