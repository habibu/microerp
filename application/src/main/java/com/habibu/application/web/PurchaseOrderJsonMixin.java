package com.habibu.application.web;
import com.habibu.model.PurchaseOrder;
import org.springframework.roo.addon.web.mvc.controller.annotations.config.RooJsonMixin;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.habibu.model.Employee;
import com.habibu.model.Product;

/**
 * = PurchaseOrderJsonMixin
 *
 * TODO Auto-generated class documentation
 *
 */
@RooJsonMixin(entity = PurchaseOrder.class)
public abstract class PurchaseOrderJsonMixin {

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    @JsonDeserialize(using = ProductDeserializer.class)
    private Product product;

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    @JsonDeserialize(using = EmployeeDeserializer.class)
    private Employee employee;

    /**
     * TODO Auto-generated method documentation
     *
     * @return Employee
     */
    public Employee getEmployee() {
        return employee;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param employee
     */
    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @return Product
     */
    public Product getProduct() {
        return product;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param product
     */
    public void setProduct(Product product) {
        this.product = product;
    }
}
