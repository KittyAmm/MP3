package dao;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import java.util.ArrayList;
import java.util.List;

public class HibernateDao implements InterfaceDao {

    private SessionFactory factory;

    public HibernateDao() {
        Configuration configObj = new Configuration();
        configObj.configure("hibernate.cfg.xml");
        configObj.addAnnotatedClass(modele.Utilisateur.class);
        configObj.addAnnotatedClass(modele.Favoris.class);
        configObj.addAnnotatedClass(modele.Telechargement.class);
        configObj.addAnnotatedClass(modele.Playlist.class);
        configObj.addAnnotatedClass(modele.Mp3Info.class);
        configObj.addAnnotatedClass(modele.Menu.class);

        ServiceRegistry service = new StandardServiceRegistryBuilder()
                .applySettings(configObj.getProperties())
                .build();
        factory = configObj.buildSessionFactory(service);
    }

    public void save(BaseModele bm, Session session) {
        session.save(bm);
    }

    @Override
    public void save(BaseModele bm) throws Exception {
        Session     session     = null;
        Transaction transaction = null;
        try {
            session = factory.openSession();
            transaction = session.beginTransaction();
            bm.setId(bm.getId(session));
            save(bm, session);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            throw e;
        } finally {
            if (session != null) session.close();
        }
    }

    public void update(BaseModele bm, Session session) {
        session.update(bm);
    }

    @Override
    public void update(BaseModele bm) throws Exception {
        Session     session = null;
        Transaction tx      = null;
        try {
            session = factory.openSession();
            tx = session.beginTransaction();
            update(bm, session);
            tx.commit();
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            throw e;
        } finally {
            if (session != null) session.close();
        }
    }

    public void delete(BaseModele bm, Session session) {
        session.delete(bm);
    }

    @Override
    public void delete(BaseModele bm) throws Exception {
        Session     session = null;
        Transaction tx      = null;
        try {
            session = factory.openSession();
            tx = session.beginTransaction();
            delete(bm, session);
            tx.commit();
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            throw e;
        } finally {
            if (session != null) session.close();
        }
    }

    @SuppressWarnings("unchecked")
    public ArrayList<BaseModele> findAll(BaseModele bm, Session session) {
        Criteria cr = session.createCriteria(bm.getClass());
        return (ArrayList<BaseModele>) cr.list();
    }

    @Override
    @SuppressWarnings("unchecked")
    public ArrayList<BaseModele> findAll(BaseModele bm) {
        ArrayList objects = null;
        Session   session = null;
        try {
            session = factory.openSession();
            Criteria cr = session.createCriteria(bm.getClass());
            return (ArrayList<BaseModele>) cr.list();
        } finally {
            if (session != null) session.close();
        }
    }

    @SuppressWarnings("unchecked")
    public ArrayList<BaseModele> findAll(BaseModele bm, Session session, String where) {
        Criteria cr = session.createCriteria(bm.getClass(), where);
        return (ArrayList<BaseModele>) cr.list();

    }

    @Override
    @SuppressWarnings("unchecked")
    public ArrayList<BaseModele> findAll(BaseModele bm, String where) {
        ArrayList objects = null;
        Session   session = null;
        try {
            session = factory.openSession();
            Criteria cr = session.createCriteria(bm.getClass(), where);
            return (ArrayList<BaseModele>) cr.list();
        } finally {
            if (session != null) session.close();
        }
    }

    public void findById(BaseModele modele, String id, Session session) {
        session.load(modele, id);
    }

    @Override
    public void findById(BaseModele modele, String id) {
        Session     session = null;
        Transaction tx      = null;
        try {
            session = factory.openSession();
            session.load(modele, id);
        } catch (Exception e) {
            throw e;
        } finally {
            if (session != null) session.close();
        }
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<BaseModele> findAll(BaseModele bm, int nombre, int index) {
        Session session = null;
        try {
            session = factory.openSession();
            Criteria cr = session.createCriteria(bm.getClass());
            cr.setFirstResult((index - 1) * nombre);
            cr.setMaxResults(nombre);
            return (ArrayList<BaseModele>) cr.list();
        } catch (Exception e) {
            throw e;
        } finally {
            if (session != null) session.close();
        }
    }
}
