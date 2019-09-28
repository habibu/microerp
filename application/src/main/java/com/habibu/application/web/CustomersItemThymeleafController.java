package com.habibu.application.web;
import com.habibu.model.Customer;
import io.springlets.web.mvc.util.concurrency.ConcurrencyManager;
import org.springframework.roo.addon.web.mvc.controller.annotations.ControllerType;
import org.springframework.roo.addon.web.mvc.controller.annotations.RooController;
import org.springframework.roo.addon.web.mvc.thymeleaf.annotations.RooThymeleaf;
import com.habibu.service.api.CustomerService;
import io.springlets.data.web.validation.GenericValidator;
import io.springlets.web.NotFoundException;
import io.springlets.web.mvc.util.ControllerMethodLinkBuilderFactory;
import io.springlets.web.mvc.util.MethodLinkBuilderFactory;
import io.springlets.web.mvc.util.concurrency.ConcurrencyCallback;
import io.springlets.web.mvc.util.concurrency.ConcurrencyTemplate;
import java.util.Locale;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.util.UriComponents;

/**
 * = CustomersItemThymeleafController
 *
 * TODO Auto-generated class documentation
 *
 */
@RooController(entity = Customer.class, type = ControllerType.ITEM)
@RooThymeleaf
@Controller
@RequestMapping(value = "/customers/{customer}", name = "CustomersItemThymeleafController", produces = MediaType.TEXT_HTML_VALUE)
public class CustomersItemThymeleafController implements ConcurrencyManager<Customer> {

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    private final ConcurrencyTemplate<Customer> concurrencyTemplate = new ConcurrencyTemplate<Customer>(this);

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    private CustomerService customerService;

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    private MethodLinkBuilderFactory<CustomersItemThymeleafController> itemLink;

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    private MessageSource messageSource;

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    private MethodLinkBuilderFactory<CustomersCollectionThymeleafController> collectionLink;

