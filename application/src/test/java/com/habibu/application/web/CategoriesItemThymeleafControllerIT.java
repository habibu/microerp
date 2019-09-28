package com.habibu.application.web;
import org.springframework.roo.addon.web.mvc.thymeleaf.annotations.test.RooThymeleafControllerIntegrationTest;
import com.habibu.model.dod.CategoryFactory;
import io.springlets.boot.test.autoconfigure.web.servlet.SpringletsWebMvcTest;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * = CategoriesItemThymeleafControllerIT
 *
 * TODO Auto-generated class documentation
 *
 */
@RooThymeleafControllerIntegrationTest(targetClass = CategoriesItemThymeleafController.class)
@RunWith(SpringRunner.class)
@SpringletsWebMvcTest(controllers = CategoriesItemThymeleafController.class, secure = false)
public class CategoriesItemThymeleafControllerIT {
}
