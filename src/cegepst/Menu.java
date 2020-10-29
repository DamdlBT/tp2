package cegepst;

import java.util.Scanner;

public class Menu {

    private Scanner scanner;

    public Menu() {
        scanner = new Scanner(System.in);
        printMenu();
    }

    private void printMenu() {
        System.out.println("1- Encoder un message");
        System.out.println("2- Decoder un message Binaire");
        System.out.println("9- Quitter");
        System.out.print("Votre choix: ");
        chooseAction(choice());
    }

    private int choice() {
        String answer = scanner.nextLine();
        if (answer.equalsIgnoreCase("1")) {
            clear();
            return 1;
        }
        if (answer.equalsIgnoreCase("2")) {
            clear();
            return 2;
        } else if (!answer.equalsIgnoreCase("9")) {
            System.out.println();
            System.out.println("Choix invalide!");
            System.out.println("Veuillez recommencer!");
            System.out.println();
            printMenu();
        }
        return 9;
    }

    private void chooseAction(int choice) {
        if (choice == 1) {
            new Encoder();
        }
        if (choice == 2) {
            new Decoder();
        }
        if (choice == 9) {
            System.exit(0);
        }
    }

    private void clear() {
        for (int i = 0; i < 100; i++) {
            System.out.println();
        }
    }

}
