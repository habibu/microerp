package com.habibu.service.impl;
import com.habibu.service.api.ProductService;
import org.springframework.roo.addon.layers.service.annotations.RooServiceImpl;
import com.habibu.model.Category;
import com.habibu.model.OrderDetail;
import com.habibu.model.Product;
import com.habibu.model.PurchaseOrder;
import com.habibu.model.Supplier;
import com.habibu.repository.ProductRepository;
import com.habibu.service.api.OrderDetailService;
import com.habibu.service.api.PurchaseOrderService;
import io.springlets.data.domain.GlobalSearch;
import io.springlets.data.web.validation.MessageI18n;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * = ProductServiceImpl
 *
 * TODO Auto-generated class documentation
 *
 */
@RooServiceImpl(service = ProductService.class)
@Service
@Transactional(readOnly = true)
public class ProductServiceImpl implements ProductService {

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    private PurchaseOrderService purchaseOrderService;

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    private ProductRepository productRepository;

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    private OrderDetailService orderDetailService;

    /**
     * TODO Auto-generated constructor documentation
     *
     * @param productRepository
     * @param orderDetailService
     * @param purchaseOrderService
     */
    @Autowired
    public ProductServiceImpl(ProductRepository productRepository, @Lazy OrderDetailService orderDetailService, @Lazy PurchaseOrderService purchaseOrderService) {
        setProductRepository(productRepository);
        setOrderDetailService(orderDetailService);
        setPurchaseOrderService(purchaseOrderService);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @return ProductRepository
     */
    public ProductRepository getProductRepository() {
        return productRepository;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param productRepository
     */
    public void setProductRepository(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @return OrderDetailService
     */
    public OrderDetailService getOrderDetailService() {
        return orderDetailService;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param orderDetailService
     */
    public void setOrderDetailService(OrderDetailService orderDetailService) {
        this.orderDetailService = orderDetailService;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @return PurchaseOrderService
     */
    public PurchaseOrderService getPurchaseOrderService() {
        return purchaseOrderService;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param purchaseOrderService
     */
    public void setPurchaseOrderService(PurchaseOrderService purchaseOrderService) {
        this.purchaseOrderService = purchaseOrderService;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param product
     * @return Map
     */
    public Map<String, List<MessageI18n>> validate(Product product) {
        Map<String, List<MessageI18n>> messages = new java.util.HashMap<String, List<MessageI18n>>();
        // TODO: IMPLEMENT HERE THE VALIDATION OF YOUR ENTITY
        return messages;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param product
     * @param orderDetailsToAdd
     * @return Product
     */
    @Transactional
    public Product addToOrderDetails(Product product, Iterable<Long> orderDetailsToAdd) {
        List<OrderDetail> orderDetails = getOrderDetailService().findAll(orderDetailsToAdd);
        product.addToOrderDetails(orderDetails);
        return getProductRepository().save(product);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param product
     * @param purchaseOrdersToAdd
     * @return Product
     */
    @Transactional
    public Product addToPurchaseOrders(Product product, Iterable<Long> purchaseOrdersToAdd) {
        List<PurchaseOrder> purchaseOrders = getPurchaseOrderService().findAll(purchaseOrdersToAdd);
        product.addToPurchaseOrders(purchaseOrders);
        return getProductRepository().save(product);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param product
     * @param orderDetailsToRemove
     * @return Product
     */
    @Transactional
    public Product removeFromOrderDetails(Product product, Iterable<Long> orderDetailsToRemove) {
        List<OrderDetail> orderDetails = getOrderDetailService().findAll(orderDetailsToRemove);
        product.removeFromOrderDetails(orderDetails);
        return getProductRepository().save(product);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param product
     * @param purchaseOrdersToRemove
     * @return Product
     */
    @Transactional
    public Product removeFromPurchaseOrders(Product product, Iterable<Long> purchaseOrdersToRemove) {
        List<PurchaseOrder> purchaseOrders = getPurchaseOrderService().findAll(purchaseOrdersToRemove);
        product.removeFromPurchaseOrders(purchaseOrders);
        return getProductRepository().save(product);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param product
     * @param orderDetails
     * @return Product
     */
    @Transactional
    public Product setOrderDetails(Product product, Iterable<Long> orderDetails) {
        List<OrderDetail> items = getOrderDetailService().findAll(orderDetails);
        Set<OrderDetail> currents = product.getOrderDetails();
        Set<OrderDetail> toRemove = new HashSet<OrderDetail>();
        for (Iterator<OrderDetail> iterator = currents.iterator(); iterator.hasNext(); ) {
            OrderDetail nextOrderDetail = iterator.next();
            if (items.contains(nextOrderDetail)) {
                items.remove(nextOrderDetail);
            } else {
                toRemove.add(nextOrderDetail);
            }
        }
        product.removeFromOrderDetails(toRemove);
        product.addToOrderDetails(items);
        // Force the version update of the parent side to know that the parent has changed
        // because it has new books assigned
        product.setVersion(product.getVersion() + 1);
        return getProductRepository().save(product);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param product
     * @param purchaseOrders
     * @return Product
     */
    @Transactional
    public Product setPurchaseOrders(Product product, Iterable<Long> purchaseOrders) {
        List<PurchaseOrder> items = getPurchaseOrderService().findAll(purchaseOrders);
        Set<PurchaseOrder> currents = product.getPurchaseOrders();
        Set<PurchaseOrder> toRemove = new HashSet<PurchaseOrder>();
        for (Iterator<PurchaseOrder> iterator = currents.iterator(); iterator.hasNext(); ) {
            PurchaseOrder nextPurchaseOrder = iterator.next();
            if (items.contains(nextPurchaseOrder)) {
                items.remove(nextPurchaseOrder);
            } else {
                toRemove.add(nextPurchaseOrder);
            }
        }
        product.removeFromPurchaseOrders(toRemove);
        product.addToPurchaseOrders(items);
        // Force the version update of the parent side to know that the parent has changed
        // because it has new books assigned
        product.setVersion(product.getVersion() + 1);
        return getProductRepository().save(product);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param product
     */
    @Transactional
    public void delete(Product product) {
        // Clear bidirectional many-to-one child relationship with Supplier
        if (product.getSupplier() != null) {
            product.getSupplier().getProducts().remove(product);
        }
        // Clear bidirectional many-to-one child relationship with Category
        if (product.getCategory() != null) {
            product.getCategory().getProducts().remove(product);
        }
        // Clear bidirectional one-to-many parent relationship with OrderDetail
        for (OrderDetail item : product.getOrderDetails()) {
            item.setProduct(null);
        }
        // Clear bidirectional one-to-many parent relationship with PurchaseOrder
        for (PurchaseOrder item : product.getPurchaseOrders()) {
            item.setProduct(null);
        }
        getProductRepository().delete(product);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param entities
     * @return List
     */
    @Transactional
    public List<Product> save(Iterable<Product> entities) {
        return getProductRepository().save(entities);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param ids
     */
    @Transactional
    public void delete(Iterable<Long> ids) {
        List<Product> toDelete = getProductRepository().findAll(ids);
        getProductRepository().deleteInBatch(toDelete);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param entity
     * @return Product
     */
    @Transactional
    public Product save(Product entity) {
        return getProductRepository().save(entity);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param id
     * @return Product
     */
    public Product findOne(Long id) {
        return getProductRepository().findOne(id);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param id
     * @return Product
     */
    public Product findOneForUpdate(Long id) {
        return getProductRepository().findOneDetached(id);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param ids
     * @return List
     */
    public List<Product> findAll(Iterable<Long> ids) {
        return getProductRepository().findAll(ids);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @return List
     */
    public List<Product> findAll() {
        return getProductRepository().findAll();
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @return Long
     */
    public long count() {
        return getProductRepository().count();
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param globalSearch
     * @param pageable
     * @return Page
     */
    public Page<Product> findAll(GlobalSearch globalSearch, Pageable pageable) {
        return getProductRepository().findAll(globalSearch, pageable);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param ids
     * @param globalSearch
     * @param pageable
     * @return Page
     */
    public Page<Product> findAllByIdsIn(List<Long> ids, GlobalSearch globalSearch, Pageable pageable) {
        return getProductRepository().findAllByIdsIn(ids, globalSearch, pageable);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param category
     * @param globalSearch
     * @param pageable
     * @return Page
     */
    public Page<Product> findByCategory(Category category, GlobalSearch globalSearch, Pageable pageable) {
        return getProductRepository().findByCategory(category, globalSearch, pageable);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param supplier
     * @param globalSearch
     * @param pageable
     * @return Page
     */
    public Page<Product> findBySupplier(Supplier supplier, GlobalSearch globalSearch, Pageable pageable) {
        return getProductRepository().findBySupplier(supplier, globalSearch, pageable);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param category
     * @return Long
     */
    public long countByCategory(Category category) {
        return getProductRepository().countByCategory(category);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param supplier
     * @return Long
     */
    public long countBySupplier(Supplier supplier) {
        return getProductRepository().countBySupplier(supplier);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param discontinued
     * @param pageable
     * @return Page
     */
    public Page<Product> findByDiscontinuedOrderByNameAsc(Boolean discontinued, Pageable pageable) {
        return getProductRepository().findByDiscontinuedOrderByNameAsc(discontinued, pageable);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param discontinued
     * @return Long
     */
    public long countByDiscontinuedOrderByNameAsc(Boolean discontinued) {
        return getProductRepository().countByDiscontinuedOrderByNameAsc(discontinued);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @return Class
     */
    public Class<Product> getEntityType() {
        return Product.class;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @return Class
     */
    public Class<Long> getIdType() {
        return Long.class;
    }
}
