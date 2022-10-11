/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Services.impl;

import Converter.OrderDetailConverter;
import DomainModels.OrderDetail;
import Repositories.IOrderDetailRepository;
import Repositories.IOrderRepository;
import Repositories.IProductDetailRepository;
import Repositories.impl.OrderDetailRepository;
import Repositories.impl.OrderRepository;
import Repositories.impl.ProductDetailRepository;
import Services.IManageOrderDetailService;
import ViewModels.ManageOrder;
import ViewModels.ManageOrderDetail;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Nguyen Duy Hung
 */
public class ManageOrderDetailService implements IManageOrderDetailService {
    private final IOrderDetailRepository orderDetailRepository;
    private final IProductDetailRepository productDetailRepository;
    private final IOrderRepository orderRepository;
    private final OrderDetailConverter orderDetailConverter;

    public ManageOrderDetailService() {
        this.orderDetailRepository = new OrderDetailRepository();
        this.orderDetailConverter = new OrderDetailConverter();
        this.orderRepository = new OrderRepository();
        this.productDetailRepository = new ProductDetailRepository();
    }
    
    @Override
    public List<ManageOrderDetail> findAll() {
        List<ManageOrderDetail> listResult = new ArrayList<>();
        List<OrderDetail> list = this.orderDetailRepository.findAll();
        for(OrderDetail o : list){
            listResult.add(orderDetailConverter.toViewModel(o));
        }
        return listResult;
    }

    @Override
    public String insert(ManageOrderDetail order) {
        OrderDetail iOrder = this.orderDetailConverter.toDomainModel(order);
        String idOrder = this.orderRepository.findByCode(order.getOrder().getCode()).getId();
        
        iOrder.getId().getOrder().setId(idOrder);
        iOrder.getId().getProductDetail().setId(order.getProductDetail().getId());
        return this.orderDetailRepository.insert(iOrder);    
    }

    @Override
    public boolean update(ManageOrderDetail order) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean delete(String code) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
