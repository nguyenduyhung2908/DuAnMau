/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Services;

import ViewModels.ManageCustomer;
import java.util.List;

/**
 *
 * @author Nguyen Duy Hung
 */
public interface IManageCustomerService {
    List<ManageCustomer> findAll();
    String insert(ManageCustomer iManageCus);
    boolean update(ManageCustomer uManageCus);
    boolean delete(String[] codes);
    ManageCustomer findByCode(String code);
}
