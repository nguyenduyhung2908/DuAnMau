/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Services.impl;

import Converter.ColorConverter;
import DomainModels.Color;
import Repositories.IColorRepository;
import Repositories.impl.ColorRepository;
import Services.IManageColorService;
import ViewModels.ManageColor;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Nguyen Duy Hung
 */
public class ManageColorService implements IManageColorService {
    private final IColorRepository colorRepository;
    private final ColorConverter colorConverter;

    public ManageColorService() {
        this.colorRepository = new ColorRepository();
        this.colorConverter = new ColorConverter();
    }
    
    @Override
    public List<ManageColor> findAll() {
        List<ManageColor> listResult = new ArrayList<>();
        List<Color> list = this.colorRepository.findAll();
        for(Color m : list){
            listResult.add(colorConverter.toViewModel(m));
        }
        return listResult;
    }

    @Override
    public String insert(ManageColor iManageColor) {
        Color color = colorConverter.toDomainModel(iManageColor);
        return this.colorRepository.insert(color);
    }

    @Override
    public boolean update(ManageColor uManageColor) {
        Color color = this.colorConverter.toDomainModel(uManageColor);
        return this.colorRepository.update(color);
    }

    @Override
    public boolean delete(String[] codes) {
        return this.colorRepository.delete(codes);
    }

    @Override
    public ManageColor findByCode(String code) {
        Color color = this.colorRepository.findByCode(code);
        return this.colorConverter.toViewModel(color);
    }
}
