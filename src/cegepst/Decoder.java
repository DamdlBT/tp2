package cegepst;

import java.util.ArrayList;
import java.util.Scanner;

public class Decoder {

    private Scanner scanner;
    private ArrayList<String> messageBinary = new ArrayList<String>();
    private ArrayList<Character> messageChar = new ArrayList<Character>();
    private ArrayList<Integer> oldParityByte = new ArrayList<Integer>();
    private ArrayList<String> oldParityLine = new ArrayList<String>();
    private ArrayList<Integer> parityBytes = new ArrayList<Integer>();
    private ArrayList<String> parityLine = new ArrayList<String>();
    private int currentPositionInChar;

    public Decoder() {
        scanner = new Scanner(System.in);
        do {
            read();
            //decode();
        } while(notFin());
        decode();
        genParityByte();
        genParityLine();
        print();
    }

    private void print() {
        System.out.printf("\n\n");
        for (int i = 0; i < messageChar.size(); i++) {
            System.out.print(messageChar.get(i));
        }
        System.out.printf("\n");

        for (int i = 0; i < parityBytes.size(); i++) {
            System.out.println(parityBytes.get(i));
        }
    }

    private void decode() {
        for (int i = currentPositionInChar; i < messageBinary.size(); i++) {
            String currentByte = messageBinary.get(i);
            int ascii = Integer.parseInt(currentByte, 2);
            char letter = (char)ascii;
            messageChar.add(letter);
            currentPositionInChar = i;
        }
    }

    private void read() {
        System.out.println("Entrez le code binaire: ");
        String line = scanner.nextLine();
        while (!line.equals("")) {
            messageBinary.add(separate(line));
            line = scanner.nextLine();
        }
        int messageBinarySize = messageBinary.size();
        oldParityLine.add(messageBinary.get(messageBinarySize - 1));
        messageBinary.remove(messageBinarySize - 1);
    }

    private void genParityLine() {
        int parityLineTotal = 0;
        String finalParity = "";
        for (int i = 0; i < messageChar.size(); i++) {
            if (i % 8 == 0 && i != 0) {
                String parityLineString = Integer.toString(parityLineTotal);
                for (int j = 0; j < parityLineString.length(); j++) {
                    if (Integer.parseInt(String.valueOf(parityLineString.charAt(i))) == 1) {
                        finalParity += "1";
                    }
                    if (Integer.parseInt(String.valueOf(parityLineString.charAt(i))) == 1) {
                        finalParity += "0";
                    }
                }
                parityLine.add(finalParity);
            }
            parityLineTotal += toBinary(i);
        }
        String parityLineString = Integer.toString(parityLineTotal);
        for (int i = 0; i < parityLineString.length(); i++) {
            if (Integer.parseInt(String.valueOf(parityLineString.charAt(i))) == 1) {
                finalParity += "1";
            }
            if (Integer.parseInt(String.valueOf(parityLineString.charAt(i))) == 1) {
                finalParity += "0";
            }
        }
    }

    private int toBinary(int i) {
            int ascii = messageChar.get(i);
            String binary = Integer.toBinaryString(ascii);

            return Integer.parseInt(binary);
    }

    private String separate(String line) {
        int parity = Integer.parseInt(String.valueOf(line.charAt(8)));
        oldParityByte.add(parity);
        line = line.substring(0, 8);
        return line;
    }

    private void genParityByte() {
        for (int i = 0; i < messageChar.size(); i++) {
            int byteCounter = 0;
            String currentString = messageBinary.get(i);
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

    private void compareParityByte() {

    }

    private void compareParityLine() {

    }

    private boolean notFin() {
        String answer;

        do {
            System.out.print("Avez-vous terminer (oui/non): ");
            answer = scanner.nextLine();
            if (!answer.equalsIgnoreCase("oui") && !answer.equalsIgnoreCase("non")) {
                System.out.println("Réponse invalide!");
                System.out.println("Veuillez recommencer!");
                System.out.println();
            }
        }while(!answer.equalsIgnoreCase("oui") && !answer.equalsIgnoreCase("non"));

        if (answer.equalsIgnoreCase("oui")) {
            return false;
        }
        System.out.printf("\n");
        return true;
    }
}
