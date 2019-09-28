package com.habibu.application.web;
import com.habibu.model.OrderDetail;
import org.springframework.roo.addon.web.mvc.controller.annotations.config.RooJsonMixin;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.habibu.model.CustomerOrder;
import com.habibu.model.Product;

/**
 * = OrderDetailJsonMixin
 *
 * TODO Auto-generated class documentation
 *
 */
@RooJsonMixin(entity = OrderDetail.class)
public abstract class OrderDetailJsonMixin {

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    @JsonDeserialize(using = ProductDeserializer.class)
    private Product product;

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    @JsonDeserialize(using = CustomerOrderDeserializer.class)
    private CustomerOrder customerOrder;

    /**
     * TODO Auto-generated method documentation
     *
     * @return CustomerOrder
     */
    public CustomerOrder getCustomerOrder() {
        return customerOrder;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param customerOrder
     */
    public void setCustomerOrder(CustomerOrder customerOrder) {
        this.customerOrder = customerOrder;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @return Product
     */
    public Product getProduct() {
        return product;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param product
     */
    public void setProduct(Product product) {
        this.product = product;
    }
}
