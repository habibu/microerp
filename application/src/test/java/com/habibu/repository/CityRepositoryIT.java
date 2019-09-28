package com.habibu.repository;
import com.habibu.model.dod.CityDataOnDemand;
import com.habibu.model.dod.DataOnDemandConfiguration;
import org.springframework.roo.addon.layers.repository.jpa.annotations.test.RooRepositoryJpaIntegrationTest;
import com.habibu.application.config.SpringDataJpaDetachableRepositoryConfiguration;
import com.habibu.model.City;
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
 * = CityRepositoryIT
 *
 * TODO Auto-generated class documentation
 *
 */
@RooRepositoryJpaIntegrationTest(targetClass = CityRepository.class, dodConfigurationClass = DataOnDemandConfiguration.class, dodClass = CityDataOnDemand.class)
@RunWith(SpringRunner.class)
@DataJpaTest
@Import({ DataOnDemandConfiguration.class, SpringDataJpaDetachableRepositoryConfiguration.class })
public class CityRepositoryIT {
}
