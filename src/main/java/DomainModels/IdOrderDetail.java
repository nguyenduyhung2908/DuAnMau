/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DomainModels;

import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 *
 * @author Nguyen Duy Hung
 */
@Embeddable
public class IdOrderDetail implements Serializable {
    
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "IdHoaDon")
    private Order order;
    
    @ManyToOne
    @JoinColumn(name = "IdChiTietSP")
    private ProductDetail productDetail;

    public IdOrderDetail() {
    }

    public IdOrderDetail(Order order, ProductDetail productDetail) {
        this.order = order;
        this.productDetail = productDetail;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public ProductDetail getProductDetail() {
        return productDetail;
    }

    public void setProductDetail(ProductDetail productDetail) {
        this.productDetail = productDetail;
    }
    
    
}
