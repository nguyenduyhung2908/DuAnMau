/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Converter;

import DomainModels.Order;
import ViewModels.ManageOrder;

/**
 *
 * @author Nguyen Duy Hung
 */
public class OrderConverter {
    private final CustomerConverter customerConverter;
    private final EmployeeConverter employeeConverter;

    public OrderConverter() {
        this.customerConverter = new CustomerConverter();
        this.employeeConverter = new EmployeeConverter();
    }
    
    public Order toDomainModel(ManageOrder viewModel){
        if(viewModel != null){
            Order result = new Order();
            result.setAddress(viewModel.getAddress());
            result.setCode(viewModel.getCode());
            result.setCreatedDate(viewModel.getCreatedDate());
            result.setCustomer(this.customerConverter.toDomainModel(viewModel.getCustomer()));
            result.setEmployee(this.employeeConverter.toDomainModel(viewModel.getEmployee()));
            result.setPaidDate(viewModel.getPaidDate());
            result.setPhone(viewModel.getPhone());
            result.setReceivedDate(viewModel.getReceivedDate());
            result.setReceiver(viewModel.getReceiver());
            result.setShipDate(viewModel.getShipDate());
            result.setStatus(viewModel.getStatus());
            return result;
        }
        return null;
    }
    public ManageOrder toViewModel(Order domainModel){
        if(domainModel != null){
            ManageOrder result = new ManageOrder();
            result.setAddress(domainModel.getAddress());
            result.setCode(domainModel.getCode());
            result.setCreatedDate(domainModel.getCreatedDate());
            result.setCustomer(this.customerConverter.toViewModel(domainModel.getCustomer()));
            result.setEmployee(this.employeeConverter.toViewModel(domainModel.getEmployee()));
            result.setPaidDate(domainModel.getPaidDate());
            result.setPhone(domainModel.getPhone());
            result.setReceivedDate(domainModel.getReceivedDate());
            result.setReceiver(domainModel.getReceiver());
            result.setShipDate(domainModel.getShipDate());
            result.setStatus(domainModel.getStatus());
            return result;
        }
        return null;
    }
}
