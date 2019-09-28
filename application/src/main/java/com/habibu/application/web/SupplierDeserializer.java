package com.habibu.application.web;
import com.habibu.model.Supplier;
import com.habibu.service.api.SupplierService;
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
 * = SupplierDeserializer
 *
 * TODO Auto-generated class documentation
 *
 */
@RooDeserializer(entity = Supplier.class)
@JsonComponent
public class SupplierDeserializer extends JsonObjectDeserializer<Supplier> {

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    private SupplierService supplierService;

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    private ConversionService conversionService;

    /**
     * TODO Auto-generated constructor documentation
     *
     * @param supplierService
     * @param conversionService
     */
    @Autowired
    public SupplierDeserializer(@Lazy SupplierService supplierService, ConversionService conversionService) {
        this.supplierService = supplierService;
        this.conversionService = conversionService;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @return SupplierService
     */
    public SupplierService getSupplierService() {
        return supplierService;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param supplierService
     */
    public void setSupplierService(SupplierService supplierService) {
        this.supplierService = supplierService;
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
     * @return Supplier
     */
    public Supplier deserializeObject(JsonParser jsonParser, DeserializationContext context, ObjectCodec codec, JsonNode tree) {
        String idText = tree.asText();
        Long id = conversionService.convert(idText, Long.class);
        Supplier supplier = supplierService.findOne(id);
        if (supplier == null) {
            throw new NotFoundException("Supplier not found");
        }
        return supplier;
    }
}
