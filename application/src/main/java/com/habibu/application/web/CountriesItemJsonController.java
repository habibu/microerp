package com.habibu.application.web;
import com.habibu.model.Country;
import org.springframework.roo.addon.web.mvc.controller.annotations.ControllerType;
import org.springframework.roo.addon.web.mvc.controller.annotations.RooController;
import org.springframework.roo.addon.web.mvc.controller.annotations.responses.json.RooJSON;
import com.habibu.service.api.CountryService;
import io.springlets.web.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;
import org.springframework.web.util.UriComponents;

/**
 * = CountriesItemJsonController
 *
 * TODO Auto-generated class documentation
 *
 */
@RooController(entity = Country.class, pathPrefix = "/api", type = ControllerType.ITEM)
@RooJSON
@RestController
@RequestMapping(value = "/api/countries/{country}", name = "CountriesItemJsonController", produces = MediaType.APPLICATION_JSON_VALUE)
public class CountriesItemJsonController {

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
    public CountriesItemJsonController(CountryService countryService) {
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
     * @param id
     * @return Country
     */
    @ModelAttribute
    public Country getCountry(@PathVariable("country") Long id) {
        Country country = countryService.findOne(id);
        if (country == null) {
            throw new NotFoundException(String.format("Country with identifier '%s' not found", id));
        }
        return country;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param country
     * @return ResponseEntity
     */
    @GetMapping(name = "show")
    public ResponseEntity<?> show(@ModelAttribute Country country) {
        return ResponseEntity.ok(country);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param country
     * @return UriComponents
     */
    public static UriComponents showURI(Country country) {
        return MvcUriComponentsBuilder.fromMethodCall(MvcUriComponentsBuilder.on(CountriesItemJsonController.class).show(country)).buildAndExpand(country.getId()).encode();
    }
}
