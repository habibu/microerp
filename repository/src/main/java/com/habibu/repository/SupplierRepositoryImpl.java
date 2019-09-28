package com.habibu.repository;
import io.springlets.data.jpa.repository.support.QueryDslRepositorySupportExt;
import org.springframework.roo.addon.layers.repository.jpa.annotations.RooJpaRepositoryCustomImpl;
import com.habibu.model.Supplier;
import com.habibu.model.City;
import com.habibu.model.Country;
import com.habibu.model.QSupplier;
import com.habibu.model.Region;
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
 * = SupplierRepositoryImpl
 *
 * TODO Auto-generated class documentation
 *
 */
@RooJpaRepositoryCustomImpl(repository = SupplierRepositoryCustom.class)
@Transactional(readOnly = true)
public class SupplierRepositoryImpl extends QueryDslRepositorySupportExt<Supplier> implements SupplierRepositoryCustom {

    /**
     * Default constructor
     */
    SupplierRepositoryImpl() {
        super(Supplier.class);
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
    public static final String WEBADDRESS = "webaddress";

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    public static final String FAX = "fax";

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    public static final String REGION = "region";

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    public static final String NAME = "name";

    /**
     * TODO Auto-generated method documentation
     *
     * @param globalSearch
     * @param pageable
     * @return Page
     */
    public Page<Supplier> findAll(GlobalSearch globalSearch, Pageable pageable) {
        QSupplier supplier = QSupplier.supplier;
        JPQLQuery<Supplier> query = from(supplier);
        Path<?>[] paths = new Path<?>[] { supplier.city, supplier.country, supplier.region, supplier.name, supplier.contactName, supplier.contactTitle, supplier.address, supplier.postalCode, supplier.phone, supplier.fax, supplier.webaddress };
        applyGlobalSearch(globalSearch, query, paths);
        AttributeMappingBuilder mapping = buildMapper().map(CITY, supplier.city).map(COUNTRY, supplier.country).map(REGION, supplier.region).map(NAME, supplier.name).map(CONTACT_NAME, supplier.contactName).map(CONTACT_TITLE, supplier.contactTitle).map(ADDRESS, supplier.address).map(POSTAL_CODE, supplier.postalCode).map(PHONE, supplier.phone).map(FAX, supplier.fax).map(WEBADDRESS, supplier.webaddress);
        applyPagination(pageable, query, mapping);
        applyOrderById(query);
        return loadPage(query, pageable, supplier);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param ids
     * @param globalSearch
     * @param pageable
     * @return Page
     */
    public Page<Supplier> findAllByIdsIn(List<Long> ids, GlobalSearch globalSearch, Pageable pageable) {
        QSupplier supplier = QSupplier.supplier;
        JPQLQuery<Supplier> query = from(supplier);
        Path<?>[] paths = new Path<?>[] { supplier.city, supplier.country, supplier.region, supplier.name, supplier.contactName, supplier.contactTitle, supplier.address, supplier.postalCode, supplier.phone, supplier.fax, supplier.webaddress };
        applyGlobalSearch(globalSearch, query, paths);
        // Also, filter by the provided ids
        query.where(supplier.id.in(ids));
        AttributeMappingBuilder mapping = buildMapper().map(CITY, supplier.city).map(COUNTRY, supplier.country).map(REGION, supplier.region).map(NAME, supplier.name).map(CONTACT_NAME, supplier.contactName).map(CONTACT_TITLE, supplier.contactTitle).map(ADDRESS, supplier.address).map(POSTAL_CODE, supplier.postalCode).map(PHONE, supplier.phone).map(FAX, supplier.fax).map(WEBADDRESS, supplier.webaddress);
        applyPagination(pageable, query, mapping);
        applyOrderById(query);
        return loadPage(query, pageable, supplier);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param city
     * @param globalSearch
     * @param pageable
     * @return Page
     */
    public Page<Supplier> findByCity(City city, GlobalSearch globalSearch, Pageable pageable) {
        QSupplier supplier = QSupplier.supplier;
        JPQLQuery<Supplier> query = from(supplier);
        Assert.notNull(city, "city is required");
        query.where(supplier.city.eq(city));
        Path<?>[] paths = new Path<?>[] { supplier.city, supplier.country, supplier.region, supplier.name, supplier.contactName, supplier.contactTitle, supplier.address, supplier.postalCode, supplier.phone, supplier.fax, supplier.webaddress };
        applyGlobalSearch(globalSearch, query, paths);
        AttributeMappingBuilder mapping = buildMapper().map(CITY, supplier.city).map(COUNTRY, supplier.country).map(REGION, supplier.region).map(NAME, supplier.name).map(CONTACT_NAME, supplier.contactName).map(CONTACT_TITLE, supplier.contactTitle).map(ADDRESS, supplier.address).map(POSTAL_CODE, supplier.postalCode).map(PHONE, supplier.phone).map(FAX, supplier.fax).map(WEBADDRESS, supplier.webaddress);
        applyPagination(pageable, query, mapping);
        applyOrderById(query);
        return loadPage(query, pageable, supplier);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param country
     * @param globalSearch
     * @param pageable
     * @return Page
     */
    public Page<Supplier> findByCountry(Country country, GlobalSearch globalSearch, Pageable pageable) {
        QSupplier supplier = QSupplier.supplier;
        JPQLQuery<Supplier> query = from(supplier);
        Assert.notNull(country, "country is required");
        query.where(supplier.country.eq(country));
        Path<?>[] paths = new Path<?>[] { supplier.city, supplier.country, supplier.region, supplier.name, supplier.contactName, supplier.contactTitle, supplier.address, supplier.postalCode, supplier.phone, supplier.fax, supplier.webaddress };
        applyGlobalSearch(globalSearch, query, paths);
        AttributeMappingBuilder mapping = buildMapper().map(CITY, supplier.city).map(COUNTRY, supplier.country).map(REGION, supplier.region).map(NAME, supplier.name).map(CONTACT_NAME, supplier.contactName).map(CONTACT_TITLE, supplier.contactTitle).map(ADDRESS, supplier.address).map(POSTAL_CODE, supplier.postalCode).map(PHONE, supplier.phone).map(FAX, supplier.fax).map(WEBADDRESS, supplier.webaddress);
        applyPagination(pageable, query, mapping);
        applyOrderById(query);
        return loadPage(query, pageable, supplier);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param region
     * @param globalSearch
     * @param pageable
     * @return Page
     */
    public Page<Supplier> findByRegion(Region region, GlobalSearch globalSearch, Pageable pageable) {
        QSupplier supplier = QSupplier.supplier;
        JPQLQuery<Supplier> query = from(supplier);
        Assert.notNull(region, "region is required");
        query.where(supplier.region.eq(region));
        Path<?>[] paths = new Path<?>[] { supplier.city, supplier.country, supplier.region, supplier.name, supplier.contactName, supplier.contactTitle, supplier.address, supplier.postalCode, supplier.phone, supplier.fax, supplier.webaddress };
        applyGlobalSearch(globalSearch, query, paths);
        AttributeMappingBuilder mapping = buildMapper().map(CITY, supplier.city).map(COUNTRY, supplier.country).map(REGION, supplier.region).map(NAME, supplier.name).map(CONTACT_NAME, supplier.contactName).map(CONTACT_TITLE, supplier.contactTitle).map(ADDRESS, supplier.address).map(POSTAL_CODE, supplier.postalCode).map(PHONE, supplier.phone).map(FAX, supplier.fax).map(WEBADDRESS, supplier.webaddress);
        applyPagination(pageable, query, mapping);
        applyOrderById(query);
        return loadPage(query, pageable, supplier);
    }
}
