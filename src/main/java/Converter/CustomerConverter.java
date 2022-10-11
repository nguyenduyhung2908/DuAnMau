/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Converter;

import DomainModels.Customer;
import ViewModels.ManageCustomer;

/**
 *
 * @author Nguyen Duy Hung
 */
public class CustomerConverter {
    public Customer toDomainModel(ManageCustomer viewModel){
        Customer result = new Customer();
        if(viewModel != null){
            result.setAddress(viewModel.getAddress());
            result.setCity(viewModel.getCity());
            result.setCode(viewModel.getCode());
            result.setCountry(viewModel.getCountry());
            result.setFirstName(viewModel.getFirstName());
            result.setLastName(viewModel.getLastName());
            result.setMiddleName(viewModel.getMiddleName());
            result.setPassword(viewModel.getPassword());
            result.setPhone(viewModel.getPhone());
            result.setdOB(viewModel.getdOB());
            return result;
        }
        return null;
    }
    public ManageCustomer toViewModel(Customer domainModel){
        ManageCustomer result = new ManageCustomer();
        if(domainModel != null){
            result.setAddress(domainModel.getAddress());
            result.setCity(domainModel.getCity());
            result.setCode(domainModel.getCode());
            result.setCountry(domainModel.getCountry());
            result.setFirstName(domainModel.getFirstName());
            result.setLastName(domainModel.getLastName());
            result.setMiddleName(domainModel.getMiddleName());
            result.setPassword(domainModel.getPassword());
            result.setPhone(domainModel.getPhone());
            result.setdOB(domainModel.getdOB());
            return result;
        }
        return null;
    }
}
