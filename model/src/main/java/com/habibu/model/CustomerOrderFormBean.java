package com.habibu.model;
import org.springframework.roo.addon.dto.annotations.RooDTO;
import org.springframework.roo.addon.javabean.annotations.RooJavaBean;
import org.springframework.roo.addon.javabean.annotations.RooSerializable;
import org.springframework.format.annotation.NumberFormat;
import java.util.Calendar;
import org.springframework.format.annotation.DateTimeFormat;
import java.math.BigDecimal;
import io.springlets.format.EntityFormat;
import java.io.Serializable;

/**
 * = CustomerOrderFormBean
 *
 * TODO Auto-generated class documentation
 *
 */
@RooDTO
@RooJavaBean
@RooSerializable
@EntityFormat
public class CustomerOrderFormBean implements Serializable {

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    @NumberFormat
    private Long orderId;

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    @NumberFormat
    private Long employeeId;

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    @NumberFormat
    private Long customerId;

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    @DateTimeFormat(style = "M-")
    private Calendar orderDate;

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    private String employeeName;

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    private String customerCompanyName;

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    private Status status;

    /**
     * TODO Auto-generated attribute documentation
     *
     */
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
    private static final long serialVersionUID = 1L;

    /**
     * Gets orderId value
     *
     * @return Long
     */
    public Long getOrderId() {
        return this.orderId;
    }

    /**
     * Sets orderId value
     *
     * @param orderId
     * @return CustomerOrderFormBean
     */
    public CustomerOrderFormBean setOrderId(Long orderId) {
        this.orderId = orderId;
        return this;
    }

    /**
     * Gets employeeId value
     *
     * @return Long
     */
    public Long getEmployeeId() {
        return this.employeeId;
    }

    /**
     * Sets employeeId value
     *
     * @param employeeId
     * @return CustomerOrderFormBean
     */
    public CustomerOrderFormBean setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
        return this;
    }

    /**
     * Gets customerId value
     *
     * @return Long
     */
    public Long getCustomerId() {
        return this.customerId;
    }

    /**
     * Sets customerId value
     *
     * @param customerId
     * @return CustomerOrderFormBean
     */
    public CustomerOrderFormBean setCustomerId(Long customerId) {
        this.customerId = customerId;
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
     * @return CustomerOrderFormBean
     */
    public CustomerOrderFormBean setOrderDate(Calendar orderDate) {
        this.orderDate = orderDate;
        return this;
    }

    /**
     * Gets employeeName value
     *
     * @return String
     */
    public String getEmployeeName() {
        return this.employeeName;
    }

    /**
     * Sets employeeName value
     *
     * @param employeeName
     * @return CustomerOrderFormBean
     */
    public CustomerOrderFormBean setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
        return this;
    }

    /**
     * Gets customerCompanyName value
     *
     * @return String
     */
    public String getCustomerCompanyName() {
        return this.customerCompanyName;
    }

    /**
     * Sets customerCompanyName value
     *
     * @param customerCompanyName
     * @return CustomerOrderFormBean
     */
    public CustomerOrderFormBean setCustomerCompanyName(String customerCompanyName) {
        this.customerCompanyName = customerCompanyName;
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
     * @return CustomerOrderFormBean
     */
    public CustomerOrderFormBean setStatus(Status status) {
        this.status = status;
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
     * @return CustomerOrderFormBean
     */
    public CustomerOrderFormBean setShippedDate(Calendar shippedDate) {
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
     * @return CustomerOrderFormBean
     */
    public CustomerOrderFormBean setFreight(BigDecimal freight) {
        this.freight = freight;
        return this;
    }
}
