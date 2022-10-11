/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Converter;

import DomainModels.Category;
import ViewModels.ManageCategory;

/**
 *
 * @author Nguyen Duy Hung
 */
public class CategoryConverter {
    public Category toDomainModel(ManageCategory viewModel){
        Category result = new Category();
        if(viewModel != null){
            result.setCode(viewModel.getCode());
            result.setName(viewModel.getName());
        }
        return result;
    }
    
    public ManageCategory toViewModel(Category domainModel){
        ManageCategory result = new ManageCategory();
        if(domainModel != null){
            result.setCode(domainModel.getCode());
            result.setName(domainModel.getName());       
        }
        return result;
    }
}
