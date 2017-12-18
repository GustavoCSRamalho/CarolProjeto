package site.infra;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

public class HibernateUtil {
     private static SessionFactory sessionFactory ;
     
    public static SessionFactory getSessionFactory() {

       	 Configuration configuration = new Configuration().configure();
       	 StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().
       	 applySettings(configuration.getProperties());
       	 sessionFactory = configuration.buildSessionFactory(builder.build());
       	 

    	return sessionFactory;
    }
    
    public static Session getSession() {
    	return getSessionFactory().openSession();
    }
}
