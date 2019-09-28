package com.habibu.application.web;
import com.habibu.model.Customer;
import com.habibu.service.api.CustomerService;
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
 * = CustomerDeserializer
 *
 * TODO Auto-generated class documentation
 *
 */
@RooDeserializer(entity = Customer.class)
@JsonComponent
public class CustomerDeserializer extends JsonObjectDeserializer<Customer> {

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    private CustomerService customerService;

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    private ConversionService conversionService;

    /**
     * TODO Auto-generated constructor documentation
     *
     * @param customerService
     * @param conversionService
     */
    @Autowired
    public CustomerDeserializer(@Lazy CustomerService customerService, ConversionService conversionService) {
        this.customerService = customerService;
        this.conversionService = conversionService;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @return CustomerService
     */
    public CustomerService getCustomerService() {
        return customerService;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param customerService
     */
    public void setCustomerService(CustomerService customerService) {
        this.customerService = customerService;
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
     * @return Customer
     */
    public Customer deserializeObject(JsonParser jsonParser, DeserializationContext context, ObjectCodec codec, JsonNode tree) {
        String idText = tree.asText();
        Long id = conversionService.convert(idText, Long.class);
        Customer customer = customerService.findOne(id);
        if (customer == null) {
            throw new NotFoundException("Customer not found");
        }
        return customer;
    }
}
