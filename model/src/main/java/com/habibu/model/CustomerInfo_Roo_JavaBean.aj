// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package com.habibu.model;

import com.habibu.model.CustomerInfo;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

privileged aspect CustomerInfo_Roo_JavaBean {
    
    /**
     * Gets id value
     * 
     * @return Long
     */
    public Long CustomerInfo.getId() {
        return this.id;
    }
    
    /**
     * Gets companyName value
     * 
     * @return String
     */
    public String CustomerInfo.getCompanyName() {
        return this.companyName;
    }
    
    /**
     * Gets email value
     * 
     * @return String
     */
    public String CustomerInfo.getEmail() {
        return this.email;
    }
    
    /**
     * Gets fax value
     * 
     * @return String
     */
    public String CustomerInfo.getFax() {
        return this.fax;
    }
    
    /**
     * TODO Auto-generated method documentation
     * 
     * @param obj
     * @return Boolean
     */
    public boolean CustomerInfo.equals(Object obj) {
        if (!(obj instanceof CustomerInfo)) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        CustomerInfo rhs = (CustomerInfo) obj;
        return new EqualsBuilder().append(companyName, rhs.companyName).append(email, rhs.email).append(fax, rhs.fax).append(id, rhs.id).isEquals();
    }
    
    /**
     * TODO Auto-generated method documentation
     * 
     * @return Integer
     */
    public int CustomerInfo.hashCode() {
        return new HashCodeBuilder().append(companyName).append(email).append(fax).append(id).toHashCode();
    }
    
    /**
     * TODO Auto-generated method documentation
     * 
     * @return String
     */
    public String CustomerInfo.toString() {
        return "CustomerInfo {" + 
                "id='" + id + '\'' + 
                ", companyName='" + companyName + '\'' + 
                ", email='" + email + '\'' + 
                ", fax='" + fax + '\'' + "}" + super.toString();
    }
    
}
