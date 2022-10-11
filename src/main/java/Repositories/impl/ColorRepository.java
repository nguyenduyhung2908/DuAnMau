/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repositories.impl;

import DomainModels.Color;
import DomainModels.Product;
import Repositories.IColorRepository;
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
public class ColorRepository implements IColorRepository{

    @Override
    public List<Color> findAll() {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Transaction transaction = null;
        try(Session session = sessionFactory.openSession()){
            transaction = session.beginTransaction();
            Query<Color> query = session.createNamedQuery("Color.FIND_ALL");
            List<Color> listResult = query.list();
            transaction.commit();
            return listResult;
        }catch(Exception e){
            if(transaction != null) transaction.rollback();
        }
        return null;
    }

    @Override
    public String insert(Color iColor) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Transaction transaction = null;
        try(Session session = sessionFactory.openSession()){
            transaction = session.beginTransaction();
            String inserted = (String) session.save(iColor);
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
            String hql = "DELETE FROM MauSac WHERE Ma = :code";
            NativeQuery<Color> query = session.createNativeQuery(hql);
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
    public boolean update(Color uColor) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Transaction transaction = null;
        try(Session session = sessionFactory.openSession()){
            transaction = session.beginTransaction();
            String hql = "UPDATE MauSac SET Ten = :name WHERE Ma = :code";
            int updated = session.createNativeQuery(hql)
                    .setParameter("code", uColor.getCode())
                    .setParameter("name", uColor.getName())
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
    public Color findByCode(String code) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Transaction transaction = null;
        try(Session session = sessionFactory.openSession()){
            transaction = session.beginTransaction();
            Query<Color> query = session.createNamedQuery("Color.FIND_BY_CODE");
            List<Color> listResult = query.setParameter("code", code).list();
            transaction.commit();
            return listResult.isEmpty() ? null : listResult.get(0);
        }catch(Exception e){
            if(transaction != null) transaction.rollback();
        }
        return null;
    }
    
}
