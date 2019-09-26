package com.habibu.repository;

import io.springlets.data.jpa.repository.support.QueryDslRepositorySupportExt;
import org.springframework.roo.addon.layers.repository.jpa.annotations.RooJpaRepositoryCustomImpl;
import com.habibu.model.Party;

/**
 * = PartyRepositoryImpl
 *
 * Implementation of PartyRepositoryCustom
 *
 */
@RooJpaRepositoryCustomImpl(repository = PartyRepositoryCustom.class)
public class PartyRepositoryImpl extends QueryDslRepositorySupportExt<Party> implements PartyRepositoryCustom{

    /**
     * Default constructor
     */
    PartyRepositoryImpl() {
        super(Party.class);
    }
}