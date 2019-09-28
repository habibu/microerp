package com.habibu.application.web;
import com.habibu.model.SoldProduct;
import org.springframework.roo.addon.web.mvc.controller.annotations.ControllerType;
import org.springframework.roo.addon.web.mvc.controller.annotations.RooController;
import org.springframework.roo.addon.web.mvc.controller.annotations.responses.json.RooJSON;
import com.habibu.service.api.SoldProductService;
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
 * = SoldProductsItemJsonController
 *
 * TODO Auto-generated class documentation
 *
 */
@RooController(entity = SoldProduct.class, pathPrefix = "/api", type = ControllerType.ITEM)
@RooJSON
@RestController
@RequestMapping(value = "/api/soldproducts/{soldProduct}", name = "SoldProductsItemJsonController", produces = MediaType.APPLICATION_JSON_VALUE)
public class SoldProductsItemJsonController {

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    private SoldProductService soldProductService;

    /**
     * TODO Auto-generated constructor documentation
     *
     * @param soldProductService
     */
    @Autowired
    public SoldProductsItemJsonController(SoldProductService soldProductService) {
        this.soldProductService = soldProductService;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @return SoldProductService
     */
    public SoldProductService getSoldProductService() {
        return soldProductService;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param soldProductService
     */
    public void setSoldProductService(SoldProductService soldProductService) {
        this.soldProductService = soldProductService;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param id
     * @return SoldProduct
     */
    @ModelAttribute
    public SoldProduct getSoldProduct(@PathVariable("soldProduct") Long id) {
        SoldProduct soldProduct = soldProductService.findOne(id);
        if (soldProduct == null) {
            throw new NotFoundException(String.format("SoldProduct with identifier '%s' not found", id));
        }
        return soldProduct;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param soldProduct
     * @return ResponseEntity
     */
    @GetMapping(name = "show")
    public ResponseEntity<?> show(@ModelAttribute SoldProduct soldProduct) {
        return ResponseEntity.ok(soldProduct);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param soldProduct
     * @return UriComponents
     */
    public static UriComponents showURI(SoldProduct soldProduct) {
        return MvcUriComponentsBuilder.fromMethodCall(MvcUriComponentsBuilder.on(SoldProductsItemJsonController.class).show(soldProduct)).buildAndExpand(soldProduct.getId()).encode();
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param storedSoldProduct
     * @param soldProduct
     * @param result
     * @return ResponseEntity
     */
    @PutMapping(name = "update")
    public ResponseEntity<?> update(@ModelAttribute SoldProduct storedSoldProduct, @Valid @RequestBody SoldProduct soldProduct, BindingResult result) {
        if (result.hasErrors()) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(result);
        }
        soldProduct.setId(storedSoldProduct.getId());
        getSoldProductService().save(soldProduct);
        return ResponseEntity.ok().build();
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param soldProduct
     * @return ResponseEntity
     */
    @DeleteMapping(name = "delete")
    public ResponseEntity<?> delete(@ModelAttribute SoldProduct soldProduct) {
        getSoldProductService().delete(soldProduct);
        return ResponseEntity.ok().build();
    }
}
