package com.habibu.application.web;
import org.springframework.roo.addon.web.mvc.thymeleaf.annotations.test.RooThymeleafControllerIntegrationTest;
import com.habibu.model.dod.CustomerOrderFactory;
import io.springlets.boot.test.autoconfigure.web.servlet.SpringletsWebMvcTest;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * = CustomerOrdersCollectionThymeleafControllerIT
 *
 * TODO Auto-generated class documentation
 *
 */
@RooThymeleafControllerIntegrationTest(targetClass = CustomerOrdersCollectionThymeleafController.class)
@RunWith(SpringRunner.class)
@SpringletsWebMvcTest(controllers = CustomerOrdersCollectionThymeleafController.class, secure = false)
public class CustomerOrdersCollectionThymeleafControllerIT {
}
