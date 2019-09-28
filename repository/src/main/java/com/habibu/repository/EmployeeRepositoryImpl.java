package com.habibu.repository;
import io.springlets.data.jpa.repository.support.QueryDslRepositorySupportExt;
import org.springframework.roo.addon.layers.repository.jpa.annotations.RooJpaRepositoryCustomImpl;
import com.habibu.model.Employee;
//import com.habibu.model.QEmployee;
import com.querydsl.core.types.Path;
import com.querydsl.jpa.JPQLQuery;
import io.springlets.data.domain.GlobalSearch;
import io.springlets.data.jpa.repository.support.QueryDslRepositorySupportExt.AttributeMappingBuilder;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;

/**
 * = EmployeeRepositoryImpl
 *
 * TODO Auto-generated class documentation
 *
 */
@RooJpaRepositoryCustomImpl(repository = EmployeeRepositoryCustom.class)
@Transactional(readOnly = true)
public class EmployeeRepositoryImpl extends QueryDslRepositorySupportExt<Employee> implements EmployeeRepositoryCustom {

    /**
     * Default constructor
     */
    EmployeeRepositoryImpl() {
        super(Employee.class);
    }

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
    public static final String REGION = "region";

	@Override
	public Page<Employee> findAll(GlobalSearch globalSearch, Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<Employee> findAllByIdsIn(List<Long> ids, GlobalSearch globalSearch, Pageable pageable) {
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
    public Page<Employee> findAll(GlobalSearch globalSearch, Pageable pageable) {
        QEmployee employee = QEmployee.employee;
        JPQLQuery<Employee> query = from(employee);
        Path<?>[] paths = new Path<?>[] { employee.city, employee.country, employee.address, employee.postalCode, employee.phone, employee.region };
        applyGlobalSearch(globalSearch, query, paths);
        AttributeMappingBuilder mapping = buildMapper().map(CITY, employee.city).map(COUNTRY, employee.country).map(ADDRESS, employee.address).map(POSTAL_CODE, employee.postalCode).map(PHONE, employee.phone).map(REGION, employee.region);
        applyPagination(pageable, query, mapping);
        applyOrderById(query);
        return loadPage(query, pageable, employee);
    }

	@Override
	public Page<Employee> findAllByIdsIn(List<Long> ids, GlobalSearch globalSearch, Pageable pageable) {
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
    public Page<Employee> findAllByIdsIn(List<Long> ids, GlobalSearch globalSearch, Pageable pageable) {
        QEmployee employee = QEmployee.employee;
        JPQLQuery<Employee> query = from(employee);
        Path<?>[] paths = new Path<?>[] { employee.city, employee.country, employee.address, employee.postalCode, employee.phone, employee.region };
        applyGlobalSearch(globalSearch, query, paths);
        // Also, filter by the provided ids
        query.where(employee.id.in(ids));
        AttributeMappingBuilder mapping = buildMapper().map(CITY, employee.city).map(COUNTRY, employee.country).map(ADDRESS, employee.address).map(POSTAL_CODE, employee.postalCode).map(PHONE, employee.phone).map(REGION, employee.region);
        applyPagination(pageable, query, mapping);
        applyOrderById(query);
        return loadPage(query, pageable, employee);
    }
    */
}
