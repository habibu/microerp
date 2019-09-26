// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package com.habibu.repository;

import com.habibu.model.QSoldProduct;
import com.habibu.model.SoldProduct;
import com.habibu.repository.SoldProductRepositoryImpl;
import com.querydsl.core.types.Path;
import com.querydsl.jpa.JPQLQuery;
import io.springlets.data.domain.GlobalSearch;
import io.springlets.data.jpa.repository.support.QueryDslRepositorySupportExt.AttributeMappingBuilder;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;

privileged aspect SoldProductRepositoryImpl_Roo_Jpa_Repository_Impl {
    
    declare @type: SoldProductRepositoryImpl: @Transactional(readOnly = true);
    
    /**
     * TODO Auto-generated method documentation
     * 
     * @param globalSearch
     * @param pageable
     * @return Page
     */
    public Page<SoldProduct> SoldProductRepositoryImpl.findAll(GlobalSearch globalSearch, Pageable pageable) {
        
        QSoldProduct soldProduct = QSoldProduct.soldProduct;
        
        JPQLQuery<SoldProduct> query = from(soldProduct);
        
        Path<?>[] paths = new Path<?>[] {};        
        applyGlobalSearch(globalSearch, query, paths);
        
        AttributeMappingBuilder mapping = buildMapper();
        
        applyPagination(pageable, query, mapping);
        applyOrderById(query);
        
        return loadPage(query, pageable, soldProduct);
    }
    
    /**
     * TODO Auto-generated method documentation
     * 
     * @param ids
     * @param globalSearch
     * @param pageable
     * @return Page
     */
    public Page<SoldProduct> SoldProductRepositoryImpl.findAllByIdsIn(List<Long> ids, GlobalSearch globalSearch, Pageable pageable) {
        
        QSoldProduct soldProduct = QSoldProduct.soldProduct;
        
        JPQLQuery<SoldProduct> query = from(soldProduct);
        
        Path<?>[] paths = new Path<?>[] {};        
        applyGlobalSearch(globalSearch, query, paths);
        
        // Also, filter by the provided ids
        query.where(soldProduct.id.in(ids));
        
        AttributeMappingBuilder mapping = buildMapper();
        
        applyPagination(pageable, query, mapping);
        applyOrderById(query);
        
        return loadPage(query, pageable, soldProduct);
    }
    
}