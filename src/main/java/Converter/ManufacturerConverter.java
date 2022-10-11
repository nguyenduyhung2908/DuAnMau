/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Converter;

import DomainModels.Manufacturer;
import ViewModels.ManageManufacturer;

/**
 *
 * @author Nguyen Duy Hung
 */
public class ManufacturerConverter {
    public Manufacturer toDomainModel(ManageManufacturer viewModel){
        Manufacturer result = new Manufacturer();
        if(viewModel != null){
            result.setCode(viewModel.getCode());
            result.setName(viewModel.getName());
        }
        return result;
    }
    public ManageManufacturer toViewModel(Manufacturer domainModel){
        ManageManufacturer result = new ManageManufacturer();
        if(domainModel != null){
            result.setCode(domainModel.getCode());
            result.setName(domainModel.getName());
        }
        return result;
    }
}
