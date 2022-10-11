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
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.NamedQueries;
import org.hibernate.annotations.NamedQuery;
@NamedQueries(value ={
    @NamedQuery(name = "Customer.FIND_ALL", query = "SELECT c FROM Customer c"),
    @NamedQuery(name = "Customer.FIND_BY_CODE", query = "SELECT c FROM Customer c WHERE c.code = :code")
})
/**
 *
 * @author Nguyen Duy Hung
 */
@Entity
@Table(name = "KhachHang")
public class Customer implements Serializable{
    @Id
    @GenericGenerator(name = "generator", strategy = "guid")
    @GeneratedValue(generator = "generator")
    private String id;
    
    @Column(name = "Ma", unique = true)
    private String code;
    
    @Column(name = "Ten")
    private String firstName;
    
    @Column(name = "Ho")
    private String lastName;
    
    @Column(name = "TenDem")
    private String middleName;
    
    @Column(name = "NgaySinh")
    private Date dOB;
    
    @Column(name = "Sdt")
    private String phone;
    
    @Column(name = "DiaChi")
    private String address;
    
    @Column(name = "ThanhPho")
    private String city;
    
    @Column(name = "QuocGia")
    private String country;
    
    @Column(name = "MatKhau", nullable = false)
    private String password;

    public Customer(String id, String code, String firstName, String lastName, String middleName, Date dOB, String phone, String address, String city, String country, String password) {
        this.id = id;
        this.code = code;
        this.firstName = firstName;
        this.lastName = lastName;
        this.middleName = middleName;
        this.dOB = dOB;
        this.phone = phone;
        this.address = address;
        this.city = city;
        this.country = country;
        this.password = password;
    }

    public Customer() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public Date getdOB() {
        return dOB;
    }

    public void setdOB(Date dOB) {
        this.dOB = dOB;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    
}
