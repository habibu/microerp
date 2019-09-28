package com.habibu.application.web;
import com.habibu.model.Store;
import com.habibu.service.api.StoreService;
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
 * = StoreDeserializer
 *
 * TODO Auto-generated class documentation
 *
 */
@RooDeserializer(entity = Store.class)
@JsonComponent
public class StoreDeserializer extends JsonObjectDeserializer<Store> {

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    private StoreService storeService;

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    private ConversionService conversionService;

    /**
     * TODO Auto-generated constructor documentation
     *
     * @param storeService
     * @param conversionService
     */
    @Autowired
    public StoreDeserializer(@Lazy StoreService storeService, ConversionService conversionService) {
        this.storeService = storeService;
        this.conversionService = conversionService;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @return StoreService
     */
    public StoreService getStoreService() {
        return storeService;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param storeService
     */
    public void setStoreService(StoreService storeService) {
        this.storeService = storeService;
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
     * @return Store
     */
    public Store deserializeObject(JsonParser jsonParser, DeserializationContext context, ObjectCodec codec, JsonNode tree) {
        String idText = tree.asText();
        Long id = conversionService.convert(idText, Long.class);
        Store store = storeService.findOne(id);
        if (store == null) {
            throw new NotFoundException("Store not found");
        }
        return store;
    }
}
