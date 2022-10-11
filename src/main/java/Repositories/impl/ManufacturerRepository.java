/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repositories.impl;

import DomainModels.Color;
import DomainModels.Manufacturer;
import DomainModels.Product;
import Repositories.IManufacturerRepository;
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
public class ManufacturerRepository implements IManufacturerRepository{

    @Override
    public List<Manufacturer> findAll() {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Transaction transaction = null;
        try(Session session = sessionFactory.openSession()){
            transaction = session.beginTransaction();
            Query<Manufacturer> query = session.createNamedQuery("Manufacturer.FIND_ALL");
            List<Manufacturer> listResult = query.list();
            transaction.commit();
            return listResult;
        }catch(Exception e){
            if(transaction != null) transaction.rollback();
        }
        return null;
    }

    @Override
    public String insert(Manufacturer iManufacturer) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Transaction transaction = null;
        try(Session session = sessionFactory.openSession()){
            transaction = session.beginTransaction();
            String inserted = (String) session.save(iManufacturer);
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
            String hql = "DELETE FROM NSX WHERE Ma = :code";
            NativeQuery<Manufacturer> query = session.createNativeQuery(hql);
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
    public boolean update(Manufacturer uManufacturer) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Transaction transaction = null;
        try(Session session = sessionFactory.openSession()){
            transaction = session.beginTransaction();
            String hql = "UPDATE NSX SET Ten = :name WHERE Ma = :code";
            int updated = session.createNativeQuery(hql)
                    .setParameter("code", uManufacturer.getCode())
                    .setParameter("name", uManufacturer.getName())
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
    public Manufacturer findByCode(String code) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Transaction transaction = null;
        try(Session session = sessionFactory.openSession()){
            transaction = session.beginTransaction();
            Query<Manufacturer> query = session.createNamedQuery("Manufacturer.FIND_BY_CODE");
            List<Manufacturer> listResult = query.setParameter("code", code).list();
            transaction.commit();
            return listResult.isEmpty() ? null : listResult.get(0);
        }catch(Exception e){
            if(transaction != null) transaction.rollback();
        }
        return null;
    }
    
}
