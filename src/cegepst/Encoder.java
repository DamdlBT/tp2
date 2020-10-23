package cegepst;

import java.util.ArrayList;
import java.util.Scanner;

public class Encoder {

    ArrayList<Word> listOfWord = new ArrayList<Word>();
    Scanner scanner = new Scanner(System.in);
    ArrayList<Integer> messageInBinary = new ArrayList<Integer>();
    String message;

    public void read() {
        System.out.print("Quel est votre message: ");
        message = scanner.nextLine();
        System.out.println();
        toBinary();
        printMessage();
    }

    private void toBinary() {
        for (int i = 0; i < message.length(); i++) {
            int ascii = message.charAt(i);
            String binary = Integer.toBinaryString(ascii);
            int binaryInInt = Integer.parseInt(binary);
            messageInBinary.add(binaryInInt);
        }
    }

    private void printMessage() {
        int positionInArray = 0;
        for (int i = 0; i < messageInBinary.size(); i++) {
            if (i % 8 == 0) {
                System.out.println();
            }
            System.out.printf("%08d \n", messageInBinary.get(i));
        }

    }
}
