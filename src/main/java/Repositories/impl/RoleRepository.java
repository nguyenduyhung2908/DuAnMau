/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repositories.impl;

import DomainModels.Role;
import Repositories.IRoleRepository;
import Utilities.HibernateUtil;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.NativeQuery;

/**
 *
 * @author Nguyen Duy Hung
 */
public class RoleRepository implements IRoleRepository {

    @Override
    public List<Role> findAll() {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Transaction transaction = null;
        List<Role> listResult = null;
        try(Session session = sessionFactory.openSession()){
            transaction = session.beginTransaction();
            NativeQuery<Role> query = session.createNativeQuery("SELECT * FROM ChucVu",Role.class);
            listResult = query.list();
            transaction.commit();
            return listResult;
        }catch(Exception e){
            if(transaction != null)transaction.rollback();
        }
        return null;
    }

    @Override
    public String insert(Role iRole) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Transaction transaction = null;
        try(Session session = sessionFactory.openSession()){
            transaction = session.beginTransaction();
            String idInserted = (String) session.save(iRole);
            transaction.commit();
            return idInserted;
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
            String hql = "DELETE FROM ChucVu WHERE Ma = :ma";
            NativeQuery<Role> query = session.createNativeQuery(hql,Role.class);
            int affactedRow = 0;
            for(String c : codes){
                query.setParameter("ma", c);
                affactedRow = query.executeUpdate();
            }
            transaction.commit();
            if(affactedRow > 0) return true;
        }catch(Exception e){
            if(transaction != null)transaction.rollback();
        }
        return false;
    }

    @Override
    public boolean update(Role uRole) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Transaction transaction = null;
        try(Session session = sessionFactory.openSession()){
            transaction = session.beginTransaction();
            String hql = "UPDATE ChucVu SET Ten = :ten WHERE Ma = :ma";
            NativeQuery<Role> query = session.createNativeQuery(hql,Role.class);
            query.setParameter("ten", uRole.getName());
            query.setParameter("ma", uRole.getCode());
            int affactedRow = query.executeUpdate();
            transaction.commit();
            if(affactedRow > 0) return true;
            return false;
        }catch(Exception e){
            if(transaction != null) transaction.rollback();
            return false;
        }
    }
    
}
