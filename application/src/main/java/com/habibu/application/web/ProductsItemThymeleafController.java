package com.habibu.application.web;
import com.habibu.model.Product;
import io.springlets.web.mvc.util.concurrency.ConcurrencyManager;
import org.springframework.roo.addon.web.mvc.controller.annotations.ControllerType;
import org.springframework.roo.addon.web.mvc.controller.annotations.RooController;
import org.springframework.roo.addon.web.mvc.thymeleaf.annotations.RooThymeleaf;
import com.habibu.service.api.ProductService;
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
 * = ProductsItemThymeleafController
 *
 * TODO Auto-generated class documentation
 *
 */
@RooController(entity = Product.class, type = ControllerType.ITEM)
@RooThymeleaf
@Controller
@RequestMapping(value = "/products/{product}", name = "ProductsItemThymeleafController", produces = MediaType.TEXT_HTML_VALUE)
public class ProductsItemThymeleafController implements ConcurrencyManager<Product> {

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    private final ConcurrencyTemplate<Product> concurrencyTemplate = new ConcurrencyTemplate<Product>(this);

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    private MethodLinkBuilderFactory<ProductsItemThymeleafController> itemLink;

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    private MessageSource messageSource;

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    private MethodLinkBuilderFactory<ProductsCollectionThymeleafController> collectionLink;

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    private ProductService productService;

    /**
     * TODO Auto-generated constructor documentation
     *
     * @param productService
     * @param messageSource
     * @param linkBuilder
     */
    @Autowired
    public ProductsItemThymeleafController(ProductService productService, MessageSource messageSource, ControllerMethodLinkBuilderFactory linkBuilder) {
        setProductService(productService);
        setMessageSource(messageSource);
        setItemLink(linkBuilder.of(ProductsItemThymeleafController.class));
        setCollectionLink(linkBuilder.of(ProductsCollectionThymeleafController.class));
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @return ProductService
     */
    public ProductService getProductService() {
        return productService;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param productService
     */
    public void setProductService(ProductService productService) {
        this.productService = productService;
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
    public MethodLinkBuilderFactory<ProductsItemThymeleafController> getItemLink() {
        return itemLink;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param itemLink
     */
    public void setItemLink(MethodLinkBuilderFactory<ProductsItemThymeleafController> itemLink) {
        this.itemLink = itemLink;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @return MethodLinkBuilderFactory
     */
    public MethodLinkBuilderFactory<ProductsCollectionThymeleafController> getCollectionLink() {
        return collectionLink;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param collectionLink
     */
    public void setCollectionLink(MethodLinkBuilderFactory<ProductsCollectionThymeleafController> collectionLink) {
        this.collectionLink = collectionLink;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param id
     * @param locale
     * @param method
     * @return Product
     */
    @ModelAttribute
    public Product getProduct(@PathVariable("product") Long id, Locale locale, HttpMethod method) {
        Product product = null;
        if (HttpMethod.PUT.equals(method)) {
            product = productService.findOneForUpdate(id);
        } else {
            product = productService.findOne(id);
        }
        if (product == null) {
            String message = messageSource.getMessage("error_NotFound", new Object[] { "Product", id }, "The record couldn't be found", locale);
            throw new NotFoundException(message);
        }
        return product;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param product
     * @param model
     * @return ModelAndView
     */
    @GetMapping(name = "show")
    public ModelAndView show(@ModelAttribute Product product, Model model) {
        model.addAttribute("product", product);
        return new ModelAndView("products/show");
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param product
     * @param model
     * @return ModelAndView
     */
    @GetMapping(value = "/inline", name = "showInline")
    public ModelAndView showInline(@ModelAttribute Product product, Model model) {
        model.addAttribute("product", product);
        return new ModelAndView("products/showInline :: inline-content");
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
    public ConcurrencyTemplate<Product> getConcurrencyTemplate() {
        return concurrencyTemplate;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @return String
     */
    public String getModelName() {
        return "product";
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @return String
     */
    public String getEditViewPath() {
        return "products/edit";
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param record
     * @return Integer
     */
    public Integer getLastVersion(Product record) {
        return getProductService().findOne(record.getId()).getVersion();
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param entity
     * @param model
     * @return ModelAndView
     */
    public ModelAndView populateAndGetFormView(Product entity, Model model) {
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
    @InitBinder("product")
    public void initProductBinder(WebDataBinder binder) {
        binder.setDisallowedFields("id");
        // Register validators
        GenericValidator validator = new GenericValidator(Product.class, getProductService());
        binder.addValidators(validator);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param product
     * @param model
     * @return ModelAndView
     */
    @GetMapping(value = "/edit-form", name = "editForm")
    public ModelAndView editForm(@ModelAttribute Product product, Model model) {
        populateForm(model);
        model.addAttribute("product", product);
        return new ModelAndView("products/edit");
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param product
     * @param result
     * @param version
     * @param concurrencyControl
     * @param model
     * @return ModelAndView
     */
    @PutMapping(name = "update")
    public ModelAndView update(@Valid @ModelAttribute Product product, BindingResult result, @RequestParam("version") Integer version, @RequestParam(value = "concurrency", required = false, defaultValue = "") String concurrencyControl, Model model) {
        // Check if provided form contain errors
        if (result.hasErrors()) {
            populateForm(model);
            return new ModelAndView(getEditViewPath());
        }
        // Create Concurrency Spring Template to ensure that the following code will manage the
        // possible concurrency exceptions that appears and execute the provided coded inside the Spring template.
        // If some concurrency exception appears the template will manage it.
        Product savedProduct = getConcurrencyTemplate().execute(product, model, new ConcurrencyCallback<Product>() {

            @Override
            public Product doInConcurrency(Product product) throws Exception {
                return getProductService().save(product);
            }
        });
        UriComponents showURI = getItemLink().to(ProductsItemThymeleafLinkFactory.SHOW).with("product", savedProduct.getId()).toUri();
        return new ModelAndView("redirect:" + showURI.toUriString());
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param product
     * @return ResponseEntity
     */
    @ResponseBody
    @DeleteMapping(name = "delete")
    public ResponseEntity<?> delete(@ModelAttribute Product product) {
        getProductService().delete(product);
        return ResponseEntity.ok().build();
    }
}
