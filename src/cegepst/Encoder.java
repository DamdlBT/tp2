package cegepst;

import java.util.ArrayList;
import java.util.Scanner;

public class Encoder {

    ArrayList<Word> listOfWord = new ArrayList<Word>();
    Scanner scanner = new Scanner(System.in);
    ArrayList<String> messageInBinaryString = new ArrayList<String>();
    ArrayList<Integer> parityBytes = new ArrayList<Integer>();
    String message;

    public void read() {
        System.out.print("Quel est votre message: ");
        message = scanner.nextLine();
        System.out.println();
        toBinary();
        genParityByte();
        printMessage();
    }

    private void toBinary() {
        for (int i = 0; i < message.length(); i++) {
            int ascii = message.charAt(i);
            String binary = Integer.toBinaryString(ascii);
            messageInBinaryString.add(binary);
        }
    }

    private void printMessage() {
        int positionInArray = 0;
        for (int i = 0; i < messageInBinaryString.size(); i++) {
            if (i % 8 == 0) {
                System.out.println();
            }
            int binary = Integer.parseInt(messageInBinaryString.get(i));
            int parityBit = parityBytes.get(i);
            System.out.printf("%08d %d \n", binary, parityBit);
        }

    }

    private void genParityByte() {
        for (int i = 0; i < messageInBinaryString.size(); i++) {
            int byteCounter = 0;
            String currentString = messageInBinaryString.get(i);
            for (int j = 0; j < currentString.length(); j++) {
                if (currentString.charAt(j) == '1') {
                    byteCounter++;
                }
            }
            if (byteCounter % 2 == 0) {
                parityBytes.add(0);
            } else {
                parityBytes.add(1);
            }
        }
    }
}
