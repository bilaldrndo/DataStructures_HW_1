package task2;

import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        System.out.println("Hello, please enter Your expression: ");

        Scanner stringScanner = new Scanner(System.in);

        String expression = stringScanner.nextLine();
        Double result = Algorithm.calculate(expression);
        System.out.println("Result is: " + result);
    }
}