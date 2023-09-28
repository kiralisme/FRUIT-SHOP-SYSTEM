package view;

import java.util.Scanner;

public class UserInterface {
    private Scanner scanner;

    public UserInterface() {
        scanner = new Scanner(System.in);
    }

    public int showMainMenu() {
        System.out.println("1. Create fruit");
        System.out.println("2. View order");
        System.out.println("3. Shopping");
        System.out.println("4. Exit");
        System.out.print("Enter your choice: ");
        return scanner.nextInt();
    }

    public void close() {
        scanner.close();
    }
}
