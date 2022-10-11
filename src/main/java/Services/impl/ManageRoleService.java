/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Services.impl;

import Converter.RoleConverter;
import DomainModels.Role;
import Repositories.IRoleRepository;
import Repositories.impl.RoleRepository;
import Services.IManageRoleService;
import ViewModels.ManageRole;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Nguyen Duy Hung
 */
public class ManageRoleService implements IManageRoleService {
    
    private final IRoleRepository roleRepository;
    private final RoleConverter roleConverter;
    public ManageRoleService() {
        roleConverter = new RoleConverter();
        roleRepository = new RoleRepository();
    }
    
    
    @Override
    public List<ManageRole> findAll() {
        List<ManageRole> listResult = new ArrayList<>();
        var listRole = roleRepository.findAll();
        for(Role role : listRole){
            listResult.add(roleConverter.toViewModel(role));
        }
        return listResult;
    }

    @Override
    public String insert(ManageRole iRole) {
        Role role = roleConverter.toDomainModel(iRole);
        return this.roleRepository.insert(role);
    }

    @Override
    public boolean update(ManageRole uRole) {
        Role role = roleConverter.toDomainModel(uRole);
        return this.roleRepository.update(role);
    }

    @Override
    public boolean delete(String[] codes) {
        return this.roleRepository.delete(codes);
    }
    
}
