import com.db.DBConnection;
import com.db.UserDAO;
import entity.User;

/**
 * Created by taras on 14.06.2017.
 */
public class Main {
    public static void main(String[] args) {
        User user = UserDAO.INSTANCE.findUser("taras");
        System.out.println(user);
    }
}
