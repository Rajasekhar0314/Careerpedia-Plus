package org.example;

import jakarta.persistence.TypedQuery;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.query.Query;

import javax.swing.text.html.parser.Entity;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

public class Main {
    public static void main(String[] args)  {
     //  Environment
       Configuration cn = new Configuration()  //
               .configure()
               .addAnnotatedClass(Product.class);
       SessionFactory sessionFactory = cn.buildSessionFactory();
       Session s  = sessionFactory.openSession();
       Transaction t = s.beginTransaction();

       Product p = new Product(1l,"Dabba","Happy Dabba",LocalDateTime.of(2024,12,11,11,46));
       Product p1 = new Product(2L, "Bottle", "Eco-friendly water bottle", LocalDateTime.of(2024, 12, 12, 10, 30));
       Product p2 = new Product(3L, "Notebook", "Premium quality notebook", LocalDateTime.of(2024, 12, 13, 14, 15));
       Product p3 = new Product(4L, "Pen", "Smooth ink ballpoint pen", LocalDateTime.of(2024, 12, 14, 9, 0));
       Product p4 = new Product(5L, "Backpack", "Durable travel backpack", LocalDateTime.of(2024, 12, 15, 16, 45));
       Product p5 = new Product(6L, "Mouse", "Wireless optical mouse", LocalDateTime.of(2024, 12, 16, 13, 20));

       s.save(p);s.save(p1);s.save(p2);s.save(p3);s.save(p4);s.save(p5);
       t.commit();

       System.out.println("++++++++++++++++++++++++++++++++GET API++++++++++++++++++++++++++++++++");
       Session s1  = sessionFactory.openSession();
       Transaction t1 = s.beginTransaction();

       Product get = s1.get(Product.class,3);
       System.out.println(get + " get by id");


       String query = "From Product";
       Query createQuery = s1.createQuery(query);
       List products = createQuery.list();
       for(Object sp : products)
       {
          System.out.println(sp);
       }
//       String query1 = "From Product p WHERE p.name  = 'Mouse'";
//       Query q1 = s1.createQuery(query1);
//       System.out.println(q1);
       TypedQuery<Product> tp = s1.createQuery("From Product p WHERE p.name = 'Mouse'", Product.class);
       Product pro = tp.getSingleResult();
       System.out.println(pro.getName());
       t1.commit();
       s1.close();
       sessionFactory.close();
       System.out.println("+++++++++++++++++++++++++GET CLOSE+++++++++++++++++++++++++++++++++++++++++++");
    }
}