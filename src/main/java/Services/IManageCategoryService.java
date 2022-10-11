/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import ViewModels.ManageCategory;
import java.util.List;

/**
 *
 * @author Phong
 */
public interface IManageCategoryService {
    
    List<ManageCategory> findAll();
    String insert(ManageCategory iCategory);
    boolean update(ManageCategory uCategory);
    boolean delete(String[]codes);
    ManageCategory findByCode(String code);
}
