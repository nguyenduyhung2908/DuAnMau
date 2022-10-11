/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Services.impl;

import Converter.OrderConverter;
import DomainModels.Order;
import Repositories.ICustomerRepository;
import Repositories.IEmployeeRepository;
import Repositories.IOrderRepository;
import Repositories.impl.CustomerRepository;
import Repositories.impl.EmployeeRepository;
import Repositories.impl.OrderRepository;
import Services.IManageOrderSevice;
import ViewModels.ManageOrder;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Nguyen Duy Hung
 */
public class ManageOrderService implements IManageOrderSevice {
    private final IOrderRepository orderRepository;
    private final ICustomerRepository customerRepository;
    private final IEmployeeRepository employeeRepository;
    private final OrderConverter orderConverter;
    public ManageOrderService() {
        this.orderRepository = new OrderRepository();
        this.customerRepository = new CustomerRepository();
        this.employeeRepository = new EmployeeRepository();
        this.orderConverter = new OrderConverter();
    }
    
    
    @Override
    public List<ManageOrder> findAll() {
        List<ManageOrder> listResult = new ArrayList<>();
        List<Order> list = this.orderRepository.findAll();
        for(Order o : list){
            listResult.add(this.orderConverter.toViewModel(o));
        }
        return listResult;
    }

    @Override
    public String insert(ManageOrder iOrder) {
        Order order = this.orderConverter.toDomainModel(iOrder);
        if(iOrder.getCustomer() != null){
            String idCustomer = this.customerRepository.findByCode(iOrder.getCustomer().getCode()).getId();
            order.getCustomer().setId(idCustomer);
        }
        if(iOrder.getEmployee() != null){
            String idEmployee = this.employeeRepository.findByCode(iOrder.getEmployee().getCode()).getId();
            order.getEmployee().setId(idEmployee);
        }
        return this.orderRepository.insert(order);
    }

    @Override
    public boolean update(ManageOrder uOrder) {
        Order order = this.orderConverter.toDomainModel(uOrder);
        if(order.getCustomer() != null){
            String idCustomer = this.customerRepository.findByCode(order.getCustomer().getCode()).getId();
            order.getCustomer().setId(idCustomer);
        }
        if(order.getEmployee() != null){
            String idEmployee = this.employeeRepository.findByCode(order.getEmployee().getCode()).getId();
            order.getEmployee().setId(idEmployee);
        }
        order.setId(this.orderRepository.findByCode(order.getCode()).getId());
        return this.orderRepository.update(order);
    }

    @Override
    public boolean delete(String[] codes) {
        return this.orderRepository.delete(codes);
    }

    @Override
    public ManageOrder findByCode(String code) {
        Order order = this.orderRepository.findByCode(code);
        return this.orderConverter.toViewModel(order);
    }
    
}
