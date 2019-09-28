package com.habibu.service.impl;
import com.habibu.service.api.CityService;
import org.springframework.roo.addon.layers.service.annotations.RooServiceImpl;
import com.habibu.model.City;
import com.habibu.model.Region;
import com.habibu.repository.CityRepository;
import com.habibu.service.api.CustomerOrderService;
import com.habibu.service.api.PartyService;
import com.habibu.service.api.StoreService;
import com.habibu.service.api.SupplierService;
import io.springlets.data.domain.GlobalSearch;
import io.springlets.data.web.validation.MessageI18n;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * = CityServiceImpl
 *
 * TODO Auto-generated class documentation
 *
 */
@RooServiceImpl(service = CityService.class)
@Service
@Transactional(readOnly = true)
public class CityServiceImpl implements CityService {

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    private CustomerOrderService customerOrderService;

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    private StoreService storeService;

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    private CityRepository cityRepository;

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    private PartyService partyService;

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    private SupplierService supplierService;

    /**
     * TODO Auto-generated constructor documentation
     *
     * @param cityRepository
     * @param customerOrderService
     * @param partyService
     * @param storeService
     * @param supplierService
     */
    @Autowired
    public CityServiceImpl(CityRepository cityRepository, @Lazy CustomerOrderService customerOrderService, @Lazy PartyService partyService, @Lazy StoreService storeService, @Lazy SupplierService supplierService) {
        setCityRepository(cityRepository);
        setCustomerOrderService(customerOrderService);
        setPartyService(partyService);
        setStoreService(storeService);
        setSupplierService(supplierService);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @return CityRepository
     */
    public CityRepository getCityRepository() {
        return cityRepository;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param cityRepository
     */
    public void setCityRepository(CityRepository cityRepository) {
        this.cityRepository = cityRepository;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @return CustomerOrderService
     */
    public CustomerOrderService getCustomerOrderService() {
        return customerOrderService;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param customerOrderService
     */
    public void setCustomerOrderService(CustomerOrderService customerOrderService) {
        this.customerOrderService = customerOrderService;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @return PartyService
     */
    public PartyService getPartyService() {
        return partyService;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param partyService
     */
    public void setPartyService(PartyService partyService) {
        this.partyService = partyService;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @return StoreService
     */
    public StoreService getStoreService() {
        return storeService;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param storeService
     */
    public void setStoreService(StoreService storeService) {
        this.storeService = storeService;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @return SupplierService
     */
    public SupplierService getSupplierService() {
        return supplierService;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param supplierService
     */
    public void setSupplierService(SupplierService supplierService) {
        this.supplierService = supplierService;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param city
     * @return Map
     */
    public Map<String, List<MessageI18n>> validate(City city) {
        Map<String, List<MessageI18n>> messages = new java.util.HashMap<String, List<MessageI18n>>();
        // TODO: IMPLEMENT HERE THE VALIDATION OF YOUR ENTITY
        return messages;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param id
     * @return City
     */
    public City findOne(Long id) {
        return getCityRepository().findOne(id);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param ids
     * @return List
     */
    public List<City> findAll(Iterable<Long> ids) {
        return getCityRepository().findAll(ids);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @return List
     */
    public List<City> findAll() {
        return getCityRepository().findAll();
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @return Long
     */
    public long count() {
        return getCityRepository().count();
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param globalSearch
     * @param pageable
     * @return Page
     */
    public Page<City> findAll(GlobalSearch globalSearch, Pageable pageable) {
        return getCityRepository().findAll(globalSearch, pageable);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param ids
     * @param globalSearch
     * @param pageable
     * @return Page
     */
    public Page<City> findAllByIdsIn(List<Long> ids, GlobalSearch globalSearch, Pageable pageable) {
        return getCityRepository().findAllByIdsIn(ids, globalSearch, pageable);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param region
     * @param globalSearch
     * @param pageable
     * @return Page
     */
    public Page<City> findByRegion(Region region, GlobalSearch globalSearch, Pageable pageable) {
        return getCityRepository().findByRegion(region, globalSearch, pageable);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param region
     * @return Long
     */
    public long countByRegion(Region region) {
        return getCityRepository().countByRegion(region);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param id
     * @param pageable
     * @return Page
     */
    public Page<City> findByRegionIdOrderByDescriptionAsc(Long id, Pageable pageable) {
        return getCityRepository().findByRegionIdOrderByDescriptionAsc(id, pageable);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param id
     * @return Long
     */
    public long countByRegionIdOrderByDescriptionAsc(Long id) {
        return getCityRepository().countByRegionIdOrderByDescriptionAsc(id);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @return Class
     */
    public Class<City> getEntityType() {
        return City.class;
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
