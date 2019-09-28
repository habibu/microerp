package com.habibu.application.web;
import com.habibu.model.Region;
import com.habibu.service.api.RegionService;
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
 * = RegionDeserializer
 *
 * TODO Auto-generated class documentation
 *
 */
@RooDeserializer(entity = Region.class)
@JsonComponent
public class RegionDeserializer extends JsonObjectDeserializer<Region> {

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    private RegionService regionService;

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    private ConversionService conversionService;

    /**
     * TODO Auto-generated constructor documentation
     *
     * @param regionService
     * @param conversionService
     */
    @Autowired
    public RegionDeserializer(@Lazy RegionService regionService, ConversionService conversionService) {
        this.regionService = regionService;
        this.conversionService = conversionService;
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
     * @return Region
     */
    public Region deserializeObject(JsonParser jsonParser, DeserializationContext context, ObjectCodec codec, JsonNode tree) {
        String idText = tree.asText();
        Long id = conversionService.convert(idText, Long.class);
        Region region = regionService.findOne(id);
        if (region == null) {
            throw new NotFoundException("Region not found");
        }
        return region;
    }
}
