/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repositories.impl;

import DomainModels.ProductDetail;
import Repositories.IProductDetailRepository;
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
public class ProductDetailRepository implements IProductDetailRepository{

    @Override
    public List<ProductDetail> findAll() {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Transaction transaction = null;
        try(Session session = sessionFactory.openSession()){
            transaction = session.beginTransaction();
            List<ProductDetail> listResult = session.createNamedQuery("ProductDetail.FIND_ALL").list();
            transaction.commit();
            return listResult;
        }catch(Exception e){
            if(transaction != null) transaction.rollback();
        }
        return null;
    }

    @Override
    public String insert(ProductDetail iProductDetail) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Transaction transaction = null;
        try(Session session = sessionFactory.openSession()){
            transaction = session.beginTransaction();
            String inserted = (String) session.save("ChiTietSP",iProductDetail);
            transaction.commit();
            return inserted;
        }catch(Exception e){
            if(transaction != null) transaction.rollback();
        }
        return null;
    }

    @Override
    public boolean update(ProductDetail uProductDetail) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Transaction transaction = null;
        try(Session session = sessionFactory.openSession()){
            transaction = session.beginTransaction();
            session.update("ChiTietSP",uProductDetail);
            transaction.commit();
            return true;
        }catch(Exception e){
            if(transaction != null) transaction.rollback();
        }
        return false;
    }

    @Override
    public boolean delete(String[] ids) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Transaction transaction = null;
        try(Session session = sessionFactory.openSession()){
            transaction = session.beginTransaction();
            NativeQuery<ProductDetail> query = session.createNativeQuery("DELETE FROM ChiTietSP WHERE Id = :id");
            for(String id : ids){
                query.setParameter("id", id).executeUpdate();
            }
            transaction.commit();
            return true;
        }catch(Exception e){
            if(transaction != null) transaction.rollback();
        }
        return false;
    }

    @Override
    public ProductDetail findByProductCode(String pCode) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ProductDetail findById(String id) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Transaction transaction = null;
        try(Session session = sessionFactory.openSession()){
            transaction = session.beginTransaction();
            Query<ProductDetail> query = session.createNamedQuery("ProductDetail.FIND_BY_ID");
            List<ProductDetail> listResult = query.setParameter("id", id).list();
            transaction.commit();
            return listResult.isEmpty() ? null : listResult.get(0);
        }catch(Exception e){
            if(transaction != null) transaction.rollback();
        }
        return null;
    }
    
}
