package com.habibu.service.impl;
import com.habibu.service.api.CustomerOrderService;
import org.springframework.roo.addon.layers.service.annotations.RooServiceImpl;
import com.habibu.model.City;
import com.habibu.model.Country;
import com.habibu.model.Customer;
import com.habibu.model.CustomerOrder;
import com.habibu.model.OrderDetail;
import com.habibu.model.Region;
import com.habibu.model.Shipper;
import com.habibu.repository.CustomerOrderRepository;
import com.habibu.service.api.OrderDetailService;
import io.springlets.data.domain.GlobalSearch;
import io.springlets.data.web.validation.MessageI18n;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * = CustomerOrderServiceImpl
 *
 * TODO Auto-generated class documentation
 *
 */
@RooServiceImpl(service = CustomerOrderService.class)
@Service
@Transactional(readOnly = true)
public class CustomerOrderServiceImpl implements CustomerOrderService {

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    private CustomerOrderRepository customerOrderRepository;

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    private OrderDetailService orderDetailService;

    /**
     * TODO Auto-generated constructor documentation
     *
     * @param customerOrderRepository
     * @param orderDetailService
     */
    @Autowired
    public CustomerOrderServiceImpl(CustomerOrderRepository customerOrderRepository, @Lazy OrderDetailService orderDetailService) {
        setCustomerOrderRepository(customerOrderRepository);
        setOrderDetailService(orderDetailService);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @return CustomerOrderRepository
     */
    public CustomerOrderRepository getCustomerOrderRepository() {
        return customerOrderRepository;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param customerOrderRepository
     */
    public void setCustomerOrderRepository(CustomerOrderRepository customerOrderRepository) {
        this.customerOrderRepository = customerOrderRepository;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @return OrderDetailService
     */
    public OrderDetailService getOrderDetailService() {
        return orderDetailService;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param orderDetailService
     */
    public void setOrderDetailService(OrderDetailService orderDetailService) {
        this.orderDetailService = orderDetailService;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param customerorder
     * @return Map
     */
    public Map<String, List<MessageI18n>> validate(CustomerOrder customerorder) {
        Map<String, List<MessageI18n>> messages = new java.util.HashMap<String, List<MessageI18n>>();
        // TODO: IMPLEMENT HERE THE VALIDATION OF YOUR ENTITY
        return messages;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param customerOrder
     * @param orderDetailsToAdd
     * @return CustomerOrder
     */
    @Transactional
    public CustomerOrder addToOrderDetails(CustomerOrder customerOrder, Iterable<Long> orderDetailsToAdd) {
        List<OrderDetail> orderDetails = getOrderDetailService().findAll(orderDetailsToAdd);
        customerOrder.addToOrderDetails(orderDetails);
        return getCustomerOrderRepository().save(customerOrder);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param customerOrder
     * @param orderDetailsToRemove
     * @return CustomerOrder
     */
    @Transactional
    public CustomerOrder removeFromOrderDetails(CustomerOrder customerOrder, Iterable<Long> orderDetailsToRemove) {
        List<OrderDetail> orderDetails = getOrderDetailService().findAll(orderDetailsToRemove);
        customerOrder.removeFromOrderDetails(orderDetails);
        return getCustomerOrderRepository().save(customerOrder);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param customerOrder
     * @param orderDetails
     * @return CustomerOrder
     */
    @Transactional
    public CustomerOrder setOrderDetails(CustomerOrder customerOrder, Iterable<Long> orderDetails) {
        List<OrderDetail> items = getOrderDetailService().findAll(orderDetails);
        Set<OrderDetail> currents = customerOrder.getOrderDetails();
        Set<OrderDetail> toRemove = new HashSet<OrderDetail>();
        for (Iterator<OrderDetail> iterator = currents.iterator(); iterator.hasNext(); ) {
            OrderDetail nextOrderDetail = iterator.next();
            if (items.contains(nextOrderDetail)) {
                items.remove(nextOrderDetail);
            } else {
                toRemove.add(nextOrderDetail);
            }
        }
        customerOrder.removeFromOrderDetails(toRemove);
        customerOrder.addToOrderDetails(items);
        // Force the version update of the parent side to know that the parent has changed
        // because it has new books assigned
        customerOrder.setVersion(customerOrder.getVersion() + 1);
        return getCustomerOrderRepository().save(customerOrder);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param customerOrder
     */
    @Transactional
    public void delete(CustomerOrder customerOrder) {
        // Clear bidirectional many-to-one child relationship with Country
        if (customerOrder.getCountry() != null) {
            customerOrder.getCountry().getCustomerOrders().remove(customerOrder);
        }
        // Clear bidirectional many-to-one child relationship with Shipper
        if (customerOrder.getShipper() != null) {
            customerOrder.getShipper().getCustomerOrders().remove(customerOrder);
        }
        // Clear bidirectional many-to-one child relationship with City
        if (customerOrder.getCity() != null) {
            customerOrder.getCity().getCustomerOrders().remove(customerOrder);
        }
        // Clear bidirectional many-to-one child relationship with Region
        if (customerOrder.getRegion() != null) {
            customerOrder.getRegion().getCustomerOrders().remove(customerOrder);
        }
        // Clear bidirectional many-to-one child relationship with Customer
        if (customerOrder.getCustomer() != null) {
            customerOrder.getCustomer().getCustomerOrders().remove(customerOrder);
        }
        // Clear bidirectional one-to-many parent relationship with OrderDetail
        for (OrderDetail item : customerOrder.getOrderDetails()) {
            item.setCustomerOrder(null);
        }
        getCustomerOrderRepository().delete(customerOrder);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param entities
     * @return List
     */
    @Transactional
    public List<CustomerOrder> save(Iterable<CustomerOrder> entities) {
        return getCustomerOrderRepository().save(entities);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param ids
     */
    @Transactional
    public void delete(Iterable<Long> ids) {
        List<CustomerOrder> toDelete = getCustomerOrderRepository().findAll(ids);
        getCustomerOrderRepository().deleteInBatch(toDelete);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param entity
     * @return CustomerOrder
     */
    @Transactional
    public CustomerOrder save(CustomerOrder entity) {
        return getCustomerOrderRepository().save(entity);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param id
     * @return CustomerOrder
     */
    public CustomerOrder findOne(Long id) {
        return getCustomerOrderRepository().findOne(id);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param id
     * @return CustomerOrder
     */
    public CustomerOrder findOneForUpdate(Long id) {
        return getCustomerOrderRepository().findOneDetached(id);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param ids
     * @return List
     */
    public List<CustomerOrder> findAll(Iterable<Long> ids) {
        return getCustomerOrderRepository().findAll(ids);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @return List
     */
    public List<CustomerOrder> findAll() {
        return getCustomerOrderRepository().findAll();
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @return Long
     */
    public long count() {
        return getCustomerOrderRepository().count();
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param globalSearch
     * @param pageable
     * @return Page
     */
    public Page<CustomerOrder> findAll(GlobalSearch globalSearch, Pageable pageable) {
        return getCustomerOrderRepository().findAll(globalSearch, pageable);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param ids
     * @param globalSearch
     * @param pageable
     * @return Page
     */
    public Page<CustomerOrder> findAllByIdsIn(List<Long> ids, GlobalSearch globalSearch, Pageable pageable) {
        return getCustomerOrderRepository().findAllByIdsIn(ids, globalSearch, pageable);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param city
     * @param globalSearch
     * @param pageable
     * @return Page
     */
    public Page<CustomerOrder> findByCity(City city, GlobalSearch globalSearch, Pageable pageable) {
        return getCustomerOrderRepository().findByCity(city, globalSearch, pageable);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param country
     * @param globalSearch
     * @param pageable
     * @return Page
     */
    public Page<CustomerOrder> findByCountry(Country country, GlobalSearch globalSearch, Pageable pageable) {
        return getCustomerOrderRepository().findByCountry(country, globalSearch, pageable);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param customer
     * @param globalSearch
     * @param pageable
     * @return Page
     */
    public Page<CustomerOrder> findByCustomer(Customer customer, GlobalSearch globalSearch, Pageable pageable) {
        return getCustomerOrderRepository().findByCustomer(customer, globalSearch, pageable);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param region
     * @param globalSearch
     * @param pageable
     * @return Page
     */
    public Page<CustomerOrder> findByRegion(Region region, GlobalSearch globalSearch, Pageable pageable) {
        return getCustomerOrderRepository().findByRegion(region, globalSearch, pageable);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param shipper
     * @param globalSearch
     * @param pageable
     * @return Page
     */
    public Page<CustomerOrder> findByShipper(Shipper shipper, GlobalSearch globalSearch, Pageable pageable) {
        return getCustomerOrderRepository().findByShipper(shipper, globalSearch, pageable);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param city
     * @return Long
     */
    public long countByCity(City city) {
        return getCustomerOrderRepository().countByCity(city);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param country
     * @return Long
     */
    public long countByCountry(Country country) {
        return getCustomerOrderRepository().countByCountry(country);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param customer
     * @return Long
     */
    public long countByCustomer(Customer customer) {
        return getCustomerOrderRepository().countByCustomer(customer);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param region
     * @return Long
     */
    public long countByRegion(Region region) {
        return getCustomerOrderRepository().countByRegion(region);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param shipper
     * @return Long
     */
    public long countByShipper(Shipper shipper) {
        return getCustomerOrderRepository().countByShipper(shipper);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @return Class
     */
    public Class<CustomerOrder> getEntityType() {
        return CustomerOrder.class;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @return Class
     */
    public Class<Long> getIdType() {
        return Long.class;
    }
}
