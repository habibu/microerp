package com.habibu.application.web;
import org.springframework.roo.addon.web.mvc.thymeleaf.annotations.test.RooThymeleafControllerIntegrationTest;
import com.habibu.model.dod.OrderDetailFactory;
import io.springlets.boot.test.autoconfigure.web.servlet.SpringletsWebMvcTest;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * = OrderDetailsCollectionThymeleafControllerIT
 *
 * TODO Auto-generated class documentation
 *
 */
@RooThymeleafControllerIntegrationTest(targetClass = OrderDetailsCollectionThymeleafController.class)
@RunWith(SpringRunner.class)
@SpringletsWebMvcTest(controllers = OrderDetailsCollectionThymeleafController.class, secure = false)
public class OrderDetailsCollectionThymeleafControllerIT {
}
