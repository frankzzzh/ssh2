package dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 * @author Andong
 * @create 2021-06-13-16:52
 */
public class BaseDao {
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public Session getSession(){
        return this.sessionFactory.getCurrentSession();
    }

}
