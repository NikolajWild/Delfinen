
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Scanner;

public class FileHandler {
    private final File file = new File("medlemmer.csv");


    public ArrayList<Medlemmer> loadMedlemdsData() {
        ArrayList<Medlemmer> medlemsData = new ArrayList();
        Scanner sc = null;
        try {
            sc = new Scanner(file, StandardCharsets.ISO_8859_1);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        Medlemmer medlemmerFil = null;
        while (sc.hasNext()) {
            String line = sc.nextLine();
            String[] attributes = line.split(",");
            medlemmerFil = new Medlemmer(
                    attributes[1],
                    (Integer.parseInt(attributes[0])),
                    (Boolean.parseBoolean(attributes[2])),
                    (Boolean.parseBoolean(attributes[3]))
            );
            medlemsData.add(medlemmerFil);
        }
        sc.close();
        return medlemsData;
    }


    public void gemListeAfMedlemmer(ArrayList<Medlemmer> medlemsListe) {
        try (
                PrintStream saves = new PrintStream("medlemmer.csv")) {
            for (Medlemmer medlemmer : medlemsListe) {
                String medlem = medlemmer.getNavn() + "," + medlemmer.getAlder() +","+medlemmer.getAktivtMedlemskab()+","+
                        medlemmer.getJuniorMedlemskab();
                saves.println(medlem);
            }
            System.out.println("Gem Liste");
        } catch (
                FileNotFoundException e) {
            System.err.println("File Not Found");
            e.printStackTrace();
        }
    }
}
