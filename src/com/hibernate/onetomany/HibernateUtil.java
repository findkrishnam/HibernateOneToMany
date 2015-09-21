package com.hibernate.onetomany;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class HibernateUtil {

    private static SessionFactory    sessionFactory;
    private static ServiceRegistry    serviceRegistry;
    
    public static SessionFactory createSessionFactory(){
        Configuration conf = new Configuration();
        conf.configure("/META-INF/hibernate.cfg.xml");
        serviceRegistry = new StandardServiceRegistryBuilder().applySettings(conf.getProperties()).build();
        sessionFactory = conf.buildSessionFactory(serviceRegistry);
        return sessionFactory;
    }
    
}
