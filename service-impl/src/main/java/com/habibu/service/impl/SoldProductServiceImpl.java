package com.habibu.service.impl;
import com.habibu.service.api.SoldProductService;
import org.springframework.roo.addon.layers.service.annotations.RooServiceImpl;
import com.habibu.model.SoldProduct;
import com.habibu.repository.SoldProductRepository;
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
 * = SoldProductServiceImpl
 *
 * TODO Auto-generated class documentation
 *
 */
@RooServiceImpl(service = SoldProductService.class)
@Service
@Transactional(readOnly = true)
public class SoldProductServiceImpl implements SoldProductService {

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    private SoldProductRepository soldProductRepository;

    /**
     * TODO Auto-generated constructor documentation
     *
     * @param soldProductRepository
     */
    @Autowired
    public SoldProductServiceImpl(SoldProductRepository soldProductRepository) {
        setSoldProductRepository(soldProductRepository);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @return SoldProductRepository
     */
    public SoldProductRepository getSoldProductRepository() {
        return soldProductRepository;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param soldProductRepository
     */
    public void setSoldProductRepository(SoldProductRepository soldProductRepository) {
        this.soldProductRepository = soldProductRepository;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param soldproduct
     * @return Map
     */
    public Map<String, List<MessageI18n>> validate(SoldProduct soldproduct) {
        Map<String, List<MessageI18n>> messages = new java.util.HashMap<String, List<MessageI18n>>();
        // TODO: IMPLEMENT HERE THE VALIDATION OF YOUR ENTITY
        return messages;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param soldProduct
     */
    @Transactional
    public void delete(SoldProduct soldProduct) {
        getSoldProductRepository().delete(soldProduct);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param entities
     * @return List
     */
    @Transactional
    public List<SoldProduct> save(Iterable<SoldProduct> entities) {
        return getSoldProductRepository().save(entities);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param ids
     */
    @Transactional
    public void delete(Iterable<Long> ids) {
        List<SoldProduct> toDelete = getSoldProductRepository().findAll(ids);
        getSoldProductRepository().deleteInBatch(toDelete);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param entity
     * @return SoldProduct
     */
    @Transactional
    public SoldProduct save(SoldProduct entity) {
        return getSoldProductRepository().save(entity);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param id
     * @return SoldProduct
     */
    public SoldProduct findOne(Long id) {
        return getSoldProductRepository().findOne(id);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param id
     * @return SoldProduct
     */
    public SoldProduct findOneForUpdate(Long id) {
        return getSoldProductRepository().findOneDetached(id);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param ids
     * @return List
     */
    public List<SoldProduct> findAll(Iterable<Long> ids) {
        return getSoldProductRepository().findAll(ids);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @return List
     */
    public List<SoldProduct> findAll() {
        return getSoldProductRepository().findAll();
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @return Long
     */
    public long count() {
        return getSoldProductRepository().count();
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param globalSearch
     * @param pageable
     * @return Page
     */
    public Page<SoldProduct> findAll(GlobalSearch globalSearch, Pageable pageable) {
        return getSoldProductRepository().findAll(globalSearch, pageable);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param ids
     * @param globalSearch
     * @param pageable
     * @return Page
     */
    public Page<SoldProduct> findAllByIdsIn(List<Long> ids, GlobalSearch globalSearch, Pageable pageable) {
        return getSoldProductRepository().findAllByIdsIn(ids, globalSearch, pageable);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @return Class
     */
    public Class<SoldProduct> getEntityType() {
        return SoldProduct.class;
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
