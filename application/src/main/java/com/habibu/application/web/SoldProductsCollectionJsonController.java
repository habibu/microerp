package com.habibu.application.web;
import com.habibu.model.SoldProduct;
import org.springframework.roo.addon.web.mvc.controller.annotations.ControllerType;
import org.springframework.roo.addon.web.mvc.controller.annotations.RooController;
import org.springframework.roo.addon.web.mvc.controller.annotations.responses.json.RooJSON;
import com.habibu.service.api.SoldProductService;
import io.springlets.data.domain.GlobalSearch;
import java.util.Collection;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;
import org.springframework.web.util.UriComponents;

/**
 * = SoldProductsCollectionJsonController
 *
 * TODO Auto-generated class documentation
 *
 */
@RooController(entity = SoldProduct.class, pathPrefix = "/api", type = ControllerType.COLLECTION)
@RooJSON
@RestController
@RequestMapping(value = "/api/soldproducts", name = "SoldProductsCollectionJsonController", produces = MediaType.APPLICATION_JSON_VALUE)
public class SoldProductsCollectionJsonController {

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
    public SoldProductsCollectionJsonController(SoldProductService soldProductService) {
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
     * @param globalSearch
     * @param pageable
     * @return ResponseEntity
     */
    @GetMapping(name = "list")
    public ResponseEntity<Page<SoldProduct>> list(GlobalSearch globalSearch, Pageable pageable) {
        Page<SoldProduct> soldProducts = getSoldProductService().findAll(globalSearch, pageable);
        return ResponseEntity.ok(soldProducts);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @return UriComponents
     */
    public static UriComponents listURI() {
        return MvcUriComponentsBuilder.fromMethodCall(MvcUriComponentsBuilder.on(SoldProductsCollectionJsonController.class).list(null, null)).build().encode();
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param soldProduct
     * @param result
     * @return ResponseEntity
     */
    @PostMapping(name = "create")
    public ResponseEntity<?> create(@Valid @RequestBody SoldProduct soldProduct, BindingResult result) {
        if (soldProduct.getId() != null || soldProduct.getVersion() != null) {
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }
        if (result.hasErrors()) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(result);
        }
        SoldProduct newSoldProduct = getSoldProductService().save(soldProduct);
        UriComponents showURI = SoldProductsItemJsonController.showURI(newSoldProduct);
        return ResponseEntity.created(showURI.toUri()).build();
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param soldProducts
     * @param result
     * @return ResponseEntity
     */
    @PostMapping(value = "/batch", name = "createBatch")
    public ResponseEntity<?> createBatch(@Valid @RequestBody Collection<SoldProduct> soldProducts, BindingResult result) {
        if (result.hasErrors()) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(result);
        }
        getSoldProductService().save(soldProducts);
        return ResponseEntity.created(listURI().toUri()).build();
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param soldProducts
     * @param result
     * @return ResponseEntity
     */
    @PutMapping(value = "/batch", name = "updateBatch")
    public ResponseEntity<?> updateBatch(@Valid @RequestBody Collection<SoldProduct> soldProducts, BindingResult result) {
        if (result.hasErrors()) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(result);
        }
        getSoldProductService().save(soldProducts);
        return ResponseEntity.ok().build();
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param ids
     * @return ResponseEntity
     */
    @DeleteMapping(value = "/batch/{ids}", name = "deleteBatch")
    public ResponseEntity<?> deleteBatch(@PathVariable("ids") Collection<Long> ids) {
        getSoldProductService().delete(ids);
        return ResponseEntity.ok().build();
    }
}
