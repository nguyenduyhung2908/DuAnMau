/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ViewModels;

import java.sql.Date;

/**
 *
 * @author Nguyen Duy Hung
 */
public class ManageEmployee {
    private String code;
    private String firstName;
    private String lastName;
    private String middleName;
    private String gender;
    private Date dOB;
    private String address;
    private String phone;
    private String password;
    private ManageShop shop;
    private ManageRole role;
    private ManageEmployee leader;
    private int status;

    public ManageEmployee(String code, String firstName, String lastName, String middleName, String gender, Date dOB, String address, String phone, String password, ManageShop shop, ManageRole role, ManageEmployee leader, int status) {
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

    public ManageEmployee() {
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

    public ManageShop getManageShop() {
        return shop;
    }

    public void setManageShop(ManageShop shop) {
        this.shop = shop;
    }

    public ManageRole getManageRole() {
        return role;
    }

    public void setManageRole(ManageRole role) {
        this.role = role;
    }

    public ManageEmployee getLeader() {
        return leader;
    }

    public void setLeader(ManageEmployee leader) {
        this.leader = leader;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return new StringBuilder(this.lastName)
                .append(" ").append(this.middleName)
                .append(" ").append(this.firstName)
                .toString();
    }
    @Override
    public boolean equals(Object obj) {
        if(this.code.equals(((ManageEmployee) obj).getCode())) return true;
        return false;
    }
}
