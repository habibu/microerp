package com.habibu.application.web;
import org.springframework.roo.addon.web.mvc.thymeleaf.annotations.test.RooThymeleafControllerIntegrationTest;
import com.habibu.model.dod.CountryFactory;
import io.springlets.boot.test.autoconfigure.web.servlet.SpringletsWebMvcTest;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * = CountriesItemRegionsThymeleafControllerIT
 *
 * TODO Auto-generated class documentation
 *
 */
@RooThymeleafControllerIntegrationTest(targetClass = CountriesItemRegionsThymeleafController.class)
@RunWith(SpringRunner.class)
@SpringletsWebMvcTest(controllers = CountriesItemRegionsThymeleafController.class, secure = false)
public class CountriesItemRegionsThymeleafControllerIT {
}
