import src.User;
import src.UserManager;

import java.io.*;

public class App {
    public static void main(String[] args) {
        UserManager userManager = new UserManager();
        User user = new User("minh", "1234", "hoi34@gmail.com");
        userManager.add(user);


        // Xay dung cac chuc nang crud user
    }
}
