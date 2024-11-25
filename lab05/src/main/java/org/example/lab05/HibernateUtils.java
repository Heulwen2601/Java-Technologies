package org.example.lab05;

import org.example.lab05.Models.Product;
import org.example.lab05.Models.User;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class HibernateUtils {
    private static final SessionFactory sessionFactory;

    private HibernateUtils() {
        super();
    }

    static {
        Configuration configuration = new Configuration();
        configuration.addAnnotatedClass(User.class);
        configuration.addAnnotatedClass(Product.class);
        sessionFactory = buildSessionFactory();
    }

    private static SessionFactory buildSessionFactory() {
        ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder() //
                .configure()
                .build();
        Metadata metadata = new MetadataSources(serviceRegistry).getMetadataBuilder().build();
        return metadata.getSessionFactoryBuilder().build();
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public static void close() {
        getSessionFactory().close();
    }
}
