package Task_1;

import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.File;
import java.io.IOException;
public class Task1 {
    private static String reg = "^\\((\\d{3})\\)\\s*(\\d{3})-(\\d{4})$|^\\d{3}-\\d{3}-\\d{4}$";
    private static boolean validator(String number) {
        return number.matches(reg);
    }
    public static void main(String[] args) throws IOException {
        File file = new File("File1.txt");
        //Якщо коректно вказати шлях до файлу то все працює
        try {
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String number = scanner.nextLine();
                if (validator(number)) {
                    System.out.println(number);
                }
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        }
    }
}