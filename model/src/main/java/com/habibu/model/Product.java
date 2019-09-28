package com.habibu.model;
import org.springframework.format.annotation.NumberFormat;
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
import java.util.HashSet;
import java.util.Set;
import javax.persistence.OneToMany;
import org.springframework.roo.addon.jpa.annotations.entity.JpaRelationType;
import org.springframework.roo.addon.jpa.annotations.entity.RooJpaRelation;
import org.springframework.roo.addon.ws.annotations.jaxb.RooJaxbEntity;
import java.util.Objects;
import javax.persistence.Entity;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlID;
import javax.xml.bind.annotation.XmlRootElement;
import org.springframework.util.Assert;

/**
 * = Product
 *
 * TODO Auto-generated class documentation
 *
 */
@RooJavaBean
@RooToString
@RooJpaEntity(entityFormatExpression = "#{name}, #{code}")
@RooEquals(isJpaEntity = true)
@RooJaxbEntity
@Entity
@EntityFormat("#{name}, #{code}")
@XmlRootElement(name = "product", namespace = "http://ws.habibu.com/")
public class Product {

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
    private Category category;

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    private String name;

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    private String code;

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    private String quantityPerUnit;

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
    private BigDecimal unitPrice;

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    @NumberFormat
    private Integer unitsInStock;

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    @NumberFormat
    private Integer reorderLevel;

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    private Boolean discontinued;

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    @OneToMany(cascade = { javax.persistence.CascadeType.MERGE, javax.persistence.CascadeType.PERSIST }, fetch = FetchType.LAZY, mappedBy = "product")
    @RooJpaRelation(type = JpaRelationType.AGGREGATION)
    private Set<PurchaseOrder> purchaseOrders = new HashSet<PurchaseOrder>();

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    @OneToMany(cascade = { javax.persistence.CascadeType.MERGE, javax.persistence.CascadeType.PERSIST }, fetch = FetchType.LAZY, mappedBy = "product")
    @RooJpaRelation(type = JpaRelationType.AGGREGATION)
    private Set<OrderDetail> orderDetails = new HashSet<OrderDetail>();

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @EntityFormat
    private Supplier supplier;

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
     * @return Product
     */
    public Product setId(Long id) {
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
     * @return Product
     */
    public Product setVersion(Integer version) {
        this.version = version;
        return this;
    }

    /**
     * Gets category value
     *
     * @return Category
     */
    public Category getCategory() {
        return this.category;
    }

    /**
     * Sets category value
     *
     * @param category
     * @return Product
     */
    public Product setCategory(Category category) {
        this.category = category;
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
     * @return Product
     */
    public Product setName(String name) {
        this.name = name;
        return this;
    }

    /**
     * Gets code value
     *
     * @return String
     */
    public String getCode() {
        return this.code;
    }

    /**
     * Sets code value
     *
     * @param code
     * @return Product
     */
    public Product setCode(String code) {
        this.code = code;
        return this;
    }

    /**
     * Gets quantityPerUnit value
     *
     * @return String
     */
    public String getQuantityPerUnit() {
        return this.quantityPerUnit;
    }

    /**
     * Sets quantityPerUnit value
     *
     * @param quantityPerUnit
     * @return Product
     */
    public Product setQuantityPerUnit(String quantityPerUnit) {
        this.quantityPerUnit = quantityPerUnit;
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
     * @return Product
     */
    public Product setUnitCost(BigDecimal unitCost) {
        this.unitCost = unitCost;
        return this;
    }

    /**
     * Gets unitPrice value
     *
     * @return BigDecimal
     */
    public BigDecimal getUnitPrice() {
        return this.unitPrice;
    }

    /**
     * Sets unitPrice value
     *
     * @param unitPrice
     * @return Product
     */
    public Product setUnitPrice(BigDecimal unitPrice) {
        this.unitPrice = unitPrice;
        return this;
    }

    /**
     * Gets unitsInStock value
     *
     * @return Integer
     */
    public Integer getUnitsInStock() {
        return this.unitsInStock;
    }

    /**
     * Sets unitsInStock value
     *
     * @param unitsInStock
     * @return Product
     */
    public Product setUnitsInStock(Integer unitsInStock) {
        this.unitsInStock = unitsInStock;
        return this;
    }

    /**
     * Gets reorderLevel value
     *
     * @return Integer
     */
    public Integer getReorderLevel() {
        return this.reorderLevel;
    }

    /**
     * Sets reorderLevel value
     *
     * @param reorderLevel
     * @return Product
     */
    public Product setReorderLevel(Integer reorderLevel) {
        this.reorderLevel = reorderLevel;
        return this;
    }

    /**
     * Gets discontinued value
     *
     * @return Boolean
     */
    public Boolean getDiscontinued() {
        return this.discontinued;
    }

    /**
     * Sets discontinued value
     *
     * @param discontinued
     * @return Product
     */
    public Product setDiscontinued(Boolean discontinued) {
        this.discontinued = discontinued;
        return this;
    }

    /**
     * Gets purchaseOrders value
     *
     * @return Set
     */
    public Set<PurchaseOrder> getPurchaseOrders() {
        return this.purchaseOrders;
    }

    /**
     * Sets purchaseOrders value
     *
     * @param purchaseOrders
     * @return Product
     */
    public Product setPurchaseOrders(Set<PurchaseOrder> purchaseOrders) {
        this.purchaseOrders = purchaseOrders;
        return this;
    }

    /**
     * Gets orderDetails value
     *
     * @return Set
     */
    public Set<OrderDetail> getOrderDetails() {
        return this.orderDetails;
    }

    /**
     * Sets orderDetails value
     *
     * @param orderDetails
     * @return Product
     */
    public Product setOrderDetails(Set<OrderDetail> orderDetails) {
        this.orderDetails = orderDetails;
        return this;
    }

    /**
     * Gets supplier value
     *
     * @return Supplier
     */
    public Supplier getSupplier() {
        return this.supplier;
    }

    /**
     * Sets supplier value
     *
     * @param supplier
     * @return Product
     */
    public Product setSupplier(Supplier supplier) {
        this.supplier = supplier;
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
        if (!(obj instanceof Product)) {
            return false;
        }
        return getId() != null && Objects.equals(getId(), ((Product) obj).getId());
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
        return "Product {" + "id='" + id + '\'' + ", version='" + version + '\'' + ", name='" + name + '\'' + ", code='" + code + '\'' + ", quantityPerUnit='" + quantityPerUnit + '\'' + ", unitsInStock='" + unitsInStock + '\'' + ", reorderLevel='" + reorderLevel + '\'' + ", discontinued='" + discontinued + '\'' + "}" + super.toString();
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param purchaseOrdersToAdd
     */
    public void addToPurchaseOrders(Iterable<PurchaseOrder> purchaseOrdersToAdd) {
        Assert.notNull(purchaseOrdersToAdd, ITERABLE_TO_ADD_CANT_BE_NULL_MESSAGE);
        for (PurchaseOrder item : purchaseOrdersToAdd) {
            this.purchaseOrders.add(item);
            item.setProduct(this);
        }
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param purchaseOrdersToRemove
     */
    public void removeFromPurchaseOrders(Iterable<PurchaseOrder> purchaseOrdersToRemove) {
        Assert.notNull(purchaseOrdersToRemove, ITERABLE_TO_REMOVE_CANT_BE_NULL_MESSAGE);
        for (PurchaseOrder item : purchaseOrdersToRemove) {
            this.purchaseOrders.remove(item);
            item.setProduct(null);
        }
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param orderDetailsToAdd
     */
    public void addToOrderDetails(Iterable<OrderDetail> orderDetailsToAdd) {
        Assert.notNull(orderDetailsToAdd, ITERABLE_TO_ADD_CANT_BE_NULL_MESSAGE);
        for (OrderDetail item : orderDetailsToAdd) {
            this.orderDetails.add(item);
            item.setProduct(this);
        }
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param orderDetailsToRemove
     */
    public void removeFromOrderDetails(Iterable<OrderDetail> orderDetailsToRemove) {
        Assert.notNull(orderDetailsToRemove, ITERABLE_TO_REMOVE_CANT_BE_NULL_MESSAGE);
        for (OrderDetail item : orderDetailsToRemove) {
            this.orderDetails.remove(item);
            item.setProduct(null);
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
