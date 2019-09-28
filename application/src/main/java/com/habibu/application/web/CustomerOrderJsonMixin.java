package com.habibu.application.web;
import com.habibu.model.CustomerOrder;
import org.springframework.roo.addon.web.mvc.controller.annotations.config.RooJsonMixin;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.habibu.model.City;
import com.habibu.model.Country;
import com.habibu.model.Customer;
import com.habibu.model.Employee;
import com.habibu.model.OrderDetail;
import com.habibu.model.Region;
import com.habibu.model.Shipper;
import java.util.Set;

/**
 * = CustomerOrderJsonMixin
 *
 * TODO Auto-generated class documentation
 *
 */
@RooJsonMixin(entity = CustomerOrder.class)
public abstract class CustomerOrderJsonMixin {

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    @JsonIgnore
    private Set<OrderDetail> orderDetails;

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
    @JsonDeserialize(using = ShipperDeserializer.class)
    private Shipper shipper;

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
    @JsonDeserialize(using = EmployeeDeserializer.class)
    private Employee employee;

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
    @JsonDeserialize(using = CustomerDeserializer.class)
    private Customer customer;

    /**
     * TODO Auto-generated method documentation
     *
     * @return Set
     */
    public Set<OrderDetail> getOrderDetails() {
        return orderDetails;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param orderDetails
     */
    public void setOrderDetails(Set<OrderDetail> orderDetails) {
        this.orderDetails = orderDetails;
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
     * @return Customer
     */
    public Customer getCustomer() {
        return customer;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param customer
     */
    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @return Employee
     */
    public Employee getEmployee() {
        return employee;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param employee
     */
    public void setEmployee(Employee employee) {
        this.employee = employee;
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

    /**
     * TODO Auto-generated method documentation
     *
     * @return Shipper
     */
    public Shipper getShipper() {
        return shipper;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param shipper
     */
    public void setShipper(Shipper shipper) {
        this.shipper = shipper;
    }
}
