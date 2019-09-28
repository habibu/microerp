package com.habibu.repository;
import com.habibu.model.dod.DataOnDemandConfiguration;
import com.habibu.model.dod.OrderDetailDataOnDemand;
import org.springframework.roo.addon.layers.repository.jpa.annotations.test.RooRepositoryJpaIntegrationTest;
import com.habibu.application.config.SpringDataJpaDetachableRepositoryConfiguration;
import com.habibu.model.OrderDetail;
import io.springlets.data.domain.GlobalSearch;
import java.util.Iterator;
import java.util.List;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import static org.assertj.core.api.Assertions.assertThat;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * = OrderDetailRepositoryIT
 *
 * TODO Auto-generated class documentation
 *
 */
@RooRepositoryJpaIntegrationTest(targetClass = OrderDetailRepository.class, dodConfigurationClass = DataOnDemandConfiguration.class, dodClass = OrderDetailDataOnDemand.class)
@RunWith(SpringRunner.class)
@DataJpaTest
@Import({ DataOnDemandConfiguration.class, SpringDataJpaDetachableRepositoryConfiguration.class })
public class OrderDetailRepositoryIT {
}
