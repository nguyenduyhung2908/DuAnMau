/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Repositories;

import DomainModels.Role;
import java.util.List;

/**
 *
 * @author Nguyen Duy Hung
 */
public interface IRoleRepository {
    List<Role> findAll();
    String insert(Role iRole);
    boolean delete(String[] code);
    boolean update(Role uRole);
}
