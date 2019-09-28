package com.habibu.repository;
import io.springlets.data.jpa.repository.support.QueryDslRepositorySupportExt;
import org.springframework.roo.addon.layers.repository.jpa.annotations.RooJpaRepositoryCustomImpl;
import com.habibu.model.CustomerOrder;
import com.habibu.model.City;
import com.habibu.model.Country;
import com.habibu.model.Customer;
//import com.habibu.model.QCustomerOrder;
import com.habibu.model.Region;
import com.habibu.model.Shipper;
import com.querydsl.core.types.Path;
import com.querydsl.jpa.JPQLQuery;
import io.springlets.data.domain.GlobalSearch;
import io.springlets.data.jpa.repository.support.QueryDslRepositorySupportExt.AttributeMappingBuilder;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

/**
 * = CustomerOrderRepositoryImpl
 *
 * TODO Auto-generated class documentation
 *
 */
@RooJpaRepositoryCustomImpl(repository = CustomerOrderRepositoryCustom.class)
@Transactional(readOnly = true)
public class CustomerOrderRepositoryImpl extends QueryDslRepositorySupportExt<CustomerOrder> implements CustomerOrderRepositoryCustom {

    /**
     * Default constructor
     */
    CustomerOrderRepositoryImpl() {
        super(CustomerOrder.class);
    }

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    public static final String REQUIRED_DATE = "requiredDate";

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    public static final String SHIP_NAME = "shipName";

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    public static final String SHIP_ADDRESS = "shipAddress";

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    public static final String ORDER_DATE = "orderDate";

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    public static final String EMPLOYEE = "employee";

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    public static final String SHIPPER = "shipper";

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    public static final String SHIP_POSTAL_CODE = "shipPostalCode";

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    public static final String REGION = "region";

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    public static final String INVOICE_DATE = "invoiceDate";

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    public static final String CLOSE_DATE = "closeDate";

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    public static final String STATUS = "status";

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    public static final String FREIGHT = "freight";

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    public static final String CITY = "city";

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    public static final String COUNTRY = "country";

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    public static final String SHIPPED_DATE = "shippedDate";

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    public static final String SHIP_PHONE = "shipPhone";

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    public static final String CUSTOMER = "customer";

