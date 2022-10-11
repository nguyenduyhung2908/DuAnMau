/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Repositories;

import DomainModels.Customer;
import java.util.List;

/**
 *
 * @author Nguyen Duy Hung
 */
public interface ICustomerRepository {
    List<Customer> findAll();
    String insert(Customer iCus);
    boolean update(Customer uCus);
    boolean delete(String[] codes);
    Customer findByCode(String code);
}
