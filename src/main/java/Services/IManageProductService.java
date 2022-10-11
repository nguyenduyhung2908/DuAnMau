/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import ViewModels.ManageProduct;
import java.util.List;

/**
 *
 * @author Phong
 */
public interface IManageProductService {
    List<ManageProduct> findAll();
    String insert(ManageProduct iManageProduct);
    boolean update(ManageProduct uManageProduct);
    boolean delete(String[] codes);
    ManageProduct findByCode(String code);
}
