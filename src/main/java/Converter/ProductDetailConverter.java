/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Converter;

import DomainModels.ProductDetail;
import ViewModels.ManageProductDetail;

/**
 *
 * @author Nguyen Duy Hung
 */
public class ProductDetailConverter {
    private final ColorConverter colorConverter;
    private final CategoryConverter categoryConverter;
    private final ProductConverter productConverter;
    private final ManufacturerConverter manufacturerConverter;
    public ProductDetailConverter() {
        colorConverter = new ColorConverter();
        categoryConverter = new CategoryConverter();
        productConverter = new ProductConverter();
        manufacturerConverter = new ManufacturerConverter();
    }
    
    public ProductDetail toDomainModel(ManageProductDetail viewModel){
        
        ProductDetail result = new ProductDetail();
        result.setCategory(categoryConverter.toDomainModel(viewModel.getManageCategory()));
        result.setColor(colorConverter.toDomainModel(viewModel.getManageColor()));
        result.setDecription(viewModel.getDecription());
        result.setId(viewModel.getId());
        result.setImportPrice(viewModel.getImportPrice());
        result.setManufacturer(manufacturerConverter.toDomainModel(viewModel.getManageManufacturer()));
        result.setPrice(viewModel.getPrice());
        result.setProduct(productConverter.toDomainModel(viewModel.getManageProduct()));
        result.setWarrantyYear(viewModel.getWarrantyYear());
        result.setQuantity(viewModel.getQuantity());
        return result;
    }
    public ManageProductDetail toViewModel(ProductDetail domainModel){
        
        ManageProductDetail result = new ManageProductDetail();
        result.setManageCategory(categoryConverter.toViewModel(domainModel.getCategory()));
        result.setManageColor(colorConverter.toViewModel(domainModel.getColor()));
        result.setDecription(domainModel.getDecription());
        result.setId(domainModel.getId());
        result.setImportPrice(domainModel.getImportPrice());
        result.setManageProduct(productConverter.toViewModel(domainModel.getProduct()));
        result.setPrice(domainModel.getPrice());
        result.setManageManufacturer(manufacturerConverter.toViewModel(domainModel.getManufacturer()));
        result.setWarrantyYear(domainModel.getWarrantyYear());
        result.setQuantity(domainModel.getQuantity());
        return result;
    }
}
