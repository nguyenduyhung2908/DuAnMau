/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Converter;

import DomainModels.Shop;
import ViewModels.ManageShop;

/**
 *
 * @author Nguyen Duy Hung
 */
public class ShopConverter {
    public ManageShop toViewModel(Shop domainModel){
        if(domainModel != null){
            ManageShop result = new ManageShop();
            result.setId(domainModel.getId());
            result.setAddress(domainModel.getAddress());
            result.setCity(domainModel.getCity());
            result.setCode(domainModel.getCode());
            result.setCountry(domainModel.getCountry());
            result.setName(domainModel.getName());
            return result;
        }
        return null;
    }
    
    public Shop toDomainModel(ManageShop viewModel){
        if(viewModel != null){
            Shop result = new Shop();
            if(viewModel.getId()!= null) result.setId(viewModel.getId());
            result.setAddress(viewModel.getAddress());
            result.setCity(viewModel.getCity());
            result.setCode(viewModel.getCode());
            result.setCountry(viewModel.getCountry());
            result.setName(viewModel.getName());
            return result;
        }
        return null;
    }
}
