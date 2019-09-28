package com.habibu.repository;
import io.springlets.data.jpa.repository.support.QueryDslRepositorySupportExt;
import org.springframework.roo.addon.layers.repository.jpa.annotations.RooJpaRepositoryCustomImpl;
import com.habibu.model.Customer;
import com.habibu.model.CustomerInfo;
//import com.habibu.model.QCustomer;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.JPQLQuery;
import io.springlets.data.domain.GlobalSearch;
import io.springlets.data.jpa.repository.support.QueryDslRepositorySupportExt.AttributeMappingBuilder;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;

/**
 * = CustomerRepositoryImpl
 *
 * TODO Auto-generated class documentation
 *
 */
@RooJpaRepositoryCustomImpl(repository = CustomerRepositoryCustom.class)
@Transactional(readOnly = true)
public class CustomerRepositoryImpl extends QueryDslRepositorySupportExt<Customer> implements CustomerRepositoryCustom {

    /**
     * Default constructor
     */
    CustomerRepositoryImpl() {
        super(Customer.class);
    }

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    public static final String CONTACT_NAME = "contactName";

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    public static final String COMPANY_NAME = "companyName";

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
    public static final String CONTACT_TITLE = "contactTitle";

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    public static final String POSTAL_CODE = "postalCode";

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    public static final String ADDRESS = "address";

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    public static final String PHONE = "phone";

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    public static final String ID = "id";

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    public static final String FAX = "fax";

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    public static final String EMAIL = "email";

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    public static final String REGION = "region";

    /**
     * TODO Auto-generated method documentation
     *
     * @param globalSearch
     * @param pageable
     * @return Page
     *
    public Page<CustomerInfo> findAll(GlobalSearch globalSearch, Pageable pageable) {
        QCustomer customer = QCustomer.customer;
        JPQLQuery<Customer> query = from(customer);
        Path<?>[] paths = new Path<?>[] { customer.id, customer.companyName, customer.email, customer.fax };
        applyGlobalSearch(globalSearch, query, paths);
        AttributeMappingBuilder mapping = buildMapper().map(ID, customer.id).map(COMPANY_NAME, customer.companyName).map(EMAIL, customer.email).map(FAX, customer.fax);
        applyPagination(pageable, query, mapping);
        applyOrderById(query);
        return loadPage(query, pageable, Projections.constructor(CustomerInfo.class, customer.id, customer.companyName, customer.email, customer.fax));
    }
		*/
	@Override
	public Page<CustomerInfo> findAllByIdsIn(List<Long> ids, GlobalSearch globalSearch, Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<CustomerInfo> findAll(GlobalSearch globalSearch, Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

    /**
     * TODO Auto-generated method documentation
     *
     * @param ids
     * @param globalSearch
     * @param pageable
     * @return Page
     *
    public Page<CustomerInfo> findAllByIdsIn(List<Long> ids, GlobalSearch globalSearch, Pageable pageable) {
        QCustomer customer = QCustomer.customer;
        JPQLQuery<Customer> query = from(customer);
        Path<?>[] paths = new Path<?>[] { customer.id, customer.companyName, customer.email, customer.fax };
        applyGlobalSearch(globalSearch, query, paths);
        // Also, filter by the provided ids
        query.where(customer.id.in(ids));
        AttributeMappingBuilder mapping = buildMapper().map(ID, customer.id).map(COMPANY_NAME, customer.companyName).map(EMAIL, customer.email).map(FAX, customer.fax);
        applyPagination(pageable, query, mapping);
        applyOrderById(query);
        return loadPage(query, pageable, Projections.constructor(CustomerInfo.class, customer.id, customer.companyName, customer.email, customer.fax));
    }
    */
}
