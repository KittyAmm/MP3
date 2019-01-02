package dao.connex;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class ConnexHibernate {
    private static      SessionFactory factory = null;
    public static final ThreadLocal    session = new ThreadLocal();

    public SessionFactory buildSessionFactory() {
        Configuration configObj = new Configuration();
        configObj.addAnnotatedClass(modele.Album.class);
        configObj.configure("hibernate.cfg.xml");
        ServiceRegistry service = new StandardServiceRegistryBuilder().applySettings(configObj.getProperties()).build();
        factory = configObj.buildSessionFactory(service);
        return factory;
    }

    static {
        try {
            factory = new Configuration().configure().buildSessionFactory();
            System.out.println("connecter");
        } catch (HibernateException ex) {
            throw new RuntimeException("Problème de configuration : " + ex.getMessage(), ex);
        }
    }

    public static Session currentSession() throws HibernateException {
        Session s = (Session) session.get();
        // Ouvre une nouvelle Session, si ce Thread n'en a aucune
        if (s == null) {
            s = factory.openSession();
            session.set(s);
        }
        return s;
    }

    public static void closeSession() throws HibernateException {
        Session s = (Session) session.get();
        session.set(null);
        if (s != null) {
            s.close();
        }
    }

    public static void rollback(Transaction tx) {
        try {
            if (tx != null) {
                tx.rollback();
            }
        } catch (HibernateException ignored) {
            System.out.println("Couldn't rollback Transaction" + ignored);
            //  log.error("Couldn't rollback Transaction", ignored);
        }
    }

}
