package com.habibu.repository;
import com.habibu.model.Country;
import org.springframework.roo.addon.layers.repository.jpa.annotations.RooJpaRepository;

/**
 * = CountryRepository
 *
 * TODO Auto-generated class documentation
 *
 */
@RooJpaRepository(entity = Country.class)
public interface CountryRepository extends ReadOnlyRepository<Country, Long>, CountryRepositoryCustom {
}
