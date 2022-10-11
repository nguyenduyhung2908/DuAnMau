/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Services;

import ViewModels.ManageOrder;
import java.util.List;

/**
 *
 * @author Nguyen Duy Hung
 */
public interface IManageOrderSevice {
    List<ManageOrder> findAll();
    String insert(ManageOrder iOrder);
    boolean update(ManageOrder uOrder);
    boolean delete(String[] codes);
    ManageOrder findByCode(String code);
}
