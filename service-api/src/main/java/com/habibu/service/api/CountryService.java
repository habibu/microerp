package com.habibu.service.api;
import com.habibu.model.Country;
import io.springlets.data.web.validation.ValidatorService;
import io.springlets.format.EntityResolver;
import org.springframework.roo.addon.layers.service.annotations.RooService;
import io.springlets.data.domain.GlobalSearch;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * = CountryService
 *
 * TODO Auto-generated class documentation
 *
 */
@RooService(entity = Country.class)
public interface CountryService extends EntityResolver<Country, Long>, ValidatorService<Country> {

    /**
     * TODO Auto-generated method documentation
     *
     * @param id
     * @return Country
     */
    public abstract Country findOne(Long id);

    /**
     * TODO Auto-generated method documentation
     *
     * @param ids
     * @return List
     */
    public abstract List<Country> findAll(Iterable<Long> ids);

    /**
     * TODO Auto-generated method documentation
     *
     * @return List
     */
    public abstract List<Country> findAll();

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
    public abstract Page<Country> findAll(GlobalSearch globalSearch, Pageable pageable);

    /**
     * TODO Auto-generated method documentation
     *
     * @param ids
     * @param globalSearch
     * @param pageable
     * @return Page
     */
    public abstract Page<Country> findAllByIdsIn(List<Long> ids, GlobalSearch globalSearch, Pageable pageable);
}
