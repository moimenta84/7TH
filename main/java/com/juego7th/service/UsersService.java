package com.juego7th.service;
import com.juego7th.Utils.ValidatorUtil;
import com.juego7th.modelo.Users;
import com.juego7th.modelo.UsersGames;
import com.juego7th.repository.UsersGamesRepository;
import com.juego7th.repository.UsersRepository;
import org.hibernate.HibernateException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
public class UsersService {

    private final UsersRepository usersRepository = new UsersRepository();
    private final UsersGamesRepository usersGamesRepository = new UsersGamesRepository();
    public String registrerUser(String username, String password,String email) {

        try {

            if (!ValidatorUtil.isName(username)) {
                return "Error: Invalid name";

            }else if (!ValidatorUtil.isValidEmail(email)) {
                return "Error: Invalid email format";

            }else if(ValidatorUtil.isValidPassword(password)) {
                return "Error: Invalid password";

            }else{

                Users newUsers = new Users();
                newUsers.setName(username);
                newUsers.setEmail(email);
                newUsers.setPassword(password);
                usersRepository.create(newUsers);
                return "Client created successfully! ID: " + newUsers.getId();
            }
        }catch (HibernateException e){
            return "Database error: Could not create client";

        }catch (Exception e){
            return "Error: Could not create client "+e.getMessage();
        }
    }

    public Users loginUser(String username, String password) {

        try{

            Users user = usersRepository.findByName(username);
            if(user.getPassword().equals(password) && user.getEmail().equals(username)){

                return user;

            }else{

                return null;
            }
        }catch (HibernateException e) {

            return null;
        }
    }
    public String  updateUser(int id, String username, String password,String email,int vidas){

        try{
            if (!ValidatorUtil.isName(username)) {
                return "Error: Invalid name";

            } else if (!ValidatorUtil.isValidEmail(email)) {
                return "Error: Invalid email format";


            } else if (!ValidatorUtil.isValidPassword(password)) {
                return "Error: Invalid password";

            }else {

                Users updateUsers = usersRepository.getfindById(id);;
                updateUsers.setName(username);
                updateUsers.setEmail(email);
                updateUsers.setPassword(password);
                usersRepository.update(updateUsers);
                return "Client updated successfully! ID: " + updateUsers.getId();
            }
        }catch (HibernateException e){
            return "Database error: Could not create client";

        }catch (Exception e){
            return "Error: Could not create client "+e.getMessage();
        }
    }
    public String deleteUser(int id) {

        try{
          Users user =  usersRepository.getfindById(id);
          if(ValidatorUtil.isObjectValid(user)){
              usersRepository.delete(id);
              return "Client deleted successfully! ID: " + id;
          }else{
              return "Error: Could not delete Users";
          }
        }catch (HibernateException e) {
            return "Database error: Could not delete users";

        } catch (Exception e) {
            return "Unexpected error: " + e.getMessage();
        }
    }
    public String gerUsersById(int id) {

        try{
            Users user =  usersRepository.getfindById(id);
            if(ValidatorUtil.isObjectValid(user)){

                return "Users\n: "+
                        "ID: " + user.getId()+"\n"+
                        "NAME: "+ user.getName()+"\n"+
                        "EMAIL: "+ user.getEmail();
            }else{

                return "Error: Could not get Users";
            }
        }catch (HibernateException e) {
            return "Database error: Could not retrieve user";

        } catch (Exception e) {
            return "Unexpected error: " + e.getMessage();
        }
    }
    public String getAllUsers() {
        StringBuilder result;
        try{
            List<Users> clients = usersRepository.findAll();
            if(getAllUsers().isEmpty()){

                return "No users found";

            }else{

                result = new StringBuilder();
                for(Users user : clients){
                    result.append("\n")
                            .append("ID: " + user.getId())
                            .append("\n")
                            .append("NAME: " + user.getName())
                            .append("\n")
                            .append("EMAIL: " + user.getEmail());
                }
            }
        }catch (HibernateException e) {
            return "Database error: Could not retrieve user";

        } catch (Exception e) {
            return "Unexpected error: " + e.getMessage();
        }
        return result.toString();
    }
    public Users getUserById(int id) {

        return usersRepository.getfindById(id);
    }

    public void actualizarVidas(UsersGames userGames, int vidas) {
        userGames.setVidas(vidas);
        usersGamesRepository.update(userGames);
        System.out.println("Vidas actualizadas para " + userGames.getId() + ": " + vidas);


    }

}
