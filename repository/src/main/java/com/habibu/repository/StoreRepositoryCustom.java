package com.habibu.repository;
import com.habibu.model.Store;
import org.springframework.roo.addon.layers.repository.jpa.annotations.RooJpaRepositoryCustom;
import com.habibu.model.City;
import com.habibu.model.Country;
import com.habibu.model.Region;
import com.habibu.model.Supplier;
import io.springlets.data.domain.GlobalSearch;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * = StoreRepositoryCustom
 *
 * TODO Auto-generated class documentation
 *
 */
@RooJpaRepositoryCustom(entity = Store.class)
public interface StoreRepositoryCustom {

    /**
     * TODO Auto-generated method documentation
     *
     * @param country
     * @param globalSearch
     * @param pageable
     * @return Page
     */
    public abstract Page<Store> findByCountry(Country country, GlobalSearch globalSearch, Pageable pageable);

    /**
     * TODO Auto-generated method documentation
     *
     * @param suppliers
     * @param globalSearch
     * @param pageable
     * @return Page
     */
    public abstract Page<Store> findBySuppliersContains(Supplier suppliers, GlobalSearch globalSearch, Pageable pageable);

    /**
     * TODO Auto-generated method documentation
     *
     * @param city
     * @param globalSearch
     * @param pageable
     * @return Page
     */
    public abstract Page<Store> findByCity(City city, GlobalSearch globalSearch, Pageable pageable);

    /**
     * TODO Auto-generated method documentation
     *
     * @param region
     * @param globalSearch
     * @param pageable
     * @return Page
     */
    public abstract Page<Store> findByRegion(Region region, GlobalSearch globalSearch, Pageable pageable);

    /**
     * TODO Auto-generated method documentation
     *
     * @param globalSearch
     * @param pageable
     * @return Page
     */
    public abstract Page<Store> findAll(GlobalSearch globalSearch, Pageable pageable);

    /**
     * TODO Auto-generated method documentation
     *
     * @param ids
     * @param globalSearch
     * @param pageable
     * @return Page
     */
    public abstract Page<Store> findAllByIdsIn(List<Long> ids, GlobalSearch globalSearch, Pageable pageable);
}
