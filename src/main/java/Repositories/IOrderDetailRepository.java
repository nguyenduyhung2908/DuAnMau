/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Repositories;

import DomainModels.OrderDetail;
import java.util.List;

/**
 *
 * @author Nguyen Duy Hung
 */
public interface IOrderDetailRepository {
    List<OrderDetail> findAll();
    String insert(OrderDetail orderDetail);
    boolean update(OrderDetail orderDetail);
    boolean delete(String id);
    OrderDetail findByOrderId(String id);
}
