/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Converter;

import DomainModels.Product;
import ViewModels.ManageProduct;

/**
 *
 * @author Nguyen Duy Hung
 */
public class ProductConverter {
    public Product toDomainModel(ManageProduct viewModel){
        Product result = new Product();
        if(viewModel != null){
            result.setCode(viewModel.getCode());
            result.setName(viewModel.getName());
        }
        return result;
    }
    public ManageProduct toViewModel(Product domainModel){
        ManageProduct result = new ManageProduct();
        if(domainModel != null){
            result.setCode(domainModel.getCode());
            result.setName(domainModel.getName());
        }
        return result;
    }
}
