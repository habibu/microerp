package com.habibu.application.web;
import com.habibu.model.Country;
import org.springframework.roo.addon.web.mvc.controller.annotations.config.RooJsonMixin;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.habibu.model.CustomerOrder;
import com.habibu.model.Party;
import com.habibu.model.Region;
import com.habibu.model.Store;
import com.habibu.model.Supplier;
import java.util.Set;

/**
 * = CountryJsonMixin
 *
 * TODO Auto-generated class documentation
 *
 */
@RooJsonMixin(entity = Country.class)
public abstract class CountryJsonMixin {

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    @JsonIgnore
    private Set<CustomerOrder> customerOrders;

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    @JsonIgnore
    private Set<Region> regions;

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    @JsonIgnore
    private Set<Supplier> suppliers;

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    @JsonIgnore
    private Set<Store> stores;

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    @JsonIgnore
    private Set<Party> parties;

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

    /**
     * TODO Auto-generated method documentation
     *
     * @return Set
     */
    public Set<Party> getParties() {
        return parties;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param parties
     */
    public void setParties(Set<Party> parties) {
        this.parties = parties;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @return Set
     */
    public Set<Region> getRegions() {
        return regions;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param regions
     */
    public void setRegions(Set<Region> regions) {
        this.regions = regions;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @return Set
     */
    public Set<Store> getStores() {
        return stores;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param stores
     */
    public void setStores(Set<Store> stores) {
        this.stores = stores;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @return Set
     */
    public Set<Supplier> getSuppliers() {
        return suppliers;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param suppliers
     */
    public void setSuppliers(Set<Supplier> suppliers) {
        this.suppliers = suppliers;
    }
}
