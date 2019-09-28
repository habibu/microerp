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
import java.math.BigDecimal;
import org.springframework.format.annotation.NumberFormat;
import java.util.Calendar;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.roo.addon.ws.annotations.jaxb.RooJaxbEntity;
import java.util.Objects;
import javax.persistence.Entity;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlID;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * = PurchaseOrder
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
@XmlRootElement(name = "purchaseorder", namespace = "http://ws.habibu.com/")
public class PurchaseOrder {

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
    private Product product;

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @EntityFormat
    private Employee employee;

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    @NumberFormat
    private BigDecimal unitCost;

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    @NumberFormat
    private Integer quantity;

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(style = "M-")
    private Calendar orderDate;

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
     * @return PurchaseOrder
     */
    public PurchaseOrder setId(Long id) {
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
     * @return PurchaseOrder
     */
    public PurchaseOrder setVersion(Integer version) {
        this.version = version;
        return this;
    }

    /**
     * Gets product value
     *
     * @return Product
     */
    public Product getProduct() {
        return this.product;
    }

    /**
     * Sets product value
     *
     * @param product
     * @return PurchaseOrder
     */
    public PurchaseOrder setProduct(Product product) {
        this.product = product;
        return this;
    }

    /**
     * Gets employee value
     *
     * @return Employee
     */
    public Employee getEmployee() {
        return this.employee;
    }

    /**
     * Sets employee value
     *
     * @param employee
     * @return PurchaseOrder
     */
    public PurchaseOrder setEmployee(Employee employee) {
        this.employee = employee;
        return this;
    }

    /**
     * Gets unitCost value
     *
     * @return BigDecimal
     */
    public BigDecimal getUnitCost() {
        return this.unitCost;
    }

    /**
     * Sets unitCost value
     *
     * @param unitCost
     * @return PurchaseOrder
     */
    public PurchaseOrder setUnitCost(BigDecimal unitCost) {
        this.unitCost = unitCost;
        return this;
    }

    /**
     * Gets quantity value
     *
     * @return Integer
     */
    public Integer getQuantity() {
        return this.quantity;
    }

    /**
     * Sets quantity value
     *
     * @param quantity
     * @return PurchaseOrder
     */
    public PurchaseOrder setQuantity(Integer quantity) {
        this.quantity = quantity;
        return this;
    }

    /**
     * Gets orderDate value
     *
     * @return Calendar
     */
    public Calendar getOrderDate() {
        return this.orderDate;
    }

    /**
     * Sets orderDate value
     *
     * @param orderDate
     * @return PurchaseOrder
     */
    public PurchaseOrder setOrderDate(Calendar orderDate) {
        this.orderDate = orderDate;
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
        if (!(obj instanceof PurchaseOrder)) {
            return false;
        }
        return getId() != null && Objects.equals(getId(), ((PurchaseOrder) obj).getId());
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
        return "PurchaseOrder {" + "id='" + id + '\'' + ", version='" + version + '\'' + ", unitCost='" + unitCost + '\'' + ", quantity='" + quantity + '\'' + ", orderDate='" + orderDate == null ? null : java.text.DateFormat.getDateTimeInstance().format(orderDate.getTime()) + '\'' + "}" + super.toString();
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
