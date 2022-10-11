/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Converter;

import DomainModels.Employee;
import ViewModels.ManageEmployee;

/**
 *
 * @author Nguyen Duy Hung
 */
public class EmployeeConverter {
    
    private ShopConverter sc;
    private RoleConverter rc;

    public EmployeeConverter() {
        sc = new ShopConverter();
        rc = new RoleConverter();
    }
    
    public ManageEmployee toViewModel(Employee domainModel){
        
        if(domainModel != null){
            ManageEmployee result = new ManageEmployee();
            result.setAddress(domainModel.getAddress());
            result.setCode(domainModel.getCode());
            result.setFirstName(domainModel.getFirstName());
            result.setGender(domainModel.getGender());
            result.setLastName(domainModel.getLastName());
            result.setMiddleName(domainModel.getMiddleName());
            result.setPassword(domainModel.getPassword());
            result.setPhone(domainModel.getPhone());
            result.setManageRole(rc.toViewModel(domainModel.getRole()));
            result.setManageShop(sc.toViewModel(domainModel.getShop()));
            result.setStatus(domainModel.getStatus());
            result.setdOB(domainModel.getdOB());
            result.setLeader(this.toViewModel(domainModel.getLeader()));
            return result;
        }else{
            return null;
            
        }
    }
    public Employee toDomainModel(ManageEmployee viewModel){
        
        if(viewModel != null){
        Employee result = new Employee();
        result.setAddress(viewModel.getAddress());
        result.setCode(viewModel.getCode());
        result.setFirstName(viewModel.getFirstName());
        result.setGender(viewModel.getGender());
        result.setLastName(viewModel.getLastName());
        result.setMiddleName(viewModel.getMiddleName());
        result.setPassword(viewModel.getPassword());
        result.setPhone(viewModel.getPhone());
        result.setRole(rc.toDomainModel(viewModel.getManageRole()));
        result.setShop(sc.toDomainModel(viewModel.getManageShop()));
        result.setStatus(viewModel.getStatus());
        result.setdOB(viewModel.getdOB());
        if(viewModel.getLeader() != null){
            if(!viewModel.getLeader().getManageRole().getName().equalsIgnoreCase("quan ly"))
            result.setLeader(this.toDomainModel(viewModel.getLeader()));
            else result.setLeader(null);
        }
        else 
            result.setLeader(null);
        return result;
        }else{
            return null;
        }
        
    }
}
