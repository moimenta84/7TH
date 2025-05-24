package com.juego7th.repository;

import com.juego7th.Utils.HibernateUtil;
import com.juego7th.modelo.Users;
import org.hibernate.Session;

public class UsersRepository extends GenericRepository<Users,Integer>{
    public UsersRepository() {
        super(Users.class);
    }

    public Users findByName(String email) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("FROM Users WHERE email= :email", Users.class)
                    .setParameter("email", email)
                    .uniqueResult();
        }
    }

    public Users findById(int id ) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("FROM Users WHERE id= :id", Users.class)
                    .setParameter("id", id)
                    .uniqueResult();
        }
    }
    public void update(Users user) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.beginTransaction();
            System.out.println("Actualizando vidas del usuario: " + user.getName() + " → ");
            session.merge(user);
            session.getTransaction().commit();
            System.out.println("Actualización commit realizada");
        }
    }



}
