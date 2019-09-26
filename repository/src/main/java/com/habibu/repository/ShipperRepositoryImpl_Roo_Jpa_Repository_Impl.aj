// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package com.habibu.repository;

import com.habibu.model.QShipper;
import com.habibu.model.Shipper;
import com.habibu.repository.ShipperRepositoryImpl;
import com.querydsl.core.types.Path;
import com.querydsl.jpa.JPQLQuery;
import io.springlets.data.domain.GlobalSearch;
import io.springlets.data.jpa.repository.support.QueryDslRepositorySupportExt.AttributeMappingBuilder;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;

privileged aspect ShipperRepositoryImpl_Roo_Jpa_Repository_Impl {
    
    declare @type: ShipperRepositoryImpl: @Transactional(readOnly = true);
    
    /**
     * TODO Auto-generated attribute documentation
     * 
     */
    public static final String ShipperRepositoryImpl.COMPANY_NAME = "companyName";
    
    /**
     * TODO Auto-generated attribute documentation
     * 
     */
    public static final String ShipperRepositoryImpl.PHONE = "phone";
    
    /**
     * TODO Auto-generated method documentation
     * 
     * @param globalSearch
     * @param pageable
     * @return Page
     */
    public Page<Shipper> ShipperRepositoryImpl.findAll(GlobalSearch globalSearch, Pageable pageable) {
        
        QShipper shipper = QShipper.shipper;
        
        JPQLQuery<Shipper> query = from(shipper);
        
        Path<?>[] paths = new Path<?>[] {shipper.companyName,shipper.phone};        
        applyGlobalSearch(globalSearch, query, paths);
        
        AttributeMappingBuilder mapping = buildMapper()
			.map(COMPANY_NAME, shipper.companyName)
			.map(PHONE, shipper.phone);
        
        applyPagination(pageable, query, mapping);
        applyOrderById(query);
        
        return loadPage(query, pageable, shipper);
    }
    
    /**
     * TODO Auto-generated method documentation
     * 
     * @param ids
     * @param globalSearch
     * @param pageable
     * @return Page
     */
    public Page<Shipper> ShipperRepositoryImpl.findAllByIdsIn(List<Long> ids, GlobalSearch globalSearch, Pageable pageable) {
        
        QShipper shipper = QShipper.shipper;
        
        JPQLQuery<Shipper> query = from(shipper);
        
        Path<?>[] paths = new Path<?>[] {shipper.companyName,shipper.phone};        
        applyGlobalSearch(globalSearch, query, paths);
        
        // Also, filter by the provided ids
        query.where(shipper.id.in(ids));
        
        AttributeMappingBuilder mapping = buildMapper()
			.map(COMPANY_NAME, shipper.companyName)
			.map(PHONE, shipper.phone);
        
        applyPagination(pageable, query, mapping);
        applyOrderById(query);
        
        return loadPage(query, pageable, shipper);
    }
    
}
