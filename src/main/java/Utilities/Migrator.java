/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utilities;


import DomainModels.Category;
import DomainModels.Product;
import java.math.BigDecimal;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.service.ServiceRegistry;

/**
 *
 * @author Phong
 */
public class Migrator {

  //Tạo DB trong SQL SERVER = SOFT2041_PTPM
  //Sau đó tiến hành chạy đển zen bảng
    public static void main(String[] args) {
        // Tạo đối tượng ServiceRegistry từ hibernate.cfg.xml
        ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                .configure("META-INF/hibernate.cfg.xml")
                .build();

        // Tạo nguồn siêu dữ liệu (metadata) từ ServiceRegistry
        Metadata metadata = new MetadataSources(serviceRegistry)
                .getMetadataBuilder().build();
        SessionFactory sessionFactory = metadata.getSessionFactoryBuilder().build();
    }
}
