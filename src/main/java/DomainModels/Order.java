/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DomainModels;

import java.io.Serializable;
import java.sql.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.NamedQueries;
import org.hibernate.annotations.NamedQuery;
@NamedQueries({
    @NamedQuery(name = "Order.FIND_ALL",query = "SELECT o FROM Order o"),
    @NamedQuery(name = "Order.FIND_BY_CODE",query = "SELECT o FROM Order o WHERE o.code = :code")
})
/**
 *
 * @author Nguyen Duy Hung
 */
@Entity
@Table(name = "HoaDon")
public class Order implements Serializable{
    
    @Id
    @GenericGenerator(name = "generator", strategy = "guid")
    @GeneratedValue(generator = "generator")
    private String id;
    
    @ManyToOne
    @JoinColumn(name = "IdKH")
    private Customer customer;
    
    @ManyToOne
    @JoinColumn(name = "IdNV")
    private Employee employee;
    
    @Column(name = "Ma")
    private String code;
    
    @Column(name = "NgayTao")
    private Date createdDate;
    
    @Column(name = "NgayThanhToan")
    private Date paidDate;
    
    @Column(name = "NgayShip")
    private Date shipDate;
    
    @Column(name = "NgayNhan")
    private Date receivedDate;
    
    @Column(name = "TinhTrang")
    private int status;
    
    @Column(name = "TenNguoiNhan")
    private String receiver;
    
    @Column(name = "DiaChi")
    private String address;
    
    @Column(name = "Sdt")
    private String phone;

    public Order() {
    }

    public Order(String id, Customer customer, Employee employee, String code, Date createdDate, Date paidDate, Date shipDate, Date receivedDate, int status, String receiver, String address, String phone) {
        this.id = id;
        this.customer = customer;
        this.employee = employee;
        this.code = code;
        this.createdDate = createdDate;
        this.paidDate = paidDate;
        this.shipDate = shipDate;
        this.receivedDate = receivedDate;
        this.status = status;
        this.receiver = receiver;
        this.address = address;
        this.phone = phone;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Date getPaidDate() {
        return paidDate;
    }

    public void setPaidDate(Date paidDate) {
        this.paidDate = paidDate;
    }

    public Date getShipDate() {
        return shipDate;
    }

    public void setShipDate(Date shipDate) {
        this.shipDate = shipDate;
    }

    public Date getReceivedDate() {
        return receivedDate;
    }

    public void setReceivedDate(Date receivedDate) {
        this.receivedDate = receivedDate;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getReceiver() {
        return receiver;
    }

    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
    
    
}
