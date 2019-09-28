package com.habibu.repository;
import io.springlets.data.jpa.repository.support.QueryDslRepositorySupportExt;
import org.springframework.roo.addon.layers.repository.jpa.annotations.RooJpaRepositoryCustomImpl;
import com.habibu.model.City;
//import com.habibu.model.QCity;
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
 * = CityRepositoryImpl
 *
 * TODO Auto-generated class documentation
 *
 */
@RooJpaRepositoryCustomImpl(repository = CityRepositoryCustom.class)
@Transactional(readOnly = true)
public class CityRepositoryImpl extends QueryDslRepositorySupportExt<City> implements CityRepositoryCustom {

    /**
     * Default constructor
     */
    CityRepositoryImpl() {
        super(City.class);
    }

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    public static final String DESCRIPTION = "description";

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    public static final String REGION = "region";

	@Override
	public Page<City> findByRegion(Region region, GlobalSearch globalSearch, Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<City> findAll(GlobalSearch globalSearch, Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<City> findAllByIdsIn(List<Long> ids, GlobalSearch globalSearch, Pageable pageable) {
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
    public Page<City> findAll(GlobalSearch globalSearch, Pageable pageable) {
        QCity city = QCity.city;
        JPQLQuery<City> query = from(city);
        Path<?>[] paths = new Path<?>[] { city.description, city.region };
        applyGlobalSearch(globalSearch, query, paths);
        AttributeMappingBuilder mapping = buildMapper().map(DESCRIPTION, city.description).map(REGION, city.region);
        applyPagination(pageable, query, mapping);
        applyOrderById(query);
        return loadPage(query, pageable, city);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param ids
     * @param globalSearch
     * @param pageable
     * @return Page
     *
    public Page<City> findAllByIdsIn(List<Long> ids, GlobalSearch globalSearch, Pageable pageable) {
        QCity city = QCity.city;
        JPQLQuery<City> query = from(city);
        Path<?>[] paths = new Path<?>[] { city.description, city.region };
        applyGlobalSearch(globalSearch, query, paths);
        // Also, filter by the provided ids
        query.where(city.id.in(ids));
        AttributeMappingBuilder mapping = buildMapper().map(DESCRIPTION, city.description).map(REGION, city.region);
        applyPagination(pageable, query, mapping);
        applyOrderById(query);
        return loadPage(query, pageable, city);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param region
     * @param globalSearch
     * @param pageable
     * @return Page
     *
    public Page<City> findByRegion(Region region, GlobalSearch globalSearch, Pageable pageable) {
        QCity city = QCity.city;
        JPQLQuery<City> query = from(city);
        Assert.notNull(region, "region is required");
        query.where(city.region.eq(region));
        Path<?>[] paths = new Path<?>[] { city.description, city.region };
        applyGlobalSearch(globalSearch, query, paths);
        AttributeMappingBuilder mapping = buildMapper().map(DESCRIPTION, city.description).map(REGION, city.region);
        applyPagination(pageable, query, mapping);
        applyOrderById(query);
        return loadPage(query, pageable, city);
    }
    */
}
