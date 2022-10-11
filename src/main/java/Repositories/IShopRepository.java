/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Repositories;

import DomainModels.Shop;
import java.util.List;

/**
 *
 * @author Nguyen Duy Hung
 */
public interface IShopRepository {
    List<Shop> findAll();
    String insert(Shop iShop);
    boolean update(Shop uShop);
    boolean delete(String[] codes);
}
