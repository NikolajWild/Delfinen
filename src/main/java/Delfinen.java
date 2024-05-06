import java.time.LocalDate;
import java.util.ArrayList;

public class Delfinen {

    private ArrayList<Medlemmer> medlemskollektion;
    private FileHandler fileHandler;

    public Delfinen(){
        this.fileHandler = new FileHandler();
        this.medlemskollektion = fileHandler.loadMedlemdsData();
    }

    public ArrayList<Medlemmer> getMedlemskollektion() {
        return medlemskollektion;
    }

    //viser dag i måned (now og of er vigtige)
    public static void LocalDate() {
        LocalDate herognu = LocalDate.now();
        int dagIMåned = herognu.getDayOfMonth();
        System.out.println(dagIMåned);
    }

    //laver en arraylist til søgemetode
    public ArrayList<Medlemmer> searchMatch = new ArrayList<>();

    //Søger et medlem
    public ArrayList<Medlemmer> søgMedlem(String navn) {
        for (Medlemmer medlem : medlemskollektion) {
            if (medlem.getNavn().toLowerCase().contains(navn.toLowerCase())) {
                searchMatch.add(medlem);
            }
        }
        return searchMatch;
    }

    //Redigér i medlemslisten
    public ArrayList<Medlemmer> redigérMedlem(String navn, int redigeringsvalg, String nyVærdi) {
        for (Medlemmer medlem : medlemskollektion) {
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


    public void tilføjMedlem(String navn, int alder, boolean aktivtMedlemskab, boolean juniorMedlemskab, boolean motionistSvømmer) {
        medlemskollektion.add(new Medlemmer(navn, alder, aktivtMedlemskab, juniorMedlemskab));
        fileHandler.gemListeAfMedlemmer(medlemskollektion);
        //to do lav save funktion her.
    }


}
