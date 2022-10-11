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

/**
 *
 * @author Nguyen Duy Hung
 */
@Entity
@Table(name = "NhanVien")
public class Employee implements Serializable{
    
    @Id
    @GenericGenerator(name = "generator", strategy = "guid", parameters = {})
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
    
    @Column(name = "GioiTinh")
    private String gender;
    
    @Column(name = "NgaySinh")
    private Date dOB;
    
    @Column(name = "DiaChi")
    private String address;
    
    @Column(name = "Sdt")
    private String phone;
    
    @Column(name = "MatKhau")
    private String password;
    
    @ManyToOne
    @JoinColumn(name = "IdCH")
    private Shop shop;
    
    @ManyToOne
    @JoinColumn(name = "IdCV")
    private Role role;
    
    @ManyToOne
    @JoinColumn(name = "IdGuiBC")
    private Employee leader ;
    
    @Column(name = "TrangThai")
    private int status;

    public Employee(String id, String code, String firstName, String lastName, String middleName, String gender, Date dOB, String address, String phone, String password, Shop shop, Role role,Employee leader, int status) {
        this.id = id;
        this.code = code;
        this.firstName = firstName;
        this.lastName = lastName;
        this.middleName = middleName;
        this.gender = gender;
        this.dOB = dOB;
        this.address = address;
        this.phone = phone;
        this.password = password;
        this.shop = shop;
        this.role = role;
        this.leader = leader;
        this.status = status;
    }

    public Employee() {
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

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Date getdOB() {
        return dOB;
    }

    public void setdOB(Date dOB) {
        this.dOB = dOB;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Shop getShop() {
        return shop;
    }

    public void setShop(Shop shop) {
        this.shop = shop;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public Employee getLeader() {
        return leader;
    }

    public void setLeader(Employee leader) {
        this.leader = leader;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
    
}
