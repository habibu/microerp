package com.habibu.service.api;
import com.habibu.model.Employee;
import io.springlets.data.web.validation.ValidatorService;
import io.springlets.format.EntityResolver;
import org.springframework.roo.addon.layers.service.annotations.RooService;
import io.springlets.data.domain.GlobalSearch;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * = EmployeeService
 *
 * TODO Auto-generated class documentation
 *
 */
@RooService(entity = Employee.class)
public interface EmployeeService extends EntityResolver<Employee, Long>, ValidatorService<Employee> {

    /**
     * TODO Auto-generated method documentation
     *
     * @param id
     * @return Employee
     */
    public abstract Employee findOne(Long id);

    /**
     * TODO Auto-generated method documentation
     *
     * @param employee
     */
    public abstract void delete(Employee employee);

    /**
     * TODO Auto-generated method documentation
     *
     * @param entities
     * @return List
     */
    public abstract List<Employee> save(Iterable<Employee> entities);

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
     * @return Employee
     */
    public abstract Employee save(Employee entity);

    /**
     * TODO Auto-generated method documentation
     *
     * @param id
     * @return Employee
     */
    public abstract Employee findOneForUpdate(Long id);

    /**
     * TODO Auto-generated method documentation
     *
     * @param ids
     * @return List
     */
    public abstract List<Employee> findAll(Iterable<Long> ids);

    /**
     * TODO Auto-generated method documentation
     *
     * @return List
     */
    public abstract List<Employee> findAll();

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
    public abstract Page<Employee> findAll(GlobalSearch globalSearch, Pageable pageable);

    /**
     * TODO Auto-generated method documentation
     *
     * @param ids
     * @param globalSearch
     * @param pageable
     * @return Page
     */
    public abstract Page<Employee> findAllByIdsIn(List<Long> ids, GlobalSearch globalSearch, Pageable pageable);
}
