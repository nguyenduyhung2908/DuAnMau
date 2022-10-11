/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Services;

import ViewModels.ManageRole;
import java.util.List;

/**
 *
 * @author Nguyen Duy Hung
 */
public interface IManageRoleService {
    List<ManageRole> findAll();
    String insert(ManageRole iRole);
    boolean update(ManageRole uRole);
    boolean delete(String[] codes);
}
