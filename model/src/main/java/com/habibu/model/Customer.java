package com.habibu.model;
import org.springframework.roo.addon.javabean.annotations.RooJavaBean;
import org.springframework.roo.addon.javabean.annotations.RooToString;
import org.springframework.roo.addon.jpa.annotations.entity.RooJpaEntity;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import org.springframework.roo.addon.jpa.annotations.entity.JpaRelationType;
import org.springframework.roo.addon.jpa.annotations.entity.RooJpaRelation;
import org.springframework.roo.addon.ws.annotations.jaxb.RooJaxbEntity;
import io.springlets.format.EntityFormat;
import javax.persistence.Entity;
import javax.xml.bind.annotation.XmlRootElement;
import org.springframework.util.Assert;

/**
 * = Customer
 *
 * TODO Auto-generated class documentation
 *
 */
@RooJavaBean
@RooToString
@RooJpaEntity
@RooJaxbEntity
@Entity
@EntityFormat
@XmlRootElement(name = "customer", namespace = "http://ws.habibu.com/")
public class Customer extends Party {

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    private String companyName;

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    private String contactName;

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    private String contactTitle;

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    private String fax;

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    private String email;

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    @OneToMany(cascade = { javax.persistence.CascadeType.MERGE, javax.persistence.CascadeType.PERSIST }, fetch = FetchType.LAZY, mappedBy = "customer")
    @RooJpaRelation(type = JpaRelationType.AGGREGATION)
    private Set<CustomerOrder> customerOrders = new HashSet<CustomerOrder>();

    /**
     * Gets companyName value
     *
     * @return String
     */
    public String getCompanyName() {
        return this.companyName;
    }

    /**
     * Sets companyName value
     *
     * @param companyName
     * @return Customer
     */
    public Customer setCompanyName(String companyName) {
        this.companyName = companyName;
        return this;
    }

    /**
     * Gets contactName value
     *
     * @return String
     */
    public String getContactName() {
        return this.contactName;
    }

    /**
     * Sets contactName value
     *
     * @param contactName
     * @return Customer
     */
    public Customer setContactName(String contactName) {
        this.contactName = contactName;
        return this;
    }

    /**
     * Gets contactTitle value
     *
     * @return String
     */
    public String getContactTitle() {
        return this.contactTitle;
    }

    /**
     * Sets contactTitle value
     *
     * @param contactTitle
     * @return Customer
     */
    public Customer setContactTitle(String contactTitle) {
        this.contactTitle = contactTitle;
        return this;
    }

    /**
     * Gets fax value
     *
     * @return String
     */
    public String getFax() {
        return this.fax;
    }

    /**
     * Sets fax value
     *
     * @param fax
     * @return Customer
     */
    public Customer setFax(String fax) {
        this.fax = fax;
        return this;
    }

    /**
     * Gets email value
     *
     * @return String
     */
    public String getEmail() {
        return this.email;
    }

    /**
     * Sets email value
     *
     * @param email
     * @return Customer
     */
    public Customer setEmail(String email) {
        this.email = email;
        return this;
    }

    /**
     * Gets customerOrders value
     *
     * @return Set
     */
    public Set<CustomerOrder> getCustomerOrders() {
        return this.customerOrders;
    }

    /**
     * Sets customerOrders value
     *
     * @param customerOrders
     * @return Customer
     */
    public Customer setCustomerOrders(Set<CustomerOrder> customerOrders) {
        this.customerOrders = customerOrders;
        return this;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param customerOrdersToAdd
     */
    public void addToCustomerOrders(Iterable<CustomerOrder> customerOrdersToAdd) {
        Assert.notNull(customerOrdersToAdd, ITERABLE_TO_ADD_CANT_BE_NULL_MESSAGE);
        for (CustomerOrder item : customerOrdersToAdd) {
            this.customerOrders.add(item);
            item.setCustomer(this);
        }
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param customerOrdersToRemove
     */
    public void removeFromCustomerOrders(Iterable<CustomerOrder> customerOrdersToRemove) {
        Assert.notNull(customerOrdersToRemove, ITERABLE_TO_REMOVE_CANT_BE_NULL_MESSAGE);
        for (CustomerOrder item : customerOrdersToRemove) {
            this.customerOrders.remove(item);
            item.setCustomer(null);
        }
    }
}
