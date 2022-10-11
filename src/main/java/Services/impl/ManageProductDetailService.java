/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Services.impl;

import Converter.ProductDetailConverter;
import DomainModels.Category;
import DomainModels.Color;
import DomainModels.Manufacturer;
import DomainModels.Product;
import DomainModels.ProductDetail;
import Repositories.ICategoryRepository;
import Repositories.IColorRepository;
import Repositories.IManufacturerRepository;
import Repositories.IProductDetailRepository;
import Repositories.IProductRepository;
import Repositories.impl.CategoryRepository;
import Repositories.impl.ColorRepository;
import Repositories.impl.ManufacturerRepository;
import Repositories.impl.ProductDetailRepository;
import Repositories.impl.ProductRepository;
import Services.IManageProductDetailService;
import ViewModels.ManageProductDetail;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Nguyen Duy Hung
 */
public class ManageProductDetailService implements IManageProductDetailService {
    private final IProductDetailRepository productDetailRepository;
    private final ProductDetailConverter converter;
    private final ICategoryRepository categoryRepository;
    private final IManufacturerRepository manufacturerRepository;
    private final IProductRepository productRepository;
    private final IColorRepository colorRepository;

    public ManageProductDetailService() {
        this.productDetailRepository = new  ProductDetailRepository();
        this.converter = new ProductDetailConverter();
        categoryRepository  = new CategoryRepository();
        manufacturerRepository = new ManufacturerRepository();
        productRepository = new ProductRepository();
        colorRepository = new ColorRepository();
    }

    @Override
    public List<ManageProductDetail> findAll() {
        List<ManageProductDetail> listResult = new ArrayList<>();
        List<ProductDetail> list = this.productDetailRepository.findAll();
        for(ProductDetail pd : list){
            listResult.add(converter.toViewModel(pd));
        }
        return listResult;
     }

    @Override
    public String insert(ManageProductDetail iManageProductDetail) {
        ProductDetail pd = this.converter.toDomainModel(iManageProductDetail);
        Category c = this.categoryRepository.findByCode(pd.getCategory().getCode());
        Product p = this.productRepository.findByCode(pd.getProduct().getCode());
        Manufacturer m = this.manufacturerRepository.findByCode(pd.getManufacturer().getCode());
        Color color = this.colorRepository.findByCode(pd.getColor().getCode());
        pd.getCategory().setId(c.getId());
        pd.getManufacturer().setId(m.getId());
        pd.getProduct().setId(p.getId());
        pd.getColor().setId(color.getId());
        return this.productDetailRepository.insert(pd);
    }

    @Override
    public boolean update(ManageProductDetail uManageProductDetail) {
        ProductDetail pd = this.converter.toDomainModel(uManageProductDetail);
        Category c = this.categoryRepository.findByCode(pd.getCategory().getCode());
        Product p = this.productRepository.findByCode(pd.getProduct().getCode());
        Manufacturer m = this.manufacturerRepository.findByCode(pd.getManufacturer().getCode());
        Color color = this.colorRepository.findByCode(pd.getColor().getCode());
        pd.getCategory().setId(c.getId());
        pd.getManufacturer().setId(m.getId());
        pd.getProduct().setId(p.getId());
        pd.getColor().setId(color.getId());
        return this.productDetailRepository.update(pd);
    }

    @Override
    public boolean delete(String[] ids) {
        return this.productDetailRepository.delete(ids);
    }

    @Override
    public ManageProductDetail findById(String id) {
        return this.converter.toViewModel(this.productDetailRepository.findById(id));
    }
    
    
}
