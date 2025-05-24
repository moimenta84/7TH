package com.juego7th.repository;
import com.juego7th.Utils.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import java.io.Serializable;
import java.util.List;
public class GenericRepository<T,ID extends Serializable> implements RepositoryImplements<T, ID> {
    private final SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
    private final Class<T> entityClass;
    public GenericRepository(Class<T> entityClass) {
        this.entityClass = entityClass;
    }
    @Override
    public  String create(T entity) {
        try(Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            session.save(entity);
            session.getTransaction().commit();
        }
        return "Se ha credo correctamente el registro";
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
        T entity = session.get(entityClass, id);
        if(entity != null) {
            session.delete(entity);
        }
        session.getTransaction().commit();
    }
    @Override
    public T getfindById(ID id) {
        try(Session session = sessionFactory.openSession()){
            return session.get(entityClass, id);
        }
    }
    @Override
    public List<T> findAll() {
        try(Session session = sessionFactory.openSession()){

            return session.createQuery("FROM " +entityClass.getSimpleName(),entityClass).getResultList();
        }
    }
}
