package com.habibu.application.web;
import org.springframework.roo.addon.web.mvc.controller.annotations.test.RooJsonControllerIntegrationTest;
import com.habibu.model.dod.PurchaseOrderFactory;
import com.habibu.service.api.PurchaseOrderService;
import io.springlets.boot.test.autoconfigure.web.servlet.SpringletsWebMvcTest;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * = PurchaseOrdersItemJsonControllerIT
 *
 * TODO Auto-generated class documentation
 *
 */
@RooJsonControllerIntegrationTest(targetClass = PurchaseOrdersItemJsonController.class)
@RunWith(SpringRunner.class)
@SpringletsWebMvcTest(controllers = PurchaseOrdersItemJsonController.class, secure = false)
public class PurchaseOrdersItemJsonControllerIT {
}
