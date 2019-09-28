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
import java.util.Calendar;
import javax.persistence.Column;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.springframework.format.annotation.DateTimeFormat;
import java.math.BigDecimal;
import org.springframework.format.annotation.NumberFormat;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
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
 * = CustomerOrder
 *
 * TODO Auto-generated class documentation
 *
 */
@RooJavaBean
@RooToString
@RooJpaEntity(entityFormatMessage = "custormerorder_format")
@RooEquals(isJpaEntity = true)
@RooJaxbEntity
@Entity
@EntityFormat(message = "custormerorder_format")
@XmlRootElement(name = "customerorder", namespace = "http://ws.habibu.com/")
public class CustomerOrder {

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
    private Customer customer;

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    @Column(name = "ORDER_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(style = "M-")
    private Calendar orderDate;

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(style = "M-")
    private Calendar requiredDate;

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(style = "M-")
    private Calendar shippedDate;

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    @NumberFormat
    private BigDecimal freight;

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    private String shipName;

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    private String shipAddress;

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    private String shipPostalCode;

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    @Enumerated(EnumType.STRING)
    private Status status;

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    private String shipPhone;

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(style = "M-")
    private Calendar invoiceDate;

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(style = "M-")
    private Calendar closeDate;

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    @OneToMany(cascade = { javax.persistence.CascadeType.MERGE, javax.persistence.CascadeType.PERSIST }, fetch = FetchType.LAZY, mappedBy = "customerOrder")
    @RooJpaRelation(type = JpaRelationType.AGGREGATION)
    private Set<OrderDetail> orderDetails = new HashSet<OrderDetail>();

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
    @ManyToOne(fetch = FetchType.LAZY)
    @EntityFormat
    private Region region;

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @EntityFormat
    private Shipper shipper;

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
     * @return CustomerOrder
     */
    public CustomerOrder setId(Long id) {
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
     * @return CustomerOrder
     */
    public CustomerOrder setVersion(Integer version) {
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
     * @return CustomerOrder
     */
    public CustomerOrder setCity(City city) {
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
     * @return CustomerOrder
     */
    public CustomerOrder setCountry(Country country) {
        this.country = country;
        return this;
    }

    /**
     * Gets customer value
     *
     * @return Customer
     */
    public Customer getCustomer() {
        return this.customer;
    }

    /**
     * Sets customer value
     *
     * @param customer
     * @return CustomerOrder
     */
    public CustomerOrder setCustomer(Customer customer) {
        this.customer = customer;
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
     * @return CustomerOrder
     */
    public CustomerOrder setOrderDate(Calendar orderDate) {
        this.orderDate = orderDate;
        return this;
    }

    /**
     * Gets requiredDate value
     *
     * @return Calendar
     */
    public Calendar getRequiredDate() {
        return this.requiredDate;
    }

    /**
     * Sets requiredDate value
     *
     * @param requiredDate
     * @return CustomerOrder
     */
    public CustomerOrder setRequiredDate(Calendar requiredDate) {
        this.requiredDate = requiredDate;
        return this;
    }

    /**
     * Gets shippedDate value
     *
     * @return Calendar
     */
    public Calendar getShippedDate() {
        return this.shippedDate;
    }

    /**
     * Sets shippedDate value
     *
     * @param shippedDate
     * @return CustomerOrder
     */
    public CustomerOrder setShippedDate(Calendar shippedDate) {
        this.shippedDate = shippedDate;
        return this;
    }

    /**
     * Gets freight value
     *
     * @return BigDecimal
     */
    public BigDecimal getFreight() {
        return this.freight;
    }

    /**
     * Sets freight value
     *
     * @param freight
     * @return CustomerOrder
     */
    public CustomerOrder setFreight(BigDecimal freight) {
        this.freight = freight;
        return this;
    }

    /**
     * Gets shipName value
     *
     * @return String
     */
    public String getShipName() {
        return this.shipName;
    }

    /**
     * Sets shipName value
     *
     * @param shipName
     * @return CustomerOrder
     */
    public CustomerOrder setShipName(String shipName) {
        this.shipName = shipName;
        return this;
    }

    /**
     * Gets shipAddress value
     *
     * @return String
     */
    public String getShipAddress() {
        return this.shipAddress;
    }

    /**
     * Sets shipAddress value
     *
     * @param shipAddress
     * @return CustomerOrder
     */
    public CustomerOrder setShipAddress(String shipAddress) {
        this.shipAddress = shipAddress;
        return this;
    }

    /**
     * Gets shipPostalCode value
     *
     * @return String
     */
    public String getShipPostalCode() {
        return this.shipPostalCode;
    }

    /**
     * Sets shipPostalCode value
     *
     * @param shipPostalCode
     * @return CustomerOrder
     */
    public CustomerOrder setShipPostalCode(String shipPostalCode) {
        this.shipPostalCode = shipPostalCode;
        return this;
    }

    /**
     * Gets status value
     *
     * @return Status
     */
    public Status getStatus() {
        return this.status;
    }

    /**
     * Sets status value
     *
     * @param status
     * @return CustomerOrder
     */
    public CustomerOrder setStatus(Status status) {
        this.status = status;
        return this;
    }

    /**
     * Gets shipPhone value
     *
     * @return String
     */
    public String getShipPhone() {
        return this.shipPhone;
    }

    /**
     * Sets shipPhone value
     *
     * @param shipPhone
     * @return CustomerOrder
     */
    public CustomerOrder setShipPhone(String shipPhone) {
        this.shipPhone = shipPhone;
        return this;
    }

    /**
     * Gets invoiceDate value
     *
     * @return Calendar
     */
    public Calendar getInvoiceDate() {
        return this.invoiceDate;
    }

    /**
     * Sets invoiceDate value
     *
     * @param invoiceDate
     * @return CustomerOrder
     */
    public CustomerOrder setInvoiceDate(Calendar invoiceDate) {
        this.invoiceDate = invoiceDate;
        return this;
    }

    /**
     * Gets closeDate value
     *
     * @return Calendar
     */
    public Calendar getCloseDate() {
        return this.closeDate;
    }

    /**
     * Sets closeDate value
     *
     * @param closeDate
     * @return CustomerOrder
     */
    public CustomerOrder setCloseDate(Calendar closeDate) {
        this.closeDate = closeDate;
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
     * @return CustomerOrder
     */
    public CustomerOrder setOrderDetails(Set<OrderDetail> orderDetails) {
        this.orderDetails = orderDetails;
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
     * @return CustomerOrder
     */
    public CustomerOrder setEmployee(Employee employee) {
        this.employee = employee;
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
     * @return CustomerOrder
     */
    public CustomerOrder setRegion(Region region) {
        this.region = region;
        return this;
    }

    /**
     * Gets shipper value
     *
     * @return Shipper
     */
    public Shipper getShipper() {
        return this.shipper;
    }

    /**
     * Sets shipper value
     *
     * @param shipper
     * @return CustomerOrder
     */
    public CustomerOrder setShipper(Shipper shipper) {
        this.shipper = shipper;
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
        if (!(obj instanceof CustomerOrder)) {
            return false;
        }
        return getId() != null && Objects.equals(getId(), ((CustomerOrder) obj).getId());
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
        return "CustomerOrder {" + "id='" + id + '\'' + ", version='" + version + '\'' + ", orderDate='" + orderDate == null ? null : java.text.DateFormat.getDateTimeInstance().format(orderDate.getTime()) + '\'' + ", requiredDate='" + requiredDate == null ? null : java.text.DateFormat.getDateTimeInstance().format(requiredDate.getTime()) + '\'' + ", shippedDate='" + shippedDate == null ? null : java.text.DateFormat.getDateTimeInstance().format(shippedDate.getTime()) + '\'' + ", freight='" + freight + '\'' + ", shipName='" + shipName + '\'' + ", shipAddress='" + shipAddress + '\'' + ", shipPostalCode='" + shipPostalCode + '\'' + ", shipPhone='" + shipPhone + '\'' + ", invoiceDate='" + invoiceDate == null ? null : java.text.DateFormat.getDateTimeInstance().format(invoiceDate.getTime()) + '\'' + ", closeDate='" + closeDate == null ? null : java.text.DateFormat.getDateTimeInstance().format(closeDate.getTime()) + '\'' + "}" + super.toString();
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
            item.setCustomerOrder(this);
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
            item.setCustomerOrder(null);
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
