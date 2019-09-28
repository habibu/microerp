package com.habibu.application.web;
import com.habibu.model.City;
import org.springframework.roo.addon.web.mvc.controller.annotations.ControllerType;
import org.springframework.roo.addon.web.mvc.controller.annotations.RooController;
import org.springframework.roo.addon.web.mvc.controller.annotations.responses.json.RooJSON;
import com.habibu.service.api.CityService;
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
 * = CitiesItemJsonController
 *
 * TODO Auto-generated class documentation
 *
 */
@RooController(entity = City.class, pathPrefix = "/api", type = ControllerType.ITEM)
@RooJSON
@RestController
@RequestMapping(value = "/api/cities/{city}", name = "CitiesItemJsonController", produces = MediaType.APPLICATION_JSON_VALUE)
public class CitiesItemJsonController {

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    private CityService cityService;

    /**
     * TODO Auto-generated constructor documentation
     *
     * @param cityService
     */
    @Autowired
    public CitiesItemJsonController(CityService cityService) {
        this.cityService = cityService;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @return CityService
     */
    public CityService getCityService() {
        return cityService;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param cityService
     */
    public void setCityService(CityService cityService) {
        this.cityService = cityService;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param id
     * @return City
     */
    @ModelAttribute
    public City getCity(@PathVariable("city") Long id) {
        City city = cityService.findOne(id);
        if (city == null) {
            throw new NotFoundException(String.format("City with identifier '%s' not found", id));
        }
        return city;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param city
     * @return ResponseEntity
     */
    @GetMapping(name = "show")
    public ResponseEntity<?> show(@ModelAttribute City city) {
        return ResponseEntity.ok(city);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param city
     * @return UriComponents
     */
    public static UriComponents showURI(City city) {
        return MvcUriComponentsBuilder.fromMethodCall(MvcUriComponentsBuilder.on(CitiesItemJsonController.class).show(city)).buildAndExpand(city.getId()).encode();
    }
}
