/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Services.impl;

import Converter.ManufacturerConverter;
import DomainModels.Manufacturer;
import Repositories.IManufacturerRepository;
import Repositories.impl.ManufacturerRepository;
import Services.IManageManufacturerService;
import ViewModels.ManageManufacturer;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Nguyen Duy Hung
 */
public class ManageManufacturerService implements IManageManufacturerService{
    private final IManufacturerRepository manufacturerRepository;
    private final ManufacturerConverter manufacturerConverter;

    public ManageManufacturerService() {
        this.manufacturerRepository = new ManufacturerRepository();
        this.manufacturerConverter = new ManufacturerConverter();
    }
    
    @Override
    public List<ManageManufacturer> findAll() {
        List<ManageManufacturer> listResult = new ArrayList<>();
        List<Manufacturer> list = this.manufacturerRepository.findAll();
        for(Manufacturer m : list){
            listResult.add(manufacturerConverter.toViewModel(m));
        }
        return listResult;
    }

    @Override
    public String insert(ManageManufacturer iManageManufacturer) {
        Manufacturer manufacturer = manufacturerConverter.toDomainModel(iManageManufacturer);
        return this.manufacturerRepository.insert(manufacturer);
    }

    @Override
    public boolean update(ManageManufacturer uManageManufacturer) {
        Manufacturer manufacturer = this.manufacturerConverter.toDomainModel(uManageManufacturer);
        return this.manufacturerRepository.update(manufacturer);
    }

    @Override
    public boolean delete(String[] codes) {
        return this.manufacturerRepository.delete(codes);
    }

    @Override
    public ManageManufacturer findByCode(String code) {
        Manufacturer manufacturer = this.manufacturerRepository.findByCode(code);
        return this.manufacturerConverter.toViewModel(manufacturer);
    }
    
}
