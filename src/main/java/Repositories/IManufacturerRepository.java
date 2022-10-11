/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Repositories;

import DomainModels.Manufacturer;
import java.util.List;

/**
 *
 * @author Nguyen Duy Hung
 */
public interface IManufacturerRepository {
    List<Manufacturer> findAll();
    String insert(Manufacturer iManufacturer);
    boolean delete(String[] codes);
    boolean update(Manufacturer uManufacturer);
    Manufacturer findByCode(String code);
}
