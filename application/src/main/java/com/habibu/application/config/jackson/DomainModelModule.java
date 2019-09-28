package com.habibu.application.config.jackson;
import org.springframework.roo.addon.web.mvc.controller.annotations.config.RooDomainModelModule;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.habibu.application.web.CategoryJsonMixin;
import com.habibu.application.web.CityJsonMixin;
import com.habibu.application.web.CountryJsonMixin;
import com.habibu.application.web.CustomerJsonMixin;
import com.habibu.application.web.CustomerOrderJsonMixin;
import com.habibu.application.web.EmployeeJsonMixin;
import com.habibu.application.web.OrderDetailJsonMixin;
import com.habibu.application.web.PartyJsonMixin;
import com.habibu.application.web.ProductJsonMixin;
import com.habibu.application.web.PurchaseOrderJsonMixin;
import com.habibu.application.web.RegionJsonMixin;
import com.habibu.application.web.ReportJsonMixin;
import com.habibu.application.web.ShipperJsonMixin;
import com.habibu.application.web.SoldProductJsonMixin;
import com.habibu.application.web.StoreJsonMixin;
import com.habibu.application.web.SupplierJsonMixin;
import com.habibu.model.Category;
import com.habibu.model.City;
import com.habibu.model.Country;
import com.habibu.model.Customer;
import com.habibu.model.CustomerOrder;
import com.habibu.model.Employee;
import com.habibu.model.OrderDetail;
import com.habibu.model.Party;
import com.habibu.model.Product;
import com.habibu.model.PurchaseOrder;
import com.habibu.model.Region;
import com.habibu.model.Report;
import com.habibu.model.Shipper;
import com.habibu.model.SoldProduct;
import com.habibu.model.Store;
import com.habibu.model.Supplier;
import org.springframework.boot.jackson.JsonComponent;

/**
 * = DomainModelModule
 *
 * TODO Auto-generated class documentation
 *
 */
@RooDomainModelModule
@JsonComponent
public class DomainModelModule extends SimpleModule {

    /**
     * TODO Auto-generated constructor documentation
     *
     */
    public DomainModelModule() {
        // Mixin registration
        setMixInAnnotation(Category.class, CategoryJsonMixin.class);
        setMixInAnnotation(City.class, CityJsonMixin.class);
        setMixInAnnotation(Country.class, CountryJsonMixin.class);
        setMixInAnnotation(Customer.class, CustomerJsonMixin.class);
        setMixInAnnotation(CustomerOrder.class, CustomerOrderJsonMixin.class);
        setMixInAnnotation(Employee.class, EmployeeJsonMixin.class);
        setMixInAnnotation(OrderDetail.class, OrderDetailJsonMixin.class);
        setMixInAnnotation(Party.class, PartyJsonMixin.class);
        setMixInAnnotation(Product.class, ProductJsonMixin.class);
        setMixInAnnotation(PurchaseOrder.class, PurchaseOrderJsonMixin.class);
        setMixInAnnotation(Region.class, RegionJsonMixin.class);
        setMixInAnnotation(Report.class, ReportJsonMixin.class);
        setMixInAnnotation(Shipper.class, ShipperJsonMixin.class);
        setMixInAnnotation(SoldProduct.class, SoldProductJsonMixin.class);
        setMixInAnnotation(Store.class, StoreJsonMixin.class);
        setMixInAnnotation(Supplier.class, SupplierJsonMixin.class);
    }
}
