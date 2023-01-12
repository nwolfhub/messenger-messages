package org.nwolfhub.messengermessages.database;


import org.hibernate.Session;
import org.hibernate.Transaction;
import org.nwolfhub.messengermessages.crypto.model.Key;
import org.nwolfhub.shared.database.HibernateController;
import org.nwolfhub.shared.database.model.Dao;
import org.nwolfhub.shared.database.model.User;

import java.util.List;

public class KeysDao implements Dao {
    private HibernateController controller;

    public KeysDao(HibernateController controller) {
        this.controller = controller;
    }

    @Override
    public Object get(Integer id) {
        Session session = this.controller.getSessionFactory().openSession();
        Key obj = session.get(Key.class, id);
        session.close();
        return obj;
    }

    @Override
    public void save(Object obj) {
        Session session = this.controller.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.save(obj);
        transaction.commit();
        session.close();
    }

    @Override
    public void update(Object obj) {
        Session session = this.controller.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.update(obj);
        transaction.commit();
        session.close();
    }

    @Override
    public void delete(Object obj) {
        Session session = this.controller.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(obj);
        transaction.commit();
        session.close();
    }

    @Override
    public List getAll() {
        return null;
    }
}
