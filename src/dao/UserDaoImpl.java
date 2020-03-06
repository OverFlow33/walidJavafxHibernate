package dao;

import modele.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;


public class UserDaoImpl implements UserDao {

    static SessionFactory sessionFactory;

    public UserDaoImpl() {
    }

    public UserDaoImpl(SessionFactory sessionFactory) {

        this.sessionFactory = sessionFactory;
    }

    @Override
    public User readById(int id) {
        User user;
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        user = session.get(User.class, id);
        session.getTransaction().commit();
        session.close();
        return user;
    }

    @Override
    public User readByUsername(String username) {
        User user;
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Query query = session.createQuery("From User AS us WHERE us.username = :u");
        query.setParameter("u", username);
        user = (User)query.uniqueResult();
        session.getTransaction().commit();
        session.close();
        return user;
    }

    @Override
    public void delete(User user) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.delete(user);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void update(User user) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.update(user);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void create(User user) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(user);
        session.getTransaction().commit();
        session.close();
    }
}
