package com.habibu.repository;
import com.habibu.model.CustomerOrder;
import io.springlets.data.jpa.repository.DetachableJpaRepository;
import org.springframework.roo.addon.layers.repository.jpa.annotations.RooJpaRepository;
import com.habibu.model.City;
import com.habibu.model.Country;
import com.habibu.model.Customer;
import com.habibu.model.Region;
import com.habibu.model.Shipper;
import org.springframework.transaction.annotation.Transactional;

/**
 * = CustomerOrderRepository
 *
 * TODO Auto-generated class documentation
 *
 */
@RooJpaRepository(entity = CustomerOrder.class)
@Transactional(readOnly = true)
public interface CustomerOrderRepository extends DetachableJpaRepository<CustomerOrder, Long>, CustomerOrderRepositoryCustom {

    /**
     * TODO Auto-generated method documentation
     *
     * @param country
     * @return Long
     */
    public abstract long countByCountry(Country country);

    /**
     * TODO Auto-generated method documentation
     *
     * @param shipper
     * @return Long
     */
    public abstract long countByShipper(Shipper shipper);

    /**
     * TODO Auto-generated method documentation
     *
     * @param city
     * @return Long
     */
    public abstract long countByCity(City city);

    /**
     * TODO Auto-generated method documentation
     *
     * @param region
     * @return Long
     */
    public abstract long countByRegion(Region region);

    /**
     * TODO Auto-generated method documentation
     *
     * @param customer
     * @return Long
     */
    public abstract long countByCustomer(Customer customer);
}
