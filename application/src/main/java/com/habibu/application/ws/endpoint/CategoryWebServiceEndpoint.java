package com.habibu.application.ws.endpoint;
import com.habibu.application.ws.api.CategoryWebService;
import org.springframework.roo.addon.ws.annotations.RooSeiImpl;
import com.habibu.model.Category;
import com.habibu.service.api.CategoryService;
import io.springlets.data.domain.GlobalSearch;
import java.util.List;
import javax.jws.WebService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * = CategoryWebServiceEndpoint
 *
 * TODO Auto-generated class documentation
 *
 */
@RooSeiImpl(sei = CategoryWebService.class)
@WebService(endpointInterface = "com.habibu.application.ws.api.CategoryWebService", portName = "CategoryWebServicePort", serviceName = "CategoryWebService", targetNamespace = "http://ws.habibu.com/")
public class CategoryWebServiceEndpoint implements CategoryWebService {

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    private CategoryService categoryService;

    /**
     * TODO Auto-generated constructor documentation
     *
     * @param categoryService
     */
    public CategoryWebServiceEndpoint(CategoryService categoryService) {
        setCategoryService(categoryService);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @return CategoryService
     */
    public CategoryService getCategoryService() {
        return categoryService;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param categoryService
     */
    public void setCategoryService(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param category
     * @param productsToAdd
     * @return Category
     */
    public Category addToProductsByCategoryAndIterable(Category category, Iterable<Long> productsToAdd) {
        return getCategoryService().addToProducts(category, productsToAdd);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @return Long
     */
    public long count() {
        return getCategoryService().count();
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param category
     */
    public void deleteByCategory(Category category) {
        getCategoryService().delete(category);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param ids
     */
    public void deleteByIterable(Iterable<Long> ids) {
        getCategoryService().delete(ids);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @return List
     */
    public List<Category> findAll() {
        return getCategoryService().findAll();
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param globalSearch
     * @param pageable
     * @return Page
     */
    public Page<Category> findAllByGlobalSearchAndPageable(GlobalSearch globalSearch, Pageable pageable) {
        return getCategoryService().findAll(globalSearch, pageable);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param ids
     * @param globalSearch
     * @param pageable
     * @return Page
     */
    public Page<Category> findAllByIdsInByListAndGlobalSearchAndPageable(List<Long> ids, GlobalSearch globalSearch, Pageable pageable) {
        return getCategoryService().findAllByIdsIn(ids, globalSearch, pageable);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param ids
     * @return List
     */
    public List<Category> findAllByIterable(Iterable<Long> ids) {
        return getCategoryService().findAll(ids);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param id
     * @return Category
     */
    public Category findOneByLong(Long id) {
        return getCategoryService().findOne(id);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param id
     * @return Category
     */
    public Category findOneForUpdateByLong(Long id) {
        return getCategoryService().findOneForUpdate(id);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param category
     * @param productsToRemove
     * @return Category
     */
    public Category removeFromProductsByCategoryAndIterable(Category category, Iterable<Long> productsToRemove) {
        return getCategoryService().removeFromProducts(category, productsToRemove);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param entity
     * @return Category
     */
    public Category saveByCategory(Category entity) {
        return getCategoryService().save(entity);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param entities
     * @return List
     */
    public List<Category> saveByIterable(Iterable<Category> entities) {
        return getCategoryService().save(entities);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param category
     * @param products
     * @return Category
     */
    public Category setProductsByCategoryAndIterable(Category category, Iterable<Long> products) {
        return getCategoryService().setProducts(category, products);
    }
}
