import com.juego7th.Utils.HibernateUtil;
import com.juego7th.modelo.Users;
import com.juego7th.repository.UsersRepository;
import com.juego7th.service.UsersGamesService;
import com.juego7th.views.MainMenu;
import org.hibernate.Session;
import org.hibernate.Transaction;

public
class Main {
private static UsersRepository usersRepository = new UsersRepository();
private static UsersGamesService usersGamesService = new UsersGamesService();
    
    public static void main(String[] args) {
        MainMenu.menu();
    }
}