	@Override
	public Page<CustomerOrder> findByCountry(Country country, GlobalSearch globalSearch, Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<CustomerOrder> findByShipper(Shipper shipper, GlobalSearch globalSearch, Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<CustomerOrder> findByCity(City city, GlobalSearch globalSearch, Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<CustomerOrder> findByRegion(Region region, GlobalSearch globalSearch, Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<CustomerOrder> findByCustomer(Customer customer, GlobalSearch globalSearch, Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<CustomerOrder> findAll(GlobalSearch globalSearch, Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<CustomerOrder> findAllByIdsIn(List<Long> ids, GlobalSearch globalSearch, Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

    /**
     * TODO Auto-generated method documentation
     *
     * @param globalSearch
     * @param pageable
     * @return Page
     *
    public Page<CustomerOrder> findAll(GlobalSearch globalSearch, Pageable pageable) {
        QCustomerOrder customerOrder = QCustomerOrder.customerOrder;
        JPQLQuery<CustomerOrder> query = from(customerOrder);
        Path<?>[] paths = new Path<?>[] { customerOrder.city, customerOrder.country, customerOrder.customer, customerOrder.orderDate, customerOrder.requiredDate, customerOrder.shippedDate, customerOrder.freight, customerOrder.shipName, customerOrder.shipAddress, customerOrder.shipPostalCode, customerOrder.status, customerOrder.shipPhone, customerOrder.invoiceDate, customerOrder.closeDate, customerOrder.employee, customerOrder.region, customerOrder.shipper };
        applyGlobalSearch(globalSearch, query, paths);
        AttributeMappingBuilder mapping = buildMapper().map(CITY, customerOrder.city).map(COUNTRY, customerOrder.country).map(CUSTOMER, customerOrder.customer).map(ORDER_DATE, customerOrder.orderDate).map(REQUIRED_DATE, customerOrder.requiredDate).map(SHIPPED_DATE, customerOrder.shippedDate).map(FREIGHT, customerOrder.freight).map(SHIP_NAME, customerOrder.shipName).map(SHIP_ADDRESS, customerOrder.shipAddress).map(SHIP_POSTAL_CODE, customerOrder.shipPostalCode).map(STATUS, customerOrder.status).map(SHIP_PHONE, customerOrder.shipPhone).map(INVOICE_DATE, customerOrder.invoiceDate).map(CLOSE_DATE, customerOrder.closeDate).map(EMPLOYEE, customerOrder.employee).map(REGION, customerOrder.region).map(SHIPPER, customerOrder.shipper);
        applyPagination(pageable, query, mapping);
        applyOrderById(query);
        return loadPage(query, pageable, customerOrder);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param ids
     * @param globalSearch
     * @param pageable
     * @return Page
     *
    public Page<CustomerOrder> findAllByIdsIn(List<Long> ids, GlobalSearch globalSearch, Pageable pageable) {
        QCustomerOrder customerOrder = QCustomerOrder.customerOrder;
        JPQLQuery<CustomerOrder> query = from(customerOrder);
        Path<?>[] paths = new Path<?>[] { customerOrder.city, customerOrder.country, customerOrder.customer, customerOrder.orderDate, customerOrder.requiredDate, customerOrder.shippedDate, customerOrder.freight, customerOrder.shipName, customerOrder.shipAddress, customerOrder.shipPostalCode, customerOrder.status, customerOrder.shipPhone, customerOrder.invoiceDate, customerOrder.closeDate, customerOrder.employee, customerOrder.region, customerOrder.shipper };
        applyGlobalSearch(globalSearch, query, paths);
        // Also, filter by the provided ids
        query.where(customerOrder.id.in(ids));
        AttributeMappingBuilder mapping = buildMapper().map(CITY, customerOrder.city).map(COUNTRY, customerOrder.country).map(CUSTOMER, customerOrder.customer).map(ORDER_DATE, customerOrder.orderDate).map(REQUIRED_DATE, customerOrder.requiredDate).map(SHIPPED_DATE, customerOrder.shippedDate).map(FREIGHT, customerOrder.freight).map(SHIP_NAME, customerOrder.shipName).map(SHIP_ADDRESS, customerOrder.shipAddress).map(SHIP_POSTAL_CODE, customerOrder.shipPostalCode).map(STATUS, customerOrder.status).map(SHIP_PHONE, customerOrder.shipPhone).map(INVOICE_DATE, customerOrder.invoiceDate).map(CLOSE_DATE, customerOrder.closeDate).map(EMPLOYEE, customerOrder.employee).map(REGION, customerOrder.region).map(SHIPPER, customerOrder.shipper);
        applyPagination(pageable, query, mapping);
        applyOrderById(query);
        return loadPage(query, pageable, customerOrder);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param city
     * @param globalSearch
     * @param pageable
     * @return Page
     *
    public Page<CustomerOrder> findByCity(City city, GlobalSearch globalSearch, Pageable pageable) {
        QCustomerOrder customerOrder = QCustomerOrder.customerOrder;
        JPQLQuery<CustomerOrder> query = from(customerOrder);
        Assert.notNull(city, "city is required");
        query.where(customerOrder.city.eq(city));
        Path<?>[] paths = new Path<?>[] { customerOrder.city, customerOrder.country, customerOrder.customer, customerOrder.orderDate, customerOrder.requiredDate, customerOrder.shippedDate, customerOrder.freight, customerOrder.shipName, customerOrder.shipAddress, customerOrder.shipPostalCode, customerOrder.status, customerOrder.shipPhone, customerOrder.invoiceDate, customerOrder.closeDate, customerOrder.employee, customerOrder.region, customerOrder.shipper };
        applyGlobalSearch(globalSearch, query, paths);
        AttributeMappingBuilder mapping = buildMapper().map(CITY, customerOrder.city).map(COUNTRY, customerOrder.country).map(CUSTOMER, customerOrder.customer).map(ORDER_DATE, customerOrder.orderDate).map(REQUIRED_DATE, customerOrder.requiredDate).map(SHIPPED_DATE, customerOrder.shippedDate).map(FREIGHT, customerOrder.freight).map(SHIP_NAME, customerOrder.shipName).map(SHIP_ADDRESS, customerOrder.shipAddress).map(SHIP_POSTAL_CODE, customerOrder.shipPostalCode).map(STATUS, customerOrder.status).map(SHIP_PHONE, customerOrder.shipPhone).map(INVOICE_DATE, customerOrder.invoiceDate).map(CLOSE_DATE, customerOrder.closeDate).map(EMPLOYEE, customerOrder.employee).map(REGION, customerOrder.region).map(SHIPPER, customerOrder.shipper);
        applyPagination(pageable, query, mapping);
        applyOrderById(query);
        return loadPage(query, pageable, customerOrder);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param country
     * @param globalSearch
     * @param pageable
     * @return Page
     *
    public Page<CustomerOrder> findByCountry(Country country, GlobalSearch globalSearch, Pageable pageable) {
        QCustomerOrder customerOrder = QCustomerOrder.customerOrder;
        JPQLQuery<CustomerOrder> query = from(customerOrder);
        Assert.notNull(country, "country is required");
        query.where(customerOrder.country.eq(country));
        Path<?>[] paths = new Path<?>[] { customerOrder.city, customerOrder.country, customerOrder.customer, customerOrder.orderDate, customerOrder.requiredDate, customerOrder.shippedDate, customerOrder.freight, customerOrder.shipName, customerOrder.shipAddress, customerOrder.shipPostalCode, customerOrder.status, customerOrder.shipPhone, customerOrder.invoiceDate, customerOrder.closeDate, customerOrder.employee, customerOrder.region, customerOrder.shipper };
        applyGlobalSearch(globalSearch, query, paths);
        AttributeMappingBuilder mapping = buildMapper().map(CITY, customerOrder.city).map(COUNTRY, customerOrder.country).map(CUSTOMER, customerOrder.customer).map(ORDER_DATE, customerOrder.orderDate).map(REQUIRED_DATE, customerOrder.requiredDate).map(SHIPPED_DATE, customerOrder.shippedDate).map(FREIGHT, customerOrder.freight).map(SHIP_NAME, customerOrder.shipName).map(SHIP_ADDRESS, customerOrder.shipAddress).map(SHIP_POSTAL_CODE, customerOrder.shipPostalCode).map(STATUS, customerOrder.status).map(SHIP_PHONE, customerOrder.shipPhone).map(INVOICE_DATE, customerOrder.invoiceDate).map(CLOSE_DATE, customerOrder.closeDate).map(EMPLOYEE, customerOrder.employee).map(REGION, customerOrder.region).map(SHIPPER, customerOrder.shipper);
        applyPagination(pageable, query, mapping);
        applyOrderById(query);
        return loadPage(query, pageable, customerOrder);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param customer
     * @param globalSearch
     * @param pageable
     * @return Page
     *
    public Page<CustomerOrder> findByCustomer(Customer customer, GlobalSearch globalSearch, Pageable pageable) {
        QCustomerOrder customerOrder = QCustomerOrder.customerOrder;
        JPQLQuery<CustomerOrder> query = from(customerOrder);
        Assert.notNull(customer, "customer is required");
        query.where(customerOrder.customer.eq(customer));
        Path<?>[] paths = new Path<?>[] { customerOrder.city, customerOrder.country, customerOrder.customer, customerOrder.orderDate, customerOrder.requiredDate, customerOrder.shippedDate, customerOrder.freight, customerOrder.shipName, customerOrder.shipAddress, customerOrder.shipPostalCode, customerOrder.status, customerOrder.shipPhone, customerOrder.invoiceDate, customerOrder.closeDate, customerOrder.employee, customerOrder.region, customerOrder.shipper };
        applyGlobalSearch(globalSearch, query, paths);
        AttributeMappingBuilder mapping = buildMapper().map(CITY, customerOrder.city).map(COUNTRY, customerOrder.country).map(CUSTOMER, customerOrder.customer).map(ORDER_DATE, customerOrder.orderDate).map(REQUIRED_DATE, customerOrder.requiredDate).map(SHIPPED_DATE, customerOrder.shippedDate).map(FREIGHT, customerOrder.freight).map(SHIP_NAME, customerOrder.shipName).map(SHIP_ADDRESS, customerOrder.shipAddress).map(SHIP_POSTAL_CODE, customerOrder.shipPostalCode).map(STATUS, customerOrder.status).map(SHIP_PHONE, customerOrder.shipPhone).map(INVOICE_DATE, customerOrder.invoiceDate).map(CLOSE_DATE, customerOrder.closeDate).map(EMPLOYEE, customerOrder.employee).map(REGION, customerOrder.region).map(SHIPPER, customerOrder.shipper);
        applyPagination(pageable, query, mapping);
        applyOrderById(query);
        return loadPage(query, pageable, customerOrder);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param region
     * @param globalSearch
     * @param pageable
     * @return Page
     *
    public Page<CustomerOrder> findByRegion(Region region, GlobalSearch globalSearch, Pageable pageable) {
        QCustomerOrder customerOrder = QCustomerOrder.customerOrder;
        JPQLQuery<CustomerOrder> query = from(customerOrder);
        Assert.notNull(region, "region is required");
        query.where(customerOrder.region.eq(region));
        Path<?>[] paths = new Path<?>[] { customerOrder.city, customerOrder.country, customerOrder.customer, customerOrder.orderDate, customerOrder.requiredDate, customerOrder.shippedDate, customerOrder.freight, customerOrder.shipName, customerOrder.shipAddress, customerOrder.shipPostalCode, customerOrder.status, customerOrder.shipPhone, customerOrder.invoiceDate, customerOrder.closeDate, customerOrder.employee, customerOrder.region, customerOrder.shipper };
        applyGlobalSearch(globalSearch, query, paths);
        AttributeMappingBuilder mapping = buildMapper().map(CITY, customerOrder.city).map(COUNTRY, customerOrder.country).map(CUSTOMER, customerOrder.customer).map(ORDER_DATE, customerOrder.orderDate).map(REQUIRED_DATE, customerOrder.requiredDate).map(SHIPPED_DATE, customerOrder.shippedDate).map(FREIGHT, customerOrder.freight).map(SHIP_NAME, customerOrder.shipName).map(SHIP_ADDRESS, customerOrder.shipAddress).map(SHIP_POSTAL_CODE, customerOrder.shipPostalCode).map(STATUS, customerOrder.status).map(SHIP_PHONE, customerOrder.shipPhone).map(INVOICE_DATE, customerOrder.invoiceDate).map(CLOSE_DATE, customerOrder.closeDate).map(EMPLOYEE, customerOrder.employee).map(REGION, customerOrder.region).map(SHIPPER, customerOrder.shipper);
        applyPagination(pageable, query, mapping);
        applyOrderById(query);
        return loadPage(query, pageable, customerOrder);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param shipper
     * @param globalSearch
     * @param pageable
     * @return Page
     *
    public Page<CustomerOrder> findByShipper(Shipper shipper, GlobalSearch globalSearch, Pageable pageable) {
        QCustomerOrder customerOrder = QCustomerOrder.customerOrder;
        JPQLQuery<CustomerOrder> query = from(customerOrder);
        Assert.notNull(shipper, "shipper is required");
        query.where(customerOrder.shipper.eq(shipper));
        Path<?>[] paths = new Path<?>[] { customerOrder.city, customerOrder.country, customerOrder.customer, customerOrder.orderDate, customerOrder.requiredDate, customerOrder.shippedDate, customerOrder.freight, customerOrder.shipName, customerOrder.shipAddress, customerOrder.shipPostalCode, customerOrder.status, customerOrder.shipPhone, customerOrder.invoiceDate, customerOrder.closeDate, customerOrder.employee, customerOrder.region, customerOrder.shipper };
        applyGlobalSearch(globalSearch, query, paths);
        AttributeMappingBuilder mapping = buildMapper().map(CITY, customerOrder.city).map(COUNTRY, customerOrder.country).map(CUSTOMER, customerOrder.customer).map(ORDER_DATE, customerOrder.orderDate).map(REQUIRED_DATE, customerOrder.requiredDate).map(SHIPPED_DATE, customerOrder.shippedDate).map(FREIGHT, customerOrder.freight).map(SHIP_NAME, customerOrder.shipName).map(SHIP_ADDRESS, customerOrder.shipAddress).map(SHIP_POSTAL_CODE, customerOrder.shipPostalCode).map(STATUS, customerOrder.status).map(SHIP_PHONE, customerOrder.shipPhone).map(INVOICE_DATE, customerOrder.invoiceDate).map(CLOSE_DATE, customerOrder.closeDate).map(EMPLOYEE, customerOrder.employee).map(REGION, customerOrder.region).map(SHIPPER, customerOrder.shipper);
        applyPagination(pageable, query, mapping);
        applyOrderById(query);
        return loadPage(query, pageable, customerOrder);
    }
    */
}
