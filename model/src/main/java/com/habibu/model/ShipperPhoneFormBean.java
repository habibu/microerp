package com.habibu.model;
import org.springframework.roo.addon.dto.annotations.RooDTO;
import org.springframework.roo.addon.javabean.annotations.RooJavaBean;
import io.springlets.format.EntityFormat;

/**
 * = ShipperPhoneFormBean
 *
 * TODO Auto-generated class documentation
 *
 */
@RooDTO
@RooJavaBean
@EntityFormat
public class ShipperPhoneFormBean {

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    private String phone;

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
     * @return ShipperPhoneFormBean
     */
    public ShipperPhoneFormBean setPhone(String phone) {
        this.phone = phone;
        return this;
    }
}
