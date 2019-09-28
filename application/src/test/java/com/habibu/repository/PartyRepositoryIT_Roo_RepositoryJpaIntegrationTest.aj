// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package com.habibu.repository;

import static org.assertj.core.api.Assertions.assertThat;

import com.habibu.model.Party;
import com.habibu.model.dod.PartyDataOnDemand;
import com.habibu.repository.PartyRepository;
import com.habibu.repository.PartyRepositoryIT;
import io.springlets.data.domain.GlobalSearch;
import java.util.Iterator;
import java.util.List;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

privileged aspect PartyRepositoryIT_Roo_RepositoryJpaIntegrationTest {
    
    /**
     * TODO Auto-generated attribute documentation
     * 
     */
    @Rule
    public ExpectedException PartyRepositoryIT.thrown = ExpectedException.none();
    
    /**
     * TODO Auto-generated attribute documentation
     * 
     */
    @Autowired
    private PartyRepository PartyRepositoryIT.repository;
    
    /**
     * TODO Auto-generated attribute documentation
     * 
     */
    @Autowired
    private PartyDataOnDemand PartyRepositoryIT.dod;
    
    /**
     * TODO Auto-generated method documentation
     * 
     * @return PartyRepository
     */
    public PartyRepository PartyRepositoryIT.getRepository() {
        return repository;
    }
    
    /**
     * TODO Auto-generated method documentation
     * 
     * @return PartyDataOnDemand
     */
    public PartyDataOnDemand PartyRepositoryIT.getDod() {
        return dod;
    }
    
    /**
     * TODO Auto-generated method documentation
     * 
     */
    @Before
    public void PartyRepositoryIT.checkDataOnDemandHasInitializedCorrectly() {
        assertThat(getDod().getRandomParty())
            .as("Check data on demand for 'Party' initializes correctly by getting a random Party")
            .isNotNull();
    }
    
    /**
     * TODO Auto-generated method documentation
     * 
     */
    @Test
    public void PartyRepositoryIT.countShouldReturnExpectedValue() {
        // Verify
        assertThat(getRepository().count()).as("Check there are available 'Party' entries").isGreaterThan(0);
    }
    
    /**
     * TODO Auto-generated method documentation
     * 
     */
    @Test
    public void PartyRepositoryIT.findOneShouldReturnExistingParty() {
        // Setup
        Long id = getRandomPartyId();
        
        // Exercise
        Party party = getRepository().findOne(id);
        
        // Verify
        assertThat(party).as("Check that findOne illegally returned null for id %s", id).isNotNull();
        assertThat(id).as("Check the identifier of the found 'Party' is the same used to look for it")
            .isEqualTo(party.getId());
    }
    
    /**
     * TODO Auto-generated method documentation
     * 
     */
    @Test
    public void PartyRepositoryIT.findAllShouldReturnAllParties() {
        // Setup
        assertThat(getRepository().count())
            .as("Check the number of entries is not too big (250 entries). "
                + "If it is, please review the tests so it doesn't take too long to run them")
            .isLessThan(250);
        
        // Exercise
        List<Party> result = getRepository().findAll();
        
        // Verify
        assertThat(result).as("Check 'findAll' returns a not null list of entries").isNotNull();
        assertThat(result.size()).as("Check 'findAll' returns a not empty list of entries")
            .isGreaterThan(0);
    }
    
    /**
     * TODO Auto-generated method documentation
     * 
     */
    @Test
    public void PartyRepositoryIT.persistShouldGenerateIdValue() {
        // Setup
        // Exercise
        Party party = getDod().getNewRandomTransientParty();
        
        // Verify
        assertThat(party).as("Check the Data on demand generated a new non null 'Party'").isNotNull();
        assertThat(party.getId()).as("Check the Data on demand generated a new 'Party' whose id is null")
            .isNull();
        try {
            party = getRepository().saveAndFlush(party);
        } catch (final ConstraintViolationException e) {
            final StringBuilder msg = new StringBuilder();
            for (Iterator<ConstraintViolation<?>> iter = e.getConstraintViolations().iterator(); iter
                .hasNext();) {
                final ConstraintViolation<?> cv = iter.next();
                msg.append("[").append(cv.getRootBean().getClass().getName()).append(".")
                    .append(cv.getPropertyPath()).append(": ").append(cv.getMessage())
                    .append(" (invalid value = ").append(cv.getInvalidValue()).append(")").append("]");
            }
            throw new IllegalStateException(msg.toString(), e);
        }
        assertThat(party.getId()).as("Check a 'Party' (%s) id is not null after been persisted", party)
            .isNotNull();
    }
    
    /**
     * TODO Auto-generated method documentation
     * 
     */
    @Test
    public void PartyRepositoryIT.deleteShouldMakePartyUnavailable() {
        // Setup
        Long id = getRandomPartyId();
        Party party = getRepository().findOne(id);
        
        // Exercise
        getRepository().delete(party);
        
        // Verify
        assertThat(getRepository().findOne(id))
        .as("Check the deleted 'Party' %s is no longer available with 'findOne'", party).isNull();
    }
    
    /**
     * TODO Auto-generated method documentation
     * 
     */
    @Test
    public void PartyRepositoryIT.findAllCustomNotFilteredNotPagedShouldReturnAllParties() {
        // Exercise
        Page<Party> all = getRepository().findAll((GlobalSearch) null, new PageRequest(0, getDod().getSize()));
        
        // Verify
        assertThat(all.getNumberOfElements())
            .as("Check 'findAll' with null 'GlobalSearch' and no pagination returns all entries")
            .isEqualTo(getDod().getSize());
    }
    
    /**
     * TODO Auto-generated method documentation
     * 
     */
    @Test
    public void PartyRepositoryIT.findAllCustomNotFilteredPagedShouldReturnAPartiesPage() {
        // Exercise
        Page<Party> all = getRepository().findAll((GlobalSearch) null, new PageRequest(0, 3));
        
        // Verify
        assertThat(all.getNumberOfElements())
            .as("Check result number is not greater than the page size").isLessThanOrEqualTo(3);
    }
    
    /**
     * TODO Auto-generated method documentation
     * 
     * @return Long
     */
    private Long PartyRepositoryIT.getRandomPartyId() {
        Party party = getDod().getRandomParty();
        Long id = party.getId();
        assertThat(id).as("Check the Data on demand generated a 'Party' with an identifier").isNotNull();
        return id;
    }
    
}
