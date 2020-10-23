package cegepst;

import java.util.ArrayList;

public class Word {
    ArrayList<Letter> wordInBinary = new ArrayList<Letter>();
    String word = "";
    int[] wordParity = new int[9];

    public void addCharToWord(char letter) {
        String newLetter = String.valueOf(letter);
        word = word + newLetter;
    }

    public void printWord() {
        System.out.println(word);
        System.out.println();
    }
}
