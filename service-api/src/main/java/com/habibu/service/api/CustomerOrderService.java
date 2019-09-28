package com.habibu.service.api;
import com.habibu.model.CustomerOrder;
import io.springlets.data.web.validation.ValidatorService;
import io.springlets.format.EntityResolver;
import org.springframework.roo.addon.layers.service.annotations.RooService;
import com.habibu.model.City;
import com.habibu.model.Country;
import com.habibu.model.Customer;
import com.habibu.model.Region;
import com.habibu.model.Shipper;
import io.springlets.data.domain.GlobalSearch;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * = CustomerOrderService
 *
 * TODO Auto-generated class documentation
 *
 */
@RooService(entity = CustomerOrder.class)
public interface CustomerOrderService extends EntityResolver<CustomerOrder, Long>, ValidatorService<CustomerOrder> {

    /**
     * TODO Auto-generated method documentation
     *
     * @param id
     * @return CustomerOrder
     */
    public abstract CustomerOrder findOne(Long id);

    /**
     * TODO Auto-generated method documentation
     *
     * @param customerOrder
     */
    public abstract void delete(CustomerOrder customerOrder);

    /**
     * TODO Auto-generated method documentation
     *
     * @param entities
     * @return List
     */
    public abstract List<CustomerOrder> save(Iterable<CustomerOrder> entities);

    /**
     * TODO Auto-generated method documentation
     *
     * @param ids
     */
    public abstract void delete(Iterable<Long> ids);

    /**
     * TODO Auto-generated method documentation
     *
     * @param entity
     * @return CustomerOrder
     */
    public abstract CustomerOrder save(CustomerOrder entity);

    /**
     * TODO Auto-generated method documentation
     *
     * @param id
     * @return CustomerOrder
     */
    public abstract CustomerOrder findOneForUpdate(Long id);

    /**
     * TODO Auto-generated method documentation
     *
     * @param ids
     * @return List
     */
    public abstract List<CustomerOrder> findAll(Iterable<Long> ids);

    /**
     * TODO Auto-generated method documentation
     *
     * @return List
     */
    public abstract List<CustomerOrder> findAll();

    /**
     * TODO Auto-generated method documentation
     *
     * @return Long
     */
    public abstract long count();

    /**
     * TODO Auto-generated method documentation
     *
     * @param globalSearch
     * @param pageable
     * @return Page
     */
    public abstract Page<CustomerOrder> findAll(GlobalSearch globalSearch, Pageable pageable);

    /**
     * TODO Auto-generated method documentation
     *
     * @param ids
     * @param globalSearch
     * @param pageable
     * @return Page
     */
    public abstract Page<CustomerOrder> findAllByIdsIn(List<Long> ids, GlobalSearch globalSearch, Pageable pageable);

    /**
     * TODO Auto-generated method documentation
     *
     * @param customerOrder
     * @param orderDetailsToAdd
     * @return CustomerOrder
     */
    public abstract CustomerOrder addToOrderDetails(CustomerOrder customerOrder, Iterable<Long> orderDetailsToAdd);

    /**
     * TODO Auto-generated method documentation
     *
     * @param customerOrder
     * @param orderDetailsToRemove
     * @return CustomerOrder
     */
    public abstract CustomerOrder removeFromOrderDetails(CustomerOrder customerOrder, Iterable<Long> orderDetailsToRemove);

    /**
     * TODO Auto-generated method documentation
     *
     * @param customerOrder
     * @param orderDetails
     * @return CustomerOrder
     */
    public abstract CustomerOrder setOrderDetails(CustomerOrder customerOrder, Iterable<Long> orderDetails);

    /**
     * TODO Auto-generated method documentation
     *
     * @param city
     * @param globalSearch
     * @param pageable
     * @return Page
     */
    public abstract Page<CustomerOrder> findByCity(City city, GlobalSearch globalSearch, Pageable pageable);

    /**
     * TODO Auto-generated method documentation
     *
     * @param country
     * @param globalSearch
     * @param pageable
     * @return Page
     */
    public abstract Page<CustomerOrder> findByCountry(Country country, GlobalSearch globalSearch, Pageable pageable);

    /**
     * TODO Auto-generated method documentation
     *
     * @param customer
     * @param globalSearch
     * @param pageable
     * @return Page
     */
    public abstract Page<CustomerOrder> findByCustomer(Customer customer, GlobalSearch globalSearch, Pageable pageable);

    /**
     * TODO Auto-generated method documentation
     *
     * @param region
     * @param globalSearch
     * @param pageable
     * @return Page
     */
    public abstract Page<CustomerOrder> findByRegion(Region region, GlobalSearch globalSearch, Pageable pageable);

    /**
     * TODO Auto-generated method documentation
     *
     * @param shipper
     * @param globalSearch
     * @param pageable
     * @return Page
     */
    public abstract Page<CustomerOrder> findByShipper(Shipper shipper, GlobalSearch globalSearch, Pageable pageable);

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
     * @param country
     * @return Long
     */
    public abstract long countByCountry(Country country);

    /**
     * TODO Auto-generated method documentation
     *
     * @param customer
     * @return Long
     */
    public abstract long countByCustomer(Customer customer);

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
     * @param shipper
     * @return Long
     */
    public abstract long countByShipper(Shipper shipper);
}
