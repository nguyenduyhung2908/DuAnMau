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
public class ManageCustomer {
    private String code;
    private String firstName;
    private String lastName;
    private String middleName;
    private Date dOB;
    private String phone;
    private String address;
    private String city;
    private String country;
    private String password;

    public ManageCustomer(String code, String firstName, String lastName, String middleName, Date dOB, String phone, String address, String city, String country, String password) {
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

    public ManageCustomer() {
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

    @Override
    public String toString() {
        return new StringBuilder(this.lastName)
                .append(" ").append(this.middleName)
                .append(" ").append(this.firstName)
                .toString();
    }

    @Override
    public boolean equals(Object obj) {
        if(this.code.equals(((ManageCustomer) obj).getCode())) return true;
        return false;
    }
    
    
}
