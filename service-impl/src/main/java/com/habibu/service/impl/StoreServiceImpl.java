package com.habibu.service.impl;
import com.habibu.service.api.StoreService;
import org.springframework.roo.addon.layers.service.annotations.RooServiceImpl;
import com.habibu.model.City;
import com.habibu.model.Country;
import com.habibu.model.Region;
import com.habibu.model.Store;
import com.habibu.model.Supplier;
import com.habibu.repository.StoreRepository;
import io.springlets.data.domain.GlobalSearch;
import io.springlets.data.web.validation.MessageI18n;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * = StoreServiceImpl
 *
 * TODO Auto-generated class documentation
 *
 */
@RooServiceImpl(service = StoreService.class)
@Service
@Transactional(readOnly = true)
public class StoreServiceImpl implements StoreService {

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    private StoreRepository storeRepository;

    /**
     * TODO Auto-generated constructor documentation
     *
     * @param storeRepository
     */
    @Autowired
    public StoreServiceImpl(StoreRepository storeRepository) {
        setStoreRepository(storeRepository);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @return StoreRepository
     */
    public StoreRepository getStoreRepository() {
        return storeRepository;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param storeRepository
     */
    public void setStoreRepository(StoreRepository storeRepository) {
        this.storeRepository = storeRepository;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param store
     * @return Map
     */
    public Map<String, List<MessageI18n>> validate(Store store) {
        Map<String, List<MessageI18n>> messages = new java.util.HashMap<String, List<MessageI18n>>();
        // TODO: IMPLEMENT HERE THE VALIDATION OF YOUR ENTITY
        return messages;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param store
     */
    @Transactional
    public void delete(Store store) {
        // Clear bidirectional many-to-one child relationship with Country
        if (store.getCountry() != null) {
            store.getCountry().getStores().remove(store);
        }
        // Clear bidirectional many-to-many child relationship with Supplier
        for (Supplier item : store.getSuppliers()) {
            item.getStores().remove(store);
        }
        // Clear bidirectional many-to-one child relationship with City
        if (store.getCity() != null) {
            store.getCity().getStores().remove(store);
        }
        // Clear bidirectional many-to-one child relationship with Region
        if (store.getRegion() != null) {
            store.getRegion().getStores().remove(store);
        }
        getStoreRepository().delete(store);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param entities
     * @return List
     */
    @Transactional
    public List<Store> save(Iterable<Store> entities) {
        return getStoreRepository().save(entities);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param ids
     */
    @Transactional
    public void delete(Iterable<Long> ids) {
        List<Store> toDelete = getStoreRepository().findAll(ids);
        getStoreRepository().deleteInBatch(toDelete);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param entity
     * @return Store
     */
    @Transactional
    public Store save(Store entity) {
        return getStoreRepository().save(entity);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param id
     * @return Store
     */
    public Store findOne(Long id) {
        return getStoreRepository().findOne(id);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param id
     * @return Store
     */
    public Store findOneForUpdate(Long id) {
        return getStoreRepository().findOneDetached(id);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param ids
     * @return List
     */
    public List<Store> findAll(Iterable<Long> ids) {
        return getStoreRepository().findAll(ids);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @return List
     */
    public List<Store> findAll() {
        return getStoreRepository().findAll();
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @return Long
     */
    public long count() {
        return getStoreRepository().count();
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param globalSearch
     * @param pageable
     * @return Page
     */
    public Page<Store> findAll(GlobalSearch globalSearch, Pageable pageable) {
        return getStoreRepository().findAll(globalSearch, pageable);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param ids
     * @param globalSearch
     * @param pageable
     * @return Page
     */
    public Page<Store> findAllByIdsIn(List<Long> ids, GlobalSearch globalSearch, Pageable pageable) {
        return getStoreRepository().findAllByIdsIn(ids, globalSearch, pageable);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param city
     * @param globalSearch
     * @param pageable
     * @return Page
     */
    public Page<Store> findByCity(City city, GlobalSearch globalSearch, Pageable pageable) {
        return getStoreRepository().findByCity(city, globalSearch, pageable);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param country
     * @param globalSearch
     * @param pageable
     * @return Page
     */
    public Page<Store> findByCountry(Country country, GlobalSearch globalSearch, Pageable pageable) {
        return getStoreRepository().findByCountry(country, globalSearch, pageable);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param region
     * @param globalSearch
     * @param pageable
     * @return Page
     */
    public Page<Store> findByRegion(Region region, GlobalSearch globalSearch, Pageable pageable) {
        return getStoreRepository().findByRegion(region, globalSearch, pageable);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param suppliers
     * @param globalSearch
     * @param pageable
     * @return Page
     */
    public Page<Store> findBySuppliersContains(Supplier suppliers, GlobalSearch globalSearch, Pageable pageable) {
        return getStoreRepository().findBySuppliersContains(suppliers, globalSearch, pageable);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param city
     * @return Long
     */
    public long countByCity(City city) {
        return getStoreRepository().countByCity(city);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param country
     * @return Long
     */
    public long countByCountry(Country country) {
        return getStoreRepository().countByCountry(country);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param region
     * @return Long
     */
    public long countByRegion(Region region) {
        return getStoreRepository().countByRegion(region);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param suppliers
     * @return Long
     */
    public long countBySuppliersContains(Supplier suppliers) {
        return getStoreRepository().countBySuppliersContains(suppliers);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @return Class
     */
    public Class<Store> getEntityType() {
        return Store.class;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @return Class
     */
    public Class<Long> getIdType() {
        return Long.class;
    }
}
