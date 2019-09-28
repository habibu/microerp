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
import java.util.HashSet;
import java.util.Set;
import javax.persistence.OneToMany;
import org.springframework.roo.addon.jpa.annotations.entity.JpaRelationType;
import org.springframework.roo.addon.jpa.annotations.entity.RooJpaRelation;
import javax.persistence.ManyToMany;
import org.springframework.roo.addon.ws.annotations.jaxb.RooJaxbEntity;
import java.util.Objects;
import javax.persistence.Entity;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlID;
import javax.xml.bind.annotation.XmlRootElement;
import org.springframework.util.Assert;

/**
 * = Supplier
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
@XmlRootElement(name = "supplier", namespace = "http://ws.habibu.com/")
public class Supplier {

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
    @ManyToOne(fetch = FetchType.LAZY)
    @EntityFormat
    private Region region;

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    private String name;

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
    private String fax;

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    private String webaddress;

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    @OneToMany(cascade = { javax.persistence.CascadeType.MERGE, javax.persistence.CascadeType.PERSIST }, fetch = FetchType.LAZY, mappedBy = "supplier")
    @RooJpaRelation(type = JpaRelationType.AGGREGATION)
    private Set<Product> products = new HashSet<Product>();

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    @ManyToMany(cascade = { javax.persistence.CascadeType.MERGE, javax.persistence.CascadeType.PERSIST }, fetch = FetchType.LAZY, mappedBy = "suppliers")
    @RooJpaRelation(type = JpaRelationType.AGGREGATION)
    private Set<Store> stores = new HashSet<Store>();

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
     * @return Supplier
     */
    public Supplier setId(Long id) {
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
     * @return Supplier
     */
    public Supplier setVersion(Integer version) {
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
     * @return Supplier
     */
    public Supplier setCity(City city) {
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
     * @return Supplier
     */
    public Supplier setCountry(Country country) {
        this.country = country;
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
     * @return Supplier
     */
    public Supplier setRegion(Region region) {
        this.region = region;
        return this;
    }

    /**
     * Gets name value
     *
     * @return String
     */
    public String getName() {
        return this.name;
    }

    /**
     * Sets name value
     *
     * @param name
     * @return Supplier
     */
    public Supplier setName(String name) {
        this.name = name;
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
     * @return Supplier
     */
    public Supplier setContactName(String contactName) {
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
     * @return Supplier
     */
    public Supplier setContactTitle(String contactTitle) {
        this.contactTitle = contactTitle;
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
     * @return Supplier
     */
    public Supplier setAddress(String address) {
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
     * @return Supplier
     */
    public Supplier setPostalCode(String postalCode) {
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
     * @return Supplier
     */
    public Supplier setPhone(String phone) {
        this.phone = phone;
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
     * @return Supplier
     */
    public Supplier setFax(String fax) {
        this.fax = fax;
        return this;
    }

    /**
     * Gets webaddress value
     *
     * @return String
     */
    public String getWebaddress() {
        return this.webaddress;
    }

    /**
     * Sets webaddress value
     *
     * @param webaddress
     * @return Supplier
     */
    public Supplier setWebaddress(String webaddress) {
        this.webaddress = webaddress;
        return this;
    }

    /**
     * Gets products value
     *
     * @return Set
     */
    public Set<Product> getProducts() {
        return this.products;
    }

    /**
     * Sets products value
     *
     * @param products
     * @return Supplier
     */
    public Supplier setProducts(Set<Product> products) {
        this.products = products;
        return this;
    }

    /**
     * Gets stores value
     *
     * @return Set
     */
    public Set<Store> getStores() {
        return this.stores;
    }

    /**
     * Sets stores value
     *
     * @param stores
     * @return Supplier
     */
    public Supplier setStores(Set<Store> stores) {
        this.stores = stores;
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
        if (!(obj instanceof Supplier)) {
            return false;
        }
        return getId() != null && Objects.equals(getId(), ((Supplier) obj).getId());
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
        return "Supplier {" + "id='" + id + '\'' + ", version='" + version + '\'' + ", name='" + name + '\'' + ", contactName='" + contactName + '\'' + ", contactTitle='" + contactTitle + '\'' + ", address='" + address + '\'' + ", postalCode='" + postalCode + '\'' + ", phone='" + phone + '\'' + ", fax='" + fax + '\'' + ", webaddress='" + webaddress + '\'' + "}" + super.toString();
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param productsToAdd
     */
    public void addToProducts(Iterable<Product> productsToAdd) {
        Assert.notNull(productsToAdd, ITERABLE_TO_ADD_CANT_BE_NULL_MESSAGE);
        for (Product item : productsToAdd) {
            this.products.add(item);
            item.setSupplier(this);
        }
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param productsToRemove
     */
    public void removeFromProducts(Iterable<Product> productsToRemove) {
        Assert.notNull(productsToRemove, ITERABLE_TO_REMOVE_CANT_BE_NULL_MESSAGE);
        for (Product item : productsToRemove) {
            this.products.remove(item);
            item.setSupplier(null);
        }
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param storesToAdd
     */
    public void addToStores(Iterable<Store> storesToAdd) {
        Assert.notNull(storesToAdd, ITERABLE_TO_ADD_CANT_BE_NULL_MESSAGE);
        for (Store item : storesToAdd) {
            this.stores.add(item);
            item.getSuppliers().add(this);
        }
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param storesToRemove
     */
    public void removeFromStores(Iterable<Store> storesToRemove) {
        Assert.notNull(storesToRemove, ITERABLE_TO_REMOVE_CANT_BE_NULL_MESSAGE);
        for (Store item : storesToRemove) {
            this.stores.remove(item);
            item.getSuppliers().remove(this);
        }
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
