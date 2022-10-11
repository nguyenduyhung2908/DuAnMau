/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repositories.impl;

import DomainModels.Category;
import DomainModels.OrderDetail;
import Repositories.IOrderDetailRepository;
import Utilities.HibernateUtil;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;

/**
 *
 * @author Nguyen Duy Hung
 */
public class OrderDetailRepository implements IOrderDetailRepository {

    @Override
    public List<OrderDetail> findAll() {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Transaction transaction = null;
        try(Session session = sessionFactory.openSession()){
            transaction = session.beginTransaction();
            Query<OrderDetail> query = session.createNamedQuery("OrderDetail.FIND_ALL");
            List<OrderDetail> category = query.list();
            transaction.commit();
            return category;
        }catch(Exception e){
            if(transaction!= null) transaction.rollback();
        }
        return null;
    }

    @Override
    public String insert(OrderDetail orderDetail) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Transaction transaction = null;
        try(Session session = sessionFactory.openSession()){
            transaction = session.beginTransaction();
            session.save(orderDetail);
            transaction.commit();
            return "success";
        }catch(Exception e){
            if(transaction!= null) transaction.rollback();
        }
        return null;
    }

    @Override
    public boolean update(OrderDetail orderDetail) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Transaction transaction = null;
        try(Session session = sessionFactory.openSession()){
            transaction = session.beginTransaction();
            session.update(orderDetail);
            transaction.commit();
            return true;
        }catch(Exception e){
            if(transaction!= null) transaction.rollback();
        }
        return false;
    }

    @Override
    public boolean delete(String id) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Transaction transaction = null;
        try(Session session = sessionFactory.openSession()){
            transaction = session.beginTransaction();
            String hql = "DELETE FROM HoaDonChiTiet WHERE IdHoaDon = :id";
            NativeQuery<OrderDetail> query = session.createNativeQuery(hql);
            int deleted = query.setParameter("id", id).executeUpdate();
            transaction.commit();
            return true;
        }catch(Exception e){
            if(transaction!= null) transaction.rollback();
        }
        return false;
    }

    @Override
    public OrderDetail findByOrderId(String id) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Transaction transaction = null;
        try(Session session = sessionFactory.openSession()){
            transaction = session.beginTransaction();
            Query<OrderDetail> query = session.createNamedQuery("OrderDetail.FIND_BY_ORDER_ID");
            List<OrderDetail> category = query.setParameter("id", id).list();
            transaction.commit();
            return category.isEmpty() ? null : category.get(0);
        }catch(Exception e){
            if(transaction!= null) transaction.rollback();
        }
        return null;
    }
    
}
