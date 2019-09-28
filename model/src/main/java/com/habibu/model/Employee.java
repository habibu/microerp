package com.habibu.model;
import org.springframework.roo.addon.javabean.annotations.RooJavaBean;
import org.springframework.roo.addon.javabean.annotations.RooToString;
import org.springframework.roo.addon.jpa.annotations.entity.RooJpaEntity;
import java.math.BigDecimal;
import org.springframework.format.annotation.NumberFormat;
import org.springframework.roo.addon.ws.annotations.jaxb.RooJaxbEntity;
import io.springlets.format.EntityFormat;
import javax.persistence.Entity;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * = Employee
 *
 * TODO Auto-generated class documentation
 *
 */
@RooJavaBean
@RooToString
@RooJpaEntity
@RooJaxbEntity
@Entity
@EntityFormat
@XmlRootElement(name = "employee", namespace = "http://ws.habibu.com/")
public class Employee extends Party {

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
     * TODO Auto-generated method documentation
     *
     * @return String
     */
    public String toString() {
        return "Employee {" + "}" + super.toString();
    }
}
