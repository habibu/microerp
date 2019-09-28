package com.habibu.application.web;
import com.habibu.model.Shipper;
import org.springframework.roo.addon.web.mvc.controller.annotations.ControllerType;
import org.springframework.roo.addon.web.mvc.controller.annotations.RooController;
import org.springframework.roo.addon.web.mvc.controller.annotations.responses.json.RooJSON;
import com.habibu.service.api.ShipperService;
import io.springlets.web.NotFoundException;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;
import org.springframework.web.util.UriComponents;

/**
 * = ShippersItemJsonController
 *
 * TODO Auto-generated class documentation
 *
 */
@RooController(entity = Shipper.class, pathPrefix = "/api", type = ControllerType.ITEM)
@RooJSON
@RestController
@RequestMapping(value = "/api/shippers/{shipper}", name = "ShippersItemJsonController", produces = MediaType.APPLICATION_JSON_VALUE)
public class ShippersItemJsonController {

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    private ShipperService shipperService;

    /**
     * TODO Auto-generated constructor documentation
     *
     * @param shipperService
     */
    @Autowired
    public ShippersItemJsonController(ShipperService shipperService) {
        this.shipperService = shipperService;
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
     * @param id
     * @return Shipper
     */
    @ModelAttribute
    public Shipper getShipper(@PathVariable("shipper") Long id) {
        Shipper shipper = shipperService.findOne(id);
        if (shipper == null) {
            throw new NotFoundException(String.format("Shipper with identifier '%s' not found", id));
        }
        return shipper;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param shipper
     * @return ResponseEntity
     */
    @GetMapping(name = "show")
    public ResponseEntity<?> show(@ModelAttribute Shipper shipper) {
        return ResponseEntity.ok(shipper);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param shipper
     * @return UriComponents
     */
    public static UriComponents showURI(Shipper shipper) {
        return MvcUriComponentsBuilder.fromMethodCall(MvcUriComponentsBuilder.on(ShippersItemJsonController.class).show(shipper)).buildAndExpand(shipper.getId()).encode();
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param storedShipper
     * @param shipper
     * @param result
     * @return ResponseEntity
     */
    @PutMapping(name = "update")
    public ResponseEntity<?> update(@ModelAttribute Shipper storedShipper, @Valid @RequestBody Shipper shipper, BindingResult result) {
        if (result.hasErrors()) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(result);
        }
        shipper.setId(storedShipper.getId());
        getShipperService().save(shipper);
        return ResponseEntity.ok().build();
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param shipper
     * @return ResponseEntity
     */
    @DeleteMapping(name = "delete")
    public ResponseEntity<?> delete(@ModelAttribute Shipper shipper) {
        getShipperService().delete(shipper);
        return ResponseEntity.ok().build();
    }
}
