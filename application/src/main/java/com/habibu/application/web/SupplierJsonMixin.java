package com.habibu.application.web;
import com.habibu.model.Supplier;
import org.springframework.roo.addon.web.mvc.controller.annotations.config.RooJsonMixin;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.habibu.model.City;
import com.habibu.model.Country;
import com.habibu.model.Product;
import com.habibu.model.Region;
import com.habibu.model.Store;
import java.util.Set;

/**
 * = SupplierJsonMixin
 *
 * TODO Auto-generated class documentation
 *
 */
@RooJsonMixin(entity = Supplier.class)
public abstract class SupplierJsonMixin {

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    @JsonDeserialize(using = CountryDeserializer.class)
    private Country country;

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    @JsonDeserialize(using = CityDeserializer.class)
    private City city;

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
    @JsonDeserialize(using = RegionDeserializer.class)
    private Region region;

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    @JsonIgnore
    private Set<Product> products;

    /**
     * TODO Auto-generated method documentation
     *
     * @return Set
     */
    public Set<Product> getProducts() {
        return products;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param products
     */
    public void setProducts(Set<Product> products) {
        this.products = products;
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
     * @return City
     */
    public City getCity() {
        return city;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param city
     */
    public void setCity(City city) {
        this.city = city;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @return Country
     */
    public Country getCountry() {
        return country;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param country
     */
    public void setCountry(Country country) {
        this.country = country;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @return Region
     */
    public Region getRegion() {
        return region;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param region
     */
    public void setRegion(Region region) {
        this.region = region;
    }
}
