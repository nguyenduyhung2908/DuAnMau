/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Repositories;

import DomainModels.Employee;
import DomainModels.Role;
import java.util.List;

/**
 *
 * @author Nguyen Duy Hung
 */
public interface IEmployeeRepository {
    List<Employee> findAll(Integer offset, Integer limit);
    String insert(Employee eInsert);
    boolean update(Employee eUpdate);
    boolean delete(String[] codes);
    Employee findByCode(String code);
    int count();
    List<Employee> findAllLeader(Role role);
}
