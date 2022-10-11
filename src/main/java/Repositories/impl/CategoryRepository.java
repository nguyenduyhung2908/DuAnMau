/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Repositories.impl;


import DomainModels.Category;
import Repositories.ICategoryRepository;
import Utilities.HibernateUtil;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

/**
 *
 * @author PTPM
 */
public class CategoryRepository implements ICategoryRepository {

    @Override
    public List<Category> findAll() {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Transaction transaction = null;
        try(Session session = sessionFactory.openSession()){
            transaction = session.beginTransaction();
            Query<Category> query = session.createNamedQuery("FIND_ALL");
            List<Category> category = query.list();
            transaction.commit();
            return category;
        }catch(Exception e){
            if(transaction!= null) transaction.rollback();
        }
        return null;
    }

    @Override
    public String insert(Category iCategory) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Transaction transaction = null;
        try(Session session = sessionFactory.openSession()){
            transaction = session.beginTransaction();
            String id = (String)session.save(iCategory);
            transaction.commit();
            return id;
        }catch(Exception e){
            if(transaction!= null) transaction.rollback();
        }
        return null;
    }

    @Override
    public boolean update(Category uCategory) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Transaction transaction = null;
        try(Session session = sessionFactory.openSession()){
            transaction = session.beginTransaction();
            String hql = "UPDATE DongSP SET Ten = :name WHERE Ma = :code";
            int updated = session.createNativeQuery(hql)
                          .setParameter("name", uCategory.getName())
                          .setParameter("code", uCategory.getCode())
                          .executeUpdate();
            transaction.commit();
            if(updated > 0) return true;
        }catch(Exception e){
            if(transaction!= null) transaction.rollback();
            return false;
        }
        return false;
    }

    @Override
    public boolean delete(String[] codes) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Transaction transaction = null;
        try(Session session = sessionFactory.openSession()){
            transaction = session.beginTransaction();
            String hql = "DELETE FROM DongSP WHERE Ma = :code";
            Query query = session.createNativeQuery(hql);
            int deleted = 0;
            for(String code : codes){
                deleted = query.setParameter("code", code).executeUpdate();
            }
            transaction.commit();
            if(deleted > 0) return true;
        }catch(Exception e){
            if(transaction!= null) transaction.rollback();
            return false;
        }
        return false;
    }

    @Override
    public Category findByCode(String code) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Transaction transaction = null;
        try(Session session = sessionFactory.openSession()){
            transaction = session.beginTransaction();
            Query<Category> query = session.createNamedQuery("FIND_BY_CODE");
            List<Category> listResult = query.setParameter("code", code).list();
            transaction.commit();
            return listResult.isEmpty() ? null : listResult.get(0);
        }catch(Exception e){
            if(transaction!= null) transaction.rollback();
        }
        return null;
    }

}
