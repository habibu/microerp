package com.habibu.application.web;
import com.habibu.model.PurchaseOrder;
import io.springlets.web.mvc.util.concurrency.ConcurrencyManager;
import org.springframework.roo.addon.web.mvc.controller.annotations.ControllerType;
import org.springframework.roo.addon.web.mvc.controller.annotations.RooController;
import org.springframework.roo.addon.web.mvc.thymeleaf.annotations.RooThymeleaf;
import com.habibu.service.api.PurchaseOrderService;
import io.springlets.data.web.validation.GenericValidator;
import io.springlets.web.NotFoundException;
import io.springlets.web.mvc.util.ControllerMethodLinkBuilderFactory;
import io.springlets.web.mvc.util.MethodLinkBuilderFactory;
import io.springlets.web.mvc.util.concurrency.ConcurrencyCallback;
import io.springlets.web.mvc.util.concurrency.ConcurrencyTemplate;
import java.util.Locale;
import javax.validation.Valid;
import org.joda.time.format.DateTimeFormat;
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
 * = PurchaseOrdersItemThymeleafController
 *
 * TODO Auto-generated class documentation
 *
 */
@RooController(entity = PurchaseOrder.class, type = ControllerType.ITEM)
@RooThymeleaf
@Controller
@RequestMapping(value = "/purchaseorders/{purchaseOrder}", name = "PurchaseOrdersItemThymeleafController", produces = MediaType.TEXT_HTML_VALUE)
public class PurchaseOrdersItemThymeleafController implements ConcurrencyManager<PurchaseOrder> {

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    private PurchaseOrderService purchaseOrderService;

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    private final ConcurrencyTemplate<PurchaseOrder> concurrencyTemplate = new ConcurrencyTemplate<PurchaseOrder>(this);

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    private MethodLinkBuilderFactory<PurchaseOrdersItemThymeleafController> itemLink;

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    private MessageSource messageSource;

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    private MethodLinkBuilderFactory<PurchaseOrdersCollectionThymeleafController> collectionLink;

