/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Services;

import ViewModels.ManageColor;
import java.util.List;

/**
 *
 * @author Nguyen Duy Hung
 */
public interface IManageColorService {
    List<ManageColor> findAll();
    String insert(ManageColor iManageColor);
    boolean update(ManageColor uManageColor);
    boolean delete(String[] codes);
    ManageColor findByCode(String code);
}
