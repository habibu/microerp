package com.habibu.model;
import org.springframework.roo.addon.dto.annotations.RooEntityProjection;
import org.springframework.roo.addon.javabean.annotations.RooEquals;
import org.springframework.roo.addon.javabean.annotations.RooJavaBean;
import org.springframework.roo.addon.javabean.annotations.RooToString;
import io.springlets.format.EntityFormat;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

/**
 * = CustomerInfo
 *
 * TODO Auto-generated class documentation
 *
 */
@RooJavaBean(settersByDefault = false)
@RooToString
@RooEquals
@RooEntityProjection(entity = Customer.class, fields = { "id", "companyName", "email", "fax" }, formatExpression = "#{companyName}")
@EntityFormat("#{companyName}")
public class CustomerInfo {

    private Long id;

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    private String companyName;

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    private String email;

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    private String fax;

    /**
     * TODO Auto-generated constructor documentation
     *
     * @param id
     * @param companyName
     * @param email
     * @param fax
     */
    public CustomerInfo(Long id, String companyName, String email, String fax) {
        this.id = id;
        this.companyName = companyName;
        this.email = email;
        this.fax = fax;
    }

    /**
     * Gets id value
     *
     * @return Long
     */
    public Long getId() {
        return this.id;
    }

    /**
     * Gets companyName value
     *
     * @return String
     */
    public String getCompanyName() {
        return this.companyName;
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
     * Gets fax value
     *
     * @return String
     */
    public String getFax() {
        return this.fax;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param obj
     * @return Boolean
     */
    public boolean equals(Object obj) {
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
    public int hashCode() {
        return new HashCodeBuilder().append(companyName).append(email).append(fax).append(id).toHashCode();
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @return String
     */
    public String toString() {
        return "CustomerInfo {" + "id='" + id + '\'' + ", companyName='" + companyName + '\'' + ", email='" + email + '\'' + ", fax='" + fax + '\'' + "}" + super.toString();
    }
}
