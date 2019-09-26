// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package com.habibu.model;

import com.habibu.model.Country;
import com.habibu.model.CustomerOrder;
import com.habibu.model.Party;
import com.habibu.model.Region;
import com.habibu.model.Store;
import com.habibu.model.Supplier;
import java.util.Objects;
import java.util.Set;

privileged aspect Country_Roo_JavaBean {
    
    /**
     * Gets id value
     * 
     * @return Long
     */
    public Long Country.getId() {
        return this.id;
    }
    
    /**
     * Gets version value
     * 
     * @return Integer
     */
    public Integer Country.getVersion() {
        return this.version;
    }
    
    /**
     * Gets description value
     * 
     * @return String
     */
    public String Country.getDescription() {
        return this.description;
    }
    
    /**
     * Gets parties value
     * 
     * @return Set
     */
    public Set<Party> Country.getParties() {
        return this.parties;
    }
    
    /**
     * Gets customerOrders value
     * 
     * @return Set
     */
    public Set<CustomerOrder> Country.getCustomerOrders() {
        return this.customerOrders;
    }
    
    /**
     * Gets suppliers value
     * 
     * @return Set
     */
    public Set<Supplier> Country.getSuppliers() {
        return this.suppliers;
    }
    
    /**
     * Gets stores value
     * 
     * @return Set
     */
    public Set<Store> Country.getStores() {
        return this.stores;
    }
    
    /**
     * Gets regions value
     * 
     * @return Set
     */
    public Set<Region> Country.getRegions() {
        return this.regions;
    }
    
    /**
     * This `equals` implementation is specific for JPA entities and uses 
     * the entity identifier for it, following the article in 
     * https://vladmihalcea.com/2016/06/06/how-to-implement-equals-and-hashcode-using-the-jpa-entity-identifier/
     * 
     * @param obj
     * @return Boolean
     */
    public boolean Country.equals(Object obj) {
        if (this == obj) {
            return true;
        }
        // instanceof is false if the instance is null
        if (!(obj instanceof Country)) {
            return false;
        }
        return getId() != null && Objects.equals(getId(), ((Country) obj).getId());
    }
    
    /**
     * This `hashCode` implementation is specific for JPA entities and uses a fixed `int` value to be able 
     * to identify the entity in collections after a new id is assigned to the entity, following the article in 
     * https://vladmihalcea.com/2016/06/06/how-to-implement-equals-and-hashcode-using-the-jpa-entity-identifier/
     * 
     * @return Integer
     */
    public int Country.hashCode() {
        return 31;
    }
    
    /**
     * TODO Auto-generated method documentation
     * 
     * @return String
     */
    public String Country.toString() {
        return "Country {" + 
                "id='" + id + '\'' + 
                ", version='" + version + '\'' + 
                ", description='" + description + '\'' + "}" + super.toString();
    }
    
}