    /**
     * TODO Auto-generated constructor documentation
     *
     * @param customerService
     * @param messageSource
     * @param linkBuilder
     */
    @Autowired
    public CustomersItemThymeleafController(CustomerService customerService, MessageSource messageSource, ControllerMethodLinkBuilderFactory linkBuilder) {
        setCustomerService(customerService);
        setMessageSource(messageSource);
        setItemLink(linkBuilder.of(CustomersItemThymeleafController.class));
        setCollectionLink(linkBuilder.of(CustomersCollectionThymeleafController.class));
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @return CustomerService
     */
    public CustomerService getCustomerService() {
        return customerService;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param customerService
     */
    public void setCustomerService(CustomerService customerService) {
        this.customerService = customerService;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @return MessageSource
     */
    public MessageSource getMessageSource() {
        return messageSource;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param messageSource
     */
    public void setMessageSource(MessageSource messageSource) {
        this.messageSource = messageSource;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @return MethodLinkBuilderFactory
     */
    public MethodLinkBuilderFactory<CustomersItemThymeleafController> getItemLink() {
        return itemLink;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param itemLink
     */
    public void setItemLink(MethodLinkBuilderFactory<CustomersItemThymeleafController> itemLink) {
        this.itemLink = itemLink;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @return MethodLinkBuilderFactory
     */
    public MethodLinkBuilderFactory<CustomersCollectionThymeleafController> getCollectionLink() {
        return collectionLink;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param collectionLink
     */
    public void setCollectionLink(MethodLinkBuilderFactory<CustomersCollectionThymeleafController> collectionLink) {
        this.collectionLink = collectionLink;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param id
     * @param locale
     * @param method
     * @return Customer
     */
    @ModelAttribute
    public Customer getCustomer(@PathVariable("customer") Long id, Locale locale, HttpMethod method) {
        Customer customer = null;
        if (HttpMethod.PUT.equals(method)) {
            customer = customerService.findOneForUpdate(id);
        } else {
            customer = customerService.findOne(id);
        }
        if (customer == null) {
            String message = messageSource.getMessage("error_NotFound", new Object[] { "Customer", id }, "The record couldn't be found", locale);
            throw new NotFoundException(message);
        }
        return customer;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param customer
     * @param model
     * @return ModelAndView
     */
    @GetMapping(name = "show")
    public ModelAndView show(@ModelAttribute Customer customer, Model model) {
        model.addAttribute("customer", customer);
        return new ModelAndView("customers/show");
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param customer
     * @param model
     * @return ModelAndView
     */
    @GetMapping(value = "/inline", name = "showInline")
    public ModelAndView showInline(@ModelAttribute Customer customer, Model model) {
        model.addAttribute("customer", customer);
        return new ModelAndView("customers/showInline :: inline-content");
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param model
     */
    public void populateFormats(Model model) {
        model.addAttribute("application_locale", LocaleContextHolder.getLocale().getLanguage());
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param model
     */
    public void populateForm(Model model) {
        populateFormats(model);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @return ConcurrencyTemplate
     */
    public ConcurrencyTemplate<Customer> getConcurrencyTemplate() {
        return concurrencyTemplate;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @return String
     */
    public String getModelName() {
        return "customer";
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @return String
     */
    public String getEditViewPath() {
        return "customers/edit";
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param record
     * @return Integer
     */
    public Integer getLastVersion(Customer record) {
        return getCustomerService().findOne(record.getId()).getVersion();
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param entity
     * @param model
     * @return ModelAndView
     */
    public ModelAndView populateAndGetFormView(Customer entity, Model model) {
        // Populate the form with all the necessary elements
        populateForm(model);
        // Add concurrency attribute to the model to show the concurrency form
        // in the current edit view
        model.addAttribute("concurrency", true);
        // Add the new version value to the model.
        model.addAttribute("newVersion", getLastVersion(entity));
        // Add the current pet values to maintain the values introduced by the user
        model.addAttribute(getModelName(), entity);
        // Return the edit view path
        return new org.springframework.web.servlet.ModelAndView(getEditViewPath(), model.asMap());
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param binder
     */
    @InitBinder("customer")
    public void initCustomerBinder(WebDataBinder binder) {
        binder.setDisallowedFields("id");
        // Register validators
        GenericValidator validator = new GenericValidator(Customer.class, getCustomerService());
        binder.addValidators(validator);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param customer
     * @param model
     * @return ModelAndView
     */
    @GetMapping(value = "/edit-form", name = "editForm")
    public ModelAndView editForm(@ModelAttribute Customer customer, Model model) {
        populateForm(model);
        model.addAttribute("customer", customer);
        return new ModelAndView("customers/edit");
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param customer
     * @param result
     * @param version
     * @param concurrencyControl
     * @param model
     * @return ModelAndView
     */
    @PutMapping(name = "update")
    public ModelAndView update(@Valid @ModelAttribute Customer customer, BindingResult result, @RequestParam("version") Integer version, @RequestParam(value = "concurrency", required = false, defaultValue = "") String concurrencyControl, Model model) {
        // Check if provided form contain errors
        if (result.hasErrors()) {
            populateForm(model);
            return new ModelAndView(getEditViewPath());
        }
        // Create Concurrency Spring Template to ensure that the following code will manage the
        // possible concurrency exceptions that appears and execute the provided coded inside the Spring template.
        // If some concurrency exception appears the template will manage it.
        Customer savedCustomer = getConcurrencyTemplate().execute(customer, model, new ConcurrencyCallback<Customer>() {

            @Override
            public Customer doInConcurrency(Customer customer) throws Exception {
                return getCustomerService().save(customer);
            }
        });
        UriComponents showURI = getItemLink().to(CustomersItemThymeleafLinkFactory.SHOW).with("customer", savedCustomer.getId()).toUri();
        return new ModelAndView("redirect:" + showURI.toUriString());
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param customer
     * @return ResponseEntity
     */
    @ResponseBody
    @DeleteMapping(name = "delete")
    public ResponseEntity<?> delete(@ModelAttribute Customer customer) {
        getCustomerService().delete(customer);
        return ResponseEntity.ok().build();
    }
}
