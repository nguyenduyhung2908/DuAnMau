/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repositories.impl;

import DomainModels.Customer;
import Repositories.ICustomerRepository;
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
public class CustomerRepository implements ICustomerRepository{

    @Override
    public List<Customer> findAll() {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Transaction transaction = null;
        try(Session session = sessionFactory.openSession()){
            transaction = session.beginTransaction();
            Query<Customer> query = session.createNamedQuery("Customer.FIND_ALL");
            List<Customer> listResult = query.list();
            transaction.commit();
            return listResult;
        }catch(Exception e){
            if(transaction != null) transaction.rollback();
        }
        return null;
    }

    @Override
    public String insert(Customer iCus) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Transaction transaction = null;
        try(Session session = sessionFactory.openSession()){
            transaction = session.beginTransaction();
            String inserted = (String) session.save(iCus);
            transaction.commit();
            return inserted;
        }catch(Exception e){
            if(transaction != null) transaction.rollback();
        }
        return null;
    }

    @Override
    public boolean update(Customer uCus) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Transaction transaction = null;
        try(Session session = sessionFactory.openSession()){
            transaction = session.beginTransaction();
            StringBuilder hql = new StringBuilder("UPDATE KhachHang SET ");
            hql.append("Ten = :fName, TenDem = :mName, Ho = :lName , NgaySinh = :dOB,");
            hql.append("Sdt = :phone, DiaChi = :address, ThanhPho = :city, QuocGia = :country,");
            hql.append("MatKhau = :password WHERE Ma = :code");
            int updated = session.createNativeQuery(hql.toString())
                                     .setParameter("fName", uCus.getFirstName())
                                     .setParameter("mName", uCus.getMiddleName())
                                     .setParameter("lName", uCus.getLastName())
                                     .setParameter("dOB", uCus.getdOB())
                                     .setParameter("phone", uCus.getPhone())
                                     .setParameter("address", uCus.getAddress())
                                     .setParameter("city", uCus.getCity())
                                     .setParameter("country", uCus.getCountry())
                                     .setParameter("password", uCus.getPassword())
                                     .setParameter("code", uCus.getCode()).executeUpdate();
            transaction.commit();
            if(updated > 0) return true;
        }catch(Exception e){
            if(transaction != null) transaction.rollback();
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
            String hql = "DELETE FROM KhachHang WHERE Ma = :code";
            NativeQuery<Customer> query = session.createNativeQuery(hql);
            int deleted = 0 ;
            for(String code : codes){
                deleted = query.setParameter("code", code).executeUpdate();
            }
            transaction.commit();
            if(deleted > 0) return true;
        }catch(Exception e){
            if(transaction != null) transaction.rollback();
            return false;
        }
        return false;
    }

    @Override
    public Customer findByCode(String code) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Transaction transaction = null;
        try(Session session = sessionFactory.openSession()){
            transaction = session.beginTransaction();
            List<Customer> list = session.createNamedQuery("Customer.FIND_BY_CODE").setParameter("code", code).list();
            transaction.commit();
            return list.isEmpty() ? null : list.get(0);
        }catch(Exception e){
            if(transaction != null) transaction.rollback();
        }
        return null;
    }
    
}
