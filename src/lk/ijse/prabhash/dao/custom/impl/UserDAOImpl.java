package lk.ijse.prabhash.dao.custom.impl;

import lk.ijse.prabhash.dao.custom.UserDAO;
import lk.ijse.prabhash.entity.User;
import lk.ijse.prabhash.util.FactoryConfiguration.FactoryConfiguration;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.io.IOException;
import java.util.List;

public class UserDAOImpl implements UserDAO {
    @Override
    public boolean save(User user) throws Exception {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        session.save(user);

        transaction.commit();
        session.close();


        return true;
    }

    @Override
    public boolean update(User user) throws Exception {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        session.update(user);

        transaction.commit();
        session.close();


        return true;

    }

    @Override
    public boolean delete(String id) throws Exception {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        User user = session.load(User.class, id);
        session.delete(user);

        transaction.commit();
        session.close();


        return true;
    }

    @Override
    public String generateId() throws Exception {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        List resultList = session.createSQLQuery("SELECT * FROM User ORDER BY userId DESC LIMIT 1").addEntity(User.class).getResultList();
        transaction.commit();
        session.close();

        return resultList.size()==0?"U000":((User)resultList.get(0)).getUserId();




    }

    @Override
    public List<User> getAll() throws IOException {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        Query query = session.createQuery("from User");
        List<User> list = query.list();


        transaction.commit();
        session.close();

        return list;
    }

    @Override
    public List<User> getUserDetails(String userName, String pwd) throws Exception {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        Query query = session.createQuery("FROM User WHERE userName= :u AND password =:p");
        query.setParameter("u", userName);
        query.setParameter("p", pwd);
        List<User> list = query.list();

        transaction.commit();
        session.close();

        return list;
    }
}
