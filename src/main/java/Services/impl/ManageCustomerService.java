/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Services.impl;

import Converter.CustomerConverter;
import DomainModels.Customer;
import Repositories.ICustomerRepository;
import Repositories.impl.CustomerRepository;
import Services.IManageCustomerService;
import ViewModels.ManageCustomer;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Nguyen Duy Hung
 */
public class ManageCustomerService implements IManageCustomerService {
    private final ICustomerRepository repository;
    private final CustomerConverter converter;

    public ManageCustomerService() {
        this.repository = new CustomerRepository();
        this.converter = new CustomerConverter();
    }

    @Override
    public List<ManageCustomer> findAll() {
        List<ManageCustomer> listResult = new ArrayList<>();
        var list = repository.findAll();
        for(Customer c : list){
            listResult.add(converter.toViewModel(c));
        }
        return listResult;
    }

    @Override
    public String insert(ManageCustomer iManageCus) {
        Customer customer = converter.toDomainModel(iManageCus);
        return this.repository.insert(customer);
    }

    @Override
    public boolean update(ManageCustomer uManageCus) {
        Customer customer = converter.toDomainModel(uManageCus);
        return this.repository.update(customer);
    }

    @Override
    public boolean delete(String[] codes) {
        return this.repository.delete(codes);
    }

    @Override
    public ManageCustomer findByCode(String code) {
        Customer customer = this.repository.findByCode(code);
        return converter.toViewModel(customer);
    }
    
}
