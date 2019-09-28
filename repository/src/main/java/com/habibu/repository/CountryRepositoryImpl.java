package com.habibu.repository;
import io.springlets.data.jpa.repository.support.QueryDslRepositorySupportExt;
import org.springframework.roo.addon.layers.repository.jpa.annotations.RooJpaRepositoryCustomImpl;
import com.habibu.model.Country;
//import com.habibu.model.QCountry;
import com.querydsl.core.types.Path;
import com.querydsl.jpa.JPQLQuery;
import io.springlets.data.domain.GlobalSearch;
import io.springlets.data.jpa.repository.support.QueryDslRepositorySupportExt.AttributeMappingBuilder;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;

/**
 * = CountryRepositoryImpl
 *
 * TODO Auto-generated class documentation
 *
 */
@RooJpaRepositoryCustomImpl(repository = CountryRepositoryCustom.class)
@Transactional(readOnly = true)
public class CountryRepositoryImpl extends QueryDslRepositorySupportExt<Country> implements CountryRepositoryCustom {

    /**
     * Default constructor
     */
    CountryRepositoryImpl() {
        super(Country.class);
    }

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    public static final String DESCRIPTION = "description";

	@Override
	public Page<Country> findAll(GlobalSearch globalSearch, Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<Country> findAllByIdsIn(List<Long> ids, GlobalSearch globalSearch, Pageable pageable) {
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
    public Page<Country> findAll(GlobalSearch globalSearch, Pageable pageable) {
        QCountry country = QCountry.country;
        JPQLQuery<Country> query = from(country);
        Path<?>[] paths = new Path<?>[] { country.description };
        applyGlobalSearch(globalSearch, query, paths);
        AttributeMappingBuilder mapping = buildMapper().map(DESCRIPTION, country.description);
        applyPagination(pageable, query, mapping);
        applyOrderById(query);
        return loadPage(query, pageable, country);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param ids
     * @param globalSearch
     * @param pageable
     * @return Page
     *
    public Page<Country> findAllByIdsIn(List<Long> ids, GlobalSearch globalSearch, Pageable pageable) {
        QCountry country = QCountry.country;
        JPQLQuery<Country> query = from(country);
        Path<?>[] paths = new Path<?>[] { country.description };
        applyGlobalSearch(globalSearch, query, paths);
        // Also, filter by the provided ids
        query.where(country.id.in(ids));
        AttributeMappingBuilder mapping = buildMapper().map(DESCRIPTION, country.description);
        applyPagination(pageable, query, mapping);
        applyOrderById(query);
        return loadPage(query, pageable, country);
    }
    */
}
