/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Converter;

import DomainModels.IdOrderDetail;
import DomainModels.OrderDetail;
import ViewModels.ManageOrderDetail;

/**
 *
 * @author Nguyen Duy Hung
 */
public class OrderDetailConverter {
    private final OrderConverter orderConverter;
    private final ProductDetailConverter productDetailConverter;

    public OrderDetailConverter() {
        this.orderConverter = new OrderConverter();
        this.productDetailConverter = new ProductDetailConverter();
    }
    
    public OrderDetail toDomainModel(ManageOrderDetail viewModel){
        if(viewModel != null){
            OrderDetail result = new OrderDetail();
            IdOrderDetail id = new IdOrderDetail();
            id.setOrder(orderConverter.toDomainModel(viewModel.getOrder()));
            id.setProductDetail(productDetailConverter.toDomainModel(viewModel.getProductDetail()));
            result.setId(id);
            result.setPrice(viewModel.getPrice());
            result.setQuantity(viewModel.getQuantity());
            return result;
        }
        return null;
    }
    
    public ManageOrderDetail toViewModel(OrderDetail domainModel){
        if(domainModel != null){
            ManageOrderDetail result = new ManageOrderDetail();
            result.setOrder(orderConverter.toViewModel(domainModel.getId().getOrder()));
            result.setProductDetail(productDetailConverter.toViewModel(domainModel.getId().getProductDetail()));
            result.setPrice(domainModel.getPrice());
            result.setQuantity(domainModel.getQuantity());
            return result;
        }
        return null;
    }
}
