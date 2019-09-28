package com.habibu.application.web;
import com.habibu.model.Shipper;
import io.springlets.web.mvc.util.concurrency.ConcurrencyManager;
import org.springframework.roo.addon.web.mvc.controller.annotations.ControllerType;
import org.springframework.roo.addon.web.mvc.controller.annotations.RooController;
import org.springframework.roo.addon.web.mvc.thymeleaf.annotations.RooThymeleaf;
import com.habibu.service.api.ShipperService;
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
 * = ShippersItemThymeleafController
 *
 * TODO Auto-generated class documentation
 *
 */
@RooController(entity = Shipper.class, type = ControllerType.ITEM)
@RooThymeleaf
@Controller
@RequestMapping(value = "/shippers/{shipper}", name = "ShippersItemThymeleafController", produces = MediaType.TEXT_HTML_VALUE)
public class ShippersItemThymeleafController implements ConcurrencyManager<Shipper> {

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    private final ConcurrencyTemplate<Shipper> concurrencyTemplate = new ConcurrencyTemplate<Shipper>(this);

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    private MethodLinkBuilderFactory<ShippersItemThymeleafController> itemLink;

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    private MessageSource messageSource;

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    private MethodLinkBuilderFactory<ShippersCollectionThymeleafController> collectionLink;

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    private ShipperService shipperService;

    /**
     * TODO Auto-generated constructor documentation
     *
     * @param shipperService
     * @param messageSource
     * @param linkBuilder
     */
    @Autowired
    public ShippersItemThymeleafController(ShipperService shipperService, MessageSource messageSource, ControllerMethodLinkBuilderFactory linkBuilder) {
        setShipperService(shipperService);
        setMessageSource(messageSource);
        setItemLink(linkBuilder.of(ShippersItemThymeleafController.class));
        setCollectionLink(linkBuilder.of(ShippersCollectionThymeleafController.class));
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @return ShipperService
     */
    public ShipperService getShipperService() {
        return shipperService;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param shipperService
     */
    public void setShipperService(ShipperService shipperService) {
        this.shipperService = shipperService;
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
    public MethodLinkBuilderFactory<ShippersItemThymeleafController> getItemLink() {
        return itemLink;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param itemLink
     */
    public void setItemLink(MethodLinkBuilderFactory<ShippersItemThymeleafController> itemLink) {
        this.itemLink = itemLink;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @return MethodLinkBuilderFactory
     */
    public MethodLinkBuilderFactory<ShippersCollectionThymeleafController> getCollectionLink() {
        return collectionLink;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param collectionLink
     */
    public void setCollectionLink(MethodLinkBuilderFactory<ShippersCollectionThymeleafController> collectionLink) {
        this.collectionLink = collectionLink;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param id
     * @param locale
     * @param method
     * @return Shipper
     */
    @ModelAttribute
    public Shipper getShipper(@PathVariable("shipper") Long id, Locale locale, HttpMethod method) {
        Shipper shipper = null;
        if (HttpMethod.PUT.equals(method)) {
            shipper = shipperService.findOneForUpdate(id);
        } else {
            shipper = shipperService.findOne(id);
        }
        if (shipper == null) {
            String message = messageSource.getMessage("error_NotFound", new Object[] { "Shipper", id }, "The record couldn't be found", locale);
            throw new NotFoundException(message);
        }
        return shipper;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param shipper
     * @param model
     * @return ModelAndView
     */
    @GetMapping(name = "show")
    public ModelAndView show(@ModelAttribute Shipper shipper, Model model) {
        model.addAttribute("shipper", shipper);
        return new ModelAndView("shippers/show");
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param shipper
     * @param model
     * @return ModelAndView
     */
    @GetMapping(value = "/inline", name = "showInline")
    public ModelAndView showInline(@ModelAttribute Shipper shipper, Model model) {
        model.addAttribute("shipper", shipper);
        return new ModelAndView("shippers/showInline :: inline-content");
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
    public ConcurrencyTemplate<Shipper> getConcurrencyTemplate() {
        return concurrencyTemplate;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @return String
     */
    public String getModelName() {
        return "shipper";
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @return String
     */
    public String getEditViewPath() {
        return "shippers/edit";
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param record
     * @return Integer
     */
    public Integer getLastVersion(Shipper record) {
        return getShipperService().findOne(record.getId()).getVersion();
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param entity
     * @param model
     * @return ModelAndView
     */
    public ModelAndView populateAndGetFormView(Shipper entity, Model model) {
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
    @InitBinder("shipper")
    public void initShipperBinder(WebDataBinder binder) {
        binder.setDisallowedFields("id");
        // Register validators
        GenericValidator validator = new GenericValidator(Shipper.class, getShipperService());
        binder.addValidators(validator);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param shipper
     * @param model
     * @return ModelAndView
     */
    @GetMapping(value = "/edit-form", name = "editForm")
    public ModelAndView editForm(@ModelAttribute Shipper shipper, Model model) {
        populateForm(model);
        model.addAttribute("shipper", shipper);
        return new ModelAndView("shippers/edit");
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param shipper
     * @param result
     * @param version
     * @param concurrencyControl
     * @param model
     * @return ModelAndView
     */
    @PutMapping(name = "update")
    public ModelAndView update(@Valid @ModelAttribute Shipper shipper, BindingResult result, @RequestParam("version") Integer version, @RequestParam(value = "concurrency", required = false, defaultValue = "") String concurrencyControl, Model model) {
        // Check if provided form contain errors
        if (result.hasErrors()) {
            populateForm(model);
            return new ModelAndView(getEditViewPath());
        }
        // Create Concurrency Spring Template to ensure that the following code will manage the
        // possible concurrency exceptions that appears and execute the provided coded inside the Spring template.
        // If some concurrency exception appears the template will manage it.
        Shipper savedShipper = getConcurrencyTemplate().execute(shipper, model, new ConcurrencyCallback<Shipper>() {

            @Override
            public Shipper doInConcurrency(Shipper shipper) throws Exception {
                return getShipperService().save(shipper);
            }
        });
        UriComponents showURI = getItemLink().to(ShippersItemThymeleafLinkFactory.SHOW).with("shipper", savedShipper.getId()).toUri();
        return new ModelAndView("redirect:" + showURI.toUriString());
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param shipper
     * @return ResponseEntity
     */
    @ResponseBody
    @DeleteMapping(name = "delete")
    public ResponseEntity<?> delete(@ModelAttribute Shipper shipper) {
        getShipperService().delete(shipper);
        return ResponseEntity.ok().build();
    }
}
