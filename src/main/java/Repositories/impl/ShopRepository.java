/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repositories.impl;

import DomainModels.Shop;
import Repositories.IShopRepository;
import Utilities.HibernateUtil;
import java.util.List;
import javax.persistence.Parameter;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.NativeQuery;

/**
 *
 * @author Nguyen Duy Hung
 */
public class ShopRepository implements IShopRepository {

    @Override
    public List<Shop> findAll() {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Transaction transaction = null;
        try(Session session = sessionFactory.openSession()){
            transaction = session.beginTransaction();
            NativeQuery<Shop> query = session.createNativeQuery("SELECT * FROM CuaHang", Shop.class);
            List<Shop> listResult = query.list();
            transaction.commit();
            return listResult;
        }catch(Exception e){
            if(transaction != null) transaction.rollback();
        }
        return null;
    }

    @Override
    public String insert(Shop iShop) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Transaction transaction = null;
        try(Session session = sessionFactory.openSession()){
            transaction = session.beginTransaction();
            String idInserted = (String) session.save(iShop);
            transaction.commit();
            return idInserted;
        }catch(Exception e){
            if(transaction != null) transaction.rollback();
        }
        return null;
    }

    @Override
    public boolean update(Shop uShop) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Transaction transaction = null;
        try(Session session = sessionFactory.openSession()){
            transaction = session.beginTransaction();
            StringBuilder hql = new StringBuilder("UPDATE CuaHang SET ");
            hql.append("Ten = :name, DiaChi = :address, ThanhPho = :city, QuocGia = :country ");
            hql.append("WHERE Ma = :code ");
            NativeQuery<Shop> query = 
                    session.createNativeQuery(hql.toString(), Shop.class)
                    .setParameter("name", uShop.getName())
                    .setParameter("address", uShop.getAddress())
                    .setParameter("city", uShop.getCity())
                    .setParameter("country", uShop.getCountry())
                    .setParameter("code", uShop.getCode());
            int affactedRow = query.executeUpdate();
            transaction.commit();
            if(affactedRow > 0) return true;
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
            String hql = "DELETE FROM CuaHang WHERE Ma = :code ";
            int affactedRow = 0;
            NativeQuery<Shop> query = session.createNativeQuery(hql).addEntity(Shop.class);
            for(String c : codes){
               query.setParameter("code", c);
               affactedRow = query.executeUpdate();
            }
            transaction.commit();
            if(affactedRow > 0) return true;
        }catch(Exception e){
            if(transaction != null) transaction.rollback();
        }
        return false;
    }
    
}
