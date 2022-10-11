/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Repositories;

import DomainModels.Color;
import java.util.List;

/**
 *
 * @author Nguyen Duy Hung
 */
public interface IColorRepository {
    List<Color> findAll();
    String insert(Color iColor);
    boolean delete(String[] codes);
    boolean update(Color uColor);
    Color findByCode(String code);
}
