package com.habibu.repository;
import com.habibu.model.Country;
import org.springframework.roo.addon.layers.repository.jpa.annotations.RooJpaRepository;
import org.springframework.transaction.annotation.Transactional;

/**
 * = CountryRepository
 *
 * TODO Auto-generated class documentation
 *
 */
@RooJpaRepository(entity = Country.class)
@Transactional(readOnly = true)
public interface CountryRepository extends ReadOnlyRepository<Country, Long>, CountryRepositoryCustom {
}
