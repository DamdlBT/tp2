package cegepst;

import java.util.Scanner;

public class Decoder {

    private Scanner scanner;


    public Decoder() {
        scanner = new Scanner(System.in);
        read();
        decode();
        print();
    }

    private void print() {

    }

    private void decode() {

    }

    private void read() {
        System.out.println("Entrez le code binaire: ");
        while (!scanner.nextLine().equalsIgnoreCase("")) {

        }

    }
}
