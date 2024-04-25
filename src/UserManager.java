package src;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class UserManager {
    private final List<User> users;
    private static final String PATH_FILE = "data/users.txt";
    public UserManager() {
        this.users = new ArrayList<User>();
    }

    public void add(User user) {
        this.readDataToFile();
        this.users.add(user);
        this.writeDataToFile();
    }

    public void showListUsers() {
        this.readDataToFile();
        // doc data tu file
        for (User user : users) {
            System.out.println(user);
        }
    }

    public void readDataToFile() {
        try {
            FileReader fileReader = new FileReader(PATH_FILE);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;
            // doc theo dong(line) den khi k con dong doc nua
            while ((line = bufferedReader.readLine()) != null) {
                String[] txt = line.split(",");
                User user = new User(txt[0],txt[1],txt[2]);
                this.users.add(user);
            }

        }catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public void writeDataToFile(){
        try {
            FileWriter fileWriter = new FileWriter(PATH_FILE);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            for (User user : users) {
                // tao 1 dong voi noi dung nhu thiet ke
                String line = user.getUsername() + "," + user.getPassword() + "," + user.getEmail();
                // ghi dong vua tao
                bufferedWriter.write(line);
                // tao dong moi de ghi dong tiep theo
                bufferedWriter.newLine();
            }
            bufferedWriter.close();
        }catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }

    public int totalUsers() {
        return users.size();
    }
}
