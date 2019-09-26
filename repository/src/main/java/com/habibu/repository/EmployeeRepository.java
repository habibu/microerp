package com.habibu.repository;
import com.habibu.model.Employee;
import io.springlets.data.jpa.repository.DetachableJpaRepository;
import org.springframework.roo.addon.layers.repository.jpa.annotations.RooJpaRepository;

/**
 * = EmployeeRepository
 *
 * TODO Auto-generated class documentation
 *
 */
@RooJpaRepository(entity = Employee.class)
public interface EmployeeRepository extends DetachableJpaRepository<Employee, Long>, EmployeeRepositoryCustom {
}
