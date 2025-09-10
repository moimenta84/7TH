package com.juego7th.repository;
import com.juego7th.Utils.HibernateUtil;
import com.juego7th.modelo.Games;
import com.juego7th.modelo.Users;
import com.juego7th.modelo.UsersGames;
import org.hibernate.Session;
import java.util.List;

public class UsersGamesRepository extends GenericRepository<UsersGames,Integer>{

    public UsersGamesRepository() {
        super(UsersGames.class);
    }
    
    //metodo para devolverlista de usuarios en una partida por id
    public List<UsersGames> findUsersByGameId(int gameId) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery(
                            "  from UsersGames  where game.id = :gameId", UsersGames.class)
                    .setParameter("gameId", gameId)
                    .list();
        }
    }
    
    public UsersGames addNumSelection(Users user, int numero, Games game) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.beginTransaction();

            UsersGames usersGames = session.createQuery(
                            "FROM UsersGames ug WHERE ug.game.id = :gameId AND ug.user.id = :userId", UsersGames.class)
                    .setParameter("gameId", game.getId())
                    .setParameter("userId", user.getId())
                    .uniqueResult();

            if (usersGames != null) {
                usersGames.setNumeroSeleccionado(numero);
                session.update(usersGames);
                usersGames.setVidas(usersGames.getVidas() - 1);
                session.merge(user); // guarda el nuevo valor de vidas
            }

            session.getTransaction().commit();
            return usersGames;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
    public UsersGames findByUserAndGame(Users user, Games game) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery(
                            "FROM UsersGames ug WHERE ug.user.id = :userId AND ug.game.id = :gameId", UsersGames.class)
                    .setParameter("userId", user.getId())
                    .setParameter("gameId", game.getId())
                    .uniqueResult();
        }
    }
    
    public void saveOrUpdate(UsersGames usersGames) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.beginTransaction();
            session.saveOrUpdate(usersGames);
            session.getTransaction().commit();
        }
    }
}



