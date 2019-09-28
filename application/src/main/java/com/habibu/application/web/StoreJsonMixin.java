package com.habibu.application.web;
import com.habibu.model.Store;
import org.springframework.roo.addon.web.mvc.controller.annotations.config.RooJsonMixin;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.habibu.model.City;
import com.habibu.model.Country;
import com.habibu.model.Region;

/**
 * = StoreJsonMixin
 *
 * TODO Auto-generated class documentation
 *
 */
@RooJsonMixin(entity = Store.class)
public abstract class StoreJsonMixin {

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
    @JsonDeserialize(using = RegionDeserializer.class)
    private Region region;

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
