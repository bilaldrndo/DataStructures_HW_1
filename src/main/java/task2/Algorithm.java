package task2;

import task1.Stack;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.lang.Math;

public class Algorithm {
    public static Double calculate(String s1) {
        String[] splittedArray = s1.split(" ");

        Stack<Double> values = new Stack<Double>();
        Stack<String> operators = new Stack<String>();

        for (String item : splittedArray) {
            

            if (isNumber(item) == true) {
                Double parsed = Double.parseDouble(item);
                values.push(parsed);
            } else if (isOperation(item).get(0).equals("true")) {
                operators.push(isOperation(item).get(1));
            } else if (item.equals( ")")) {
                String operator = operators.pop();
                Double num1 = values.pop();

                Double finalValue = 0.0;

                if (!operator.equals("sqrt")) {
                    Double num2 = values.pop();
                    finalValue = doOperation(operator, num2, num1);
                } else {
                    finalValue = Math.sqrt(num1);
                }

                values.push(finalValue);
            }
        }

        return values.pop();
    }

    public static ArrayList<Double> calculateFromFile(String filePath) throws FileNotFoundException {
        ArrayList<String> arrayOfExpressions = FileUtils.readFile(filePath);
        ArrayList<Double> finalArray = new ArrayList<Double>();

        for (String expression: arrayOfExpressions) {
            finalArray.add(calculate(expression));
        }

        return finalArray;
    }

    private static boolean isNumber(String str) {
        try {
            double v = Double.parseDouble(str);
            return true;
        } catch (NumberFormatException nfe) {}
        return false;
    }

    private static ArrayList<String> isOperation(String str) {
        ArrayList<String> finalArray = new ArrayList<String>();
        if (str.equals("+")) {
            finalArray.add("true");
            finalArray.add("add");
        } else if (str.equals("-")) {
            finalArray.add("true");
            finalArray.add("sub");
        } else if (str.equals( "*")) {
            finalArray.add("true");
            finalArray.add("mul");
        } else if (str.equals("/")) {
            finalArray.add("true");
            finalArray.add("div");
        } else if (str.equals("%")) {
            finalArray.add("true");
            finalArray.add("mod");
        } else if (str.equals("^")) {
            finalArray.add("true");
            finalArray.add("pow");
        } else if (str.equals("√")) {
            finalArray.add("true");
            finalArray.add("sqrt");
        } else {
            finalArray.add("false");
        }

        return finalArray;
    }

    private static Double doOperation(String operation, Double num1, Double num2) {
        switch (operation) {
            case "add":
                return num1 + num2;
            case "sub":
                return num1 - num2;
            case "mul":
                return num1 * num2;
            case "div":
                return num1 / num2;
            case "mod":
                return num1 % num2;
            case "pow":
                return Math.pow(num1, num2);
            default:
                return 0.0;
        }
    }
}
