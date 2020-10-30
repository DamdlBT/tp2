package cegepst;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Encoder {

    private Scanner scanner = new Scanner(System.in);
    private ArrayList<String> messageInBinaryString = new ArrayList<String>();
    private ArrayList<Integer> parityBytes = new ArrayList<Integer>();
    private ArrayList<int[]> parityLine = new ArrayList<int[]>();
    private String message;
    private int currentParity;
    private int currentParityBits;

    public Encoder(){
        read();
    }

    public void read() {
        System.out.print("Quel est votre message: ");
        message = scanner.nextLine();
        System.out.println();
        toBinary();
        formatString();
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

    private void formatString() {
        for (int i = 0; i < messageInBinaryString.size(); i++) {
            int binary = Integer.parseInt(messageInBinaryString.get(i));
            String formatedBinary = String.format("%08d", binary);
            messageInBinaryString.set(i, formatedBinary);
        }
    }

    private void printMessage() {
        int positionInArray = 0;
        for (int i = 0; i < messageInBinaryString.size(); i++) {
            if (i % 8 == 0 && i != 0) {
                printLastParity();
                System.out.println();
            }
            System.out.printf("%8s%d \n", messageInBinaryString.get(i), parityBytes.get(i));
            String line = messageInBinaryString.get(i) + Integer.toBinaryString(parityBytes.get(i));
            calculateParityLine(i);
            calculateParityByte(parityBytes.get(i));
        }
        printLastParity();
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

    private void calculateParityLine(int currentPosition) {
        String currentChar = messageInBinaryString.get(currentPosition);
        int charInInt = Integer.parseInt(currentChar);
        currentParity += charInInt;

    }

    private void printLastParity() {
        String parity = String.format("%08d", currentParity);
        String parityInBits = "";
        for (int i = 0; i < parity.length(); i++) {
            int currentChar = Integer.parseInt(String.valueOf(parity.charAt(i)));
            if (isEven(currentChar)) {
                parityInBits += '0';
            } else {
                parityInBits += '1';
            }
            System.out.print(parityInBits.charAt(i));
        }
        if (isEven(currentParityBits)) {
            currentParityBits = 0;
        } else {
            currentParityBits = 1;
        }
        System.out.print(currentParityBits);
        currentParityBits = 0;
        currentParity = 0;
        System.out.println();
    }

    private void calculateParityByte(int currentByte) {
        currentParityBits += currentByte;
    }

    private boolean isEven(int value) {
        if (value % 2 == 0) {
            return true;
        }
        return false;
    }
}
