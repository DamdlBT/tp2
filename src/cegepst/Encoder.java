package cegepst;

import java.util.ArrayList;
import java.util.Scanner;

public class Encoder {

    ArrayList<Word> listOfWord = new ArrayList<Word>();
    Scanner scanner = new Scanner(System.in);
    String message;

    public void read() {
        System.out.print("Quelle est votre message: ");
        message = scanner.nextLine();
        System.out.println();
        divideInWord();
        //System.out.print(message);
    }

    public void divideInWord() {
        int wordNumber = 0;
        for (int position = 0; position < message.length(); position ++) {

            if (wordNumber == 0) {
                listOfWord.add(new Word());
            }

            Word currentWord = listOfWord.get(wordNumber);

            if (position % 8 == 0) {
                currentWord = listOfWord.get(wordNumber);
                char currentChar;
                currentChar = message.charAt(position);
                currentWord.addCharToWord(currentChar);
            } else {
                char currentChar;
                currentChar = message.charAt(position);
                currentWord.addCharToWord(currentChar);
            }
            position++;
            if (position % 8 != 0 && position != 0) {
                wordNumber++;
                currentWord.printWord();
                listOfWord.add(new Word());
            }
        }
    }
}
