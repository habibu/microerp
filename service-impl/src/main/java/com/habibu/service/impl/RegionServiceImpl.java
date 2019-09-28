package com.habibu.service.impl;
import com.habibu.service.api.RegionService;
import org.springframework.roo.addon.layers.service.annotations.RooServiceImpl;
import com.habibu.model.Country;
import com.habibu.model.Region;
import com.habibu.repository.RegionRepository;
import com.habibu.service.api.CityService;
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
 * = RegionServiceImpl
 *
 * TODO Auto-generated class documentation
 *
 */
@RooServiceImpl(service = RegionService.class)
@Service
@Transactional(readOnly = true)
public class RegionServiceImpl implements RegionService {

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
    private CityService cityService;

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    private RegionRepository regionRepository;

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
     * @param regionRepository
     * @param cityService
     * @param customerOrderService
     * @param partyService
     * @param storeService
     * @param supplierService
     */
    @Autowired
    public RegionServiceImpl(RegionRepository regionRepository, @Lazy CityService cityService, @Lazy CustomerOrderService customerOrderService, @Lazy PartyService partyService, @Lazy StoreService storeService, @Lazy SupplierService supplierService) {
        setRegionRepository(regionRepository);
        setCityService(cityService);
        setCustomerOrderService(customerOrderService);
        setPartyService(partyService);
        setStoreService(storeService);
        setSupplierService(supplierService);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @return RegionRepository
     */
    public RegionRepository getRegionRepository() {
        return regionRepository;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param regionRepository
     */
    public void setRegionRepository(RegionRepository regionRepository) {
        this.regionRepository = regionRepository;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @return CityService
     */
    public CityService getCityService() {
        return cityService;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param cityService
     */
    public void setCityService(CityService cityService) {
        this.cityService = cityService;
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
     * @param region
     * @return Map
     */
    public Map<String, List<MessageI18n>> validate(Region region) {
        Map<String, List<MessageI18n>> messages = new java.util.HashMap<String, List<MessageI18n>>();
        // TODO: IMPLEMENT HERE THE VALIDATION OF YOUR ENTITY
        return messages;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param id
     * @return Region
     */
    public Region findOne(Long id) {
        return getRegionRepository().findOne(id);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param ids
     * @return List
     */
    public List<Region> findAll(Iterable<Long> ids) {
        return getRegionRepository().findAll(ids);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @return List
     */
    public List<Region> findAll() {
        return getRegionRepository().findAll();
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @return Long
     */
    public long count() {
        return getRegionRepository().count();
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param globalSearch
     * @param pageable
     * @return Page
     */
    public Page<Region> findAll(GlobalSearch globalSearch, Pageable pageable) {
        return getRegionRepository().findAll(globalSearch, pageable);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param ids
     * @param globalSearch
     * @param pageable
     * @return Page
     */
    public Page<Region> findAllByIdsIn(List<Long> ids, GlobalSearch globalSearch, Pageable pageable) {
        return getRegionRepository().findAllByIdsIn(ids, globalSearch, pageable);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param country
     * @param globalSearch
     * @param pageable
     * @return Page
     */
    public Page<Region> findByCountry(Country country, GlobalSearch globalSearch, Pageable pageable) {
        return getRegionRepository().findByCountry(country, globalSearch, pageable);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param country
     * @return Long
     */
    public long countByCountry(Country country) {
        return getRegionRepository().countByCountry(country);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param id
     * @param pageable
     * @return Page
     */
    public Page<Region> findByCountryIdOrderByDescriptionAsc(Long id, Pageable pageable) {
        return getRegionRepository().findByCountryIdOrderByDescriptionAsc(id, pageable);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param id
     * @return Long
     */
    public long countByCountryIdOrderByDescriptionAsc(Long id) {
        return getRegionRepository().countByCountryIdOrderByDescriptionAsc(id);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @return Class
     */
    public Class<Region> getEntityType() {
        return Region.class;
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