    /**
     * TODO Auto-generated constructor documentation
     *
     * @param purchaseOrderService
     * @param messageSource
     * @param linkBuilder
     */
    @Autowired
    public PurchaseOrdersItemThymeleafController(PurchaseOrderService purchaseOrderService, MessageSource messageSource, ControllerMethodLinkBuilderFactory linkBuilder) {
        setPurchaseOrderService(purchaseOrderService);
        setMessageSource(messageSource);
        setItemLink(linkBuilder.of(PurchaseOrdersItemThymeleafController.class));
        setCollectionLink(linkBuilder.of(PurchaseOrdersCollectionThymeleafController.class));
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @return PurchaseOrderService
     */
    public PurchaseOrderService getPurchaseOrderService() {
        return purchaseOrderService;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param purchaseOrderService
     */
    public void setPurchaseOrderService(PurchaseOrderService purchaseOrderService) {
        this.purchaseOrderService = purchaseOrderService;
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
    public MethodLinkBuilderFactory<PurchaseOrdersItemThymeleafController> getItemLink() {
        return itemLink;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param itemLink
     */
    public void setItemLink(MethodLinkBuilderFactory<PurchaseOrdersItemThymeleafController> itemLink) {
        this.itemLink = itemLink;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @return MethodLinkBuilderFactory
     */
    public MethodLinkBuilderFactory<PurchaseOrdersCollectionThymeleafController> getCollectionLink() {
        return collectionLink;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param collectionLink
     */
    public void setCollectionLink(MethodLinkBuilderFactory<PurchaseOrdersCollectionThymeleafController> collectionLink) {
        this.collectionLink = collectionLink;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param id
     * @param locale
     * @param method
     * @return PurchaseOrder
     */
    @ModelAttribute
    public PurchaseOrder getPurchaseOrder(@PathVariable("purchaseOrder") Long id, Locale locale, HttpMethod method) {
        PurchaseOrder purchaseOrder = null;
        if (HttpMethod.PUT.equals(method)) {
            purchaseOrder = purchaseOrderService.findOneForUpdate(id);
        } else {
            purchaseOrder = purchaseOrderService.findOne(id);
        }
        if (purchaseOrder == null) {
            String message = messageSource.getMessage("error_NotFound", new Object[] { "PurchaseOrder", id }, "The record couldn't be found", locale);
            throw new NotFoundException(message);
        }
        return purchaseOrder;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param purchaseOrder
     * @param model
     * @return ModelAndView
     */
    @GetMapping(name = "show")
    public ModelAndView show(@ModelAttribute PurchaseOrder purchaseOrder, Model model) {
        model.addAttribute("purchaseOrder", purchaseOrder);
        return new ModelAndView("purchaseorders/show");
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param purchaseOrder
     * @param model
     * @return ModelAndView
     */
    @GetMapping(value = "/inline", name = "showInline")
    public ModelAndView showInline(@ModelAttribute PurchaseOrder purchaseOrder, Model model) {
        model.addAttribute("purchaseOrder", purchaseOrder);
        return new ModelAndView("purchaseorders/showInline :: inline-content");
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param model
     */
    public void populateFormats(Model model) {
        model.addAttribute("application_locale", LocaleContextHolder.getLocale().getLanguage());
        model.addAttribute("orderDate_date_format", DateTimeFormat.patternForStyle("M-", LocaleContextHolder.getLocale()));
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
    public ConcurrencyTemplate<PurchaseOrder> getConcurrencyTemplate() {
        return concurrencyTemplate;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @return String
     */
    public String getModelName() {
        return "purchaseOrder";
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @return String
     */
    public String getEditViewPath() {
        return "purchaseorders/edit";
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param record
     * @return Integer
     */
    public Integer getLastVersion(PurchaseOrder record) {
        return getPurchaseOrderService().findOne(record.getId()).getVersion();
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param entity
     * @param model
     * @return ModelAndView
     */
    public ModelAndView populateAndGetFormView(PurchaseOrder entity, Model model) {
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
    @InitBinder("purchaseOrder")
    public void initPurchaseOrderBinder(WebDataBinder binder) {
        binder.setDisallowedFields("id");
        // Register validators
        GenericValidator validator = new GenericValidator(PurchaseOrder.class, getPurchaseOrderService());
        binder.addValidators(validator);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param purchaseOrder
     * @param model
     * @return ModelAndView
     */
    @GetMapping(value = "/edit-form", name = "editForm")
    public ModelAndView editForm(@ModelAttribute PurchaseOrder purchaseOrder, Model model) {
        populateForm(model);
        model.addAttribute("purchaseOrder", purchaseOrder);
        return new ModelAndView("purchaseorders/edit");
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param purchaseOrder
     * @param result
     * @param version
     * @param concurrencyControl
     * @param model
     * @return ModelAndView
     */
    @PutMapping(name = "update")
    public ModelAndView update(@Valid @ModelAttribute PurchaseOrder purchaseOrder, BindingResult result, @RequestParam("version") Integer version, @RequestParam(value = "concurrency", required = false, defaultValue = "") String concurrencyControl, Model model) {
        // Check if provided form contain errors
        if (result.hasErrors()) {
            populateForm(model);
            return new ModelAndView(getEditViewPath());
        }
        // Create Concurrency Spring Template to ensure that the following code will manage the
        // possible concurrency exceptions that appears and execute the provided coded inside the Spring template.
        // If some concurrency exception appears the template will manage it.
        PurchaseOrder savedPurchaseOrder = getConcurrencyTemplate().execute(purchaseOrder, model, new ConcurrencyCallback<PurchaseOrder>() {

            @Override
            public PurchaseOrder doInConcurrency(PurchaseOrder purchaseOrder) throws Exception {
                return getPurchaseOrderService().save(purchaseOrder);
            }
        });
        UriComponents showURI = getItemLink().to(PurchaseOrdersItemThymeleafLinkFactory.SHOW).with("purchaseOrder", savedPurchaseOrder.getId()).toUri();
        return new ModelAndView("redirect:" + showURI.toUriString());
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param purchaseOrder
     * @return ResponseEntity
     */
    @ResponseBody
    @DeleteMapping(name = "delete")
    public ResponseEntity<?> delete(@ModelAttribute PurchaseOrder purchaseOrder) {
        getPurchaseOrderService().delete(purchaseOrder);
        return ResponseEntity.ok().build();
    }
}
