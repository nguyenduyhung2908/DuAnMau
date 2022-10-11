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
public class ManageOrder {
    private ManageCustomer customer;
    private ManageEmployee employee;
    private String code;
    private Date createdDate;
    private Date paidDate;
    private Date shipDate;
    private Date receivedDate;
    private int status;
    private String receiver;
    private String address;
    private String phone;

    public ManageOrder() {
    }

    public ManageOrder(ManageCustomer customer, ManageEmployee employee, String code, Date createdDate, Date paidDate, Date shipDate, Date receivedDate, int status, String receiver, String address, String phone) {
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

    public ManageCustomer getCustomer() {
        return customer;
    }

    public void setCustomer(ManageCustomer customer) {
        this.customer = customer;
    }

    public ManageEmployee getEmployee() {
        return employee;
    }

    public void setEmployee(ManageEmployee employee) {
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

    @Override
    public String toString() {
        return this.code;
    }
    
}
