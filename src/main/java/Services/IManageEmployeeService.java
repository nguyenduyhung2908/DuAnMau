/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Services;

import ViewModels.ManageEmployee;
import java.util.List;

/**
 *
 * @author Nguyen Duy Hung
 */
public interface IManageEmployeeService {
    List<ManageEmployee> findAll();
    String insert(ManageEmployee eInsert);
    boolean update(ManageEmployee uUpdate);
    boolean delete(String[] codes);
    ManageEmployee findByCode(String code);
}
