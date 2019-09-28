package com.habibu.model;
import org.springframework.roo.addon.javabean.annotations.RooEquals;
import org.springframework.roo.addon.javabean.annotations.RooJavaBean;
import org.springframework.roo.addon.javabean.annotations.RooToString;
import org.springframework.roo.addon.jpa.annotations.entity.RooJpaEntity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Version;
import io.springlets.format.EntityFormat;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import org.springframework.roo.addon.ws.annotations.jaxb.RooJaxbEntity;
import java.util.Objects;
import javax.persistence.Entity;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlID;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * = Party
 *
 * TODO Auto-generated class documentation
 *
 */
@RooJavaBean
@RooToString
@RooJpaEntity
@RooEquals(isJpaEntity = true)
@RooJaxbEntity
@Entity
@EntityFormat
@XmlRootElement(name = "party", namespace = "http://ws.habibu.com/")
public class Party {

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    @Version
    private Integer version;

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @EntityFormat
    private City city;

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @EntityFormat
    private Country country;

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    private String address;

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    private String postalCode;

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    private String phone;

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @EntityFormat
    private Region region;

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    public static final String ITERABLE_TO_ADD_CANT_BE_NULL_MESSAGE = "The given Iterable of items to add can't be null!";

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    public static final String ITERABLE_TO_REMOVE_CANT_BE_NULL_MESSAGE = "The given Iterable of items to add can't be null!";

    /**
     * Gets id value
     *
     * @return Long
     */
    public Long getId() {
        return this.id;
    }

    /**
     * Sets id value
     *
     * @param id
     * @return Party
     */
    public Party setId(Long id) {
        this.id = id;
        return this;
    }

    /**
     * Gets version value
     *
     * @return Integer
     */
    public Integer getVersion() {
        return this.version;
    }

    /**
     * Sets version value
     *
     * @param version
     * @return Party
     */
    public Party setVersion(Integer version) {
        this.version = version;
        return this;
    }

    /**
     * Gets city value
     *
     * @return City
     */
    public City getCity() {
        return this.city;
    }

    /**
     * Sets city value
     *
     * @param city
     * @return Party
     */
    public Party setCity(City city) {
        this.city = city;
        return this;
    }

    /**
     * Gets country value
     *
     * @return Country
     */
    public Country getCountry() {
        return this.country;
    }

    /**
     * Sets country value
     *
     * @param country
     * @return Party
     */
    public Party setCountry(Country country) {
        this.country = country;
        return this;
    }

    /**
     * Gets address value
     *
     * @return String
     */
    public String getAddress() {
        return this.address;
    }

    /**
     * Sets address value
     *
     * @param address
     * @return Party
     */
    public Party setAddress(String address) {
        this.address = address;
        return this;
    }

    /**
     * Gets postalCode value
     *
     * @return String
     */
    public String getPostalCode() {
        return this.postalCode;
    }

    /**
     * Sets postalCode value
     *
     * @param postalCode
     * @return Party
     */
    public Party setPostalCode(String postalCode) {
        this.postalCode = postalCode;
        return this;
    }

    /**
     * Gets phone value
     *
     * @return String
     */
    public String getPhone() {
        return this.phone;
    }

    /**
     * Sets phone value
     *
     * @param phone
     * @return Party
     */
    public Party setPhone(String phone) {
        this.phone = phone;
        return this;
    }

    /**
     * Gets region value
     *
     * @return Region
     */
    public Region getRegion() {
        return this.region;
    }

    /**
     * Sets region value
     *
     * @param region
     * @return Party
     */
    public Party setRegion(Region region) {
        this.region = region;
        return this;
    }

    /**
     * This `equals` implementation is specific for JPA entities and uses
     * the entity identifier for it, following the article in
     * https://vladmihalcea.com/2016/06/06/how-to-implement-equals-and-hashcode-using-the-jpa-entity-identifier/
     *
     * @param obj
     * @return Boolean
     */
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        // instanceof is false if the instance is null
        if (!(obj instanceof Party)) {
            return false;
        }
        return getId() != null && Objects.equals(getId(), ((Party) obj).getId());
    }

    /**
     * This `hashCode` implementation is specific for JPA entities and uses a fixed `int` value to be able
     * to identify the entity in collections after a new id is assigned to the entity, following the article in
     * https://vladmihalcea.com/2016/06/06/how-to-implement-equals-and-hashcode-using-the-jpa-entity-identifier/
     *
     * @return Integer
     */
    public int hashCode() {
        return 31;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @return String
     */
    public String toString() {
        return "Party {" + "id='" + id + '\'' + ", version='" + version + '\'' + ", address='" + address + '\'' + ", postalCode='" + postalCode + '\'' + ", phone='" + phone + '\'' + "}" + super.toString();
    }

    /**
     * Must return an unique ID across all entities
     *
     * @return String
     */
    @XmlID
    @XmlAttribute(name = "id")
    public String getXmlIdentityInfo() {
        return getClass().getName() + ":" + getId();
    }
}
