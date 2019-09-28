package com.habibu.repository;
import com.habibu.model.Shipper;
import io.springlets.data.jpa.repository.DetachableJpaRepository;
import org.springframework.roo.addon.layers.repository.jpa.annotations.RooJpaRepository;
import org.springframework.roo.addon.layers.repository.jpa.annotations.finder.RooFinder;
import com.habibu.model.ShipperPhoneFormBean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;

/**
 * = ShipperRepository
 *
 * TODO Auto-generated class documentation
 *
 */
@RooJpaRepository(entity = Shipper.class, finders = { @RooFinder(value = "findByCompanyName", returnType = Shipper.class), @RooFinder(value = "findByPhone", returnType = Shipper.class, formBean = ShipperPhoneFormBean.class) })
@Transactional(readOnly = true)
public interface ShipperRepository extends DetachableJpaRepository<Shipper, Long>, ShipperRepositoryCustom {

    /**
     * TODO Auto-generated method documentation
     *
     * @param companyName
     * @param pageable
     * @return Page
     */
    public abstract Page<Shipper> findByCompanyName(String companyName, Pageable pageable);

    /**
     * TODO Auto-generated method documentation
     *
     * @param companyName
     * @return Long
     */
    public abstract long countByCompanyName(String companyName);
}
