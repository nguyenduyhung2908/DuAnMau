/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Converter;

import DomainModels.Color;
import ViewModels.ManageColor;

/**
 *
 * @author Nguyen Duy Hung
 */
public class ColorConverter {
    public Color toDomainModel(ManageColor viewModel){
        Color result = new Color();
        if(viewModel != null){
            result.setCode(viewModel.getCode());
            result.setName(viewModel.getName());
        }
        return result;
    }
    public ManageColor toViewModel(Color domainModel){
        ManageColor result = new ManageColor();
        if(domainModel != null){
            result.setCode(domainModel.getCode());
            result.setName(domainModel.getName());
        }
        return result;
    }
}
