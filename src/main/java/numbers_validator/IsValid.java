package numbers_validator;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;


public class IsValid {
    private static final String REG = "^\\((\\d{3})\\)\\s*(\\d{3})-(\\d{4})$|^\\d{3}-\\d{3}-\\d{4}$";

    private static boolean validator(String number) {
        return number.matches(REG);
    }

    public static void main(String[] args) throws IOException {

        File file = new File("src/main/java/numbers_validator/numbers.txt");

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