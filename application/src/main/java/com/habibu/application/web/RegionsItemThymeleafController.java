package com.habibu.application.web;
import com.habibu.model.Region;
import io.springlets.web.mvc.util.concurrency.ConcurrencyManager;
import org.springframework.roo.addon.web.mvc.controller.annotations.ControllerType;
import org.springframework.roo.addon.web.mvc.controller.annotations.RooController;
import org.springframework.roo.addon.web.mvc.thymeleaf.annotations.RooThymeleaf;
import com.habibu.service.api.RegionService;
import io.springlets.web.NotFoundException;
import io.springlets.web.mvc.util.ControllerMethodLinkBuilderFactory;
import io.springlets.web.mvc.util.MethodLinkBuilderFactory;
import io.springlets.web.mvc.util.concurrency.ConcurrencyTemplate;
import java.util.Locale;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * = RegionsItemThymeleafController
 *
 * TODO Auto-generated class documentation
 *
 */
@RooController(entity = Region.class, type = ControllerType.ITEM)
@RooThymeleaf
@Controller
@RequestMapping(value = "/regions/{region}", name = "RegionsItemThymeleafController", produces = MediaType.TEXT_HTML_VALUE)
public class RegionsItemThymeleafController implements ConcurrencyManager<Region> {

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    private final ConcurrencyTemplate<Region> concurrencyTemplate = new ConcurrencyTemplate<Region>(this);

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    private MethodLinkBuilderFactory<RegionsItemThymeleafController> itemLink;

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    private MessageSource messageSource;

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    private RegionService regionService;

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    private MethodLinkBuilderFactory<RegionsCollectionThymeleafController> collectionLink;

    /**
     * TODO Auto-generated constructor documentation
     *
     * @param regionService
     * @param messageSource
     * @param linkBuilder
     */
    @Autowired
    public RegionsItemThymeleafController(RegionService regionService, MessageSource messageSource, ControllerMethodLinkBuilderFactory linkBuilder) {
        setRegionService(regionService);
        setMessageSource(messageSource);
        setItemLink(linkBuilder.of(RegionsItemThymeleafController.class));
        setCollectionLink(linkBuilder.of(RegionsCollectionThymeleafController.class));
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @return RegionService
     */
    public RegionService getRegionService() {
        return regionService;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param regionService
     */
    public void setRegionService(RegionService regionService) {
        this.regionService = regionService;
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
    public MethodLinkBuilderFactory<RegionsItemThymeleafController> getItemLink() {
        return itemLink;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param itemLink
     */
    public void setItemLink(MethodLinkBuilderFactory<RegionsItemThymeleafController> itemLink) {
        this.itemLink = itemLink;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @return MethodLinkBuilderFactory
     */
    public MethodLinkBuilderFactory<RegionsCollectionThymeleafController> getCollectionLink() {
        return collectionLink;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param collectionLink
     */
    public void setCollectionLink(MethodLinkBuilderFactory<RegionsCollectionThymeleafController> collectionLink) {
        this.collectionLink = collectionLink;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param id
     * @param locale
     * @param method
     * @return Region
     */
    @ModelAttribute
    public Region getRegion(@PathVariable("region") Long id, Locale locale, HttpMethod method) {
        Region region = regionService.findOne(id);
        if (region == null) {
            String message = messageSource.getMessage("error_NotFound", new Object[] { "Region", id }, "The record couldn't be found", locale);
            throw new NotFoundException(message);
        }
        return region;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param region
     * @param model
     * @return ModelAndView
     */
    @GetMapping(name = "show")
    public ModelAndView show(@ModelAttribute Region region, Model model) {
        model.addAttribute("region", region);
        return new ModelAndView("regions/show");
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param region
     * @param model
     * @return ModelAndView
     */
    @GetMapping(value = "/inline", name = "showInline")
    public ModelAndView showInline(@ModelAttribute Region region, Model model) {
        model.addAttribute("region", region);
        return new ModelAndView("regions/showInline :: inline-content");
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
    public ConcurrencyTemplate<Region> getConcurrencyTemplate() {
        return concurrencyTemplate;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @return String
     */
    public String getModelName() {
        return "region";
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @return String
     */
    public String getEditViewPath() {
        return "regions/edit";
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param record
     * @return Integer
     */
    public Integer getLastVersion(Region record) {
        return getRegionService().findOne(record.getId()).getVersion();
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param entity
     * @param model
     * @return ModelAndView
     */
    public ModelAndView populateAndGetFormView(Region entity, Model model) {
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
}
