package com.habibu.application.config;
import com.habibu.application.ws.endpoint.CategoryWebServiceEndpoint;
import org.springframework.roo.addon.ws.annotations.RooWsEndpoints;
import com.habibu.service.api.CategoryService;
import io.tracee.binding.cxf.TraceeCxfFeature;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.xml.ws.Endpoint;
import org.apache.cxf.Bus;
import org.apache.cxf.feature.LoggingFeature;
import org.apache.cxf.jaxws.EndpointImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnWebApplication;
import org.springframework.boot.context.embedded.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.jpa.support.OpenEntityManagerInViewFilter;

/**
 * = WsEndpointsConfiguration
 *
 * TODO Auto-generated class documentation
 *
 */
@RooWsEndpoints(endpoints = { CategoryWebServiceEndpoint.class })
@Configuration
@ConditionalOnWebApplication
public class WsEndpointsConfiguration {

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    @Autowired
    private Bus bus;

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    @Value("${cxf.path}")
    private String cxfServletPath;

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(WsEndpointsConfiguration.class);

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    @Autowired
    private CategoryService categoryService;

    /**
     * TODO Auto-generated method documentation
     *
     * @return Logger
     */
    public Logger getLOGGER() {
        return LOGGER;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @return Bus
     */
    public Bus getBus() {
        return bus;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @return String
     */
    public String getCxfServletPath() {
        return cxfServletPath;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param cxfServletPath
     */
    public void setCxfServletPath(String cxfServletPath) {
        this.cxfServletPath = cxfServletPath;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @return CategoryService
     */
    public CategoryService getCategoryService() {
        return categoryService;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @return Endpoint
     */
    @Bean
    public Endpoint categoryWebServiceEndpoint() {
        EndpointImpl endpoint = new EndpointImpl(getBus(), new CategoryWebServiceEndpoint(getCategoryService()));
        endpoint.setFeatures(Arrays.asList(new TraceeCxfFeature(), new LoggingFeature()));
        endpoint.publish("/CategoryWebService");
        return endpoint;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @return FilterRegistrationBean
     */
    @Bean
    public FilterRegistrationBean openEntityManagerInViewFilter() {
        FilterRegistrationBean filterRegBean = new FilterRegistrationBean();
        filterRegBean.setFilter(new OpenEntityManagerInViewFilter());
        List<String> urlPatterns = new ArrayList<String>();
        urlPatterns.add(getCxfServletPath() + "/*");
        filterRegBean.setUrlPatterns(urlPatterns);
        if (getLOGGER().isDebugEnabled()) {
            getLOGGER().debug("Registering the 'OpenEntityManagerInViewFilter' filter for the '".concat(getCxfServletPath() + "/*").concat("' URL."));
        }
        return filterRegBean;
    }
}
