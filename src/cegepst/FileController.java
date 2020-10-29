package cegepst;

import java.io.File;
import java.io.IOException;
import java.io.FileWriter;

public class FileController {

    private FileWriter fileWriter = new FileWriter("file.txt");

    public FileController() throws IOException {
        try {
            File myFile = new File("file.txt");
            if (myFile.createNewFile()) {
                System.out.println("Fichier créé: " + myFile.getName());
            } else {
                System.out.println("Le fichier existe déjà.");
            }
        } catch (IOException e) {
            System.out.println("Une erreur s'est produite");
            e.printStackTrace();
        }
    }

    public void printInFile(String line) {
        try {
            fileWriter.write(line);
            fileWriter.close();
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}
