/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services.impl;


import Converter.CategoryConverter;
import DomainModels.Category;
import Repositories.impl.CategoryRepository;
import Repositories.ICategoryRepository;
import Services.IManageCategoryService;
import ViewModels.ManageCategory;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Phong
 */
public class ManageCategoryService implements IManageCategoryService {

    private final ICategoryRepository repository;
    private final CategoryConverter converter;
    public ManageCategoryService() {
        repository = new CategoryRepository();
        converter = new CategoryConverter();
    }


    @Override
    public List<ManageCategory> findAll() {
        List<Category> list = this.repository.findAll();
        List<ManageCategory> listResult = new ArrayList<>();
        for(Category c : list){
            listResult.add(converter.toViewModel(c));
        }
        return listResult;
    }

    @Override
    public String insert(ManageCategory iCategory) {
        Category category = converter.toDomainModel(iCategory);
        return this.repository.insert(category);
    }

    @Override
    public boolean update(ManageCategory uCategory) {
        Category category = converter.toDomainModel(uCategory);
        return this.repository.update(category);
    }

    @Override
    public boolean delete(String[] codes) {
        return this.repository.delete(codes);
    }

    @Override
    public ManageCategory findByCode(String code) {
        return converter.toViewModel(this.repository.findByCode(code));
    }
    
}
