package com.juego7th.repository;

import com.juego7th.Utils.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import javax.persistence.Entity;
import java.io.Serializable;
import java.util.List;

public class GenericRepository<ID extends Serializable, T> implements RepositoryImplements<T, ID> {

    private final SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
    private Class<T> entityclass;

    public GenericRepository(Class<T> entityClass) {
        this.entityclass = entityclass;
    }

    @Override
    public  void create(T entity) {
        try(Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            session.save(entity);
            session.getTransaction().commit();
        }
    }

    @Override
    public  void update(T entity) {

        try(Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            session.merge(entity);
            session.getTransaction().commit();
        }
    }

    @Override
    public void delete(ID id) {

        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Entity entity = session.get(Entity.class, id);
        if(entity != null) {
            session.delete(entity);
        }
        session.getTransaction().commit();

    }
    @Override
    public T getfindById(ID id) {

        try(Session session = sessionFactory.openSession()){

            return session.get(entityclass, id);
        }
    }
    @Override
    public List<T> findAll() {
        try(Session session = sessionFactory.openSession()){

            return session.createQuery("FROM " +entityclass.getSimpleName(),entityclass).getResultList();
        }
    }
}
