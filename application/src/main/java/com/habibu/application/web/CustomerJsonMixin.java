package com.habibu.application.web;
import com.habibu.model.Customer;
import org.springframework.roo.addon.web.mvc.controller.annotations.config.RooJsonMixin;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.habibu.model.CustomerOrder;
import java.util.Set;

/**
 * = CustomerJsonMixin
 *
 * TODO Auto-generated class documentation
 *
 */
@RooJsonMixin(entity = Customer.class)
public abstract class CustomerJsonMixin {

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    @JsonIgnore
    private Set<CustomerOrder> customerOrders;

    /**
     * TODO Auto-generated method documentation
     *
     * @return Set
     */
    public Set<CustomerOrder> getCustomerOrders() {
        return customerOrders;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param customerOrders
     */
    public void setCustomerOrders(Set<CustomerOrder> customerOrders) {
        this.customerOrders = customerOrders;
    }
}
