/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Services;

import ViewModels.ManageManufacturer;
import java.util.List;

/**
 *
 * @author Nguyen Duy Hung
 */
public interface IManageManufacturerService {
    List<ManageManufacturer> findAll();
    String insert(ManageManufacturer iManageManufacturer);
    boolean update(ManageManufacturer uManageManufacturer);
    boolean delete(String[] codes);
    ManageManufacturer findByCode(String code);
}
