package com.habibu.application.web;
import com.habibu.model.PurchaseOrder;
import org.springframework.roo.addon.web.mvc.controller.annotations.ControllerType;
import org.springframework.roo.addon.web.mvc.controller.annotations.RooController;
import org.springframework.roo.addon.web.mvc.controller.annotations.responses.json.RooJSON;
import com.habibu.service.api.PurchaseOrderService;
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
 * = PurchaseOrdersItemJsonController
 *
 * TODO Auto-generated class documentation
 *
 */
@RooController(entity = PurchaseOrder.class, pathPrefix = "/api", type = ControllerType.ITEM)
@RooJSON
@RestController
@RequestMapping(value = "/api/purchaseorders/{purchaseOrder}", name = "PurchaseOrdersItemJsonController", produces = MediaType.APPLICATION_JSON_VALUE)
public class PurchaseOrdersItemJsonController {

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    private PurchaseOrderService purchaseOrderService;

    /**
     * TODO Auto-generated constructor documentation
     *
     * @param purchaseOrderService
     */
    @Autowired
    public PurchaseOrdersItemJsonController(PurchaseOrderService purchaseOrderService) {
        this.purchaseOrderService = purchaseOrderService;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @return PurchaseOrderService
     */
    public PurchaseOrderService getPurchaseOrderService() {
        return purchaseOrderService;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param purchaseOrderService
     */
    public void setPurchaseOrderService(PurchaseOrderService purchaseOrderService) {
        this.purchaseOrderService = purchaseOrderService;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param id
     * @return PurchaseOrder
     */
    @ModelAttribute
    public PurchaseOrder getPurchaseOrder(@PathVariable("purchaseOrder") Long id) {
        PurchaseOrder purchaseOrder = purchaseOrderService.findOne(id);
        if (purchaseOrder == null) {
            throw new NotFoundException(String.format("PurchaseOrder with identifier '%s' not found", id));
        }
        return purchaseOrder;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param purchaseOrder
     * @return ResponseEntity
     */
    @GetMapping(name = "show")
    public ResponseEntity<?> show(@ModelAttribute PurchaseOrder purchaseOrder) {
        return ResponseEntity.ok(purchaseOrder);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param purchaseOrder
     * @return UriComponents
     */
    public static UriComponents showURI(PurchaseOrder purchaseOrder) {
        return MvcUriComponentsBuilder.fromMethodCall(MvcUriComponentsBuilder.on(PurchaseOrdersItemJsonController.class).show(purchaseOrder)).buildAndExpand(purchaseOrder.getId()).encode();
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param storedPurchaseOrder
     * @param purchaseOrder
     * @param result
     * @return ResponseEntity
     */
    @PutMapping(name = "update")
    public ResponseEntity<?> update(@ModelAttribute PurchaseOrder storedPurchaseOrder, @Valid @RequestBody PurchaseOrder purchaseOrder, BindingResult result) {
        if (result.hasErrors()) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(result);
        }
        purchaseOrder.setId(storedPurchaseOrder.getId());
        getPurchaseOrderService().save(purchaseOrder);
        return ResponseEntity.ok().build();
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param purchaseOrder
     * @return ResponseEntity
     */
    @DeleteMapping(name = "delete")
    public ResponseEntity<?> delete(@ModelAttribute PurchaseOrder purchaseOrder) {
        getPurchaseOrderService().delete(purchaseOrder);
        return ResponseEntity.ok().build();
    }
}
