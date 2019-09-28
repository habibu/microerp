package com.habibu.application.web;
import org.springframework.roo.addon.web.mvc.thymeleaf.annotations.RooLinkFactory;
import io.springlets.web.mvc.util.MethodLinkFactory;
import io.springlets.web.mvc.util.SpringletsMvcUriComponentsBuilder;
import java.util.Map;
import org.springframework.stereotype.Component;
import org.springframework.web.util.UriComponents;

/**
 * = CountriesItemSuppliersThymeleafLinkFactory
 *
 * TODO Auto-generated class documentation
 *
 */
@RooLinkFactory(controller = CountriesItemSuppliersThymeleafController.class)
@Component
public class CountriesItemSuppliersThymeleafLinkFactory implements MethodLinkFactory<CountriesItemSuppliersThymeleafController> {

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    public static final String DATATABLESBYIDSIN = "datatablesByIdsIn";

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    public static final String DATATABLES = "datatables";

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    public static final String CREATEFORM = "createForm";

    /**
     * TODO Auto-generated method documentation
     *
     * @return Class
     */
    public Class<CountriesItemSuppliersThymeleafController> getControllerClass() {
        return CountriesItemSuppliersThymeleafController.class;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param methodName
     * @param parameters
     * @param pathVariables
     * @return UriComponents
     */
    public UriComponents toUri(String methodName, Object[] parameters, Map<String, Object> pathVariables) {
        if (methodName.equals(DATATABLES)) {
            return SpringletsMvcUriComponentsBuilder.fromMethodCall(SpringletsMvcUriComponentsBuilder.on(getControllerClass()).datatables(null, null, null, null, null)).buildAndExpand(pathVariables);
        }
        if (methodName.equals(DATATABLESBYIDSIN)) {
            return SpringletsMvcUriComponentsBuilder.fromMethodCall(SpringletsMvcUriComponentsBuilder.on(getControllerClass()).datatablesByIdsIn(null, null, null, null, null)).buildAndExpand(pathVariables);
        }
        if (methodName.equals(CREATEFORM)) {
            return SpringletsMvcUriComponentsBuilder.fromMethodCall(SpringletsMvcUriComponentsBuilder.on(getControllerClass()).createForm(null, null)).buildAndExpand(pathVariables);
        }
        throw new IllegalArgumentException("Invalid method name: " + methodName);
    }
}
