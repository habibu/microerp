package com.habibu.service.impl;
import com.habibu.service.api.SupplierService;
import org.springframework.roo.addon.layers.service.annotations.RooServiceImpl;
import com.habibu.model.City;
import com.habibu.model.Country;
import com.habibu.model.Product;
import com.habibu.model.Region;
import com.habibu.model.Store;
import com.habibu.model.Supplier;
import com.habibu.repository.SupplierRepository;
import com.habibu.service.api.ProductService;
import com.habibu.service.api.StoreService;
import io.springlets.data.domain.GlobalSearch;
import io.springlets.data.web.validation.MessageI18n;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * = SupplierServiceImpl
 *
 * TODO Auto-generated class documentation
 *
 */
@RooServiceImpl(service = SupplierService.class)
@Service
@Transactional(readOnly = true)
public class SupplierServiceImpl implements SupplierService {

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    private StoreService storeService;

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    private SupplierRepository supplierRepository;

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    private ProductService productService;

    /**
     * TODO Auto-generated constructor documentation
     *
     * @param supplierRepository
     * @param productService
     * @param storeService
     */
    @Autowired
    public SupplierServiceImpl(SupplierRepository supplierRepository, @Lazy ProductService productService, @Lazy StoreService storeService) {
        setSupplierRepository(supplierRepository);
        setProductService(productService);
        setStoreService(storeService);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @return SupplierRepository
     */
    public SupplierRepository getSupplierRepository() {
        return supplierRepository;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param supplierRepository
     */
    public void setSupplierRepository(SupplierRepository supplierRepository) {
        this.supplierRepository = supplierRepository;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @return ProductService
     */
    public ProductService getProductService() {
        return productService;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param productService
     */
    public void setProductService(ProductService productService) {
        this.productService = productService;
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
     * @param supplier
     * @return Map
     */
    public Map<String, List<MessageI18n>> validate(Supplier supplier) {
        Map<String, List<MessageI18n>> messages = new java.util.HashMap<String, List<MessageI18n>>();
        // TODO: IMPLEMENT HERE THE VALIDATION OF YOUR ENTITY
        return messages;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param supplier
     * @param productsToAdd
     * @return Supplier
     */
    @Transactional
    public Supplier addToProducts(Supplier supplier, Iterable<Long> productsToAdd) {
        List<Product> products = getProductService().findAll(productsToAdd);
        supplier.addToProducts(products);
        return getSupplierRepository().save(supplier);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param supplier
     * @param storesToAdd
     * @return Supplier
     */
    @Transactional
    public Supplier addToStores(Supplier supplier, Iterable<Long> storesToAdd) {
        List<Store> stores = getStoreService().findAll(storesToAdd);
        supplier.addToStores(stores);
        return getSupplierRepository().save(supplier);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param supplier
     * @param productsToRemove
     * @return Supplier
     */
    @Transactional
    public Supplier removeFromProducts(Supplier supplier, Iterable<Long> productsToRemove) {
        List<Product> products = getProductService().findAll(productsToRemove);
        supplier.removeFromProducts(products);
        return getSupplierRepository().save(supplier);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param supplier
     * @param storesToRemove
     * @return Supplier
     */
    @Transactional
    public Supplier removeFromStores(Supplier supplier, Iterable<Long> storesToRemove) {
        List<Store> stores = getStoreService().findAll(storesToRemove);
        supplier.removeFromStores(stores);
        return getSupplierRepository().save(supplier);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param supplier
     * @param products
     * @return Supplier
     */
    @Transactional
    public Supplier setProducts(Supplier supplier, Iterable<Long> products) {
        List<Product> items = getProductService().findAll(products);
        Set<Product> currents = supplier.getProducts();
        Set<Product> toRemove = new HashSet<Product>();
        for (Iterator<Product> iterator = currents.iterator(); iterator.hasNext(); ) {
            Product nextProduct = iterator.next();
            if (items.contains(nextProduct)) {
                items.remove(nextProduct);
            } else {
                toRemove.add(nextProduct);
            }
        }
        supplier.removeFromProducts(toRemove);
        supplier.addToProducts(items);
        // Force the version update of the parent side to know that the parent has changed
        // because it has new books assigned
        supplier.setVersion(supplier.getVersion() + 1);
        return getSupplierRepository().save(supplier);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param supplier
     * @param stores
     * @return Supplier
     */
    @Transactional
    public Supplier setStores(Supplier supplier, Iterable<Long> stores) {
        List<Store> items = getStoreService().findAll(stores);
        Set<Store> currents = supplier.getStores();
        Set<Store> toRemove = new HashSet<Store>();
        for (Iterator<Store> iterator = currents.iterator(); iterator.hasNext(); ) {
            Store nextStore = iterator.next();
            if (items.contains(nextStore)) {
                items.remove(nextStore);
            } else {
                toRemove.add(nextStore);
            }
        }
        supplier.removeFromStores(toRemove);
        supplier.addToStores(items);
        // Force the version update of the parent side to know that the parent has changed
        // because it has new books assigned
        supplier.setVersion(supplier.getVersion() + 1);
        return getSupplierRepository().save(supplier);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param supplier
     */
    @Transactional
    public void delete(Supplier supplier) {
        // Clear bidirectional many-to-one child relationship with Country
        if (supplier.getCountry() != null) {
            supplier.getCountry().getSuppliers().remove(supplier);
        }
        // Clear bidirectional many-to-one child relationship with City
        if (supplier.getCity() != null) {
            supplier.getCity().getSuppliers().remove(supplier);
        }
        // Clear bidirectional many-to-one child relationship with Region
        if (supplier.getRegion() != null) {
            supplier.getRegion().getSuppliers().remove(supplier);
        }
        // Clear bidirectional one-to-many parent relationship with Product
        for (Product item : supplier.getProducts()) {
            item.setSupplier(null);
        }
        // Clear bidirectional many-to-many parent relationship with Store
        for (Store item : supplier.getStores()) {
            item.getSuppliers().remove(supplier);
        }
        getSupplierRepository().delete(supplier);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param entities
     * @return List
     */
    @Transactional
    public List<Supplier> save(Iterable<Supplier> entities) {
        return getSupplierRepository().save(entities);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param ids
     */
    @Transactional
    public void delete(Iterable<Long> ids) {
        List<Supplier> toDelete = getSupplierRepository().findAll(ids);
        getSupplierRepository().deleteInBatch(toDelete);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param entity
     * @return Supplier
     */
    @Transactional
    public Supplier save(Supplier entity) {
        return getSupplierRepository().save(entity);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param id
     * @return Supplier
     */
    public Supplier findOne(Long id) {
        return getSupplierRepository().findOne(id);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param id
     * @return Supplier
     */
    public Supplier findOneForUpdate(Long id) {
        return getSupplierRepository().findOneDetached(id);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param ids
     * @return List
     */
    public List<Supplier> findAll(Iterable<Long> ids) {
        return getSupplierRepository().findAll(ids);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @return List
     */
    public List<Supplier> findAll() {
        return getSupplierRepository().findAll();
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @return Long
     */
    public long count() {
        return getSupplierRepository().count();
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param globalSearch
     * @param pageable
     * @return Page
     */
    public Page<Supplier> findAll(GlobalSearch globalSearch, Pageable pageable) {
        return getSupplierRepository().findAll(globalSearch, pageable);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param ids
     * @param globalSearch
     * @param pageable
     * @return Page
     */
    public Page<Supplier> findAllByIdsIn(List<Long> ids, GlobalSearch globalSearch, Pageable pageable) {
        return getSupplierRepository().findAllByIdsIn(ids, globalSearch, pageable);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param city
     * @param globalSearch
     * @param pageable
     * @return Page
     */
    public Page<Supplier> findByCity(City city, GlobalSearch globalSearch, Pageable pageable) {
        return getSupplierRepository().findByCity(city, globalSearch, pageable);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param country
     * @param globalSearch
     * @param pageable
     * @return Page
     */
    public Page<Supplier> findByCountry(Country country, GlobalSearch globalSearch, Pageable pageable) {
        return getSupplierRepository().findByCountry(country, globalSearch, pageable);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param region
     * @param globalSearch
     * @param pageable
     * @return Page
     */
    public Page<Supplier> findByRegion(Region region, GlobalSearch globalSearch, Pageable pageable) {
        return getSupplierRepository().findByRegion(region, globalSearch, pageable);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param city
     * @return Long
     */
    public long countByCity(City city) {
        return getSupplierRepository().countByCity(city);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param country
     * @return Long
     */
    public long countByCountry(Country country) {
        return getSupplierRepository().countByCountry(country);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param region
     * @return Long
     */
    public long countByRegion(Region region) {
        return getSupplierRepository().countByRegion(region);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @return Class
     */
    public Class<Supplier> getEntityType() {
        return Supplier.class;
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
