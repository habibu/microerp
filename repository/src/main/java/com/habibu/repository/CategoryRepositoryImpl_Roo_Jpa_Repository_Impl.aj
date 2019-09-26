// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package com.habibu.repository;

import com.habibu.model.Category;
import com.habibu.model.QCategory;
import com.habibu.repository.CategoryRepositoryImpl;
import com.querydsl.core.types.Path;
import com.querydsl.jpa.JPQLQuery;
import io.springlets.data.domain.GlobalSearch;
import io.springlets.data.jpa.repository.support.QueryDslRepositorySupportExt.AttributeMappingBuilder;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;

privileged aspect CategoryRepositoryImpl_Roo_Jpa_Repository_Impl {
    
    declare @type: CategoryRepositoryImpl: @Transactional(readOnly = true);
    
    /**
     * TODO Auto-generated attribute documentation
     * 
     */
    public static final String CategoryRepositoryImpl.NAME = "name";
    
    /**
     * TODO Auto-generated attribute documentation
     * 
     */
    public static final String CategoryRepositoryImpl.DESCRIPTION = "description";
    
    /**
     * TODO Auto-generated method documentation
     * 
     * @param globalSearch
     * @param pageable
     * @return Page
     */
    public Page<Category> CategoryRepositoryImpl.findAll(GlobalSearch globalSearch, Pageable pageable) {
        
        QCategory category = QCategory.category;
        
        JPQLQuery<Category> query = from(category);
        
        Path<?>[] paths = new Path<?>[] {category.name,category.description};        
        applyGlobalSearch(globalSearch, query, paths);
        
        AttributeMappingBuilder mapping = buildMapper()
			.map(NAME, category.name)
			.map(DESCRIPTION, category.description);
        
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
     */
    public Page<Category> CategoryRepositoryImpl.findAllByIdsIn(List<Long> ids, GlobalSearch globalSearch, Pageable pageable) {
        
        QCategory category = QCategory.category;
        
        JPQLQuery<Category> query = from(category);
        
        Path<?>[] paths = new Path<?>[] {category.name,category.description};        
        applyGlobalSearch(globalSearch, query, paths);
        
        // Also, filter by the provided ids
        query.where(category.id.in(ids));
        
        AttributeMappingBuilder mapping = buildMapper()
			.map(NAME, category.name)
			.map(DESCRIPTION, category.description);
        
        applyPagination(pageable, query, mapping);
        applyOrderById(query);
        
        return loadPage(query, pageable, category);
    }
    
}
