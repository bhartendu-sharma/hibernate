package com.nucleus.cli;

import com.nucleus.entities.Address;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class FetchData {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
        Session session = factory.openSession();
//fetch data using get
        Address ad1=session.get(Address.class,1);
        System.out.println("address using get at id 1 : "+ad1);
        Address ad2=session.get(Address.class,3);    // gives :  null
        System.out.println("address using get at id 3 : "+ad2);

//        fetch data using load
            Address ad3=session.load(Address.class,1);
            System.out.println("address using load at id 1 : "+ad3);
            Address ad4 = session.load(Address.class, 3);
//            org.hibernate.ObjectNotFoundException: No row with the given identifier exists:
            System.out.println("address using load at id 3 : " + ad4);

            factory.close();

        }
    }

