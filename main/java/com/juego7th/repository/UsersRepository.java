package com.juego7th.repository;

import com.juego7th.Utils.HibernateUtil;
import com.juego7th.modelo.Users;
import org.hibernate.Session;

public class UsersRepository extends GenericRepository<Users,Integer>{
    public UsersRepository() {
        super(Users.class);
    }

    // UsersRepository.java
    public Users findByName(String name) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("FROM Users WHERE name = :name", Users.class)
                    .setParameter("name", name).uniqueResult();
        }
    }
}


