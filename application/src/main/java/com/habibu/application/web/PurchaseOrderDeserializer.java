package com.habibu.application.web;
import com.habibu.model.PurchaseOrder;
import com.habibu.service.api.PurchaseOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jackson.JsonObjectDeserializer;
import org.springframework.context.annotation.Lazy;
import org.springframework.core.convert.ConversionService;
import org.springframework.roo.addon.web.mvc.controller.annotations.config.RooDeserializer;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import io.springlets.web.NotFoundException;
import org.springframework.boot.jackson.JsonComponent;

/**
 * = PurchaseOrderDeserializer
 *
 * TODO Auto-generated class documentation
 *
 */
@RooDeserializer(entity = PurchaseOrder.class)
@JsonComponent
public class PurchaseOrderDeserializer extends JsonObjectDeserializer<PurchaseOrder> {

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    private PurchaseOrderService purchaseOrderService;

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    private ConversionService conversionService;

    /**
     * TODO Auto-generated constructor documentation
     *
     * @param purchaseOrderService
     * @param conversionService
     */
    @Autowired
    public PurchaseOrderDeserializer(@Lazy PurchaseOrderService purchaseOrderService, ConversionService conversionService) {
        this.purchaseOrderService = purchaseOrderService;
        this.conversionService = conversionService;
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
     * @param jsonParser
     * @param context
     * @param codec
     * @param tree
     * @return PurchaseOrder
     */
    public PurchaseOrder deserializeObject(JsonParser jsonParser, DeserializationContext context, ObjectCodec codec, JsonNode tree) {
        String idText = tree.asText();
        Long id = conversionService.convert(idText, Long.class);
        PurchaseOrder purchaseOrder = purchaseOrderService.findOne(id);
        if (purchaseOrder == null) {
            throw new NotFoundException("PurchaseOrder not found");
        }
        return purchaseOrder;
    }
}
