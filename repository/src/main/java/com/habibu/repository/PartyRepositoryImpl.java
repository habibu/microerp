package com.habibu.repository;
import io.springlets.data.jpa.repository.support.QueryDslRepositorySupportExt;
import org.springframework.roo.addon.layers.repository.jpa.annotations.RooJpaRepositoryCustomImpl;
import com.habibu.model.Party;
import com.habibu.model.City;
import com.habibu.model.Country;
import com.habibu.model.QParty;
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
 * = PartyRepositoryImpl
 *
 * TODO Auto-generated class documentation
 *
 */
@RooJpaRepositoryCustomImpl(repository = PartyRepositoryCustom.class)
@Transactional(readOnly = true)
public class PartyRepositoryImpl extends QueryDslRepositorySupportExt<Party> implements PartyRepositoryCustom {

    /**
     * Default constructor
     */
    PartyRepositoryImpl() {
        super(Party.class);
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

    /**
     * TODO Auto-generated method documentation
     *
     * @param globalSearch
     * @param pageable
     * @return Page
     */
    public Page<Party> findAll(GlobalSearch globalSearch, Pageable pageable) {
        QParty party = QParty.party;
        JPQLQuery<Party> query = from(party);
        Path<?>[] paths = new Path<?>[] { party.city, party.country, party.address, party.postalCode, party.phone, party.region };
        applyGlobalSearch(globalSearch, query, paths);
        AttributeMappingBuilder mapping = buildMapper().map(CITY, party.city).map(COUNTRY, party.country).map(ADDRESS, party.address).map(POSTAL_CODE, party.postalCode).map(PHONE, party.phone).map(REGION, party.region);
        applyPagination(pageable, query, mapping);
        applyOrderById(query);
        return loadPage(query, pageable, party);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param ids
     * @param globalSearch
     * @param pageable
     * @return Page
     */
    public Page<Party> findAllByIdsIn(List<Long> ids, GlobalSearch globalSearch, Pageable pageable) {
        QParty party = QParty.party;
        JPQLQuery<Party> query = from(party);
        Path<?>[] paths = new Path<?>[] { party.city, party.country, party.address, party.postalCode, party.phone, party.region };
        applyGlobalSearch(globalSearch, query, paths);
        // Also, filter by the provided ids
        query.where(party.id.in(ids));
        AttributeMappingBuilder mapping = buildMapper().map(CITY, party.city).map(COUNTRY, party.country).map(ADDRESS, party.address).map(POSTAL_CODE, party.postalCode).map(PHONE, party.phone).map(REGION, party.region);
        applyPagination(pageable, query, mapping);
        applyOrderById(query);
        return loadPage(query, pageable, party);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param city
     * @param globalSearch
     * @param pageable
     * @return Page
     */
    public Page<Party> findByCity(City city, GlobalSearch globalSearch, Pageable pageable) {
        QParty party = QParty.party;
        JPQLQuery<Party> query = from(party);
        Assert.notNull(city, "city is required");
        query.where(party.city.eq(city));
        Path<?>[] paths = new Path<?>[] { party.city, party.country, party.address, party.postalCode, party.phone, party.region };
        applyGlobalSearch(globalSearch, query, paths);
        AttributeMappingBuilder mapping = buildMapper().map(CITY, party.city).map(COUNTRY, party.country).map(ADDRESS, party.address).map(POSTAL_CODE, party.postalCode).map(PHONE, party.phone).map(REGION, party.region);
        applyPagination(pageable, query, mapping);
        applyOrderById(query);
        return loadPage(query, pageable, party);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param country
     * @param globalSearch
     * @param pageable
     * @return Page
     */
    public Page<Party> findByCountry(Country country, GlobalSearch globalSearch, Pageable pageable) {
        QParty party = QParty.party;
        JPQLQuery<Party> query = from(party);
        Assert.notNull(country, "country is required");
        query.where(party.country.eq(country));
        Path<?>[] paths = new Path<?>[] { party.city, party.country, party.address, party.postalCode, party.phone, party.region };
        applyGlobalSearch(globalSearch, query, paths);
        AttributeMappingBuilder mapping = buildMapper().map(CITY, party.city).map(COUNTRY, party.country).map(ADDRESS, party.address).map(POSTAL_CODE, party.postalCode).map(PHONE, party.phone).map(REGION, party.region);
        applyPagination(pageable, query, mapping);
        applyOrderById(query);
        return loadPage(query, pageable, party);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param region
     * @param globalSearch
     * @param pageable
     * @return Page
     */
    public Page<Party> findByRegion(Region region, GlobalSearch globalSearch, Pageable pageable) {
        QParty party = QParty.party;
        JPQLQuery<Party> query = from(party);
        Assert.notNull(region, "region is required");
        query.where(party.region.eq(region));
        Path<?>[] paths = new Path<?>[] { party.city, party.country, party.address, party.postalCode, party.phone, party.region };
        applyGlobalSearch(globalSearch, query, paths);
        AttributeMappingBuilder mapping = buildMapper().map(CITY, party.city).map(COUNTRY, party.country).map(ADDRESS, party.address).map(POSTAL_CODE, party.postalCode).map(PHONE, party.phone).map(REGION, party.region);
        applyPagination(pageable, query, mapping);
        applyOrderById(query);
        return loadPage(query, pageable, party);
    }
}
