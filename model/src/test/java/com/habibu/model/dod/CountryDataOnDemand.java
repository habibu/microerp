package com.habibu.model.dod;
import com.habibu.model.Country;
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
 * = CountryDataOnDemand
 *
 * TODO Auto-generated class documentation
 *
 */
@RooJpaDataOnDemand(entity = Country.class)
@Configurable
public class CountryDataOnDemand {

    /**
     * TODO Auto-generated constructor documentation
     *
     * @param entityManager
     */
    public CountryDataOnDemand(EntityManager entityManager) {
        this(entityManager, 10);
    }

    /**
     * TODO Auto-generated constructor documentation
     *
     * @param entityManager
     * @param size
     */
    public CountryDataOnDemand(EntityManager entityManager, int size) {
        setEntityManager(entityManager);
        setSize(size);
    }
}
