/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Services;

import ViewModels.ManageOrderDetail;
import java.util.List;

/**
 *
 * @author Nguyen Duy Hung
 */
public interface IManageOrderDetailService {
    List<ManageOrderDetail> findAll();
    String insert(ManageOrderDetail order);
    boolean update(ManageOrderDetail order);
    boolean delete(String code);
    
}
