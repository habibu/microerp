package com.habibu.repository;
import com.habibu.model.dod.DataOnDemandConfiguration;
import com.habibu.model.dod.RegionDataOnDemand;
import org.springframework.roo.addon.layers.repository.jpa.annotations.test.RooRepositoryJpaIntegrationTest;
import com.habibu.application.config.SpringDataJpaDetachableRepositoryConfiguration;
import com.habibu.model.Region;
import io.springlets.data.domain.GlobalSearch;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * = RegionRepositoryIT
 *
 * TODO Auto-generated class documentation
 *
 */
@RooRepositoryJpaIntegrationTest(targetClass = RegionRepository.class, dodConfigurationClass = DataOnDemandConfiguration.class, dodClass = RegionDataOnDemand.class)
@RunWith(SpringRunner.class)
@DataJpaTest
@Import({ DataOnDemandConfiguration.class, SpringDataJpaDetachableRepositoryConfiguration.class })
public class RegionRepositoryIT {
}
