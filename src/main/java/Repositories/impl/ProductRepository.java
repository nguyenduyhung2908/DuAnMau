/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Repositories.impl;


import DomainModels.Product;
import Repositories.IProductRepository;
import Utilities.HibernateUtil;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;
/**
 *
 * @author PTPM
 */
public class ProductRepository implements IProductRepository {

    @Override
    public List<Product> findAll() {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Transaction transaction = null;
        try(Session session = sessionFactory.openSession()){
            transaction = session.beginTransaction();
            Query<Product> query = session.createNamedQuery("Product.FIND_ALL");
            List<Product> listResult = query.list();
            transaction.commit();
            return listResult;
        }catch(Exception e){
            if(transaction != null) transaction.rollback();
        }
        return null;
    }

    @Override
    public String insert(Product iProduct) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Transaction transaction = null;
        try(Session session = sessionFactory.openSession()){
            transaction = session.beginTransaction();
            String inserted = (String) session.save(iProduct);
            transaction.commit();
            return inserted;
        }catch(Exception e){
            if(transaction != null) transaction.rollback();
        }
        return null;
    }

    @Override
    public boolean delete(String[] codes) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Transaction transaction = null;
        try(Session session = sessionFactory.openSession()){
            transaction = session.beginTransaction();
            String hql = "DELETE FROM SanPham WHERE Ma = :code";
            NativeQuery<Product> query = session.createNativeQuery(hql);
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
    public boolean update(Product uProduct) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Transaction transaction = null;
        try(Session session = sessionFactory.openSession()){
            transaction = session.beginTransaction();
            String hql = "UPDATE SanPham SET Ten = :name WHERE Ma = :code";
            int updated = session.createNativeQuery(hql)
                    .setParameter("code", uProduct.getCode())
                    .setParameter("name", uProduct.getName())
                    .executeUpdate();
            transaction.commit();
            if(updated > 0) return true;
        }catch(Exception e){
            if(transaction != null) transaction.rollback();
            return false;
        }
        return false;
    }

    @Override
    public Product findByCode(String code) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Transaction transaction = null;
        try(Session session = sessionFactory.openSession()){
            transaction = session.beginTransaction();
            Query<Product> query = session.createNamedQuery("Product.FIND_BY_CODE");
            List<Product> listResult = query.setParameter("code", code).list();
            transaction.commit();
            return listResult.isEmpty() ? null : listResult.get(0);
        }catch(Exception e){
            if(transaction != null) transaction.rollback();
        }
        return null;
    }

    

}
