package com.habibu.model.dod;
import com.habibu.model.Employee;
import org.springframework.roo.addon.jpa.annotations.dod.RooJpaDataOnDemand;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Configurable;

/**
 * = EmployeeDataOnDemand
 *
 * TODO Auto-generated class documentation
 *
 */
@RooJpaDataOnDemand(entity = Employee.class)
@Configurable
public class EmployeeDataOnDemand {

    /**
     * TODO Auto-generated constructor documentation
     *
     * @param entityManager
     */
    public EmployeeDataOnDemand(EntityManager entityManager) {
        this(entityManager, 10);
    }

    /**
     * TODO Auto-generated constructor documentation
     *
     * @param entityManager
     * @param size
     */
    public EmployeeDataOnDemand(EntityManager entityManager, int size) {
        setEntityManager(entityManager);
        setSize(size);
    }
}
