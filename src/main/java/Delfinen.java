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


    public void tilføjMedlem(String navn, int alder, boolean aktivtMedlemskab, boolean juniorMedlemskab, boolean motionistSvømmer) {
        medlemskollektion.add(new Medlemmer(navn, alder, aktivtMedlemskab, juniorMedlemskab));
        fileHandler.gemListeAfMedlemmer(medlemskollektion);
        //to do lav save funktion her.
    }


}
