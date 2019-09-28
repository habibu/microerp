package com.habibu.application.web;
import org.springframework.roo.addon.web.mvc.thymeleaf.annotations.RooLinkFactory;
import io.springlets.web.mvc.util.MethodLinkFactory;
import io.springlets.web.mvc.util.SpringletsMvcUriComponentsBuilder;
import java.util.Map;
import org.springframework.stereotype.Component;
import org.springframework.web.util.UriComponents;

/**
 * = CountriesItemThymeleafLinkFactory
 *
 * TODO Auto-generated class documentation
 *
 */
@RooLinkFactory(controller = CountriesItemThymeleafController.class)
@Component
public class CountriesItemThymeleafLinkFactory implements MethodLinkFactory<CountriesItemThymeleafController> {

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    public static final String SHOW = "show";

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    public static final String SHOWINLINE = "showInline";

    /**
     * TODO Auto-generated method documentation
     *
     * @return Class
     */
    public Class<CountriesItemThymeleafController> getControllerClass() {
        return CountriesItemThymeleafController.class;
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
        if (methodName.equals(SHOW)) {
            return SpringletsMvcUriComponentsBuilder.fromMethodCall(SpringletsMvcUriComponentsBuilder.on(getControllerClass()).show(null, null)).buildAndExpand(pathVariables);
        }
        if (methodName.equals(SHOWINLINE)) {
            return SpringletsMvcUriComponentsBuilder.fromMethodCall(SpringletsMvcUriComponentsBuilder.on(getControllerClass()).showInline(null, null)).buildAndExpand(pathVariables);
        }
        throw new IllegalArgumentException("Invalid method name: " + methodName);
    }
}
