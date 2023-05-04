package Task_2;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class Task2 {
    public static void main(String[] args) throws IOException {
        File file = new File("File2.txt");
        //Якщо коректно вказати шлях до файлу то все працює
        List<User> users = userList(file);
        goToJson(users);
    }
    private static void goToJson(List<User> users) throws IOException {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String json = gson.toJson(users);
        FileWriter fileWriter = new FileWriter("users.json");
        //Якщо коректно вказати шлях до файлу то все працює
        fileWriter.write(json);
        fileWriter.close();
    }
    private static List<User> userList(File file) throws FileNotFoundException {
        Scanner scanner = new Scanner(file);
        scanner.nextLine();
        List<User> users = new ArrayList<>();
        while (scanner.hasNext()) {
            String l = scanner.nextLine();
            String[] splitedL = l.split(" ");
            String name = splitedL[0];
            int age = Integer.parseInt(splitedL[1]);
            User user = new User(name, age);
            users.add(user);
        }
        scanner.close();
        return users;
    }
}

