package com.juego7th.repository;
import com.juego7th.modelo.Users;
public class UsersRepository extends GenericRepository<Users,Integer>{
    
    public UsersRepository() {
        super(Users.class);
    }
}
