package com.habibu.model.dod;
import com.habibu.model.Shipper;
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
 * = ShipperDataOnDemand
 *
 * TODO Auto-generated class documentation
 *
 */
@RooJpaDataOnDemand(entity = Shipper.class)
@Configurable
public class ShipperDataOnDemand {

    /**
     * TODO Auto-generated constructor documentation
     *
     * @param entityManager
     */
    public ShipperDataOnDemand(EntityManager entityManager) {
        this(entityManager, 10);
    }

    /**
     * TODO Auto-generated constructor documentation
     *
     * @param entityManager
     * @param size
     */
    public ShipperDataOnDemand(EntityManager entityManager, int size) {
        setEntityManager(entityManager);
        setSize(size);
    }
}
