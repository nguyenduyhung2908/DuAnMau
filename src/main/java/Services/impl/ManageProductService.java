/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services.impl;

import Converter.ProductConverter;
import DomainModels.Product;
import Repositories.IProductRepository;
import Repositories.impl.ProductRepository;
import Services.IManageProductService;
import ViewModels.ManageProduct;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Phong
 */
public class ManageProductService implements IManageProductService {

  private final IProductRepository productRepository;
  private final ProductConverter productConverter;
    public ManageProductService() {
        this.productRepository = new ProductRepository();
        productConverter = new ProductConverter();
    }

    @Override
    public List<ManageProduct> findAll() {
        List<ManageProduct> listResult = new ArrayList<>();
        List<Product> list = productRepository.findAll();
        for(Product p : list){
            listResult.add(productConverter.toViewModel(p));
        }
        return listResult;
    }

    @Override
    public String insert(ManageProduct iManageProduct) {
        Product product = productConverter.toDomainModel(iManageProduct);
        return this.productRepository.insert(product);
    }

    @Override
    public boolean update(ManageProduct uManageProduct) {
        Product product = productConverter.toDomainModel(uManageProduct);
        return this.productRepository.update(product);
    }

    @Override
    public boolean delete(String[] codes) {
        return this.productRepository.delete(codes);
    }

    @Override
    public ManageProduct findByCode(String code) {
        Product product = productRepository.findByCode(code);
        return this.productConverter.toViewModel(product);
    }
}
