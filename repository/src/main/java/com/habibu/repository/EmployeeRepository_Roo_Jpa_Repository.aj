// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package com.habibu.repository;

import com.habibu.repository.EmployeeRepository;
import org.springframework.transaction.annotation.Transactional;

privileged aspect EmployeeRepository_Roo_Jpa_Repository {
    
    declare @type: EmployeeRepository: @Transactional(readOnly = true);
    
}
