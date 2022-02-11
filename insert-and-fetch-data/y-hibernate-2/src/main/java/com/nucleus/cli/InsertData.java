package com.nucleus.cli;

import com.nucleus.entities.Address;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Date;

public class InsertData {
    public static void main(String[] args) throws IOException {
        Configuration cfg=new Configuration();
        cfg.configure("hibernate.cfg.xml");
        SessionFactory factory=cfg.buildSessionFactory();
//        address1
        Address address1=new Address();
        address1.setStreet("street1");
        address1.setCity("city1");
        address1.setOpen(true);
        address1.setX(1234.456);
        address1.setAddedDate(new Date());

//     Reading image
        FileInputStream fis=new FileInputStream("src/main/resources/images/demo_pic.png");
        byte[] imageData=new byte[fis.available()];
        address1.setImage(imageData);
//address2
        Address address2=new Address();
        address2.setStreet("street2");
        address2.setCity("city2");
        address2.setOpen(true);
        address2.setX(1234.456);
        address2.setAddedDate(new Date());
        address2.setImage(imageData);
//        ------
        Session session=factory.openSession();
        Transaction tx=session.beginTransaction();
        session.save(address1);
        session.save(address2);
        tx.commit();
        System.out.println(factory.isClosed());
        factory.close();
      System.out.println(factory.isClosed());
    }
}
