/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Repositories;


import DomainModels.Product;
import DomainModels.Product;
import java.util.List;

/**
 *
 * @author Phong
 */
public interface IProductRepository {
    
    List<Product> findAll();
    String insert(Product iProduct);
    boolean delete(String[] codes);
    boolean update(Product uProduct);
    Product findByCode(String code);
}
