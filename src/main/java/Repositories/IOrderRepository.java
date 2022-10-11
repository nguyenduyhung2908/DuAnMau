/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Repositories;

import DomainModels.Order;
import java.util.List;

/**
 *
 * @author Nguyen Duy Hung
 */
public interface IOrderRepository {
    List<Order> findAll();
    String insert(Order iOrder);
    boolean update(Order uOrder);
    boolean delete(String[] codes);
    Order findByCode(String code);
}
