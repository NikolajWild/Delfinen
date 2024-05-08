
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Scanner;


public class FileHandler {
    private final File file = new File("medlemmer.csv");


    public ArrayList<Medlem> loadMedlemdsData() {
        ArrayList<Medlem> medlemsData = new ArrayList();
        Scanner sc = null;
        try {
            sc = new Scanner(file, StandardCharsets.ISO_8859_1);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        Medlem medlemFil = null;
        while (sc.hasNext()) {
            String line = sc.nextLine();
            String[] attributes = line.split(",");
            medlemFil = new Medlem(
                    attributes[0],
                    (Integer.parseInt(attributes[1])),
                    (Boolean.parseBoolean(attributes[2])),
                    (Boolean.parseBoolean(attributes[3]))
            );
            medlemsData.add(medlemFil);
        }
        sc.close();
        return medlemsData;
    }


    public void gemListeAfMedlemmer(ArrayList<Medlem> medlemsListe) {
        try (
                PrintStream saves = new PrintStream("medlemmer.csv")) {
            for (Medlem medlemmer : medlemsListe) {
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



