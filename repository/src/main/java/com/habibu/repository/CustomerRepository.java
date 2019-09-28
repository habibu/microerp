package com.habibu.repository;
import com.habibu.model.Customer;
import com.habibu.model.CustomerInfo;
import io.springlets.data.jpa.repository.DetachableJpaRepository;
import org.springframework.roo.addon.layers.repository.jpa.annotations.RooJpaRepository;
import org.springframework.transaction.annotation.Transactional;

/**
 * = CustomerRepository
 *
 * TODO Auto-generated class documentation
 *
 */
@RooJpaRepository(entity = Customer.class, defaultReturnType = CustomerInfo.class)
@Transactional(readOnly = true)
public interface CustomerRepository extends DetachableJpaRepository<Customer, Long>, CustomerRepositoryCustom {
}
