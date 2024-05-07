import java.time.LocalDate;
import java.util.ArrayList;

public class DelfinenMedlemmer {

    private ArrayList<Medlem> medlemskollektion = new ArrayList<>();
    /*
    private FileHandler fileHandler;

    public DelfinenMedlemmer(){
        this.fileHandler = new FileHandler();
        this.medlemskollektion = fileHandler.loadMedlemdsData();
    }

     */

    public ArrayList<Medlem> getMedlemskollektion() {
        return medlemskollektion;
    }

    //viser dag i måned (now og of er vigtige)
    public static void LocalDate() {
        LocalDate herognu = LocalDate.now();
        int dagIMåned = herognu.getDayOfMonth();
        System.out.println(dagIMåned);
    }

    //laver en arraylist til søgemetode
    public ArrayList<Medlem> searchMatch = new ArrayList<>();

    //Søger et medlem
    public ArrayList<Medlem> søgMedlem(String navn) {
        for (Medlem medlem : medlemskollektion) {
            if (medlem.getNavn().toLowerCase().contains(navn.toLowerCase())) {
                searchMatch.add(medlem);
            }
        }
        return searchMatch;
    }

    //Redigér i medlemslisten
    public ArrayList<Medlem> redigérMedlem(String navn, int redigeringsvalg, String nyVærdi) {
        for (Medlem medlem : medlemskollektion) {
            if (medlem.getNavn().toLowerCase().contains(navn.toLowerCase())) {
                switch (redigeringsvalg) {
                    case 1:
                        medlem.setNavn(nyVærdi);
                        break;
                    case 2:
                        int nyAlder = Integer.parseInt(nyVærdi);
                        medlem.setAlder(nyAlder);
                        break;
                    case 3:
                        boolean nytAktivtMedlemskab = Boolean.parseBoolean(nyVærdi);
                        medlem.setAktivtMedlemskab(nytAktivtMedlemskab);
                        break;
                    case 4:
                        boolean nytJuniorMedlemskab = Boolean.parseBoolean(nyVærdi);
                        medlem.setJuniorMedlemskab(nytJuniorMedlemskab);
                        break;
                }

            }
        }
        return medlemskollektion;
    }


    public void tilføjMedlem(Medlem medlem) {
        medlemskollektion.add(medlem);
        /*
        fileHandler.gemListeAfMedlemmer(medlemskollektion);
         */
        //to do lav save funktion her.
    }


}
