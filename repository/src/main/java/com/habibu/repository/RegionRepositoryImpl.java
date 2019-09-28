package com.habibu.repository;
import io.springlets.data.jpa.repository.support.QueryDslRepositorySupportExt;
import org.springframework.roo.addon.layers.repository.jpa.annotations.RooJpaRepositoryCustomImpl;
import com.habibu.model.Region;
import com.habibu.model.Country;
import com.habibu.model.QRegion;
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
 * = RegionRepositoryImpl
 *
 * TODO Auto-generated class documentation
 *
 */
@RooJpaRepositoryCustomImpl(repository = RegionRepositoryCustom.class)
@Transactional(readOnly = true)
public class RegionRepositoryImpl extends QueryDslRepositorySupportExt<Region> implements RegionRepositoryCustom {

    /**
     * Default constructor
     */
    RegionRepositoryImpl() {
        super(Region.class);
    }

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    public static final String COUNTRY = "country";

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    public static final String DESCRIPTION = "description";

    /**
     * TODO Auto-generated method documentation
     *
     * @param globalSearch
     * @param pageable
     * @return Page
     */
    public Page<Region> findAll(GlobalSearch globalSearch, Pageable pageable) {
        QRegion region = QRegion.region;
        JPQLQuery<Region> query = from(region);
        Path<?>[] paths = new Path<?>[] { region.country, region.description };
        applyGlobalSearch(globalSearch, query, paths);
        AttributeMappingBuilder mapping = buildMapper().map(COUNTRY, region.country).map(DESCRIPTION, region.description);
        applyPagination(pageable, query, mapping);
        applyOrderById(query);
        return loadPage(query, pageable, region);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param ids
     * @param globalSearch
     * @param pageable
     * @return Page
     */
    public Page<Region> findAllByIdsIn(List<Long> ids, GlobalSearch globalSearch, Pageable pageable) {
        QRegion region = QRegion.region;
        JPQLQuery<Region> query = from(region);
        Path<?>[] paths = new Path<?>[] { region.country, region.description };
        applyGlobalSearch(globalSearch, query, paths);
        // Also, filter by the provided ids
        query.where(region.id.in(ids));
        AttributeMappingBuilder mapping = buildMapper().map(COUNTRY, region.country).map(DESCRIPTION, region.description);
        applyPagination(pageable, query, mapping);
        applyOrderById(query);
        return loadPage(query, pageable, region);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param country
     * @param globalSearch
     * @param pageable
     * @return Page
     */
    public Page<Region> findByCountry(Country country, GlobalSearch globalSearch, Pageable pageable) {
        QRegion region = QRegion.region;
        JPQLQuery<Region> query = from(region);
        Assert.notNull(country, "country is required");
        query.where(region.country.eq(country));
        Path<?>[] paths = new Path<?>[] { region.country, region.description };
        applyGlobalSearch(globalSearch, query, paths);
        AttributeMappingBuilder mapping = buildMapper().map(COUNTRY, region.country).map(DESCRIPTION, region.description);
        applyPagination(pageable, query, mapping);
        applyOrderById(query);
        return loadPage(query, pageable, region);
    }
}
