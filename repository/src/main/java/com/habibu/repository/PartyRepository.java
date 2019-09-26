package com.habibu.repository;
import com.habibu.model.Party;
import io.springlets.data.jpa.repository.DetachableJpaRepository;
import org.springframework.roo.addon.layers.repository.jpa.annotations.RooJpaRepository;

/**
 * = PartyRepository
 *
 * TODO Auto-generated class documentation
 *
 */
@RooJpaRepository(entity = Party.class)
public interface PartyRepository extends DetachableJpaRepository<Party, Long>, PartyRepositoryCustom {
}
