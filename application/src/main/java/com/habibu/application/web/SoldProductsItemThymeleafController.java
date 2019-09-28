package com.habibu.application.web;
import com.habibu.model.SoldProduct;
import io.springlets.web.mvc.util.concurrency.ConcurrencyManager;
import org.springframework.roo.addon.web.mvc.controller.annotations.ControllerType;
import org.springframework.roo.addon.web.mvc.controller.annotations.RooController;
import org.springframework.roo.addon.web.mvc.thymeleaf.annotations.RooThymeleaf;
import com.habibu.service.api.SoldProductService;
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
 * = SoldProductsItemThymeleafController
 *
 * TODO Auto-generated class documentation
 *
 */
@RooController(entity = SoldProduct.class, type = ControllerType.ITEM)
@RooThymeleaf
@Controller
@RequestMapping(value = "/soldproducts/{soldProduct}", name = "SoldProductsItemThymeleafController", produces = MediaType.TEXT_HTML_VALUE)
public class SoldProductsItemThymeleafController implements ConcurrencyManager<SoldProduct> {

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    private final ConcurrencyTemplate<SoldProduct> concurrencyTemplate = new ConcurrencyTemplate<SoldProduct>(this);

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    private SoldProductService soldProductService;

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    private MethodLinkBuilderFactory<SoldProductsItemThymeleafController> itemLink;

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    private MessageSource messageSource;

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    private MethodLinkBuilderFactory<SoldProductsCollectionThymeleafController> collectionLink;

    /**
     * TODO Auto-generated constructor documentation
     *
     * @param soldProductService
     * @param messageSource
     * @param linkBuilder
     */
    @Autowired
    public SoldProductsItemThymeleafController(SoldProductService soldProductService, MessageSource messageSource, ControllerMethodLinkBuilderFactory linkBuilder) {
        setSoldProductService(soldProductService);
        setMessageSource(messageSource);
        setItemLink(linkBuilder.of(SoldProductsItemThymeleafController.class));
        setCollectionLink(linkBuilder.of(SoldProductsCollectionThymeleafController.class));
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @return SoldProductService
     */
    public SoldProductService getSoldProductService() {
        return soldProductService;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param soldProductService
     */
    public void setSoldProductService(SoldProductService soldProductService) {
        this.soldProductService = soldProductService;
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
    public MethodLinkBuilderFactory<SoldProductsItemThymeleafController> getItemLink() {
        return itemLink;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param itemLink
     */
    public void setItemLink(MethodLinkBuilderFactory<SoldProductsItemThymeleafController> itemLink) {
        this.itemLink = itemLink;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @return MethodLinkBuilderFactory
     */
    public MethodLinkBuilderFactory<SoldProductsCollectionThymeleafController> getCollectionLink() {
        return collectionLink;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param collectionLink
     */
    public void setCollectionLink(MethodLinkBuilderFactory<SoldProductsCollectionThymeleafController> collectionLink) {
        this.collectionLink = collectionLink;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param id
     * @param locale
     * @param method
     * @return SoldProduct
     */
    @ModelAttribute
    public SoldProduct getSoldProduct(@PathVariable("soldProduct") Long id, Locale locale, HttpMethod method) {
        SoldProduct soldProduct = null;
        if (HttpMethod.PUT.equals(method)) {
            soldProduct = soldProductService.findOneForUpdate(id);
        } else {
            soldProduct = soldProductService.findOne(id);
        }
        if (soldProduct == null) {
            String message = messageSource.getMessage("error_NotFound", new Object[] { "SoldProduct", id }, "The record couldn't be found", locale);
            throw new NotFoundException(message);
        }
        return soldProduct;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param soldProduct
     * @param model
     * @return ModelAndView
     */
    @GetMapping(name = "show")
    public ModelAndView show(@ModelAttribute SoldProduct soldProduct, Model model) {
        model.addAttribute("soldProduct", soldProduct);
        return new ModelAndView("soldproducts/show");
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param soldProduct
     * @param model
     * @return ModelAndView
     */
    @GetMapping(value = "/inline", name = "showInline")
    public ModelAndView showInline(@ModelAttribute SoldProduct soldProduct, Model model) {
        model.addAttribute("soldProduct", soldProduct);
        return new ModelAndView("soldproducts/showInline :: inline-content");
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
    public ConcurrencyTemplate<SoldProduct> getConcurrencyTemplate() {
        return concurrencyTemplate;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @return String
     */
    public String getModelName() {
        return "soldProduct";
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @return String
     */
    public String getEditViewPath() {
        return "soldproducts/edit";
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param record
     * @return Integer
     */
    public Integer getLastVersion(SoldProduct record) {
        return getSoldProductService().findOne(record.getId()).getVersion();
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param entity
     * @param model
     * @return ModelAndView
     */
    public ModelAndView populateAndGetFormView(SoldProduct entity, Model model) {
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
    @InitBinder("soldProduct")
    public void initSoldProductBinder(WebDataBinder binder) {
        binder.setDisallowedFields("id");
        // Register validators
        GenericValidator validator = new GenericValidator(SoldProduct.class, getSoldProductService());
        binder.addValidators(validator);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param soldProduct
     * @param model
     * @return ModelAndView
     */
    @GetMapping(value = "/edit-form", name = "editForm")
    public ModelAndView editForm(@ModelAttribute SoldProduct soldProduct, Model model) {
        populateForm(model);
        model.addAttribute("soldProduct", soldProduct);
        return new ModelAndView("soldproducts/edit");
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param soldProduct
     * @param result
     * @param version
     * @param concurrencyControl
     * @param model
     * @return ModelAndView
     */
    @PutMapping(name = "update")
    public ModelAndView update(@Valid @ModelAttribute SoldProduct soldProduct, BindingResult result, @RequestParam("version") Integer version, @RequestParam(value = "concurrency", required = false, defaultValue = "") String concurrencyControl, Model model) {
        // Check if provided form contain errors
        if (result.hasErrors()) {
            populateForm(model);
            return new ModelAndView(getEditViewPath());
        }
        // Create Concurrency Spring Template to ensure that the following code will manage the
        // possible concurrency exceptions that appears and execute the provided coded inside the Spring template.
        // If some concurrency exception appears the template will manage it.
        SoldProduct savedSoldProduct = getConcurrencyTemplate().execute(soldProduct, model, new ConcurrencyCallback<SoldProduct>() {

            @Override
            public SoldProduct doInConcurrency(SoldProduct soldProduct) throws Exception {
                return getSoldProductService().save(soldProduct);
            }
        });
        UriComponents showURI = getItemLink().to(SoldProductsItemThymeleafLinkFactory.SHOW).with("soldProduct", savedSoldProduct.getId()).toUri();
        return new ModelAndView("redirect:" + showURI.toUriString());
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param soldProduct
     * @return ResponseEntity
     */
    @ResponseBody
    @DeleteMapping(name = "delete")
    public ResponseEntity<?> delete(@ModelAttribute SoldProduct soldProduct) {
        getSoldProductService().delete(soldProduct);
        return ResponseEntity.ok().build();
    }
}
