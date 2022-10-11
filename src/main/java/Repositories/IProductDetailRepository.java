/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Repositories;

import DomainModels.ProductDetail;
import java.util.List;

/**
 *
 * @author Nguyen Duy Hung
 */
public interface IProductDetailRepository {
    List<ProductDetail> findAll();
    String insert(ProductDetail iProductDetail);
    boolean update(ProductDetail uProductDetail);
    boolean delete(String[] id);
    ProductDetail findByProductCode(String pCode);
    ProductDetail findById(String id);
}
