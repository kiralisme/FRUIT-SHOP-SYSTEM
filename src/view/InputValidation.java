package view;

import java.util.Scanner;

public class InputValidation {
    private static final Scanner scanner = new Scanner(System.in);

    public String inputString(String msg) {
        System.out.print(msg);
        return scanner.nextLine();
    }

    public int inputInt(String msg, int min, int max) {
        int value;
        while (true) {
            System.out.print(msg);
            try {
                value = Integer.parseInt(scanner.nextLine());
                if (value >= min && value <= max) {
                    break;
                } else {
                    System.out.println("Invalid input. Please enter a number between " + min + " and " + max);
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid number.");
            }
        }
        return value;
    }

    public double inputDouble(String msg, double min, double max) {
        double value;
        while (true) {
            System.out.print(msg);
            try {
                value = Double.parseDouble(scanner.nextLine());
                if (value >= min && value <= max) {
                    break;
                } else {
                    System.out.println("Invalid input. Please enter a number between " + min + " and " + max);
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid number.");
            }
        }
        return value;
    }
}
