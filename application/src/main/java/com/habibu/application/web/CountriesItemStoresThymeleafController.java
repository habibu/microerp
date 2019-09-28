package com.habibu.application.web;
import com.habibu.model.Country;
import org.springframework.roo.addon.web.mvc.controller.annotations.ControllerType;
import org.springframework.roo.addon.web.mvc.controller.annotations.RooController;
import org.springframework.roo.addon.web.mvc.controller.annotations.RooDetail;
import org.springframework.roo.addon.web.mvc.thymeleaf.annotations.RooThymeleaf;
import com.habibu.model.Store;
import com.habibu.service.api.CountryService;
import com.habibu.service.api.StoreService;
import io.springlets.data.domain.GlobalSearch;
import io.springlets.data.web.datatables.ConvertedDatatablesData;
import io.springlets.data.web.datatables.Datatables;
import io.springlets.data.web.datatables.DatatablesColumns;
import io.springlets.data.web.datatables.DatatablesPageable;
import io.springlets.web.NotFoundException;
import io.springlets.web.mvc.util.ControllerMethodLinkBuilderFactory;
import io.springlets.web.mvc.util.MethodLinkBuilderFactory;
import java.util.List;
import java.util.Locale;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.core.convert.ConversionService;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 * = CountriesItemStoresThymeleafController
 *
 * TODO Auto-generated class documentation
 *
 */
@RooController(entity = Country.class, type = ControllerType.DETAIL)
@RooDetail(relationField = "stores", views = { "list" })
@RooThymeleaf
@Controller
@RequestMapping(value = "/countries/{country}/stores", name = "CountriesItemStoresThymeleafController", produces = MediaType.TEXT_HTML_VALUE)
public class CountriesItemStoresThymeleafController {

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    private StoreService storeService;

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    private MessageSource messageSource;

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    private CountryService countryService;

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    private ConversionService conversionService;

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    private MethodLinkBuilderFactory<CountriesCollectionThymeleafController> collectionLink;

    /**
     * TODO Auto-generated constructor documentation
     *
     * @param countryService
     * @param storeService
     * @param conversionService
     * @param messageSource
     * @param linkBuilder
     */
    @Autowired
    public CountriesItemStoresThymeleafController(CountryService countryService, StoreService storeService, ConversionService conversionService, MessageSource messageSource, ControllerMethodLinkBuilderFactory linkBuilder) {
        setCountryService(countryService);
        setStoreService(storeService);
        setConversionService(conversionService);
        setMessageSource(messageSource);
        setCollectionLink(linkBuilder.of(CountriesCollectionThymeleafController.class));
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @return CountryService
     */
    public CountryService getCountryService() {
        return countryService;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param countryService
     */
    public void setCountryService(CountryService countryService) {
        this.countryService = countryService;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @return StoreService
     */
    public StoreService getStoreService() {
        return storeService;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param storeService
     */
    public void setStoreService(StoreService storeService) {
        this.storeService = storeService;
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
    public MethodLinkBuilderFactory<CountriesCollectionThymeleafController> getCollectionLink() {
        return collectionLink;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param collectionLink
     */
    public void setCollectionLink(MethodLinkBuilderFactory<CountriesCollectionThymeleafController> collectionLink) {
        this.collectionLink = collectionLink;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @return ConversionService
     */
    public ConversionService getConversionService() {
        return conversionService;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param conversionService
     */
    public void setConversionService(ConversionService conversionService) {
        this.conversionService = conversionService;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param id
     * @param locale
     * @param method
     * @return Country
     */
    @ModelAttribute
    public Country getCountry(@PathVariable("country") Long id, Locale locale, HttpMethod method) {
        Country country = countryService.findOne(id);
        if (country == null) {
            String message = messageSource.getMessage("error_NotFound", new Object[] { "Country", id }, "The record couldn't be found", locale);
            throw new NotFoundException(message);
        }
        return country;
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
     * @param country
     * @param datatablesColumns
     * @param search
     * @param pageable
     * @param draw
     * @return ResponseEntity
     */
    @GetMapping(name = "datatables", produces = Datatables.MEDIA_TYPE, value = "/dt")
    @ResponseBody
    public ResponseEntity<ConvertedDatatablesData<Store>> datatables(@ModelAttribute Country country, DatatablesColumns datatablesColumns, GlobalSearch search, DatatablesPageable pageable, @RequestParam("draw") Integer draw) {
        Page<Store> stores = getStoreService().findByCountry(country, search, pageable);
        long totalStoresCount = getStoreService().countByCountry(country);
        ConvertedDatatablesData<Store> data = new ConvertedDatatablesData<Store>(stores, totalStoresCount, draw, getConversionService(), datatablesColumns);
        return ResponseEntity.ok(data);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param ids
     * @param datatablesColumns
     * @param search
     * @param pageable
     * @param draw
     * @return ResponseEntity
     */
    @GetMapping(name = "datatablesByIdsIn", produces = Datatables.MEDIA_TYPE, value = "/dtByIdsIn")
    @ResponseBody
    public ResponseEntity<ConvertedDatatablesData<Store>> datatablesByIdsIn(@RequestParam("ids") List<Long> ids, DatatablesColumns datatablesColumns, GlobalSearch search, DatatablesPageable pageable, @RequestParam("draw") Integer draw) {
        Page<Store> stores = getStoreService().findAllByIdsIn(ids, search, pageable);
        long totalStoresCount = stores.getTotalElements();
        ConvertedDatatablesData<Store> data = new ConvertedDatatablesData<Store>(stores, totalStoresCount, draw, getConversionService(), datatablesColumns);
        return ResponseEntity.ok(data);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param country
     * @param model
     * @return ModelAndView
     */
    @GetMapping(value = "/create-form", name = "createForm")
    public ModelAndView createForm(@ModelAttribute Country country, Model model) {
        populateForm(model);
        model.addAttribute("store", new Store());
        return new ModelAndView("countries/stores/create");
    }
}
