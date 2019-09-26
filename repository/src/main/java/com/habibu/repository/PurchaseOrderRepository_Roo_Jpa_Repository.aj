// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package com.habibu.repository;

import com.habibu.model.Employee;
import com.habibu.model.Product;
import com.habibu.repository.PurchaseOrderRepository;
import org.springframework.transaction.annotation.Transactional;

privileged aspect PurchaseOrderRepository_Roo_Jpa_Repository {
    
    declare @type: PurchaseOrderRepository: @Transactional(readOnly = true);
    
    /**
     * TODO Auto-generated method documentation
     * 
     * @param product
     * @return Long
     */
    public abstract long PurchaseOrderRepository.countByProduct(Product product);
    
    /**
     * TODO Auto-generated method documentation
     * 
     * @param employee
     * @return Long
     */
    public abstract long PurchaseOrderRepository.countByEmployee(Employee employee);
    
}
