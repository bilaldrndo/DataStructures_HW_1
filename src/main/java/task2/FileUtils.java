package task2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class FileUtils {

    public static ArrayList<String> readFile(String filePath) throws FileNotFoundException {
        ArrayList<String> arrayOfExpressions = new ArrayList<String>();

        try {
            Scanner scanner = new Scanner(new File(filePath));
            while (scanner.hasNext()) {
                arrayOfExpressions.add(scanner.nextLine());
            }
        } catch (FileNotFoundException ex) {
            System.err.println("File not found: " + ex.getMessage());
            throw ex;
        }

        return arrayOfExpressions;
    }
}
