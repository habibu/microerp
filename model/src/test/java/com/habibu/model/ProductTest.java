package com.habibu.model;
import org.springframework.roo.addon.jpa.annotations.test.RooJpaUnitTest;
import com.habibu.model.dod.OrderDetailFactory;
import com.habibu.model.dod.ProductFactory;
import com.habibu.model.dod.PurchaseOrderFactory;
import java.util.Arrays;
import java.util.Collections;
import static org.assertj.core.api.Assertions.assertThat;
import org.junit.Test;

/**
 * = ProductTest
 *
 * TODO Auto-generated class documentation
 *
 */
@RooJpaUnitTest(targetClass = Product.class)
public class ProductTest {

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    private PurchaseOrderFactory purchaseOrderFactory = new PurchaseOrderFactory();

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    private OrderDetailFactory orderDetailFactory = new OrderDetailFactory();

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    private ProductFactory productFactory = new ProductFactory();

    /**
     * TODO Auto-generated method documentation
     *
     * @return OrderDetailFactory
     */
    public OrderDetailFactory getOrderDetailFactory() {
        return orderDetailFactory;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param orderDetailFactory
     */
    public void setOrderDetailFactory(OrderDetailFactory orderDetailFactory) {
        this.orderDetailFactory = orderDetailFactory;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @return ProductFactory
     */
    public ProductFactory getProductFactory() {
        return productFactory;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param productFactory
     */
    public void setProductFactory(ProductFactory productFactory) {
        this.productFactory = productFactory;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @return PurchaseOrderFactory
     */
    public PurchaseOrderFactory getPurchaseOrderFactory() {
        return purchaseOrderFactory;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param purchaseOrderFactory
     */
    public void setPurchaseOrderFactory(PurchaseOrderFactory purchaseOrderFactory) {
        this.purchaseOrderFactory = purchaseOrderFactory;
    }

    /**
     * TODO Auto-generated method documentation
     *
     */
    @Test
    public void addToOrderDetailsShouldAddTheOrderDetailToTheorderDetailsRelationship() {
        // Setup
        Product product = getProductFactory().create(0);
        OrderDetail orderDetail1 = getOrderDetailFactory().create(0);
        OrderDetail orderDetail2 = getOrderDetailFactory().create(1);
        // Exercise
        product.addToOrderDetails(Arrays.asList(orderDetail1, orderDetail2));
        // Verify
        assertThat(product.getOrderDetails()).as("Check 'addToOrderDetails' adds the orderDetails to the relationship").contains(orderDetail1).contains(orderDetail2);
        assertThat(product).as("Check 'addToOrderDetails' updates the OrderDetail relationship side").isEqualTo(orderDetail1.getProduct()).isEqualTo(orderDetail2.getProduct());
    }

    /**
     * TODO Auto-generated method documentation
     *
     */
    @Test
    public void addToOrderDetailsShouldRemoveTheOrderDetailFromTheorderDetailsRelationship() {
        // Setup
        Product product = getProductFactory().create(0);
        OrderDetail orderDetail1 = getOrderDetailFactory().create(0);
        OrderDetail orderDetail2 = getOrderDetailFactory().create(1);
        product.addToOrderDetails(Arrays.asList(orderDetail1, orderDetail2));
        // Exercise
        product.removeFromOrderDetails(Collections.singleton(orderDetail1));
        // Verify
        assertThat(orderDetail1.getProduct()).as("Check 'removeFromOrderDetails' updates the OrderDetail relationship side").isNull();
        assertThat(product.getOrderDetails()).as("Check 'removeFromOrderDetails' removes a OrderDetail from the relationship").doesNotContain(orderDetail1).contains(orderDetail2);
    }

    /**
     * TODO Auto-generated method documentation
     *
     */
    @Test
    public void addToPurchaseOrdersShouldAddThePurchaseOrderToThepurchaseOrdersRelationship() {
        // Setup
        Product product = getProductFactory().create(0);
        PurchaseOrder purchaseOrder1 = getPurchaseOrderFactory().create(0);
        PurchaseOrder purchaseOrder2 = getPurchaseOrderFactory().create(1);
        // Exercise
        product.addToPurchaseOrders(Arrays.asList(purchaseOrder1, purchaseOrder2));
        // Verify
        assertThat(product.getPurchaseOrders()).as("Check 'addToPurchaseOrders' adds the purchaseOrders to the relationship").contains(purchaseOrder1).contains(purchaseOrder2);
        assertThat(product).as("Check 'addToPurchaseOrders' updates the PurchaseOrder relationship side").isEqualTo(purchaseOrder1.getProduct()).isEqualTo(purchaseOrder2.getProduct());
    }

    /**
     * TODO Auto-generated method documentation
     *
     */
    @Test
    public void addToPurchaseOrdersShouldRemoveThePurchaseOrderFromThepurchaseOrdersRelationship() {
        // Setup
        Product product = getProductFactory().create(0);
        PurchaseOrder purchaseOrder1 = getPurchaseOrderFactory().create(0);
        PurchaseOrder purchaseOrder2 = getPurchaseOrderFactory().create(1);
        product.addToPurchaseOrders(Arrays.asList(purchaseOrder1, purchaseOrder2));
        // Exercise
        product.removeFromPurchaseOrders(Collections.singleton(purchaseOrder1));
        // Verify
        assertThat(purchaseOrder1.getProduct()).as("Check 'removeFromPurchaseOrders' updates the PurchaseOrder relationship side").isNull();
        assertThat(product.getPurchaseOrders()).as("Check 'removeFromPurchaseOrders' removes a PurchaseOrder from the relationship").doesNotContain(purchaseOrder1).contains(purchaseOrder2);
    }
}
