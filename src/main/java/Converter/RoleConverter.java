/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Converter;

import DomainModels.Role;
import ViewModels.ManageRole;

/**
 *
 * @author Nguyen Duy Hung
 */
public class RoleConverter {
    public Role toDomainModel(ManageRole viewModel){
        Role result = new Role();
        if(viewModel != null){
            if(viewModel.getId() != null) result.setId(viewModel.getId());
            result.setCode(viewModel.getCode());
            result.setName(viewModel.getName());
        }
        return result;
    }
    public ManageRole toViewModel(Role domainModel){
        if(domainModel!= null){
            ManageRole role = new ManageRole();
            role.setId(domainModel.getId());
            role.setName(domainModel.getName());
            role.setCode(domainModel.getCode());
            return role;
        }
        return null;
    }
}
