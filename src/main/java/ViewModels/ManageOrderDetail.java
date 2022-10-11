/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ViewModels;

import java.math.BigDecimal;

/**
 *
 * @author Nguyen Duy Hung
 */
public class ManageOrderDetail {
    private ManageOrder order;
    private ManageProductDetail productDetail;
    private int quantity;
    private BigDecimal price;

    public ManageOrderDetail() {
    }

    public ManageOrderDetail(ManageOrder order, ManageProductDetail productDetail, int quantity, BigDecimal price) {
        this.order = order;
        this.productDetail = productDetail;
        this.quantity = quantity;
        this.price = price;
    }

    public ManageOrder getOrder() {
        return order;
    }

    public void setOrder(ManageOrder order) {
        this.order = order;
    }

    public ManageProductDetail getProductDetail() {
        return productDetail;
    }

    public void setProductDetail(ManageProductDetail productDetail) {
        this.productDetail = productDetail;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
    
    
}
