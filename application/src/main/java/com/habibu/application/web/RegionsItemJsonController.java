package com.habibu.application.web;
import com.habibu.model.Region;
import org.springframework.roo.addon.web.mvc.controller.annotations.ControllerType;
import org.springframework.roo.addon.web.mvc.controller.annotations.RooController;
import org.springframework.roo.addon.web.mvc.controller.annotations.responses.json.RooJSON;
import com.habibu.service.api.RegionService;
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
 * = RegionsItemJsonController
 *
 * TODO Auto-generated class documentation
 *
 */
@RooController(entity = Region.class, pathPrefix = "/api", type = ControllerType.ITEM)
@RooJSON
@RestController
@RequestMapping(value = "/api/regions/{region}", name = "RegionsItemJsonController", produces = MediaType.APPLICATION_JSON_VALUE)
public class RegionsItemJsonController {

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    private RegionService regionService;

    /**
     * TODO Auto-generated constructor documentation
     *
     * @param regionService
     */
    @Autowired
    public RegionsItemJsonController(RegionService regionService) {
        this.regionService = regionService;
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
     * @param id
     * @return Region
     */
    @ModelAttribute
    public Region getRegion(@PathVariable("region") Long id) {
        Region region = regionService.findOne(id);
        if (region == null) {
            throw new NotFoundException(String.format("Region with identifier '%s' not found", id));
        }
        return region;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param region
     * @return ResponseEntity
     */
    @GetMapping(name = "show")
    public ResponseEntity<?> show(@ModelAttribute Region region) {
        return ResponseEntity.ok(region);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param region
     * @return UriComponents
     */
    public static UriComponents showURI(Region region) {
        return MvcUriComponentsBuilder.fromMethodCall(MvcUriComponentsBuilder.on(RegionsItemJsonController.class).show(region)).buildAndExpand(region.getId()).encode();
    }
}
