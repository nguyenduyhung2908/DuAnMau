/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repositories.impl;

import DomainModels.Order;
import Repositories.IOrderRepository;
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
public class OrderRepository implements IOrderRepository {

    @Override
    public List<Order> findAll() {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Transaction transaction = null;
        try(Session session = sessionFactory.openSession()){
            transaction = session.beginTransaction();
            Query<Order> query = session.createNamedQuery("Order.FIND_ALL");
            List<Order> listResult = query.list();
            transaction.commit();
            return listResult;
        }catch(Exception e){
            if(transaction != null) transaction.rollback();
        }
        return null;
    }

    @Override
    public String insert(Order iOrder) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Transaction transaction = null;
        try(Session session = sessionFactory.openSession()){
            transaction = session.beginTransaction();
            String inserted = (String) session.save(iOrder);
            transaction.commit();
            return inserted;
        }catch(Exception e){
            if(transaction != null) transaction.rollback();
        }
        return null;
    }

    @Override
    public boolean update(Order uOrder) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Transaction transaction = null;
        try(Session session = sessionFactory.openSession()){
            transaction = session.beginTransaction();
             session.update(uOrder);
            transaction.commit();
            return true;
        }catch(Exception e){
            if(transaction != null) transaction.rollback();
        }
        return false;
    }

    @Override
    public boolean delete(String[] codes) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Transaction transaction = null;
        try(Session session = sessionFactory.openSession()){
            transaction = session.beginTransaction();
            String hql = "DELETE FROM HoaDon WHERE Ma = :code";
            NativeQuery<Order> query = session.createNativeQuery(hql);
            int deleted = 0;
            for(String code : codes){
               deleted = query.setParameter("code", code).executeUpdate();
            }
            transaction.commit();
            if(deleted >0 )return true;
        }catch(Exception e){
            if(transaction != null) transaction.rollback();
            return false;
        }
        return false;
    }

    @Override
    public Order findByCode(String code) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Transaction transaction = null;
        try(Session session = sessionFactory.openSession()){
            transaction = session.beginTransaction();
            Query<Order> query = session.createNamedQuery("Order.FIND_BY_CODE");
            List<Order> listResult = query.setParameter("code", code).list();
            transaction.commit();
            return listResult.isEmpty() ? null : listResult.get(0);
        }catch(Exception e){
            if(transaction != null) transaction.rollback();
        }
        return null;
    }
    
}
