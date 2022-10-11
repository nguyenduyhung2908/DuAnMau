/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Services;

import ViewModels.ManageProductDetail;
import java.util.List;

/**
 *
 * @author Nguyen Duy Hung
 */
public interface IManageProductDetailService {
    List<ManageProductDetail> findAll();
    String insert(ManageProductDetail iManageProductDetail);
    boolean update(ManageProductDetail uManageProductDetail);
    boolean delete(String[] ids);
    ManageProductDetail findById(String id);
}
