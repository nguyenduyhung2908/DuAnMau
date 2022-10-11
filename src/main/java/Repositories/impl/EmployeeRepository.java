/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repositories.impl;

import DomainModels.Employee;
import DomainModels.Role;
import Repositories.IEmployeeRepository;
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
public class EmployeeRepository implements IEmployeeRepository {

    @Override
    public List<Employee> findAll(Integer offset, Integer limit) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Transaction transaction = null;
        try(Session session = sessionFactory.openSession()){
            transaction = session.beginTransaction();
            NativeQuery<Employee> query = session.createNativeQuery("SELECT * FROM NhanVien ",Employee.class);
            List<Employee> listResult = query.list();
            transaction.commit();
            return listResult;
        }catch(Exception e){
            if(transaction != null) transaction.rollback();
        }
        return null;
    }

    @Override
    public String insert(Employee eInsert) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Transaction transaction = null;
        try(Session session = sessionFactory.openSession()){
            transaction = session.beginTransaction();
            String idInserted = (String) session.save("NhanVien",eInsert);
            transaction.commit();
            return idInserted;
        }catch(Exception e){
            if(transaction != null) transaction.rollback();
        }
        return null;
    }

    @Override
    public boolean update(Employee eUpdate) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Transaction transaction = null;
        try(Session session = sessionFactory.openSession()){
            transaction = session.beginTransaction();
            session.update("NhanVien", eUpdate);
            transaction.commit();
            return true;
        }catch(Exception e){
            if(transaction != null) transaction.rollback();
            return false;
        }
    }

    @Override
    public boolean delete(String[] codes) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Transaction transaction = null;
        try(Session session = sessionFactory.openSession()){
            transaction = session.beginTransaction();
            String hql = "DELETE FROM NhanVien WHERE Ma = :code";
            NativeQuery<Employee> query = session.createNativeQuery(hql,Employee.class);
            int affactedRow = 0;
            for(String code : codes){
                query.setParameter("code", code);
                affactedRow = query.executeUpdate();
            }
            transaction.commit();
            if(affactedRow > 0) return true;
            return false;
        }catch(Exception e){
            if(transaction != null) transaction.rollback();
            return false;
        }
    }

    @Override
    public Employee findByCode(String code) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Transaction transaction = null;
        try(Session session = sessionFactory.openSession()){
            transaction = session.beginTransaction();
            String hql = "SELECT e.* FROM NhanVien e WHERE e.Ma = :code";
            NativeQuery<Employee> query = session.createNativeQuery(hql,Employee.class);
            query.setParameter("code", code);
            Employee e = query.uniqueResult();
            transaction.commit();
            return e;
        }catch(Exception e){
            if(transaction != null) transaction.rollback();
            return null;
        }
    }

    @Override
    public int count() {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Transaction transaction = null;
        try(Session session = sessionFactory.openSession()){
            transaction = session.beginTransaction();
            String hql = "SELECT e.* FROM NhanVien e WHERE e.Ma = :code";
            NativeQuery<Employee> query = session.createNativeQuery(hql,Employee.class);
            
            transaction.commit();
            return -1;
        }catch(Exception e){
            if(transaction != null) transaction.rollback();
            return -1;
        }
    }

    @Override
    public List<Employee> findAllLeader(Role e) {
        return null;
    }
    
}
