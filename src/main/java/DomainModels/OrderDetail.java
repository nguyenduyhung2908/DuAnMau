/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DomainModels;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import org.hibernate.annotations.NamedQueries;
import org.hibernate.annotations.NamedQuery;
@NamedQueries({
    @NamedQuery(name = "OrderDetail.FIND_ALL", query = "SELECT od FROM OrderDetail od"),
    @NamedQuery(name = "OrderDetail.FIND_BY_ORDER_ID", query = "SELECT od FROM OrderDetail od WHERE od.id.order.id = :id")
})
/**
 *
 * @author Nguyen Duy Hung
 */
@Entity
@Table(name = "HoaDonChiTiet")
public class OrderDetail implements Serializable{
    @EmbeddedId
    private IdOrderDetail id;
    
    @Column(name = "SoLuong")
    private int quantity;
    
    @Column(name = "DonGia")
    private BigDecimal price;

    public OrderDetail() {
    }

    public OrderDetail(IdOrderDetail id, int quantity, BigDecimal price) {
        this.id = id;
        this.quantity = quantity;
        this.price = price;
    }

    public IdOrderDetail getId() {
        return id;
    }

    public void setId(IdOrderDetail id) {
        this.id = id;
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
