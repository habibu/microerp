package com.habibu.application.web;
import com.habibu.model.Country;
import org.springframework.roo.addon.web.mvc.controller.annotations.ControllerType;
import org.springframework.roo.addon.web.mvc.controller.annotations.RooController;
import org.springframework.roo.addon.web.mvc.controller.annotations.responses.json.RooJSON;
import com.habibu.service.api.CountryService;
import io.springlets.data.domain.GlobalSearch;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;
import org.springframework.web.util.UriComponents;

/**
 * = CountriesCollectionJsonController
 *
 * TODO Auto-generated class documentation
 *
 */
@RooController(entity = Country.class, pathPrefix = "/api", type = ControllerType.COLLECTION)
@RooJSON
@RestController
@RequestMapping(value = "/api/countries", name = "CountriesCollectionJsonController", produces = MediaType.APPLICATION_JSON_VALUE)
public class CountriesCollectionJsonController {

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    private CountryService countryService;

    /**
     * TODO Auto-generated constructor documentation
     *
     * @param countryService
     */
    @Autowired
    public CountriesCollectionJsonController(CountryService countryService) {
        this.countryService = countryService;
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
     * @param globalSearch
     * @param pageable
     * @return ResponseEntity
     */
    @GetMapping(name = "list")
    public ResponseEntity<Page<Country>> list(GlobalSearch globalSearch, Pageable pageable) {
        Page<Country> countries = getCountryService().findAll(globalSearch, pageable);
        return ResponseEntity.ok(countries);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @return UriComponents
     */
    public static UriComponents listURI() {
        return MvcUriComponentsBuilder.fromMethodCall(MvcUriComponentsBuilder.on(CountriesCollectionJsonController.class).list(null, null)).build().encode();
    }
}
