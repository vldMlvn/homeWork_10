package convert_file_to_json;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import convert_file_to_json.dto.UserEntity;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Convertor {

    public static void main(String[] args) throws IOException {
        File file = new File("src/main/java/convert_file_to_json/UserList.txt");

        List<UserEntity> users = userList(file);
        writeToJson(users);
    }

    private static void writeToJson(List<UserEntity> users) {

        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String json = gson.toJson(users);

        try (FileWriter fileWriter = new FileWriter("src/main/java/convert_file_to_json/users.json")) {
            fileWriter.write(json);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static List<UserEntity> userList(File file) throws FileNotFoundException {

        Scanner scanner = new Scanner(file);
        scanner.nextLine();

        List<UserEntity> users = new ArrayList<>();

        while (scanner.hasNext()) {
            String l = scanner.nextLine();
            String[] splitedL = l.split(" ");
            String name = splitedL[0];
            int age = Integer.parseInt(splitedL[1]);
            UserEntity user = new UserEntity(name, age);
            users.add(user);
        }

        scanner.close();
        return users;
    }
}