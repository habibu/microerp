package com.habibu.repository;
import io.springlets.data.jpa.repository.support.QueryDslRepositorySupportExt;
import org.springframework.roo.addon.layers.repository.jpa.annotations.RooJpaRepositoryCustomImpl;
import com.habibu.model.Category;
//import com.habibu.model.QCategory;
import com.querydsl.core.types.Path;
import com.querydsl.jpa.JPQLQuery;
import io.springlets.data.domain.GlobalSearch;
import io.springlets.data.jpa.repository.support.QueryDslRepositorySupportExt.AttributeMappingBuilder;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;

/**
 * = CategoryRepositoryImpl
 *
 * TODO Auto-generated class documentation
 *
 */
@RooJpaRepositoryCustomImpl(repository = CategoryRepositoryCustom.class)
@Transactional(readOnly = true)
public class CategoryRepositoryImpl extends QueryDslRepositorySupportExt<Category> implements CategoryRepositoryCustom {

    /**
     * Default constructor
     */
    CategoryRepositoryImpl() {
        super(Category.class);
    }

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    public static final String CREATED_BY = "createdBy";

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    public static final String MODIFIED_BY = "modifiedBy";

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    public static final String DESCRIPTION = "description";

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    public static final String CREATED_DATE = "createdDate";

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    public static final String MODIFIED_DATE = "modifiedDate";

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    public static final String NAME = "name";

	@Override
	public Page<Category> findAll(GlobalSearch globalSearch, Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<Category> findAllByIdsIn(List<Long> ids, GlobalSearch globalSearch, Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

    /**
     * TODO Auto-generated method documentation
     *
     * @param globalSearch
     * @param pageable
     * @return Page
     
    public Page<Category> findAll(GlobalSearch globalSearch, Pageable pageable) {
        QCategory category = QCategory.category;
        JPQLQuery<Category> query = from(category);
        Path<?>[] paths = new Path<?>[] { category.name, category.description, category.createdDate, category.createdBy, category.modifiedDate, category.modifiedBy };
        applyGlobalSearch(globalSearch, query, paths);
        AttributeMappingBuilder mapping = buildMapper().map(NAME, category.name).map(DESCRIPTION, category.description).map(CREATED_DATE, category.createdDate).map(CREATED_BY, category.createdBy).map(MODIFIED_DATE, category.modifiedDate).map(MODIFIED_BY, category.modifiedBy);
        applyPagination(pageable, query, mapping);
        applyOrderById(query);
        return loadPage(query, pageable, category);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param ids
     * @param globalSearch
     * @param pageable
     * @return Page
     *
   
    public Page<Category> findAllByIdsIn(List<Long> ids, GlobalSearch globalSearch, Pageable pageable) {
        QCategory category = QCategory.category;
        JPQLQuery<Category> query = from(category);
        Path<?>[] paths = new Path<?>[] { category.name, category.description, category.createdDate, category.createdBy, category.modifiedDate, category.modifiedBy };
        applyGlobalSearch(globalSearch, query, paths);
        // Also, filter by the provided ids
        query.where(category.id.in(ids));
        AttributeMappingBuilder mapping = buildMapper().map(NAME, category.name).map(DESCRIPTION, category.description).map(CREATED_DATE, category.createdDate).map(CREATED_BY, category.createdBy).map(MODIFIED_DATE, category.modifiedDate).map(MODIFIED_BY, category.modifiedBy);
        applyPagination(pageable, query, mapping);
        applyOrderById(query);
        return loadPage(query, pageable, category);
    }
    */
}
