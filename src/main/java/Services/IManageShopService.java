/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Services;

import ViewModels.ManageShop;
import java.util.List;

/**
 *
 * @author Nguyen Duy Hung
 */
public interface IManageShopService {
    List<ManageShop> findAll();
    String insert(ManageShop iShop);
    boolean update(ManageShop uShop);
    boolean delete(String[] codes);
}
