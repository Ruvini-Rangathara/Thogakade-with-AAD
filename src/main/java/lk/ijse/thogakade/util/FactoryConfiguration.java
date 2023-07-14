package lk.ijse.thogakade.util;

import lk.ijse.thogakade.to.CustomerTo;
import lk.ijse.thogakade.to.ItemTo;
import lk.ijse.thogakade.to.OrderDetailTo;
import lk.ijse.thogakade.to.OrderTo;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class FactoryConfiguration {
    private static FactoryConfiguration factoryConfiguration;

    private final SessionFactory sessionFactory;

    private FactoryConfiguration() {
        Configuration configuration = new Configuration().configure();
        configuration.addAnnotatedClass(ItemTo.class);
        configuration.addAnnotatedClass(CustomerTo.class);
        configuration.addAnnotatedClass(OrderTo.class);
        configuration.addAnnotatedClass(OrderDetailTo.class);

        sessionFactory = configuration.buildSessionFactory();
    }

    public static FactoryConfiguration getInstance() {

        return factoryConfiguration == null ? factoryConfiguration = new FactoryConfiguration() : factoryConfiguration;
    }

    public Session getSession() {
        return sessionFactory.openSession();
    }
}