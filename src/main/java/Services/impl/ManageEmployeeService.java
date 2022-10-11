/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Services.impl;

import Converter.EmployeeConverter;
import DomainModels.Employee;
import Repositories.IEmployeeRepository;
import Repositories.impl.EmployeeRepository;
import Services.IManageEmployeeService;
import ViewModels.ManageEmployee;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Nguyen Duy Hung
 */
public class ManageEmployeeService implements IManageEmployeeService{
    private final IEmployeeRepository employeeRepository;
    private final EmployeeConverter employeeConverter;
    public ManageEmployeeService() {
        this.employeeRepository = new EmployeeRepository();
        this.employeeConverter = new EmployeeConverter();
    }

    @Override
    public List<ManageEmployee> findAll() {
        List<ManageEmployee> listResult = new ArrayList<>();
        List<Employee> list = employeeRepository.findAll(0,0);
        for(Employee e : list){
            listResult.add(employeeConverter.toViewModel(e));
        }
        return listResult;
    }

    @Override
    public String insert(ManageEmployee eInsert) {
        Employee e = employeeConverter.toDomainModel(eInsert);
        if(eInsert.getLeader()!= null){
        String idLeader = this.employeeRepository.findByCode(eInsert.getLeader().getCode()).getId();
        if(e.getLeader() != null) e.getLeader().setId(idLeader);
        else e.setLeader(null);
        }
        return this.employeeRepository.insert(e);
    }

    @Override
    public boolean update(ManageEmployee eUpdate) {
        Employee e = employeeConverter.toDomainModel(eUpdate);
        if(eUpdate.getLeader() != null){
            String idLeader = this.employeeRepository.findByCode(eUpdate.getLeader().getCode()).getId();
            e.setId(employeeRepository.findByCode(eUpdate.getCode()).getId());
            if(e.getLeader() != null) e.getLeader().setId(idLeader);
        }
        return this.employeeRepository.update(e);
    }

    @Override
    public boolean delete(String[] codes) {
        return this.employeeRepository.delete(codes);
    }

    @Override
    public ManageEmployee findByCode(String code) {
        Employee e = this.employeeRepository.findByCode(code);
        return this.employeeConverter.toViewModel(e);
    }
    
}
