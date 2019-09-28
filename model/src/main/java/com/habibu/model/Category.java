package com.habibu.model;
import org.springframework.roo.addon.javabean.annotations.RooEquals;
import org.springframework.roo.addon.javabean.annotations.RooJavaBean;
import org.springframework.roo.addon.javabean.annotations.RooToString;
import org.springframework.roo.addon.jpa.annotations.entity.RooJpaEntity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Version;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import org.springframework.roo.addon.jpa.annotations.entity.JpaRelationType;
import org.springframework.roo.addon.jpa.annotations.entity.RooJpaRelation;
import org.springframework.roo.addon.ws.annotations.jaxb.RooJaxbEntity;
import java.util.Calendar;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.roo.addon.jpa.annotations.audit.RooJpaAudit;
import io.springlets.format.EntityFormat;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlID;
import javax.xml.bind.annotation.XmlRootElement;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.util.Assert;

/**
 * = Category
 *
 * TODO Auto-generated class documentation
 *
 */
@RooJavaBean
@RooToString
@RooJpaEntity
@RooEquals(isJpaEntity = true)
@RooJaxbEntity
@RooJpaAudit
@EntityListeners(AuditingEntityListener.class)
@Entity
@EntityFormat
@XmlRootElement(name = "category", namespace = "http://ws.habibu.com/")
public class Category {

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
    private String name;

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    private String description;

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    @OneToMany(cascade = { javax.persistence.CascadeType.MERGE, javax.persistence.CascadeType.PERSIST }, fetch = FetchType.LAZY, mappedBy = "category")
    @RooJpaRelation(type = JpaRelationType.AGGREGATION)
    private Set<Product> products = new HashSet<Product>();

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    @CreatedDate
    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(style = "M-")
    private Calendar createdDate;

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    @CreatedBy
    private String createdBy;

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    @LastModifiedDate
    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(style = "M-")
    private Calendar modifiedDate;

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    @LastModifiedBy
    private String modifiedBy;

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
     * @return Category
     */
    public Category setId(Long id) {
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
     * @return Category
     */
    public Category setVersion(Integer version) {
        this.version = version;
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
     * @return Category
     */
    public Category setName(String name) {
        this.name = name;
        return this;
    }

    /**
     * Gets description value
     *
     * @return String
     */
    public String getDescription() {
        return this.description;
    }

    /**
     * Sets description value
     *
     * @param description
     * @return Category
     */
    public Category setDescription(String description) {
        this.description = description;
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
     * @return Category
     */
    public Category setProducts(Set<Product> products) {
        this.products = products;
        return this;
    }

    /**
     * Gets createdDate value
     *
     * @return Calendar
     */
    public Calendar getCreatedDate() {
        return this.createdDate;
    }

    /**
     * Sets createdDate value
     *
     * @param createdDate
     * @return Category
     */
    public Category setCreatedDate(Calendar createdDate) {
        this.createdDate = createdDate;
        return this;
    }

    /**
     * Gets createdBy value
     *
     * @return String
     */
    public String getCreatedBy() {
        return this.createdBy;
    }

    /**
     * Sets createdBy value
     *
     * @param createdBy
     * @return Category
     */
    public Category setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
        return this;
    }

    /**
     * Gets modifiedDate value
     *
     * @return Calendar
     */
    public Calendar getModifiedDate() {
        return this.modifiedDate;
    }

    /**
     * Sets modifiedDate value
     *
     * @param modifiedDate
     * @return Category
     */
    public Category setModifiedDate(Calendar modifiedDate) {
        this.modifiedDate = modifiedDate;
        return this;
    }

    /**
     * Gets modifiedBy value
     *
     * @return String
     */
    public String getModifiedBy() {
        return this.modifiedBy;
    }

    /**
     * Sets modifiedBy value
     *
     * @param modifiedBy
     * @return Category
     */
    public Category setModifiedBy(String modifiedBy) {
        this.modifiedBy = modifiedBy;
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
        if (!(obj instanceof Category)) {
            return false;
        }
        return getId() != null && Objects.equals(getId(), ((Category) obj).getId());
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
        return "Category {" + "id='" + id + '\'' + ", version='" + version + '\'' + ", name='" + name + '\'' + ", description='" + description + '\'' + ", createdDate='" + createdDate == null ? null : java.text.DateFormat.getDateTimeInstance().format(createdDate.getTime()) + '\'' + ", createdBy='" + createdBy + '\'' + ", modifiedDate='" + modifiedDate == null ? null : java.text.DateFormat.getDateTimeInstance().format(modifiedDate.getTime()) + '\'' + ", modifiedBy='" + modifiedBy + '\'' + "}" + super.toString();
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
            item.setCategory(this);
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
            item.setCategory(null);
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
